package co.edu.iudigital.controller;

import co.edu.iudigital.service.ClientService;
import co.edu.iudigital.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.webjars.NotFoundException;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Controller
public class ClientController {
    @Autowired private ClientService service;

    @GetMapping ("/cliente")
    public String showClientList(Model model) {
        List<Cliente> allClientes = service.getAllClientes();
        model.addAttribute("allClientes", allClientes);
        return "cliente";
    }

    @GetMapping ("cliente/new")
    public String showNewForm(Model model){
        model.addAttribute("cliente", new Cliente());
        return "client-form";
    }

    @PostMapping ("cliente/save")
    public String saveClient (Cliente cliente, RedirectAttributes ra){
        service.create(cliente);
        ra.addFlashAttribute("message", "The user has been saved successfully");
        return "redirect:/cliente";
    }

    @GetMapping ("cliente/delete/{cedulacliente}")
    public String deleteClient(@PathVariable("cedulacliente") Long cedulacliente){
        service.delete(cedulacliente);
        return "redirect:/cliente";
    }

}
