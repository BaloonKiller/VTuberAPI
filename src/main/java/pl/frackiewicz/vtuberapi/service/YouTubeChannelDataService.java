package pl.frackiewicz.vtuberapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.frackiewicz.vtuberapi.pojo.YouTubeChannel;

import java.io.IOException;
import java.net.URL;

public class YouTubeChannelDataService {
    private static final String API_KEY = System.getenv("API_KEY");
    private static ObjectMapper objectMapper = getDefaultObjectMapper();
    private static final Logger logger = LogManager.getLogger(YouTubeChannelDataService.class);


    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.registerModule(new JavaTimeModule());
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }

    public static String getApiUrl(String youtubeId) {
        return "https://youtube.googleapis.com/youtube/v3/channels?part=snippet&part=statistics&part=contentDetails&id=" + youtubeId + "&key=" + API_KEY;
    }

    public static YouTubeChannel getYoutubeChannelPojo(String url) throws JsonProcessingException, IOException {
        JsonNode jsonNode = objectMapper.readTree(new URL(url));
        String channelNodeString = jsonNode.get("items").toString();
        channelNodeString = channelNodeString.substring(1, channelNodeString.length()-1);
        YouTubeChannel channelPojo = objectMapper.readValue(channelNodeString, YouTubeChannel.class);
        return channelPojo;
    }
}
