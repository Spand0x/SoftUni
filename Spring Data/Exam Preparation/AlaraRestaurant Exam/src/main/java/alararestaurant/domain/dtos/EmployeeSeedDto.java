package alararestaurant.domain.dtos;


import alararestaurant.domain.entities.Position;
import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class EmployeeSeedDto {
    @Expose
    private String name;
    @Expose
    private int age;
    @Expose
    private String position;

    public EmployeeSeedDto() {
    }

    @Length(min = 3,max = 30)
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(15)
    @Max(80)
    @NotNull
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @NotNull
    @Length(min = 3,max = 30)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
