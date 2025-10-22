package ie.atu.week5.week5.errorHandling;

public class DuplicateException extends RuntimeException {

    private String message;
    private String field;
    public DuplicateException() {
    }
    public DuplicateException(String field, String message) {
        this.field = field;
    }

    public DuplicateException(String message)
    {
        super(message);
    }

}
