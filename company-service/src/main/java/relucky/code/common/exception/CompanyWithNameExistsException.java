package relucky.code.common.exception;


public class CompanyWithNameExistsException extends RuntimeException{
    public CompanyWithNameExistsException(String message) {
        super(message);
    }
}
