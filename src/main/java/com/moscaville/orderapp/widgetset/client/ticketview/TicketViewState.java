package com.moscaville.orderapp.widgetset.client.ticketview;

import com.moscaville.orderapp.widgetset.client.model.CustomerOrder;
import com.vaadin.shared.AbstractComponentState;

public class TicketViewState extends AbstractComponentState {
    private CustomerOrder ticket = new CustomerOrder();

    public CustomerOrder getTicket() {
        return ticket;
    }

    public void setTicket(CustomerOrder ticket) {
        this.ticket = ticket;
    }

}
