package ec.com.gestion.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class to management company entity.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rhtcompany")
public class CompanyEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "rhcompanysec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rhcompanysec", sequenceName = "rhcompanysec", allocationSize = 1)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyEntity")
    private List<EmployeeEntity> employeeEntities;

    public Long getId(){return  companyId;};

}
