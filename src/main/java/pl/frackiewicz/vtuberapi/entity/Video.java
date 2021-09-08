package pl.frackiewicz.vtuberapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="videos")
public class Video {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    private VTuber author;

    @ManyToMany(mappedBy = "memberOfVideos")
    private Set<VTuber> members = new HashSet<>();

    @PositiveOrZero
    private BigInteger views;
    @PositiveOrZero
    private BigInteger likes;
    @PositiveOrZero
    private BigInteger dislikes;
    @Size(max = 255)
    private String videoUrl;
}
