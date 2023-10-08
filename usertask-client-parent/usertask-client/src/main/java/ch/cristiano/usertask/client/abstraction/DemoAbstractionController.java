package ch.cristiano.usertask.client.abstraction;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.client.abstraction.api.UsertaskManagementApi;
import org.openapitools.client.abstraction.model.AddressChangeInputData;
import org.openapitools.client.abstraction.model.NameChangeInputData;
import org.openapitools.client.abstraction.model.SortOrder;
import org.openapitools.client.abstraction.model.Usertask;
import org.openapitools.client.abstraction.model.UsertaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.cristiano.usertask.client.dto.AddressChangeDataDto;
import ch.cristiano.usertask.client.dto.NameChangeDataDto;
import ch.cristiano.usertask.client.dto.UsertaskDto;

@RestController
public class DemoAbstractionController {

    @Autowired
    private UsertaskManagementApi usertaskManagementApi;

    @RequestMapping(method = RequestMethod.GET, value = "/demo/abstraction", produces = { "application/json" })
    public ResponseEntity<List<UsertaskDto>> getDemo() {

        List<Usertask> usertasks = usertaskManagementApi.queryUserTasks(UsertaskType.NAME_CHANGE_TASK, null,
                SortOrder.DESCENDING, null, null);
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
        NameChangeInputData nameChangeInputData = (NameChangeInputData) usertask.getInputData();

        String oldName = nameChangeInputData.getOldName();
        String newName = nameChangeInputData.getNewName();
        String evidenceDocumentId = nameChangeInputData.getEvidenceDocumentId();

        NameChangeDataDto nameChangeInputDataDto = new NameChangeDataDto(oldName, newName, evidenceDocumentId);
        UsertaskDto usertaskDto = new UsertaskDto(usertask.getUsertaskType(), nameChangeInputDataDto);

        usertaskDto.setOutputData(usertask.getOutputData());

        return usertaskDto;
    }

    private UsertaskDto mapAddressChange(Usertask usertask) {
        AddressChangeInputData addressChangeData = (AddressChangeInputData) usertask.getInputData();

        String oldAddressLine1 = addressChangeData.getOldAddressLine1();
        String newAddressLine1 = addressChangeData.getNewAddressLine1();
        String evidenceDocumentId = addressChangeData.getEvidenceDocumentId();
        String oldCity = addressChangeData.getOldCity();
        String newCity = addressChangeData.getNewCity();
        String oldZipCode = addressChangeData.getOldZipCode();
        String newZipCode = addressChangeData.getNewZipCode();

        AddressChangeDataDto addressChangeDataDto = new AddressChangeDataDto(oldAddressLine1,
                newAddressLine1, evidenceDocumentId);
        addressChangeDataDto.setNewCity(newCity);
        addressChangeDataDto.setOldCity(oldCity);
        addressChangeDataDto.setNewZipCode(newZipCode);
        addressChangeDataDto.setOldZipCode(oldZipCode);
        UsertaskDto usertaskDto = new UsertaskDto(usertask.getUsertaskType(), addressChangeDataDto);

        usertaskDto.setOutputData(usertask.getOutputData());

        return usertaskDto;
    }

}
