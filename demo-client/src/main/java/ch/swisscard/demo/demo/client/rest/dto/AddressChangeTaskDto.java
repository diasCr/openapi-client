package ch.swisscard.demo.demo.client.rest.dto;

public class AddressChangeTaskDto extends UsertaskDto {

    private final String oldAddressLine1;
    private final String newAddressLine1;

    public AddressChangeTaskDto(String usertaskType, String oldAddressLine1, String newAddressLine1) {
        super(usertaskType);
        this.oldAddressLine1 = oldAddressLine1;
        this.newAddressLine1 = newAddressLine1;
    }

    public String getOldAddressLine1() {
        return oldAddressLine1;
    }

    public String getNewAddressLine1() {
        return newAddressLine1;
    }

}
