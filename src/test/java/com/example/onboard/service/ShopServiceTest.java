package com.example.onboard.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShopServiceTest {

  @Autowired
  private ShopService shopService;

  @Test
  public void addNewProductTest() {
    assertTrue(shopService.addNewProduct("milk", "carton"), "Add new item not in catalog successfully");
    assertFalse(shopService.addNewProduct("milk", "carton"), "Can't add item already exists");
  }

  @Test
  public void restockItemTest() {
    shopService.addNewProduct("chocolate milk", "carton");
    assertTrue(shopService.restockProduct("chocolate milk", 10), "Restock item in catalog successfully");
    assertFalse(shopService.restockProduct("chocolate bar", 10), "Can't restock item not yet added");
  }

  @Test
  public void checkItemAvailabilityTest() {
    shopService.addNewProduct("banana milk", "carton");
    shopService.addNewProduct("egg", "box");
    shopService.restockProduct("banana milk", 10);
    assertEquals(10, shopService.getProductAvailability("banana milk"));
    assertEquals(0, shopService.getProductAvailability("egg"));
    assertEquals(0, shopService.getProductAvailability("candy"));
  }

  @Test
  public void purchaseItemTest() {
    shopService.addNewProduct("orange juice", "carton");
    shopService.addNewProduct("popcorn", "box");
    shopService.restockProduct("orange juice", 10);
    assertTrue(shopService.purchaseProduct("orange juice", 5));
    assertFalse(shopService.purchaseProduct("egg", 5));
    assertFalse(shopService.purchaseProduct("candy", 5));
    assertTrue(shopService.purchaseProduct("orange juice", 7));
  }
}
