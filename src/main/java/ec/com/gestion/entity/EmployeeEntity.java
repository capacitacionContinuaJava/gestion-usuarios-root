package ec.com.gestion.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class to management employee entity.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rhtemployee")
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "rhemployeesec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rhemployeesec", sequenceName = "rhemployeesec", allocationSize = 1)
    @Column(name = "employee_id")
    private Long employeeId;

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
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable  = false, updatable = false)
    private PersonEntity personEntity;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", insertable  = false, updatable = false)
    private CompanyEntity companyEntity;

    public Long getId(){return employeeId;};
}
