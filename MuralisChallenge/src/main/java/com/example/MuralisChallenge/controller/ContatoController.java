package com.example.MuralisChallenge.controller;


import com.example.MuralisChallenge.Service.ContatoService;
import com.example.MuralisChallenge.model.Cliente;
import com.example.MuralisChallenge.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
@CrossOrigin

public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    //salvar Contato
    //funcionando
    @PostMapping("/salvarContato")
    public Contato salvarContato(@RequestBody Contato contato) {
        return contatoService.salvarContato(contato);
    }
    //listar todos os contatos por cliente
    //funcionando
    @GetMapping("/buscarPorId/{clienteId}")
    public List<Contato> buscarContatoById(@PathVariable int clienteId) {
        return contatoService.buscarClientePorId(clienteId);
    }


    //editar contatos
    //funcionando
    @PutMapping("/editarContato/{contatoId}")
    public ResponseEntity<Contato> editarContato(@PathVariable int contatoId, @RequestBody Contato novoContato) {
        return ResponseEntity.ok(contatoService.editarContato(contatoId, novoContato));
    }



    //excluir contatos
    //funcionando
    @DeleteMapping("/deletarContato/{id}")
    public ResponseEntity<String> deletarContato(@PathVariable("id") int id) {
        try{
            Contato contato =new Contato();
            contato.setId(id);
            contatoService.excluirContato(contato);
            return ResponseEntity.ok("Contato removido com sucesso");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }










}
