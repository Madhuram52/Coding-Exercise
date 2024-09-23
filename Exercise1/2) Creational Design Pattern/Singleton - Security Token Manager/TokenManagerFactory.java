public class TokenManagerFactory {

    private static TokenManagerFactory instance;
    
    private TokenManagerFactory() {
        // Private constructor to prevent instantiation
    }

    public static synchronized TokenManagerFactory getInstance() {
        if (instance == null) {
            instance = new TokenManagerFactory();
        }
        return instance;
    }

    public TokenManager getTokenManager() {
        return TokenManager.getInstance();
    }
}
