package com.moscaville.orderapp.widgetset.client.ticketview;

import java.util.List;

import com.moscaville.orderapp.widgetset.client.model.CustomerOrder;
import com.vaadin.shared.annotations.Delayed;
import com.vaadin.shared.communication.ServerRpc;

public interface TicketViewServerRpc extends ServerRpc {
    void persistTickets(List<CustomerOrder> tickets);

    void positionReceived(double latitude, double longitude);

    @Delayed(lastOnly = true)
    void updateState(CustomerOrder ticket);
}
