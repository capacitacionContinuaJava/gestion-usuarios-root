package ec.com.gestion.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Class to management measurer object properties.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeasurerVO {

    private Long measurerId;
    private Long measurermeterm3;
    private Boolean status;
    private String createUserId;
    private Date createdDate;
    private String modifiedUserId;
    private Date modifiedDate;

}
