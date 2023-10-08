package ch.cristiano.usertask.client.dto;

public class VehicleDto {

    private final String vehicleType;
    private final String color;

    public VehicleDto(String vehicleType, String color) {
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getVehicleType() {
        return vehicleType;
    }

}
