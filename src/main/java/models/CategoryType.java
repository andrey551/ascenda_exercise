package models;

public enum CategoryType {
    RESTAURANT,
    RETAIL,
    HOTEL,
    ACTIVITY,
    NOT_EXIST;

    public static CategoryType convertFromInt(int order) {
        switch(order) {
            case 1:
                return CategoryType.RESTAURANT;
            case 2:
                return CategoryType.RETAIL;
            case 3:
                return CategoryType.HOTEL;
            case 4:
                return CategoryType.ACTIVITY;
            default:
                return NOT_EXIST;
        }
    }
}
