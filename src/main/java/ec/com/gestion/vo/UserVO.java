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
    private String userName;
    private Boolean status;
    private String createUserId;
    private Date createdDate;
    private String modifiedUserId;
    private Date modifiedDate;
}
