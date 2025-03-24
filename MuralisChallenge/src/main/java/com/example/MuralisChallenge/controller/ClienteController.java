package com.example.MuralisChallenge.controller;


import com.example.MuralisChallenge.Service.ClienteService;
import com.example.MuralisChallenge.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    //funcionando
    @PostMapping("/salvarCliente")
    public String addCliente(@RequestBody Cliente cliente) {
        clienteService.salvarCliente(cliente);
        return "Cliente adicionado com sucesso!";
    }

    //editar clientes
    //funcionando
    @PutMapping("/editarCliente/{id}")
    public String editarCliente(@PathVariable int id,@RequestBody Cliente cliente) {
        cliente.setId(id);
        clienteService.editarCliente(cliente);
        return "Cliente editado com sucesso!";
    }


    //exclusao clientes
    //funcionando
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirCliente(@PathVariable("id") int id) {
        try{
            Cliente cliente = new Cliente();
            cliente.setId(id);
            clienteService.excluirCliente(cliente);
            return ResponseEntity.ok("Cliente excluido com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }

    }
    //buscarPorNomeOuCpf
    //funcionando
    @GetMapping("/buscarPorNomeOuCpf")
    public List<Cliente> buscarPorNomeOuCpf(@RequestParam("buscaPor") String buscaPor) {
        return clienteService.buscarPorNomeOuCpf(buscaPor);
    }

    //listar clientes
    //funcionando
    @GetMapping("/listarClientes")
    public List<Cliente> getAllClientes() {
        return clienteService.listarClientes();
    }





}
