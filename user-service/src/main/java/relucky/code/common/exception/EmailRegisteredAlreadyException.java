package relucky.code.common.exception;

public class EmailRegisteredAlreadyException extends RuntimeException{
    public EmailRegisteredAlreadyException(String email) {
        super("Email " + email + " already registered in service");
    }
}
