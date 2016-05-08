package com.moscaville.orderapp.widgetset.client.ticketview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.google.gwt.core.client.Callback;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.geolocation.client.Geolocation;
import com.google.gwt.geolocation.client.PositionError;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.addon.touchkit.gwt.client.ui.DatePicker;
import com.vaadin.addon.touchkit.gwt.client.ui.DatePicker.Resolution;
import com.vaadin.addon.touchkit.gwt.client.ui.VSwitch;
import com.vaadin.addon.touchkit.gwt.client.ui.VerticalComponentGroupWidget;
import com.vaadin.client.ui.VTextField;
import com.moscaville.orderapp.widgetset.client.model.Topping;
import com.moscaville.orderapp.widgetset.client.model.CustomerOrder;
import com.moscaville.orderapp.widgetset.client.model.Coating;

public class InformationLayout extends VerticalComponentGroupWidget {

    private final VSwitch useCurrentLocationSwitch;
    private com.google.gwt.geolocation.client.Position currentPosition;
    private final VTextField addressField;
    private final DatePicker timeField;
    private Date date = new Date();
    private final VTextField vehicleIdField;
    private final ListBox coatingBox;
    private final ListBox toppingBox;
    private final TicketViewModuleListener listener;

    private void requestUserPosition() {
        Geolocation geolocation = Geolocation.getIfSupported();
        if (geolocation == null) {
            useCurrentLocationSwitch.setValue(false);
        } else {
            geolocation
                    .getCurrentPosition(new Callback<com.google.gwt.geolocation.client.Position, PositionError>() {
                        @Override
                        public void onSuccess(
                                final com.google.gwt.geolocation.client.Position result) {
                            currentPosition = result;
                            if (listener != null) {
                                listener.positionReceived(result
                                        .getCoordinates().getLatitude(), result
                                        .getCoordinates().getLongitude());
                            }
                        }

                        @Override
                        public void onFailure(final PositionError reason) {
                            useCurrentLocationSwitch.setValue(false, true);
                            remove(useCurrentLocationSwitch);
                        }
                    });
        }
    }

    private Element getRowElement(final Widget field) {
        Element elem = field.getElement();
        while (!elem.getClassName().contains("v-touchkit-componentgroup-row")) {
            elem = elem.getParentElement();
        }
        return elem;
    }

    public final boolean validateFields() {
        resetValidations();

        ArrayList<Widget> invalidFields = new ArrayList<>();

        boolean valid = true;
        if (!useCurrentLocationSwitch.getValue()
                && (addressField.getText() == null || addressField.getText()
                .trim().isEmpty())) {
            valid = false;
            invalidFields.add(addressField);
        }
        if (date == null) {
            valid = false;
            invalidFields.add(timeField);
        }
        if (vehicleIdField.getText() == null
                || vehicleIdField.getText().trim().isEmpty()) {
            valid = false;
            invalidFields.add(vehicleIdField);
        }

        if (coatingBox.getSelectedIndex() == 0) {
            valid = false;
            invalidFields.add(coatingBox);
        }
        if (toppingBox.getSelectedIndex() == 0) {
            valid = false;
            invalidFields.add(toppingBox);
        }
        for (Widget invalidField : invalidFields) {
            getRowElement(invalidField).addClassName("invalid");
        }
        return valid;
    }

    public InformationLayout(final TicketViewModuleListener listener) {
        this.listener = listener;
        final String styleOn = "v-touchkit-switch-on";
        useCurrentLocationSwitch = new VSwitch();
        useCurrentLocationSwitch
                .addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                    @Override
                    public void onValueChange(
                            final ValueChangeEvent<Boolean> event) {
                        if (event.getValue()) {
                            useCurrentLocationSwitch.addStyleName(styleOn);
                            requestUserPosition();
                        } else {
                            useCurrentLocationSwitch.removeStyleName(styleOn);
                        }
                        if (!event.getValue()) {
                            currentPosition = null;
                        }

                        getRowElement(addressField).getStyle().setProperty(
                                "display", event.getValue() ? "none" : "");
                    }
                });
        add(useCurrentLocationSwitch);
        updateCaption(useCurrentLocationSwitch, "My location", null, "100.0%",
                "v-caption");

        final ValueChangeHandler<String> vch = new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(final ValueChangeEvent<String> event) {
                listener.fieldsChanged();
            }
        };

        addressField = new VTextField();
        addressField.addValueChangeHandler(vch);
        addressField.setWidth("100%");

        /*
         * ClickHandler is needed for fixing bug #14743 with WP
         */
        addressField.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                addressField.setFocus(true);
            }
        });

        add(addressField);
        updateCaption(addressField, "Address", null, "100.0%", "v-caption");

        timeField = new DatePicker();
        timeField.setResolution(Resolution.TIME);
        timeField.setDate(date);

        timeField.addValueChangeHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(ValueChangeEvent<Date> event) {
                date = timeField.getDateValue();
                listener.fieldsChanged();
            }
        });
                
