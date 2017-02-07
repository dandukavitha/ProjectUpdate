package com.HomeAppliances.controller;

import com.HomeAppliances.model.Item;
import com.HomeAppliances.service.ItemDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;



@Controller
@RequestMapping("/furnitures")
public class ItemAndDetailController {

    @Autowired
    private ItemDaoService itemService;
    
    @RequestMapping("/allItems")
    public String getAllItems(Model model) {
        List<Item> items = itemService.viewProducts();
        model.addAttribute("items", items);

        return "home";
    }
    
    @RequestMapping("/showitem/{itemId}")
    public String viewItem(@PathVariable int itemId, Model model) throws IOException {
    	Item items=itemService.getProduct(itemId);
        model.addAttribute("item", items);

        return "showItem";
    }
    
    @RequestMapping("/itemList")
    public String getItemByCategory(@RequestParam("searchCondition") String searchCondition, Model model) {
        List<Item> items = itemService.viewProducts();
        model.addAttribute("items", items);
        model.addAttribute("searchCondition", searchCondition);

        return "home";
    }
}
