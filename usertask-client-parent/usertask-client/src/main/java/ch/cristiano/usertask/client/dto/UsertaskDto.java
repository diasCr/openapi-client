package ch.cristiano.usertask.client.dto;

public class UsertaskDto {

    private final String id;
    private final String usertaskType;
    private final UsertaskDataBaseDto inputData;
    private Object outputData;

    public UsertaskDto(String id, String usertaskType, UsertaskDataBaseDto inputData) {
        this.id = id;
        this.usertaskType = usertaskType;
        this.inputData = inputData;
    }

    public String getId() {
        return id;
    }

    public String getUsertaskType() {
        return usertaskType;
    }

    public UsertaskDataBaseDto getInputData() {
        return inputData;
    }

    public Object getOutputData() {
        return outputData;
    }

    public void setOutputData(Object outputData) {
        this.outputData = outputData;
    }

}
