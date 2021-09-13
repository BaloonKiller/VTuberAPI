package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;
import pl.frackiewicz.vtuberapi.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "branches")
public class Branch {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotBlank
    @Size(min = 2, max = 64)
    private String name;

    @ManyToOne
    @JsonSerialize(using = OrganisationSerializer.class)
    private Organisation organisation;

    @OneToMany(mappedBy = "branch")
    @JsonSerialize(using = GenerationSerializer.class)
    private Set<Generation> generations = new HashSet<>();
    
    @OneToMany(mappedBy = "branch")
    @JsonSerialize(using = VTuberSerializer.class)
    private Set<VTuber> vTubers = new HashSet<>();
}
