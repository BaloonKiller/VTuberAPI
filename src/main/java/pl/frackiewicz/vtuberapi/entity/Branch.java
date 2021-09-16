package pl.frackiewicz.vtuberapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 64)
    private String name;

    @ManyToOne
    @NotNull
    @JsonSerialize(using = OrganisationSerializer.class)
    private Organisation organisation;

    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private Set<Generation> generations = new HashSet<>();
    
    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private Set<VTuber> vTubers = new HashSet<>();
}
