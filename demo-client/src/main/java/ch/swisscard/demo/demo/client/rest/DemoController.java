package ch.swisscard.demo.demo.client.rest;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.client.api.UsertaskManagementApi;
import org.openapitools.client.model.AddressChangeData;
import org.openapitools.client.model.NameChangeData;
import org.openapitools.client.model.Usertask;
import org.openapitools.client.model.UsertaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.swisscard.demo.demo.client.rest.dto.AddressChangeTaskDto;
import ch.swisscard.demo.demo.client.rest.dto.NameChangeTaskDto;
import ch.swisscard.demo.demo.client.rest.dto.UsertaskDto;

@RestController
public class DemoController {

    @Autowired
    private UsertaskManagementApi usertaskManagementApi;

    @RequestMapping(method = RequestMethod.GET, value = "/demo", produces = { "application/json" })
    public ResponseEntity<List<UsertaskDto>> getDemo() {

        List<Usertask> usertasks = usertaskManagementApi.queryUserTasks(null, null, null, null, null);
        List<UsertaskDto> usertaskDtos = new ArrayList<>();

        for (Usertask usertask : usertasks) {
            // anti-pattern for tolerant reader
            // switch (UsertaskType.valueOf(usertask.getUsertaskType())) {

            switch (usertask.getUsertaskType()) {
                case "NAME_CHANGE_TASK":
                    usertaskDtos.add(this.mapNameChange(usertask));
                    break;
                case "ADDRESS_CHANGE_TASK":
                    usertaskDtos.add(this.mapAddressChange(usertask));
                    break;
                default:
                    continue;
            }
        }

        return ResponseEntity.ok(usertaskDtos);
    }

    private UsertaskDto mapNameChange(Usertask usertask) {
        NameChangeData nameChangeData = (NameChangeData) usertask.getData();

        String oldName = nameChangeData.getOldName();
        String newName = nameChangeData.getNewName();
        String evidenceDocumentId = nameChangeData.getEvidenceDocumentId();

        NameChangeTaskDto nameChangeTaskDto = new NameChangeTaskDto(UsertaskType.NAME_CHANGE_TASK.name(), oldName,
                newName, evidenceDocumentId);

        return nameChangeTaskDto;
    }

    private UsertaskDto mapAddressChange(Usertask usertask) {
        AddressChangeData addressChangeData = (AddressChangeData) usertask.getData();

        String oldAddressLine1 = addressChangeData.getOldAddressLine1();
        String newAddressLine1 = addressChangeData.getNewAddressLine1();

        AddressChangeTaskDto addressChangeTaskDto = new AddressChangeTaskDto(UsertaskType.ADDRESS_CHANGE_TASK.name(),
                oldAddressLine1,
                newAddressLine1);

        return addressChangeTaskDto;
    }

}
