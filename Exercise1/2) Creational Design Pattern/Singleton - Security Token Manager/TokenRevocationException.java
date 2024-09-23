public class TokenRevocationException extends Exception {

    public TokenRevocationException(String message) {
        super(message);
    }

    public TokenRevocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
