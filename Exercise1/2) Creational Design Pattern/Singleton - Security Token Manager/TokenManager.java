public class TokenManager {

    private static TokenManager instance;
    
    private TokenManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized TokenManager getInstance() {
        if (instance == null) {
            instance = new TokenManager();
        }
        return instance;
    }

    // Method to generate a new token
    public Token generateToken(String userId) throws TokenGenerationException {
        if (userId == null || userId.isEmpty()) {
            throw new TokenGenerationException("User ID cannot be null or empty");
        }
        return new Token(userId);
    }

    // Method to validate a token
    public boolean validateToken(Token token) throws TokenValidationException {
        if (token == null || token.getTokenValue() == null) {
            throw new TokenValidationException("Invalid token");
        }
        // For demonstration, assume tokens expire after 24 hours
        if (token.getCreationTime() + 86400000L < System.currentTimeMillis()) {
            throw new TokenValidationException("Token expired");
        }
        return true;
    }

    // Method to revoke a token
    public void revokeToken(Token token) throws TokenRevocationException {
        if (token == null) {
            throw new TokenRevocationException("Token cannot be null");
        }
        System.out.println("Token revoked: " + token.getTokenValue());
    }
}
