package prueba.unexus.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import prueba.unexus.Entity.ClienteUnexus;

public interface ClienteUnexusRepo extends JpaRepository<ClienteUnexus, Long> {
    List<ClienteUnexus> findAllByOrderByRazonSocial();
    List<ClienteUnexus> findByRuc(String ruc);
    ClienteUnexus findByIdClienteUnexus(long idCliente);

    @Query(value = "select * from tbl_cliente_unexus unexus where\n"+
    "razon_social ilike %:rucrazon% or ruc ilike %:rucrazon% order by razon_social desc", nativeQuery = true)
    List<ClienteUnexus> queryFindRucRazon(@Param("rucrazon")String rucrazon);
}
