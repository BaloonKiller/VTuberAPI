package pl.frackiewicz.vtuberapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(
        name="channels",
        uniqueConstraints =
        @UniqueConstraint(columnNames = "channelUrl"))
public class Channel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    private VTuber vTuber;

    @NotBlank
    @Size(min = 11, max = 255)
    private String channelUrl;

    @PositiveOrZero
    private BigInteger subscriptions;

    @PositiveOrZero
    private BigInteger videoCount;

    @PositiveOrZero
    private BigInteger viewsSum;

    @PositiveOrZero
    private BigInteger likesSum;

    @PositiveOrZero
    private BigInteger dislikesSum;
}
