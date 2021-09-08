package pl.frackiewicz.vtuberapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "socialmediahashtags")
public class SocialMediaHashtag {
    @Id
    @Size(min = 3, max = 24)
    @NotBlank
    private String hashtag;

    @Size(max = 24)
    private String type;

    @ManyToOne
    private VTuber userOfHashtag;
}