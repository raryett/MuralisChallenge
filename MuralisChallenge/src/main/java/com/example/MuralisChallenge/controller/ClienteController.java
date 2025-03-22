package com.example.MuralisChallenge.controller;


import com.example.MuralisChallenge.Service.ClienteService;
import com.example.MuralisChallenge.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //precisa arrumar esse pra receber o id
    @PutMapping("/editarCliente/{id}")
    public String editarCliente(@RequestBody Cliente cliente) {
        clienteService.editarCliente(cliente);
        return "Cliente editado com sucesso!";
    }


    //exclusao clientes
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<String> excluirCliente(@PathVariable Cliente cliente) {
        clienteService.excluirCliente(cliente);
        return ResponseEntity.ok("Cliente excluido com sucesso!");

    }



    //busca pelo nome
    @GetMapping("/buscarClientesPeloNome")
    public String buscarClientesPeloNome(@RequestParam("nome") String nome) {
        clienteService.buscarClienteNome(nome);
        return "Busca feita com sucesso!";
    }

    //busca pelo CPF
    @GetMapping("/buscarClientesPeloCpf")
    public String buscarClientesPeloCpf(@RequestParam("cpf") String cpf) {
        clienteService.buscarClienteCpf(cpf);
        return "Busca feita com sucesso!";
    }


    //listar clientes
    @GetMapping("/listarClientes")
    public List<Cliente> getAllClientes() {
        return clienteService.listarClientes();
    }





}
