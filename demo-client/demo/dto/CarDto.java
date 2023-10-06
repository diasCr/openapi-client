package ch.swisscard.demo.demo.client.rest.dto;

public class CarDto extends VehicleDto {

    private String carAttributes;

    public CarDto(String vehicleType, String color, String carAttributes) {
        super(vehicleType, color);
        this.carAttributes = carAttributes;
    }

    public String getCarAttributes() {
        return carAttributes;
    }

}
