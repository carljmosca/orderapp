/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.orderapp.dao;

import com.moscaville.model.CustomerOrder;
import java.util.List;

/**
 *
 * @author moscac
 */
public interface CustomerOrderDao {


    public void create(CustomerOrder customerOrder);

    public CustomerOrder getCustomerOrder(Integer id);

    public List<CustomerOrder> listCustomerOrders();

    public void delete(Integer id);

    public void deleteAll();

    public void update(Integer id);
}
