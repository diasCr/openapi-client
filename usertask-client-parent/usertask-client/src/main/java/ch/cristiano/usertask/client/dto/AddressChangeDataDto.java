package ch.cristiano.usertask.client.dto;

public class AddressChangeDataDto extends UsertaskDataBaseDto {

    private final String oldAddressLine1;
    private final String newAddressLine1;
    private final String evidenceDocumentId;
    private String oldCity;
    private String newCity;
    private String oldZipCode;
    private String newZipCode;

    public AddressChangeDataDto(String oldAddressLine1, String newAddressLine1, String evidenceDocumentId) {
        this.oldAddressLine1 = oldAddressLine1;
        this.newAddressLine1 = newAddressLine1;
        this.evidenceDocumentId = evidenceDocumentId;
    }

    public String getOldAddressLine1() {
        return oldAddressLine1;
    }

    public String getNewAddressLine1() {
        return newAddressLine1;
    }

    public String getEvidenceDocumentId() {
        return evidenceDocumentId;
    }

    public String getOldCity() {
        return oldCity;
    }

    public void setOldCity(String oldCity) {
        this.oldCity = oldCity;
    }

    public String getNewCity() {
        return newCity;
    }

    public void setNewCity(String newCity) {
        this.newCity = newCity;
    }

    public String getOldZipCode() {
        return oldZipCode;
    }

    public void setOldZipCode(String oldZipCode) {
        this.oldZipCode = oldZipCode;
    }

    public String getNewZipCode() {
        return newZipCode;
    }

    public void setNewZipCode(String newZipCode) {
        this.newZipCode = newZipCode;
    }

}
