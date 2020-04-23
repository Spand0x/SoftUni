package alararestaurant.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    private String name;
    private int age;
    private Position position;
    private List<Order> orders;

    public Employee() {
    }

    @Column(nullable = false,length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManyToOne
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @OneToMany(mappedBy = "employee")
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
