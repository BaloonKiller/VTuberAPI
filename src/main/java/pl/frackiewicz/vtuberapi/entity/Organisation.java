package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pl.frackiewicz.vtuberapi.util.BranchSerializer;
import pl.frackiewicz.vtuberapi.util.GenerationSerializer;
import pl.frackiewicz.vtuberapi.util.VTuberSerializer;

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
    @JsonSerialize(using = BranchSerializer.class)
    private Set<Branch> branches = new HashSet<>();

    @OneToMany(mappedBy = "organisation")
    @JsonSerialize(using = GenerationSerializer.class)
    private Set<Generation> generations = new HashSet<>();

    @OneToMany(mappedBy = "organisation")
    @JsonSerialize(using = VTuberSerializer.class)
    private Set<VTuber> vTubers = new HashSet<>();
}
