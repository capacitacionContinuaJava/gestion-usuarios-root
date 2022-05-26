package ec.com.gestion.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class to management measurer entity
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rhtmeasurer")

public class MeasurerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "rhtmeasurersec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rhtmeasurersec", sequenceName = "rhtmeasurersec", allocationSize = 1)

    @Column(name = "measurer_id")
    private Long measurerId;

    @Column(name = "measurermeterm3")
    private Long measurermeterm3;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "create_user_id")
    private String createUserId;

    @Column(name = "create_date")
    private Date createdDate;

    @Column(name = "modified_user_id")
    private String modifiedUserId;

    @Column(name = "modified_date")
    private Date modifiedDate;

    public Long getId(){return measurerId;};


}
