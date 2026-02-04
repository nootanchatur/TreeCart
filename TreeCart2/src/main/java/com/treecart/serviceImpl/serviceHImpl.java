package com.treecart.serviceImpl;
import com.treecart.model.Item;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class serviceHImpl {

private List<Item>items=new ArrayList<>();

    // Add new item
    public Item addItem(Item item) {
        items.add(item);
        return item;
    }

    // Get item by ID
    public Item getItemById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
