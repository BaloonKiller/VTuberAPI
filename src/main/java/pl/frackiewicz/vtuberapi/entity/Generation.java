package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pl.frackiewicz.vtuberapi.util.BranchSerializer;
import pl.frackiewicz.vtuberapi.util.OrganisationSerializer;
import pl.frackiewicz.vtuberapi.util.VTuberSerializer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Size(min = 2, max = 64)
    @NotBlank
    private String name;

    @ManyToOne
    @NotNull
    @JsonSerialize(using = OrganisationSerializer.class)
    private Organisation organisation;

    @ManyToOne
    @NotNull
    @JsonSerialize(using = BranchSerializer.class)
    private Branch branch;

    @OneToMany(mappedBy = "generation")
    @JsonIgnore
    private Set<VTuber> vTubers = new HashSet<>();
}
