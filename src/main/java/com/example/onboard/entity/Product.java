package com.example.onboard.entity;

public class Product {
  private String itemName;
  private String itemUnit;

  public Product(String name, String unit) {
    this.itemName = name;
    this.itemUnit = unit;
  }

  public String getItemName() {
    return itemName;
  }

  public String getItemUnit() {
    return itemUnit;
  }
}
