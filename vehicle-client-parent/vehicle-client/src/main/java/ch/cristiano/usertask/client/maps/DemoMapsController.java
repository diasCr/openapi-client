package ch.cristiano.usertask.client.maps;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.client.maps.api.VehicleManagementApi;
import org.openapitools.client.maps.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.cristiano.usertask.client.dto.CarDto;
import ch.cristiano.usertask.client.dto.TruckDto;
import ch.cristiano.usertask.client.dto.VehicleDto;

@RestController
public class DemoMapsController {

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
        // CarDataMap carData = ((CarDataMap) vehicle.getData());
        // String carAttributes = carData.getCarAttributes();
        String carAttributes = String.valueOf(vehicle.getData().get("carAttributes"));
        CarDto carDto = new CarDto(vehicle.getVehicleType(), vehicle.getColor(), carAttributes);
        return carDto;
    }

    private VehicleDto mapTruck(Vehicle vehicle) {
        // TruckDataMap truckData = ((TruckDataMap) vehicle.getData());
        // String truckAttributes = truckData.getTruckAttributes();
        // int truckCountWheels = truckData.getTruckCountWheels();
        String truckAttributes = (String) vehicle.getData().get("truckAttributes");
        int truckCountWheels = (Integer) vehicle.getData().get("truckCountWheels");
        TruckDto truckDataDto = new TruckDto(vehicle.getVehicleType(), vehicle.getColor(), truckAttributes,
                truckCountWheels);
        return truckDataDto;
    }

}
