package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import pl.frackiewicz.vtuberapi.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(
        name="vtubers",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"firstname", "lastname"})
)
public class VTuber {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotBlank
    @Size(max = 22)
    private String firstName;

    @NotBlank
    @Size(max = 22)
    private String lastName;

    @Positive
    private Integer age;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;

    @Positive
    private Integer height;

    @Size(max = 20)
    private String zodiacSign;

    @Size(max = 5000)
    private String description;

    @ManyToMany
    @JsonSerialize(using = NicknameSerializer.class)
    private Set<Nickname> nicknames = new HashSet<>();

    @ManyToOne
    @JsonSerialize(using = OrganisationSerializer.class)
    private Organisation organisation;

    @ManyToOne
    @JsonSerialize(using = BranchSerializer.class)
    private Branch branch;

    @ManyToOne
    @JsonSerialize(using = GenerationSerializer.class)
    private Generation generation;

    @OneToOne
    @JsonSerialize(using = ChannelSerializer.class)
    private Channel channel;

    @ManyToMany
    @JsonSerialize(using = EventSerializer.class)
    private Set<Event> events = new HashSet<>();

    @OneToMany(mappedBy = "author")
    @JsonSerialize(using = VideoSerializer.class)
    private Set<Video> createdVideos = new HashSet<>();

    @ManyToMany
    @JsonSerialize(using = VideoSerializer.class)
    private Set<Video> memberOfVideos = new HashSet<>();

    @Column(unique = true)
    @Size(max = 255)
    private String twitterUrl;

    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate debutDate;

    @OneToMany(mappedBy = "userOfHashtag")
    @JsonSerialize(using = SocialMediaHashtagSerializer.class)
    private Set<SocialMediaHashtag> socialMediaHashtags = new HashSet<>();

    private boolean active;
}
