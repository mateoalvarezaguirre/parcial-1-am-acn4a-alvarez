package com.davinci.coffeemaker.domain.entities;

public class Coffee {
    private final String name;
    private final String description;
    private final int image;
    private final Float price;

    public Coffee(String name, String description, int imageSource, Float price) {
        this.name = name;
        this.description = description;
        this.image = imageSource;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public Float getPrice() {
        return price;
    }
}
