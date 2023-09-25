package prueba.unexus.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_cliente_unexus")
@Getter
@Setter

public class ClienteUnexus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secClienteUnexus")
    @SequenceGenerator(name = "secClienteUnexus", sequenceName = "tbl_cliente_unexus_sec", allocationSize = 1)
    @Column(name = "id_cliente_unexus")
    private Long idClienteUnexus;

    @Column(name = "ruc", length = 13)
    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @OneToMany(mappedBy = "idClienteUnexus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClienteSucursalUnexus> clienteSucursalUnexus;

}
