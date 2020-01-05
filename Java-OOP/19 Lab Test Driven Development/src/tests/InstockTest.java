import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class InstockTest {
    private Product product;
    private Instock instock;
    private static String[] LABELS = {"D", "A", "E", "B", "C"};
    private final static String DEFAULT_PRODUCT_LABEL = "Label";
    private final static double DEFAULT_PRODUCT_PRICE = 1.00;
    private final static int DEFAULT_PRODUCT_QUANTITY = 1;

    @Before
    public void createInstockAndProduct() {
        this.product = new Product(DEFAULT_PRODUCT_LABEL, DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        this.instock = new Instock();
    }

    private void fillWithProducts() {
        for (int i = 0; i < LABELS.length; i++) {
            this.instock.add(new Product(LABELS[i], i + 1, i));
        }
    }

    @Test
    public void getCountShouldReturnZeroOnEmptyInstock() {
        int count = this.instock.getCount();
        assertEquals(0, count);
    }

    @Test
    public void getCountShouldReturnTheCountOfProductsInstock() {
        fillWithProducts();
        int count = this.instock.getCount();
        assertEquals(LABELS.length, count);
    }

    @Test
    public void addShouldAddProductToInstockIfProductIsNotAlreadyInstock() {
        this.instock.add(this.product);
        assertEquals(1, this.instock.getCount());
    }

    @Test
    public void addShouldNotAddProductToInstockIfProductIsAlreadyInstock() {
        this.instock.add(this.product);
        this.instock.add(this.product);
        assertEquals(1, this.instock.getCount());
    }

    @Test
    public void containsShouldReturnFalseIfProductIsNotInstock() {
        assertFalse(this.instock.contains(this.product));
    }

    @Test
    public void containsShouldReturnTrueIfProductIsInstock() {
        this.instock.add(this.product);
        assertTrue(this.instock.contains(this.product));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findShouldThrowExceptionIfIndexIsOutOfBounds() {
        this.instock.find(0);
    }


    @Test
    public void findShouldReturnProductIfIndexIsInBounds() {
        this.instock.add(this.product);
        this.instock.add(new Product("Product", 2.0, 1));
        Product currentProduct = this.instock.find(0);
        assertEquals(this.product, currentProduct);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowExceptionIfProductIsNotInstock() {
        this.instock.changeQuantity("product", 10);
    }

    @Test
    public void changeQuantityShouldChangeTheQuantityOfAProductInInstock() {
        this.instock.add(product);
        this.instock.changeQuantity(DEFAULT_PRODUCT_LABEL, 3);
        Product currentProduct = this.instock.find(0);
        int productQuantity = currentProduct.getQuantity();
        assertEquals(3, productQuantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowExceptionWhenProductIsNotInstock() {
        this.instock.findByLabel(DEFAULT_PRODUCT_LABEL);
    }

    @Test
    public void findByLabelShouldReturnProductSearchedByLabel() {
        this.instock.add(this.product);
        Product byLabel = this.instock.findByLabel(DEFAULT_PRODUCT_LABEL);
        assertEquals(this.product.getLabel(), byLabel.getLabel());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollectionIfIndexIsOutOfBounds() {
        Iterable<Product> iter = this.instock.findFirstByAlphabeticalOrder(0);
        int count = 0;
        for (Product product1 : iter) {
            count++;
        }
        assertEquals(0, count);
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnNewOrderedIterableWithNElements() {
        fillWithProducts();
        Iterable<Product> iter = this.instock.findFirstByAlphabeticalOrder(LABELS.length);
        List<Product> arr = new ArrayList<>();
        iter.forEach(arr::add);
        assertEquals(LABELS.length, arr.size());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnOrderedElements() {
        fillWithProducts();
        String[] sorted = LABELS.clone();
        Arrays.sort(sorted);

        Iterable<Product> iter = this.instock.findFirstByAlphabeticalOrder(LABELS.length);
        String[] sortedInstock = new String[LABELS.length];
        int index = 0;
        for (Product currentProduct : iter) {
            sortedInstock[index++] = currentProduct.getLabel();
        }

        assertArrayEquals(sorted, sortedInstock);
    }

    @Test
    public void findAllInRangeShouldReturnEmptyCollectionWhenThereAreNoProductsInThePriceRange() {
        fillWithProducts();
        Iterable<Product> iter = this.instock.findAllInRange(10, 20);
        int count = 0;
        for (Product currentProduct : iter) {
            count++;
        }

        assertEquals(0, count);
    }

    @Test
    public void findAllInRangeShouldReturnAllElementsPresentedInTheRange() {
        fillWithProducts();
        Iterable<Product> iterable = this.instock.findAllInRange(1, 3);
        int count = 0;
        for (Product currentProduct : iterable) {
            count++;
        }

        assertEquals(2, count);
    }

    @Test
    public void findAllInRangeShouldReturnElementsInDescendingOrder() {
        fillWithProducts();
        Iterable<Product> iterable = this.instock.findAllInRange(Double.MIN_VALUE, Double.MAX_VALUE);
        List<Double> prices = new LinkedList<>();
        for (int i = 0; i < LABELS.length; i++) {
            prices.add(instock.find(i).getPrice());

        }
        Collections.sort(prices);
        Collections.reverse(prices);
        List<Double> pricesInstock = new LinkedList<>();
        for (Product currentProduct : iterable) {
            pricesInstock.add(currentProduct.getPrice());
        }


        assertArrayEquals(prices.toArray(), pricesInstock.toArray());
    }

    @Test
    public void findAllByPriceShouldReturnEmptyCollectionWhenPriceDontMatch() {
        Iterable<Product> iterable = this.instock.findAllByPrice(DEFAULT_PRODUCT_PRICE);
        int count = 0;
        for (Product currentProduct : iterable) {
            count++;
        }
        assertEquals(0, count);
    }

    @Test
    public void findAllByPriceShouldReturnAllProductsWithMatchingPrice() {
        fillWithProducts();
        this.instock.add(this.product);
        Iterable<Product> iterable = this.instock.findAllByPrice(DEFAULT_PRODUCT_PRICE);
        List<Product> productList = new ArrayList<>();
        for (Product currentProduct : iterable) {
            productList.add(currentProduct);
        }

        List<Product> instockList = new ArrayList<>();
        for (Product currentProduct : instock) {
            if (currentProduct.getPrice() == DEFAULT_PRODUCT_PRICE) {
                instockList.add(currentProduct);
            }
        }

        assertArrayEquals(instockList.toArray(), productList.toArray());
    }

    @Test
    public void iteratorShouldReturnEmptyListWhenInstockIsEmpty() {
        Iterator<Product> iterator = this.instock.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }
        assertEquals(0, count);
    }

    @Test
    public void iteratorShouldReturnAllElementsFromInstock() {
        fillWithProducts();
        Iterator<Product> iterator = this.instock.iterator();
        String[] instockLabels = new String[LABELS.length];
        int index = 0;
        while (iterator.hasNext()){
            instockLabels[index++] = iterator.next().getLabel();
        }

        assertArrayEquals(LABELS,instockLabels);


    }

    @Test (expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProductsShouldThrowExceptionIfCountIsLessThanInstockCount(){
        fillWithProducts();
        this.instock.findFirstMostExpensiveProducts(LABELS.length+1);
    }

    @Test
    public void findFirstMostExpensiveProductsShouldReturnOrderedCollectionWithFirstNProductsWithHighestPriceInstock(){
        fillWithProducts();

        List<Double> prices = new LinkedList<>();
        for (int i = 0; i < LABELS.length; i++) {
            prices.add(instock.find(i).getPrice());

        }
        Collections.sort(prices);
        Collections.reverse(prices);

        Iterable<Product> iterable = this.instock.findFirstMostExpensiveProducts(LABELS.length);
        List<Double> highestProductPrices = new LinkedList<>();
        for (Product currentProduct : iterable) {
            highestProductPrices.add(currentProduct.getPrice());
        }

        assertEquals(prices,highestProductPrices);
    }

    @Test
    public void findFirstMostExpensiveProductsShouldReturnIndexAmountOfProducts(){
        fillWithProducts();
        Iterable<Product> iterable = this.instock.findFirstMostExpensiveProducts(LABELS.length/2);
        int count = 0;
        for (Product currentProduct : iterable) {
            count++;
        }

        assertEquals(LABELS.length/2,count);
    }

    @Test
    public void findAllByQuantityShouldReturnEmptyStringIfNoQuantityIsPresented(){
        fillWithProducts();
        Iterable<Product> iterable = this.instock.findAllByQuantity(DEFAULT_PRODUCT_QUANTITY + 100);
        int count = 0;
        for (Product currentProduct : iterable) {
            count++;
        }

        assertEquals(0,count);
    }

    @Test
    public void findAllByQuantityShouldReturnProductsWithTheGivenQuantity(){
        fillWithProducts();
        this.instock.add(this.product);
        List<Product> products = new LinkedList<>();
        for (Product currentProduct : instock) {
            if(currentProduct.getQuantity()==DEFAULT_PRODUCT_QUANTITY){
                products.add(currentProduct);
            }
        }

        Iterable<Product> iterable = this.instock.findAllByQuantity(DEFAULT_PRODUCT_QUANTITY);
        List<Product> instockProducts = new LinkedList<>();
        for (Product currentProduct : iterable) {
            instockProducts.add(currentProduct);
        }

        assertEquals(products,instockProducts);


    }

}