//                (final ValueChangeEvent<Date> event) -> {
//            date = timeField.getDateValue();
//            listener.fieldsChanged();
//        });

        add(timeField);
        updateCaption(timeField, "Time", null, "100.0%", "v-caption");

        vehicleIdField = new VTextField();
        vehicleIdField.addValueChangeHandler(vch);
        vehicleIdField.setWidth("100%");

        /*
         * ClickHandler is needed for fixing bug #14743 with WP
         */
        vehicleIdField.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                vehicleIdField.setFocus(true);

            }
        });

        add(vehicleIdField);
        updateCaption(vehicleIdField, "Vehicle ID", null, "100.0%", "v-caption");

        final ChangeHandler ch = new ChangeHandler() {
            @Override
            public void onChange(final ChangeEvent event) {
                listener.fieldsChanged();
            }
        };

        coatingBox = new ListBox();
        coatingBox.setMultipleSelect(true);
        coatingBox.addChangeHandler(ch);
        coatingBox.addItem("Choose...", (String) null);
        for (Coating coating : Coating.values()) {
            coatingBox.addItem(coating.getCaption(), coating.name());
        }
        coatingBox.setWidth("100%");
        coatingBox.setStyleName("v-select-select");
        SimplePanel coatingWrapper = new SimplePanel(coatingBox);
        coatingWrapper.setStyleName("v-select");
        add(coatingWrapper);
        updateCaption(coatingWrapper, "Coating", null, "100.0%",
                "v-caption");

        toppingBox = new ListBox();
        toppingBox.addChangeHandler(ch);
        toppingBox.addItem("Choose...", (String) null);
        for (char zone : "ABC".toCharArray()) {
            for (int i = 1; i < 5; i++) {
                String area = String.valueOf(zone) + i;
                toppingBox.addItem(area, area);
            }
        }
        toppingBox.setWidth("100%");
        toppingBox.setStyleName("v-select-select");
        SimplePanel toppingWrapper = new SimplePanel(toppingBox);
        toppingWrapper.setStyleName("v-select");
        add(toppingWrapper);
        updateCaption(toppingWrapper, "Topping", null, "100.0%", "v-caption");

        useCurrentLocationSwitch.setValue(true, true);
    }

    public final void resetValidations() {
        for (Widget field : Arrays.<Widget>asList(addressField, timeField,
                vehicleIdField, coatingBox, toppingBox)) {
            getRowElement(field).removeClassName("invalid");
        }
    }

    public final void populateTicket(final CustomerOrder ticket) {
        final Topping location = new Topping();
        if (currentPosition != null) {
            location.setLatitude(currentPosition.getCoordinates().getLatitude());
            location.setLongitude(currentPosition.getCoordinates()
                    .getLongitude());
        }
        location.setAddress(addressField.getText());
        ticket.setLocation(location);

        ticket.setTimeStamp(date);

        ticket.setRegisterPlateNumber(vehicleIdField.getText());

        int vi = coatingBox.getSelectedIndex();
        ticket.setViolation(vi == 0 ? null : Coating.values()[vi - 1]);

        ticket.setArea(toppingBox.getValue(toppingBox.getSelectedIndex()));
    }

    public final void ticketUpdated(final CustomerOrder ticket) {
        addressField.setText(ticket.getLocation().getAddress());

        vehicleIdField.setText(ticket.getRegisterPlateNumber());

        int vi = Arrays.asList(Coating.values()).indexOf(
                ticket.getViolation()) + 1;
        coatingBox.setSelectedIndex(vi);

        toppingBox.setSelectedIndex(0);
        for (int i = 0; i < toppingBox.getItemCount(); i++) {
            if (toppingBox.getValue(i).equals(ticket.getArea())) {
                toppingBox.setSelectedIndex(i);
                break;
            }
        }

        date = ticket.getTimeStamp();
        timeField.setDate(date);
    }
}