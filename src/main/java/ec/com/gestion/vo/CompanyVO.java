package ec.com.gestion.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Class to management company object properties.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyVO {

    private Long companyId;
    private String name;
    private String address;
    private String phoneNumber;
    private Boolean status;
    private String createUserId;
    private Date createdDate;
    private String modifiedUserId;
    private Date modifiedDate;
}
