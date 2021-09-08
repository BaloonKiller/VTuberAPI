package pl.frackiewicz.vtuberapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(
        name="organisations",
        uniqueConstraints =
        @UniqueConstraint(columnNames = "name")
)
public class Organisation {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    private String name;

    @PastOrPresent
    private LocalDate createdDate;

    @OneToMany(mappedBy = "organisation")
    private Set<Branch> branches = new HashSet<>();

    @OneToMany(mappedBy = "organisation")
    private Set<Generation> generations = new HashSet<>();

    @OneToMany(mappedBy = "organisation")
    private Set<VTuber> vTubers = new HashSet<>();
}
