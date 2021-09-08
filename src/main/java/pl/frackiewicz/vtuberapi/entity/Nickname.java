package pl.frackiewicz.vtuberapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Nickname {
    @Id
    private String nickname;
    @ManyToMany(mappedBy = "nicknames")
    private Set<VTuber> usersOfNickname = new HashSet<>();
}
