package prueba.unexus.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import prueba.unexus.Entity.ClienteUnexus;
import prueba.unexus.Repo.ClienteUnexusRepo;

@Service

public class ClienteService {
    @Autowired
    private ClienteUnexusRepo clienteUnexusRepo;

    public List<ClienteUnexus> verificarExiste(String ruc){
        List<ClienteUnexus> cliente =  clienteUnexusRepo.findByRuc(ruc);
        
        if( !cliente.isEmpty() ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente con ruc "+ ruc + " ya existe");
        }
        return cliente;
    }

    public List<ClienteUnexus> verificarDuplicado(String ruc){
        List<ClienteUnexus> cliente =  clienteUnexusRepo.findByRuc(ruc);
        if( cliente.size() > 1){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente con ruc "+ ruc + " duplicado");
        }
        return cliente;
    }

}
