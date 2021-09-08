package pl.frackiewicz.vtuberapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

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
        @UniqueConstraint(columnNames = {"firstName", "lastName"})
)
public class VTuber {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
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
    private Set<Nickname> nicknames = new HashSet<>();

    @ManyToOne
    private Organisation organisation;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private Generation generation;

    @OneToOne
    private Channel channel;

    @ManyToMany
    private Set<Event> events = new HashSet<>();

    @OneToMany(mappedBy = "author")
    private Set<Video> createdVideos = new HashSet<>();

    @ManyToMany
    private Set<Video> memberOfVideos = new HashSet<>();

    @Column(unique = true)
    @Size(max = 255)
    private String twitterUrl;

    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate debutDate;

    @OneToMany(mappedBy = "userOfHashtag")
    private Set<SocialMediaHashtag> socialMediaHashtags = new HashSet<>();

    private boolean active;
}
