package ch.cristiano.usertask.client.maps;

import java.util.ArrayList;
import java.util.List;

import org.openapitools.client.maps.api.UsertaskManagementApi;
import org.openapitools.client.maps.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.cristiano.usertask.client.dto.AddressChangeDataDto;
import ch.cristiano.usertask.client.dto.NameChangeDataDto;
import ch.cristiano.usertask.client.dto.UsertaskDto;

@RestController
public class DemoMapsController {

    @Autowired
    @Qualifier("usertaskManagementApiMaps")
    private UsertaskManagementApi usertaskManagementApi;

    @RequestMapping(method = RequestMethod.GET, value = "/demo/maps", produces = { "application/json" })
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
        // NameChangeInputData nameChangeInputData = ((NameChangeInputData)
        // usertask.getInputData());

        // String oldName = nameChangeInputData.getOldName();
        // String newName = nameChangeInputData.getNewName();
        // String evidenceDocumentId = nameChangeInputData.getEvidenceDocumentId();

        String oldName = usertask.getInputData().get("oldName").toString();
        String newName = usertask.getInputData().get("newName").toString();
        String evidenceDocumentId = usertask.getInputData().get("evidenceDocumentId").toString();

        NameChangeDataDto changeInputDataDto = new NameChangeDataDto(oldName, newName, evidenceDocumentId);
        UsertaskDto usertaskDto = new UsertaskDto(usertask.getId(), usertask.getUsertaskType(), changeInputDataDto);

        usertaskDto.setOutputData(usertask.getOutputData());

        return usertaskDto;
    }

    private UsertaskDto mapAddressChange(Usertask usertask) {
        // AddressChangeInputData addressChangeInputData = ((AddressChangeInputData)
        // usertask.getInputData());

        // String oldAddressLine1 = addressChangeInputData.getOldAddressLine1();
        // String newAddressLine1 = addressChangeInputData.getNewAddressLine1();
        // String evidenceDocumentId = addressChangeInputData.getEvidenceDocumentId();
        // String oldCity = addressChangeInputData.getOldCity();
        // String newCity = addressChangeInputData.getNewCity();
        // String oldZipCode = addressChangeInputData.getOldZipCode();
        // String newZipCode = addressChangeInputData.getNewZipCode();

        String oldAddressLine1 = usertask.getInputData().get("oldAddressLine1").toString();
        String newAddressLine1 = usertask.getInputData().get("newAddressLine1").toString();
        String evidenceDocumentId = usertask.getInputData().get("evidenceDocumentId").toString();

        AddressChangeDataDto addressChangeDataDto = new AddressChangeDataDto(oldAddressLine1,
                newAddressLine1, evidenceDocumentId);
        UsertaskDto usertaskDto = new UsertaskDto(usertask.getId(), usertask.getUsertaskType(), addressChangeDataDto);

        usertaskDto.setOutputData(usertask.getOutputData());

        return usertaskDto;
    }

}
