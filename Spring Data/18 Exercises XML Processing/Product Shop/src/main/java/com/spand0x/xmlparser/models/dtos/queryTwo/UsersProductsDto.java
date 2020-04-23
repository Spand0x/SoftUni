package com.spand0x.xmlparser.models.dtos.queryTwo;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UsersProductsDto {
    private List<UserProductsDto> users;

    public UsersProductsDto() {
    }

    public UsersProductsDto(List<UserProductsDto> users) {
        this.users = users;
    }

    @XmlElement(name = "user")
    public List<UserProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserProductsDto> users) {
        this.users = users;
    }
}
