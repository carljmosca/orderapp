package com.moscaville.orderapp;

import java.util.List;

import com.vaadin.addon.touchkit.extensions.OfflineMode;
import com.moscaville.orderapp.util.DataUtil;
import com.moscaville.orderapp.widgetset.client.PersistOfflineTicketsServerRpc;
import com.moscaville.orderapp.widgetset.client.model.CustomerOrder;

/**
 * 
 * This is server side counter part for Parking offline extension. Here we
 * handle persisting the tickets stored during offline usage.
 * 
 */
public class ParkingOfflineModeExtension extends OfflineMode {

    private final PersistOfflineTicketsServerRpc serverRpc = new PersistOfflineTicketsServerRpc() {
        @Override
        public void persistTickets(final List<CustomerOrder> tickets) {
            DataUtil.persistTickets(tickets);
        }
    };

    public ParkingOfflineModeExtension() {
        registerRpc(serverRpc);
    }

}
