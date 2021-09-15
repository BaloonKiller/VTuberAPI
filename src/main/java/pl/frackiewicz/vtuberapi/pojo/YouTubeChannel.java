package pl.frackiewicz.vtuberapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YouTubeChannel {
    private String id;
    private ContentDetails contentDetails;
    private Snippet snippet;
    private Statistics statistics;
    private String defaultLanguage;
    private String country;
}
