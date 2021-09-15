package pl.frackiewicz.vtuberapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDetails {
    private String duration;
    private String likes;
    private String uploads;
}
