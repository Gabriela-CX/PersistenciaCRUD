package co.edu.iudigital.repository;


import co.edu.iudigital.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Cliente, Long>{
}
