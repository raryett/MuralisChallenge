package com.example.MuralisChallenge.Service;

import com.example.MuralisChallenge.model.Cliente;

import java.util.List;

public interface ClienteService {

    //cadastro Cliente
    Cliente salvarCliente (Cliente cliente);

    //listar clientes
    List<Cliente> listarClientes();

    //editar clientes
    Cliente editarCliente (Cliente cliente);

    //exclusao clientes
    Cliente excluirCliente (Cliente cliente);

    //busca de cliente por nome ou cpf

    List<Cliente> buscarPorNomeOuCpf (String buscaPor);






}
