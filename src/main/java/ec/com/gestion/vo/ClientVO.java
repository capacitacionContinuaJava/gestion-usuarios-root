package ec.com.gestion.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Class to management client object properties.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientVO {

    private Long clientId;
    private Boolean status;
    private String createClientId;
    private Date createdDate;
    private String modifiedClientId;
    private Date modifiedDate;
}
