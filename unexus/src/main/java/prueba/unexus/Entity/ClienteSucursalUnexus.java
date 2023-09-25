package prueba.unexus.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_cliente_sucursal_unexus")
@Getter
@Setter

public class ClienteSucursalUnexus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secClienteSucUnexus")
    @SequenceGenerator(name = "secClienteSucUnexus", sequenceName = "tbl_cliente_sucursal_unexus_sec", allocationSize = 1)
    @Column(name = "id_cliente_sucursal_unexus")
    private Long idClienteSucursalUnexus;

    @Column(name = "id_cliente_unexus")
    private Long idClienteUnexus;

    @Column(name = "direccion")
    private String direccion;
}
