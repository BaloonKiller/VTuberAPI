package pl.frackiewicz.vtuberapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="vtubers")
public class VTuber {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthday;
    private Integer height;
    private String zodiacSign;
    private String description;
    @ManyToMany(mappedBy = "usersOfNickname")
    private Set<Nickname> nicknames = new HashSet<>();
    @ManyToOne
    private Organisation organisation;
    @ManyToOne
    private Branch branch;
    @ManyToOne
    private Generation generation;
    @OneToOne
    private Channel channel;
    @ManyToMany(mappedBy = "members")
    private HashSet<Event> events = new HashSet<>();
    @OneToMany(mappedBy = "author")
    private Set<Video> createdVideos = new HashSet<>();
    @ManyToMany(mappedBy = "members")
    private Set<Video> memberOfVideos = new HashSet<>();
    private String twitter;
    private LocalDate debutDate;
    @OneToMany(mappedBy = "userOfHashtag")
    private Set<SocialMediaHashtag> socialMediaHashtags = new HashSet<>();
    private boolean active;
}
