package parking;

public enum VehicleType {
    TWO_WHEELER("Two Wheelerrrrrr"), CAR("Carrrrrrrr");
    private String value;

    private VehicleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
