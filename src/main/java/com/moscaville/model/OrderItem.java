/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moscac
 */
public class OrderItem implements Serializable {
    
    private int itemNumber;
    private String description;
    private List<String> primaryAttributes;
    private List<String> secondaryAttributes;
    
    public OrderItem() {
        primaryAttributes = new ArrayList<>();
        secondaryAttributes = new ArrayList<>();
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPrimaryAttributes() {
        return primaryAttributes;
    }

    public void setPrimaryAttributes(List<String> primaryAttributes) {
        this.primaryAttributes = primaryAttributes;
    }

    public List<String> getSecondaryAttributes() {
        return secondaryAttributes;
    }

    public void setSecondaryAttributes(List<String> secondaryAttributes) {
        this.secondaryAttributes = secondaryAttributes;
    }

    @Override
    public String toString() {
        return description;
    }
    
}
