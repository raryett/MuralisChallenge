package com.example.MuralisChallenge.Service;

import com.example.MuralisChallenge.model.Contato;

import java.util.List;

public interface ContatoService {


    //Cadastrar
    Contato salvarContato (Contato contato);

    //Listar
    List<Contato> listarContatos();

    //Edicao dos contatos
    Contato editarContato (Contato contato);

    //Exclusão
    Contato excluirContato (Contato contato);

    //listagem de todos os contatos de um cliente especifico


}
