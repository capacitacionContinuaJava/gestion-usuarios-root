package ec.com.gestion.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class to management client entity
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rhtclient")
public class ClientEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "rhtclientsec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rhtclientsec", sequenceName = "rhtclientsec", allocationSize = 1)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "create_client_id")
    private String createClientId;

    @Column(name = "create_date")
    private Date createdDate;

    @Column(name = "modified_client_id")
    private String modifiedClientId;

    @Column(name = "modified_date")
    private Date modifiedDate;

    public Long getId(){return clientId;};
}
