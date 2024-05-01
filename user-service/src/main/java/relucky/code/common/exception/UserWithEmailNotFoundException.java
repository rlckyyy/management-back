package relucky.code.common.exception;

public class UserWithEmailNotFoundException extends RuntimeException{
    public UserWithEmailNotFoundException(String email) {
        super("User with email " + email + " not found in user service");
    }
}
