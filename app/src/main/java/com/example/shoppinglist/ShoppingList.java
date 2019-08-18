package com.example.shoppinglist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ShoppingList
{
    private HashMap<ProductCategory, List<Product>> products;
    private ProductCategoryMapper productCategoryMapper;

    ShoppingList() {
        this.productCategoryMapper = ProductCategoryMapper.getInstance();
        this.products = this.productCategoryMapper.getNewShoppingListProductMap();
    }

    ShoppingList(ShoppingList list) {
        if(list == null) {
            this.productCategoryMapper = ProductCategoryMapper.getInstance();
            this.products = this.productCategoryMapper.getNewShoppingListProductMap();
        }
        this.products = list.getProducts();
        this.productCategoryMapper = ProductCategoryMapper.getInstance();
    }

    public HashMap<ProductCategory, List<Product>> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        if(product == null) {
            //TODO Null product Exception
            return;
        }
        ProductCategory productCategory = this.productCategoryMapper.getProductCategory(product);
        this.products.get(productCategory).add(product);
    }

    public void removeProduct(Product product) {
        if(product != null) {
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
