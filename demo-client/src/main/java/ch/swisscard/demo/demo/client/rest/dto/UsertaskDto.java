package ch.swisscard.demo.demo.client.rest.dto;

public class UsertaskDto {

    private String usertaskType;

    public UsertaskDto(String usertaskType) {
        this.usertaskType = usertaskType;
    }

    public String getUsertaskType() {
        return usertaskType;
    }

}
