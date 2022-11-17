package com.example.eBooking.controller;

import com.example.eBooking.model.Client;
import com.example.eBooking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String viewHomePage(){
        return "home_page";
    }

    @GetMapping("/clientList")
    public String viewHomePageClientList(Model model){
       model.addAttribute("clientList", clientService.getAllClients());
        return "fetched_db";
    }

    @GetMapping("/newClientForm") //href link
    public String viewNewClientForm(Model model){
        model.addAttribute("client", new Client());
        return "client_form";
    }

    @PostMapping("/addClient")
        public String addNewClient(@ModelAttribute("client") Client client){
        clientService.saveClient(client);
        return "redirect:/clientList";
    }

    @GetMapping("/updateClientData/{id}")
    public String showClientUpdateDataForm(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("client", clientService.findClientById(id));
        return "update_client";
    }


    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable(value = "id") Long id) {
        clientService.deleteClientById(id);
        return "redirect:/clientList";
    }

}
