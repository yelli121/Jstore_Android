package jstore.controller;

import jstore.DatabaseItem;
import jstore.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ItemController {

    @RequestMapping(value = "/items", method= RequestMethod.GET)
    public ArrayList<Item> itemList(){
        return DatabaseItem.getItemDatabase();
    }

    @RequestMapping(value = "/items/{id_item}", method = RequestMethod.GET)
    public Item getItemFromID(@PathVariable int id_item) {
        return DatabaseItem.getItemFromID(id_item);
    }
}
