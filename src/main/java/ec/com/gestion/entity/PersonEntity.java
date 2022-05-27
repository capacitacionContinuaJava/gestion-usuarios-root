package ec.com.gestion.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class to management person entity
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rhtperson")
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "rhsecperson", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rhsecperson", sequenceName = "rhsecperson", allocationSize = 1)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "document_type")
    private String documentType;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personEntity")
    private List<UserEntity> userEntities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personEntity")
    private  List<ClientEntity> clientEntities;

    public Long getId(){return personId;};
}
