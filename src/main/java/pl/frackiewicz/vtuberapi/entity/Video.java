package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pl.frackiewicz.vtuberapi.pojo.YouTubeVideo;
import pl.frackiewicz.vtuberapi.util.VTuberSerializer;
import pl.frackiewicz.vtuberapi.util.VTuberSetSerializer;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="videos")
public class Video {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private String youtubeId;

    @ManyToOne
    @JsonSerialize(using = VTuberSerializer.class)
    private VTuber author;

    @ManyToMany(mappedBy = "memberOfVideos")
    @JsonSerialize(using = VTuberSetSerializer.class)
    private Set<VTuber> members = new HashSet<>();

    @Size(max = 255)
    private String title;

    @PastOrPresent
    private LocalDateTime publishedAt;

    @Size(max = 16)
    private String duration;

    @PositiveOrZero
    private BigInteger views;

    @PositiveOrZero
    private BigInteger likes;

    @PositiveOrZero
    private BigInteger dislikes;

    @Size(max = 255)
    private String videoUrl;

    @PositiveOrZero
    private BigInteger commentCount;

    @Size(max = 999)
    private String description;

    public void consumeVideoData(YouTubeVideo data) {
        this.setTitle(data.getSnippet().getTitle());
        this.setPublishedAt(data.getSnippet().getPublishedAt());
        this.setDuration(data.getContentDetails().getDuration());
        this.setDescription(data.getSnippet().getDescription());
        this.setViews(BigInteger.valueOf(data.getStatistics().getViewCount()));
        this.setLikes(BigInteger.valueOf(data.getStatistics().getLikeCount()));
        this.setDislikes(BigInteger.valueOf(data.getStatistics().getDislikeCount()));
        this.setCommentCount(BigInteger.valueOf(data.getStatistics().getCommentCount()));
        this.setVideoUrl("https://www.youtube.com/watch?v=" + data.getId());
    }
}
