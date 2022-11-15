package com.example.eBooking.controller;

import com.example.eBooking.model.Client;
import com.example.eBooking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("clientList", clientService.getAllClients());
        return "index";
    }

    @GetMapping("/newClientForm") //href link
    public String viewNewClientForm(Model model){
        model.addAttribute("client", new Client());
        return "client_form";
    }

    @PostMapping("/addClient")
        public String addNewClient(@ModelAttribute("client") Client client){
        clientService.saveClient(client);
        return "redirect:/";
    }
}
