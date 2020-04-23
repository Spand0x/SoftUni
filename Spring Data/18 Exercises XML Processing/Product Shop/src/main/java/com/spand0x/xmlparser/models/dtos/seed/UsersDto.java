package com.spand0x.xmlparser.models.dtos.seed;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UsersDto {

    private List<UserSeedDto> userSeedDtos;

    public UsersDto() {
    }

    public UsersDto(List<UserSeedDto> userSeedDtos) {
        this.userSeedDtos = userSeedDtos;
    }

    @XmlElement(name = "user")
    public List<UserSeedDto> getUserSeedDtos() {
        return userSeedDtos;
    }

    public void setUserSeedDtos(List<UserSeedDto> userSeedDtos) {
        this.userSeedDtos = userSeedDtos;
    }
}
