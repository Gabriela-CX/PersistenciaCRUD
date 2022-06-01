package co.edu.iudigital.rest;

import co.edu.iudigital.model.Cliente;
import co.edu.iudigital.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente/")
public class ClientREST {

    @Autowired
    private ClientService clientService;

    @PostMapping
    private ResponseEntity<Cliente> guardar (@RequestBody Cliente cliente){
        Cliente temporal = clientService.create(cliente);

        try{
            return ResponseEntity.created(new URI("/cliente"+temporal.getCedulacliente())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Cliente>> listarTodosLosClientes (){
        return ResponseEntity.ok(clientService.getAllClientes());
    }

    @DeleteMapping
    private ResponseEntity<Void> eliminarCliente (@RequestBody Cliente cliente){
        clientService.delete(cliente);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "{cedulacliente}")
    private ResponseEntity<Optional<Cliente>> listarClientesPorId (@PathVariable ("cedulacliente") Long cedulacliente){
        return ResponseEntity.ok(clientService.findById(cedulacliente));
    }
}
