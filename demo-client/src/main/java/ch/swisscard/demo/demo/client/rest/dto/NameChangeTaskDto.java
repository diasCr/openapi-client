package ch.swisscard.demo.demo.client.rest.dto;

public class NameChangeTaskDto extends UsertaskDto {

    private final String oldName;
    private final String newName;
    private final String evidenceDocumentId;

    public NameChangeTaskDto(String usertaskType, String oldName, String newName, String evidenceDocumentId) {
        super(usertaskType);
        this.oldName = oldName;
        this.newName = newName;
        this.evidenceDocumentId = evidenceDocumentId;
    }

    public String getOldName() {
        return oldName;
    }

    public String getNewName() {
        return newName;
    }

    public String getEvidenceDocumentId() {
        return evidenceDocumentId;
    }

}
