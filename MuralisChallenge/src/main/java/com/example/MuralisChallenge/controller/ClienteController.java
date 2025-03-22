package com.example.MuralisChallenge.controller;


import com.example.MuralisChallenge.Service.ClienteService;
import com.example.MuralisChallenge.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin

public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    //cadastro Cliente
    @PostMapping("/salvarCliente")
    public String addCliente(@RequestBody Cliente cliente) {
        clienteService.salvarCliente(cliente);
        return "Cliente adicionado com sucesso!";
    }

    //editar clientes

    @PostMapping("/editarCliente")
    public String editarCliente(@RequestBody Cliente cliente) {
        clienteService.editarCliente(cliente);
        return "Cliente editado com sucesso!";
    }

    //exclusao clientes

    //busca pelo nome ou CPF




    //listar clientes
    @GetMapping("/listarClientes")
    public List<Cliente> getAllClientes() {
        return clienteService.listarClientes();
    }





}
