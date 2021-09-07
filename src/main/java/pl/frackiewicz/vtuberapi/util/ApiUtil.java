package pl.frackiewicz.vtuberapi.util;

public class ApiUtil {
    private static ApiUtil INSTANCE = null;

    private ApiUtil() {}

    public static ApiUtil getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApiUtil();
        }
        return INSTANCE;
    }

    public static String getApiKey() {
        String apiKey;
        try {
            apiKey = System.getProperty("API_KEY");
        } catch (Exception e) {
            e.printStackTrace();
            apiKey = "unknown";
        }
        return apiKey;
    }
}
