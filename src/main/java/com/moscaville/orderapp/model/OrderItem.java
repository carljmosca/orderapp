/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.orderapp.model;

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
    private String primaryAttribute;
    private List<ItemAttribute> primaryAttributes;
    private String secondaryAttribute;
    private List<ItemAttribute> secondaryAttributes;
    
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

    public String getPrimaryAttribute() {
        return primaryAttribute;
    }

    public void setPrimaryAttribute(String primaryAttribute) {
        this.primaryAttribute = primaryAttribute;
    }

    public List<ItemAttribute> getPrimaryAttributes() {
        return primaryAttributes;
    }

    public void setPrimaryAttributes(List<ItemAttribute> primaryAttributes) {
        this.primaryAttributes = primaryAttributes;
    }

    public String getSecondaryAttribute() {
        return secondaryAttribute;
    }

    public void setSecondaryAttribute(String secondaryAttribute) {
        this.secondaryAttribute = secondaryAttribute;
    }

    public List<ItemAttribute> getSecondaryAttributes() {
        return secondaryAttributes;
    }

    public void setSecondaryAttributes(List<ItemAttribute> secondaryAttributes) {
        this.secondaryAttributes = secondaryAttributes;
    }

    @Override
    public String toString() {
        return description;
    }
    
}
