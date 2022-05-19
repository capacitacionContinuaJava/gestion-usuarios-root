package ec.com.gestion.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class to management user entity.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rhtuser")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "rhtusersec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rhtusersec", sequenceName = "rhtusersec", allocationSize = 1)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

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

    public Long getId(){return userId;};
}
