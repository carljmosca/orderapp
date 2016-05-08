package com.moscaville.orderapp.widgetset.client.model;

public enum Coating {
    
//Bare
//Cinnamon Sugar
//Powdered Sugar
//Glazed
//Vanilla Icing
//Chocolate Icing
//Lemon Icing
//Peanut Butter Icing
//Maple Icing
//Strawberry Icing
    
    BARE("Bare"), CINNAMON_SUGAR("Cinnamon Sugar"), POWDERED_SUGAR(
            "Powdered Sugar"), GLAZED("Glazed"), VANILLA_ICING(
            "Vanilla Icing"), ZONE_PERMIT("No zone permit"), SPECIAL_PERMIT(
            "No special permit"), PERMIT_NOT_VISIBLE("Permit not visible"), SNOW_EMERGENCY(
            "Snow emergency area"), STREET_SWEEPING("Street sweeping area"), OVER_MAX_TIME(
            "Max time exceeded"), AGAINST_TRAFFC_DIRECTION(
            "Against traffic direction");

    private final String caption;

    private Coating(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

}
