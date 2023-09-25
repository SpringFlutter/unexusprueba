package prueba.unexus.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import prueba.unexus.Entity.ClienteSucursalUnexus;
import java.util.List;


public interface ClienteSucursalUnexusRepo extends JpaRepository<ClienteSucursalUnexus, Long> {
    List<ClienteSucursalUnexus> findByIdClienteUnexus(Long idClienteUnexus);
}
