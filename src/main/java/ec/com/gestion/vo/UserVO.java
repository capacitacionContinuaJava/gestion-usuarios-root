package ec.com.gestion.vo;

import lombok.*;

import java.util.Date;

/**
 * Class to management user object properties.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private Long userId;
    private Long personId;
    private Long companyId;
    private String userName;
    private String password;
    private Boolean status;
    private String createUserId;
    private Date createdDate;
    private String modifiedUserId;
    private Date modifiedDate;
    private String firstName;
    private String lastName;
}
