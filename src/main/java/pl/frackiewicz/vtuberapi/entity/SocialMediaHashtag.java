package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.frackiewicz.vtuberapi.util.VTuberSerializer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "socialmediahashtags")
public class SocialMediaHashtag {
    @Id
    @Size(min = 3, max = 24)
    @Column(nullable = false)
    private String hashtag;

    @Size(max = 24)
    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JsonSerialize(using = VTuberSerializer.class)
    @NotNull
    private VTuber userOfHashtag;
}
