package pl.frackiewicz.vtuberapi.util;

public abstract class ApiUtil {
    public static String getApiKey() {
        String apiKey;
        try {
            apiKey = System.getenv("API_KEY");
        } catch (Exception e) {
            e.printStackTrace();
            apiKey = "unknown";
        }
        return apiKey;
    }
}
