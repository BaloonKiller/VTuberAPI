package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pl.frackiewicz.vtuberapi.util.BranchSerializer;
import pl.frackiewicz.vtuberapi.util.GenerationSetSerializer;
import pl.frackiewicz.vtuberapi.util.VTuberSetSerializer;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @PastOrPresent
    private LocalDate createdDate;

    @OneToMany(mappedBy = "organisation")
    @JsonSerialize(using = BranchSerializer.class)
    private Set<Branch> branches = new HashSet<>();

    @OneToMany(mappedBy = "organisation")
    @JsonSerialize(using = GenerationSetSerializer.class)
    private Set<Generation> generations = new HashSet<>();

    @OneToMany(mappedBy = "organisation")
    @JsonSerialize(using = VTuberSetSerializer.class)
    private Set<VTuber> vTubers = new HashSet<>();
}
