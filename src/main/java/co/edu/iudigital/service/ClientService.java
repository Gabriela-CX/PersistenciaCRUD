package co.edu.iudigital.service;

import co.edu.iudigital.model.Cliente;
import co.edu.iudigital.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Cliente create (Cliente cliente){
        return clientRepository.save(cliente);
    }

    public List<Cliente> getAllClientes (){
        return clientRepository.findAll();
    }

    public void delete (Cliente cliente){
        clientRepository.delete(cliente);
    }

    public Optional<Cliente> findById (Long cedulacliente){
        return clientRepository.findById(cedulacliente);
    }
}
