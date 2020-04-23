package com.spand0x.xmlparser.models.dtos.queryFour;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UsersRootDto {
    private int count;
    private List<UserProductsSoldDto> users;

    public UsersRootDto() {
    }

    @XmlAttribute(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @XmlElement(name = "user")
    public List<UserProductsSoldDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserProductsSoldDto> users) {
        this.users = users;
    }
}
