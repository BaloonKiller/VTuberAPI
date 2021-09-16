package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pl.frackiewicz.vtuberapi.pojo.YouTubeChannel;
import pl.frackiewicz.vtuberapi.util.VTuberSerializer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(
        name="channels",
        uniqueConstraints =
        @UniqueConstraint(columnNames = "youtubeid"))
public class Channel {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @NotBlank
    private String youtubeId;

    @OneToOne
    @NotNull
    private VTuber vTuber;

    @Size(max = 255)
    private String channelName;

    @Size(min = 11, max = 255)
    @Column(unique = true)
    private String channelUrl;

    @PositiveOrZero
    private BigInteger subscriptions;

    @PositiveOrZero
    private BigInteger videoCount;

    @PositiveOrZero
    private BigInteger viewsSum;

    public void consumeChannelData(YouTubeChannel data) {
        this.setChannelName(data.getSnippet().getTitle());
        this.setChannelUrl("https://www.youtube.com/channel/" + data.getId());
        this.setSubscriptions(BigInteger.valueOf(data.getStatistics().getSubscriberCount()));
        this.setVideoCount(BigInteger.valueOf(data.getStatistics().getVideoCount()));
        this.setViewsSum(BigInteger.valueOf(data.getStatistics().getViewCount()));
    }
}
