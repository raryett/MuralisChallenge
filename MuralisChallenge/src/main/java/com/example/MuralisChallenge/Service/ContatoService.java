package com.example.MuralisChallenge.Service;

import com.example.MuralisChallenge.model.Contato;

import java.util.List;

public interface ContatoService {


    //Cadastrar
    Contato salvarContato (Contato contato);

    //Listar
    List<Contato> buscarClientePorId(int clienteId);

    //Edicao dos contatos
    Contato editarContato (int contatoId, Contato novoContato);

    //Exclusão
    Contato excluirContato (Contato contato);




}
