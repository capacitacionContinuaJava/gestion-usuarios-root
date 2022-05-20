package ec.com.gestion.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

/**
 * Class to management person object properties.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO {

    private Long personId;
    private String firstName;
    private String lastName;
    private String documentNumber;
    private String documentType;
    private Boolean status;
    private String createUserId;
    private Date createdDate;
    private String modifiedUserId;
    private Date modifiedDate;

}
