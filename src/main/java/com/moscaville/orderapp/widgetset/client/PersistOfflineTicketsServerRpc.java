package com.moscaville.orderapp.widgetset.client;

import java.util.List;

import com.moscaville.orderapp.widgetset.client.model.CustomerOrder;
import com.vaadin.shared.communication.ServerRpc;

public interface PersistOfflineTicketsServerRpc extends ServerRpc {

    void persistTickets(List<CustomerOrder> tickets);

}
