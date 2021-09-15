package pl.frackiewicz.vtuberapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Snippet {
    private LocalDateTime publishedAt;
    private String channelId;
    private String title;
    private String description;
    private Set<String> tags;
    private String customURL;
}
