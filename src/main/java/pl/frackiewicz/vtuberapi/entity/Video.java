package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pl.frackiewicz.vtuberapi.util.VTuberSerializer;

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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JsonSerialize(using = VTuberSerializer.class)
    private VTuber author;

    @ManyToMany(mappedBy = "memberOfVideos")
    @JsonSerialize(using = VTuberSerializer.class)
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
