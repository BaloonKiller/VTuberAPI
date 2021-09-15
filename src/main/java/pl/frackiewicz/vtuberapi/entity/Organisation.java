package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
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

    @NotNull
    private String name;

    @PastOrPresent
    private LocalDate createdDate;

    @OneToMany(mappedBy = "organisation")
    @JsonIgnore
    private Set<Branch> branches = new HashSet<>();

    @OneToMany(mappedBy = "organisation")
    @JsonIgnore
    private Set<Generation> generations = new HashSet<>();

    @OneToMany(mappedBy = "organisation")
    @JsonIgnore
    private Set<VTuber> vTubers = new HashSet<>();
}
