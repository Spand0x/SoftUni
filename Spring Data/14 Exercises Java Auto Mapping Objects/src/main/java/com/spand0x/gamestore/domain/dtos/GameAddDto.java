package com.spand0x.gamestore.domain.dtos;

import com.spand0x.gamestore.domain.entities.Order;
import com.spand0x.gamestore.domain.entities.User;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class GameAddDto {
    private String title;
    private BigDecimal price;
    private double size;
    private String trailer;
    private String image;
    private String description;
    private LocalDate releaseDate;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, double size, String trailer, String image, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.image = image;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Pattern(regexp = "^[A-Z]\\S+",message = "Title must start with capital letter")
    @Size(min = 3,max = 101,message = "Title length must be between 3 and 100")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DecimalMin(value = "0",message = "Price must be positive")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Min(value = 0,message = "Size must be positive")
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Size(min = 11,max = 11,message = "Trailer id should be 11 chars exactly")
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Pattern(regexp = "^(http://\\S+|https://\\S+)")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Size(min = 20,message = "Description should be at lest 20 chars")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
