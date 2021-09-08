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
@Table(
        name = "generations",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"name", "organisation_id", "branch_id"}))
public class Generation {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Size(min = 2, max = 64)
    @NotBlank
    private String name;

    @ManyToOne
    private Organisation organisation;

    @ManyToOne
    private Branch branch;

    @OneToMany(mappedBy = "generation")
    private Set<VTuber> vTubers = new HashSet<>();
}
