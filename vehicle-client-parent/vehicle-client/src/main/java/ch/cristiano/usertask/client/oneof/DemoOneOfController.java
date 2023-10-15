package ch.cristiano.usertask.client.oneof;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.client.oneof.api.VehicleManagementApi;
import org.openapitools.client.oneof.model.CarData;
import org.openapitools.client.oneof.model.TruckData;
import org.openapitools.client.oneof.model.Vehicle;
import org.openapitools.client.oneof.model.VehicleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.cristiano.usertask.client.dto.CarDto;
import ch.cristiano.usertask.client.dto.TruckDto;
import ch.cristiano.usertask.client.dto.VehicleDto;

@RestController
public class DemoOneOfController {

    @Autowired
    @Qualifier("vehicleManagementApiOneOf")
    private VehicleManagementApi vehicleManagementApi;

    @RequestMapping(method = RequestMethod.GET, value = "/demo/oneof", produces = { "application/json" })
    public ResponseEntity<List<VehicleDto>> getDemo() {

        VehicleResponse vehicleResponse = vehicleManagementApi.queryVehicles(null, null);
        List<VehicleDto> vehicleDtos = new ArrayList<>();

        for (Vehicle vehicle : vehicleResponse.getVehicles()) {
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
