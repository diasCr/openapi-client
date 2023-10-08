package ch.cristiano.usertask.client.dto;

public class UsertaskDto {

    private final String usertaskType;
    private final UsertaskDataBaseDto inputData;
    private Object outputData;

    public UsertaskDto(String usertaskType, UsertaskDataBaseDto data) {
        this.usertaskType = usertaskType;
        this.inputData = data;
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
