package ch.cristiano.usertask.client.dto;

public class NameChangeDataDto extends UsertaskDataBaseDto {

    private final String oldName;
    private final String newName;
    private final String evidenceDocumentId;

    public NameChangeDataDto(String oldName, String newName, String evidenceDocumentId) {
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
