package pl.frackiewicz.vtuberapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YouTubeVideo {
    private String id;
    private Snippet snippet;
    private ContentDetails contentDetails;
    private Statistics statistics;
}
