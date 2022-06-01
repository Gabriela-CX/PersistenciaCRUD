package co.edu.iudigital.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "clientes")
public class Cliente {

    @Id
    private Long cedulacliente;
    private String nombre;
    private String direccion;
    private String telefono;

    public Cliente(Long cedulacliente, String nombre, String direccion, String telefono) {
        this.cedulacliente = cedulacliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Long getCedulacliente() {
        return cedulacliente;
    }

    public void setCedulacliente(Long cedulacliente) {
        this.cedulacliente = cedulacliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
