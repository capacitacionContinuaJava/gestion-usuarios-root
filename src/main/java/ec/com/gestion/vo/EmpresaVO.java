package ec.com.gestion.vo;

import lombok.*;

import java.util.Date;

/**
 * Class to management empresa object properties.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaVO {

    private Long empresaId;
    private String empresaName;
    private Boolean status;
    private String createEmpresaId;
    private Date createdDate;
    private String modifiedEmpresaId;
    private Date modifiedDate;
}
