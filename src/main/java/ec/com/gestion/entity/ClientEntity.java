package ec.com.gestion.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @GeneratedValue(generator = "rhsecclient", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rhsecclient", sequenceName = "rhsecclient", allocationSize = 1)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "company_id")
    private Long companyId;

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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false )
    private PersonEntity personEntity;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", insertable = false, updatable = false )
    private CompanyEntity companyEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientEntity")
    private List<MeasurerEntity> measurerEntities;

    public Long getId(){return clientId;};
}
