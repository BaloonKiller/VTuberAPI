package pl.frackiewicz.vtuberapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
    private long subscriberCount;
    private long videoCount;
    private long viewCount;
    private long likeCount;
    private long dislikeCount;
    private long favouriteCount;
    private long commentCount;
}
