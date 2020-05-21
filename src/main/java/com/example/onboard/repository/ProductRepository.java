package com.example.onboard.repository;

import com.example.onboard.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository {

  static HashMap<String, Product> productMap = new HashMap<String, Product>();
  static HashMap<String, Integer> itemStock = new HashMap<String, Integer>();

  public int getProductAvailability(String productName) {
    if (itemStock.get(productName) != null) {
      return itemStock.get(productName);
    }
    return 0;
  }

  public boolean purchaseProduct(String productName, int quantity) {
    if (itemStock.get(productName) != null) {
      return itemStock.get(productName) - quantity >= 0;
    }
    return false;
  }

  public boolean restockProduct(String productName, int quantity) {
    if (productMap.get(productName) == null) {
      return false;
    }
    itemStock.put(productName, quantity + itemStock.get(productName));
    return true;
  }

  public boolean addNewProduct(String productName, String unit) {
    if (productMap.get(productName) != null) {
      return false;
    }
    Product newProduct = new Product(productName, unit);
    itemStock.put(productName, 0);
    productMap.put(productName, newProduct);
    return true;
  }

  public String getProductUnit(String productName) {
    Product product = productMap.get(productName);
    if (product != null) {
      return product.getItemUnit();
    }
    return "";
  }
}
