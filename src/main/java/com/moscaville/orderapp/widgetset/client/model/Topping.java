package com.moscaville.orderapp.widgetset.client.model;

import java.io.Serializable;

public class Topping implements Serializable {
    private double longitude;
    private double latitude;
    private String address;

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private static final String DELIMITER = "<l-d>";

    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append(longitude + DELIMITER);
        sb.append(latitude + DELIMITER);
        sb.append(address + DELIMITER);
        return sb.toString();
    }

    public static Topping deserialize(final String str) {
        Topping result = null;
        if (str != null) {
            result = new Topping();
            String[] split = str.split(DELIMITER);
            result.setLongitude(Double.parseDouble(split[0]));
            result.setLatitude(Double.parseDouble(split[1]));
            if (split.length > 2) {
                result.setAddress(split[2]);
            }
        }
        return result;
    }
}
