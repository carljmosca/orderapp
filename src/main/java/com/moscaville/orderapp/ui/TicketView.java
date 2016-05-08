package com.moscaville.orderapp.ui;

import java.util.List;

import com.moscaville.orderapp.util.DataUtil;
import com.moscaville.orderapp.widgetset.client.model.CustomerOrder;
import com.moscaville.orderapp.widgetset.client.ticketview.TicketViewServerRpc;
import com.moscaville.orderapp.widgetset.client.ticketview.TicketViewState;
import com.vaadin.ui.AbstractComponent;
import org.vaadin.tkspring.MainUI;

/**
 * A view to report a new parking ticket.
 * <p>
 * The form in the view uses "pre created fields pattern" thus the view also
 * implements FormFieldFactory that return pre created fields based on the
 * property key.
 */
public class TicketView extends AbstractComponent implements
        TicketViewServerRpc {

    public TicketView() {
        setSizeFull();
        registerRpc(this);
    }

    @Override
    protected TicketViewState getState() {
        return (TicketViewState) super.getState();
    }

    @Override
    public void persistTickets(final List<CustomerOrder> tickets) {
        DataUtil.persistTickets(tickets);
        getState().setTicket(new CustomerOrder());
    }

    @Override
    public void positionReceived(final double latitude, final double longitude) {
        MainUI.getApp().setCurrentLatitude(latitude);
        MainUI.getApp().setCurrentLongitude(longitude);
    }

    @Override
    public void updateState(final CustomerOrder ticket) {
        getState().setTicket(ticket);
    }
}
