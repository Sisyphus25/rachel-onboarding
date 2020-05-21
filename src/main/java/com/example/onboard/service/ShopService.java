package com.example.onboard.service;

import com.example.onboard.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

  @Autowired
  private ProductRepository productRepository;

  public boolean addNewProduct(String productName, String unit) {
    return productRepository.addNewProduct(productName, unit);
  }

  public boolean restockProduct(String productName, int quantity) {
    return productRepository.restockProduct(productName, quantity);
  }

  public int getProductAvailability(String productName) {
    return productRepository.getProductAvailability(productName);
  }

  public boolean purchaseProduct(String productName, int quantity) {
    return productRepository.purchaseProduct(productName, quantity);
  }

  public String getItemUnit(String productName) {
    return productRepository.getProductUnit(productName);
  }
}
