package com.moscaville.orderapp.widgetset.client.ticketview;

public interface TicketViewModuleListener {
    void fieldsChanged();

    void positionReceived(double latitude, double longitude);
}
