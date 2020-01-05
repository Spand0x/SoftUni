import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private Map<String,Product> products;

    public Instock(){
        this.products = new LinkedHashMap<>();
    }


    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        String productLabel = product.getLabel();
        return this.products.containsKey(productLabel);
    }

    @Override
    public void add(Product product) {
        if(!this.contains(product)){
            String productLabel = product.getLabel();
            this.products.put(productLabel,product);
        }
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if(!this.products.containsKey(product)){
            throw new IllegalArgumentException();
        }
        this.products.get(product).setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        return this.products.entrySet().stream().skip(index).map(Map.Entry::getValue).findFirst().orElseThrow(IndexOutOfBoundsException::new);
    }

    @Override
    public Product findByLabel(String label) {
        if(!this.products.containsKey(label)){
            throw new IllegalArgumentException();
        }
        return this.products.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        Iterable<Product> list = null;
        if(count>0 && count<=this.products.size()) {
            list = this.products.values().stream()
                    .sorted(Product::compareTo)
                    .limit(count)
                    .collect(Collectors.toList());
        }
        return list ==null ? new ArrayList<>() : list;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        Iterable<Product> list = this.products.values().stream()
                .sorted((p1,p2)-> (int) (p2.getPrice()-p1.getPrice()))
                .filter(product -> product.getPrice()>lo && product.getPrice()<=hi)
                .collect(Collectors.toList());

        return list == null ? new ArrayList<>():list;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        Iterable<Product> list = this.products.values().stream()
                .filter(product -> product.getPrice() == price)
                .collect(Collectors.toList());
        return list == null ? new ArrayList<>() : list;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        List<Product> list = this.products.values().stream()
                .sorted((p1,p2)->Double.compare(p2.getPrice(),p1.getPrice()))
                .limit(count)
                .collect(Collectors.toList());
        if(list.size()<count){
            throw new IllegalArgumentException();
        }
        return list;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        List<Product> list = this.products.values().stream()
                .filter(product -> product.getQuantity()==quantity)
                .collect(Collectors.toList());
        return list ==null? new ArrayList<>() : list;
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.values().iterator();
    }
}
