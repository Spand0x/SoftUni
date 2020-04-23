package entities.ingredients;

import entities.shampoos.BasicShampoo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ingredients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ingredient_type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicIngredient implements Ingredient{
    private int id;
    private String name;
    private BigDecimal price;
    private List<BasicShampoo> shampoos;

    protected BasicIngredient(){};
    protected BasicIngredient(String name, BigDecimal price){
        setName(name);
        setPrice(price);
    }

    @Override
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @Override
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Override
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    @ManyToMany(mappedBy = "ingredients",cascade = CascadeType.ALL)
    public List<BasicShampoo> getShampoos() {
        return shampoos;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setShampoos(List<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
