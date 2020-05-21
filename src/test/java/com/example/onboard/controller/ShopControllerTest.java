package com.example.onboard.controller;

import com.example.onboard.service.ShopService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ShopControllerTest {
  @Autowired
  private ShopService shopService;
  @Autowired
  private ShopController shopController;

  @Test
  @Order(1)
  public void addNewProductAPITest() {
    assertEquals("Add new item successful", shopController.addNewItem("vanilla milk", "carton"));
    assertEquals("Item already existed in product catalog", shopController.addNewItem("vanilla milk", "carton"));
  }

  @Test
  @Order(2)
  public void restockItemAPITest() {
    assertEquals("Restock successful", shopController.restockItem("vanilla milk", 10));
    assertEquals("Restock unsuccessful", shopController.restockItem("special milk", 10));
  }

  @Test
  @Order(3)
  public void checkItemAvailabilityAPITest() {
    assertEquals(10, shopController.getItemAvailability("vanilla milk"));
    assertEquals(0, shopController.getItemAvailability("special egg"));
    assertEquals(0, shopController.getItemAvailability("candy"));
  }

  @Test
  @Order(4)
  public void purchaseItemAPITest() {
    assertEquals("Successfully purchased 5 carton of vanilla milk", shopController.purchaseItem("vanilla milk", 5));
    assertEquals(shopController.purchaseItem("special egg", 5), "Purchase unsuccessful");
  }
}