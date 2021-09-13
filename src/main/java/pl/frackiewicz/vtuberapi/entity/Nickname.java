package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.frackiewicz.vtuberapi.util.VTuberSerializer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "nicknames")
public class Nickname {
    @Id
    @Size(min = 3, max = 64)
    @NotBlank
    private String nickname;

    @ManyToMany(mappedBy = "nicknames")
    @JsonSerialize(using = VTuberSerializer.class)
    private Set<VTuber> usersOfNickname = new HashSet<>();
}
