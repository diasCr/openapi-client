package ch.cristiano.usertask.client.dto;

public class TruckDto extends VehicleDto {

    private String truckAttributes;
    private int truckCountWheels;

    public TruckDto(String vehicleType, String color, String truckAttributes, int truckCountWheels) {
        super(vehicleType, color);
        this.truckAttributes = truckAttributes;
        this.truckCountWheels = truckCountWheels;
    }

    public String getTruckAttributes() {
        return truckAttributes;
    }

    public int getTruckCountWheels() {
        return truckCountWheels;
    }

}
