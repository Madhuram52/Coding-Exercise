import java.util.UUID;

public class Token {
    private final String userId;
    private final String tokenValue;
    private final long creationTime;

    public Token(String userId) {
        this.userId = userId;
        this.tokenValue = UUID.randomUUID().toString(); // Generates a random unique token
        this.creationTime = System.currentTimeMillis();
    }

    public String getUserId() {
        return userId;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public long getCreationTime() {
        return creationTime;
    }
}
