package ch.swisscard.demo.demo.client.rest;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.client.api.VehicleManagementApi;
import org.openapitools.client.model.CarData;
import org.openapitools.client.model.TruckData;
import org.openapitools.client.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.swisscard.demo.demo.client.rest.dto.CarDto;
import ch.swisscard.demo.demo.client.rest.dto.TruckDto;
import ch.swisscard.demo.demo.client.rest.dto.VehicleDto;

@RestController
public class DemoController {

    @Autowired
    private VehicleManagementApi vehicleManagementApi;

    @RequestMapping(method = RequestMethod.GET, value = "/demo", produces = { "application/json" })
    public ResponseEntity<List<VehicleDto>> getDemo() {

        List<Vehicle> vehicles = vehicleManagementApi.queryVehicles();
        List<VehicleDto> vehicleDtos = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            // anti-pattern for tolerant reader
            // switch (UsertaskType.valueOf(usertask.getUsertaskType())) {

            switch (vehicle.getVehicleType()) {
                case "CAR":
                    vehicleDtos.add(this.mapCar(vehicle));
                    break;
                case "TRUCK":
                    vehicleDtos.add(this.mapTruck(vehicle));
                    break;
                default:
                    continue;
            }
        }

        return ResponseEntity.ok(vehicleDtos);
    }

    private VehicleDto mapCar(Vehicle vehicle) {
        CarData carData = ((CarData) vehicle.getData());
        String carAttributes = carData.getCarAttributes();
        CarDto carDto = new CarDto(vehicle.getVehicleType(), vehicle.getColor(), carAttributes);
        return carDto;
    }

    private VehicleDto mapTruck(Vehicle vehicle) {
        TruckData truckData = ((TruckData) vehicle.getData());
        String truckAttributes = truckData.getTruckAttributes();
        int truckCountWheels = truckData.getTruckCountWheels();
        TruckDto truckDto = new TruckDto(vehicle.getVehicleType(), vehicle.getColor(), truckAttributes,
                truckCountWheels);
        return truckDto;
    }

}
