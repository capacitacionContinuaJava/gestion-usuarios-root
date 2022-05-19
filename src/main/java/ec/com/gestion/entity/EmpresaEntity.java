package ec.com.gestion.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Class to management empresa entity.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rhtempresa")
public class EmpresaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "rhtempresasec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rhtempresasec", sequenceName = "rhtempresasec", allocationSize = 1)
    @Column(name = "empresa_id")
    private Long empresaId;

    @Column(name = "empresa_name")
    private String empresaName;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "create_empresa_id")
    private String createEmpresaId;

    @Column(name = "create_date")
    private Date createdDate;

    @Column(name = "modified_empresa_id")
    private String modifiedEmpresaId;

    @Column(name = "modified_date")
    private Date modifiedDate;

    public Long getId(){return empresaId;};



}
