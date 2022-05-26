package ec.com.gestion.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Class to management employee object properties.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVO {

    private Long employeeId;
    private Long personId;
    private Long companyId;
    private Boolean status;
    private String createUserId;
    private Date createdDate;
    private String modifiedUserId;
    private Date modifiedDate;

}
