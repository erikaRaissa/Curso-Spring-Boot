package awesome.error;

public class CustomErrorType {
    private String errorMessage;

    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CustomErrorType() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
