package pl.frackiewicz.vtuberapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="organisations")
public class Organisation {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String name;
    private LocalDate createdDate;
    @OneToMany(mappedBy = "organisation")
    private Set<Branch> branches = new HashSet<>();
    @OneToMany(mappedBy = "organisation")
    private Set<Generation> generations = new HashSet<>();
    @OneToMany(mappedBy = "organisation")
    private Set<VTuber> vTubers = new HashSet<>();
}
