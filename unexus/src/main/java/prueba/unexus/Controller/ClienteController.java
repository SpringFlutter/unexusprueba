package prueba.unexus.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import prueba.unexus.Entity.ClienteSucursalUnexus;
import prueba.unexus.Entity.ClienteUnexus;
import prueba.unexus.Repo.ClienteSucursalUnexusRepo;
import prueba.unexus.Repo.ClienteUnexusRepo;
import prueba.unexus.Service.ClienteService;

@RestController
@RequestMapping("cliente")
@CrossOrigin

public class ClienteController {

    @Autowired
    private ClienteUnexusRepo clienteUnexusRepo;

    @Autowired
    private ClienteSucursalUnexusRepo clienteSucursalUnexusRepo;

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/insertar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ClienteUnexus> insertarCliente(@RequestBody ClienteUnexus nuevoCliente ){

        clienteService.verificarExiste(nuevoCliente.getRuc());
        
        ClienteUnexus clienteUnexus = clienteUnexusRepo.save(nuevoCliente);
        clienteSucursalUnexusRepo.saveAll(
            nuevoCliente.getClienteSucursalUnexus().stream() 
                .map(sucursal -> {
                    sucursal.setIdClienteUnexus(clienteUnexus.getIdClienteUnexus());
                    return sucursal;
                })
                .collect(Collectors.toList()));
        
        return ResponseEntity.ok(clienteUnexus);
    }

    @GetMapping(value = "/obtener/datos/{rucrazon}")
    ResponseEntity<List<ClienteUnexus>> obtenerDatosCliente(@PathVariable String rucrazon){
        List<ClienteUnexus> clienteUnexus =  clienteUnexusRepo.queryFindRucRazon(rucrazon);
        if(clienteUnexus.isEmpty() || clienteUnexus == null){throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay datos");}
        return ResponseEntity.ok(clienteUnexus);
    }

    @PutMapping(value = "/actualizar/datos")
    ResponseEntity<ClienteUnexus> actualizarDatosCliente(@RequestBody ClienteUnexus clienteDatos){
        ClienteUnexus clienteActualizar = clienteService.verificarDuplicado(clienteDatos.getRuc()).get(0);
        clienteActualizar.setRazonSocial(clienteDatos.getRazonSocial());
        return ResponseEntity.ok(clienteUnexusRepo.save(clienteActualizar));
    }

    @PostMapping(value = "/insertar/nueva/direccion")
    ResponseEntity<ClienteSucursalUnexus> insertarNuevaDireccion(@RequestBody ClienteSucursalUnexus datosSucursal){
        return ResponseEntity.ok(clienteSucursalUnexusRepo.save(datosSucursal));
    }

    @GetMapping(value = "/obtener/direcciones/{idClienteUnexus}") 
    ResponseEntity<List<ClienteSucursalUnexus>> obtenerDirecciones(@PathVariable long idClienteUnexus){
        return ResponseEntity.ok(clienteSucursalUnexusRepo.findByIdClienteUnexus(idClienteUnexus));
    }

    @DeleteMapping(value = "/eliminar/{idClienteUnexus}")
    ResponseEntity<HttpStatus> eliminarCliente(@PathVariable long idClienteUnexus){
        clienteUnexusRepo.delete(clienteUnexusRepo.findByIdClienteUnexus(idClienteUnexus));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
