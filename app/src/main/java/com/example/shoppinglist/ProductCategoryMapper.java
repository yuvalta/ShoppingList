package com.example.shoppinglist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ProductCategoryMapper
{
    private static final ProductCategoryMapper ourInstance = new ProductCategoryMapper();

    private HashMap<String, ProductCategory> productCategoryMappings;
    private LinkedList<String> newProductMappings;

    private ProductCategoryMapper()
    {
        this.productCategoryMappings = new HashMap<>();
        //TODO get Dictionary from firebase.
        this.newProductMappings = new LinkedList<>();
    }
    public static ProductCategoryMapper getInstance()
    {
        return ourInstance;
    }

    public HashMap<String, ProductCategory> getProductCategoryMappings() {
        return productCategoryMappings;
    }

    public LinkedList<String> getNewProductMappings() {
        return newProductMappings;
    }

    public ProductCategory getProductCategory(Product product) {
        if(productCategoryMappings.containsKey(product.getName())) {
            return productCategoryMappings.get(product.getName());
        } else if(!newProductMappings.contains(product.getName())) {
            newProductMappings.add(product.getName());
        }
        return ProductCategory.Not_Mapped;
    }

    public HashMap<ProductCategory, List<Product>> getNewShoppingListProductMap() {
        HashMap<ProductCategory, List<Product>> products = new HashMap<>();
        for(ProductCategory category : ProductCategory.values()) {
            products.put(category, new LinkedList<Product>());
        }
        return products;
    }
}
