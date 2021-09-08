package pl.frackiewicz.vtuberapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

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
    private Organisation organisation;

    @OneToMany(mappedBy = "branch")
    private Set<Generation> generations = new HashSet<>();
    
    @OneToMany(mappedBy = "branch")
    private Set<VTuber> vTubers = new HashSet<>();
}
