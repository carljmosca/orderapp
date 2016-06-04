/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.orderapp.template;

import com.moscaville.orderapp.model.ItemAttribute;
import com.moscaville.orderapp.model.OrderItem;
import com.moscaville.orderapp.dao.OrderItemDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author moscac
 */
@Repository
public class OrderItemTemplate implements OrderItemDao {

    @Override
    public List<OrderItem> listOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItem.setDescription("Test item");
        orderItem.setPrimaryAttribute("Attribute 1");
        ItemAttribute itemAttribute = new ItemAttribute();
        itemAttribute.setDescription("Test Description");
        orderItem.getPrimaryAttributes().add(itemAttribute);
        orderItems.add(orderItem);
        orderItem = new OrderItem();
        orderItem.setDescription("Another Item");
        orderItems.add(orderItem);
        return orderItems;
    }

    private void populateOrderItems() {
        
    }
    
}
