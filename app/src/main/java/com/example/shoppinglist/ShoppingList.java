package com.example.shoppinglist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ShoppingList
{
    private HashMap<ProductCategory, List<Product>> products;

    ShoppingList() {
        this.products = new HashMap<>();
    }

    ShoppingList(ShoppingList list) {
        if(list != null) {
            this.products = list.getProducts();
        }
    }
    public HashMap<ProductCategory, List<Product>> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        if(product == null) {
            //TODO Null product Exception
            return;
        }
        if(!this.products.containsKey(product.getCategory())) {
            List<Product> newCategoryList = new ArrayList<>();
            newCategoryList.add(product);
            this.products.put(product.getCategory(), newCategoryList);
            return;
        }
        this.products.get(product.getCategory()).add(product);
    }

    public void removeProduct(Product product) {
        if(product != null && this.products.containsKey(product.getCategory())) {
            this.products.get(product.getCategory()).remove(product);
        }
    }

    public void removeCategory(ProductCategory productCategory) {
        this.products.remove(productCategory);
    }

    public void changeProductStatus(Product product) {
        product.isChecked = !product.isChecked;
    }
}
