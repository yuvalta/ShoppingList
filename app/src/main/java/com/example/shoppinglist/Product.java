package com.example.shoppinglist;

public class Product
{
    private ProductCategory category;
    private String name;
    public boolean isChecked;

    Product(ProductCategory category, String name) {
        this.category = category;
        this.name = name;
        this.isChecked = false;
    }

    Product(Product product) {
        if(product != null) {
            this.category = product.getCategory();
            this.name = product.getName();
            this.isChecked = product.isChecked;
        }
    }

    public ProductCategory getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
}
