package com.example.onboard.controller;

import com.example.onboard.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
public class ShopController {

  @Autowired
  private ShopService shopService;

  @RequestMapping(value = "shop/product", method = RequestMethod.GET)
  public Integer getItemAvailability(@RequestParam String name) {
    return shopService.getProductAvailability(name);
  }

  @RequestMapping(value = "shop/product", method = RequestMethod.POST)
  public String purchaseItem(@RequestParam(value = "name") String name, @RequestParam(value = "quantity") Integer quantity) {
    if (shopService.purchaseProduct(name, quantity)) {
      return String.format("Successfully purchased %d %s of %s", quantity, shopService.getItemUnit(name), name);
    }
    return "Purchase unsuccessful";
  }

  @RequestMapping(value = "shop/product/restock", method = RequestMethod.POST)
  public String restockItem(@RequestParam(value = "name") String name, @RequestParam(value = "quantity") Integer quantity) {
    if (shopService.restockProduct(name, quantity)) {
      return "Restock successful";
    }
    return "Restock unsuccessful";
  }

  @RequestMapping(value = "shop/product/add", method = RequestMethod.POST)
  public String addNewItem(@RequestParam(value = "name") String name, @RequestParam(value = "unit") String unit) {
    if (shopService.addNewProduct(name, unit)) {
      return "Add new item successful";
    }
    return "Item already existed in product catalog";
  }

}
