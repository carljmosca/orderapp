package com.moscaville.orderapp.widgetset.client.ticketview;

import java.util.Arrays;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.moscaville.orderapp.ui.TicketView;
import com.moscaville.orderapp.widgetset.client.model.CustomerOrder;
import com.moscaville.orderapp.widgetset.client.ticketview.TicketViewWidget.TicketViewWidgetListener;
import com.vaadin.shared.ui.Connect;

@SuppressWarnings("serial")
@Connect(TicketView.class)
public class TicketViewConnector extends AbstractComponentConnector implements
        TicketViewWidgetListener {

    private final TicketViewServerRpc rpc = RpcProxy.create(
            TicketViewServerRpc.class, this);

    @Override
    public TicketViewWidget getWidget() {
        return (TicketViewWidget) super.getWidget();
    }

    @Override
    public TicketViewState getState() {
        return (TicketViewState) super.getState();
    }

    @Override
    protected Widget createWidget() {
        final TicketViewWidget widget = GWT.create(TicketViewWidget.class);
        widget.setTicketViewWidgetListener(this);
        return widget;
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        getWidget().ticketUpdated(getState().getTicket(), true);
        super.onStateChanged(stateChangeEvent);
    }

    @Override
    public void persistTicket(final CustomerOrder ticket) {
        // Send the Ticket to server to be persisted
        rpc.persistTickets(Arrays.asList(ticket));
    }

    @Override
    public void positionReceived(final double latitude, final double longitude) {
        rpc.positionReceived(latitude, longitude);
    }

    @Override
    public void updateState(final CustomerOrder ticket) {
        rpc.updateState(ticket);
    }

    @Override
    public void onUnregister() {
        getWidget().destroy();
        super.onUnregister();
    }
}
