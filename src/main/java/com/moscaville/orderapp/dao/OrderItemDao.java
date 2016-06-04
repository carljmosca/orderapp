/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.orderapp.dao;

import com.moscaville.orderapp.model.OrderItem;
import java.util.List;

/**
 *
 * @author moscac
 */
public interface OrderItemDao {
    
    public List<OrderItem> listOrderItems();
    
}
