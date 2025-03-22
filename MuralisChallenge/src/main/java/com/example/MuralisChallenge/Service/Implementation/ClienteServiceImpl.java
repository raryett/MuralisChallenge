package com.example.MuralisChallenge.Service.Implementation;

import com.example.MuralisChallenge.Service.ClienteService;
import com.example.MuralisChallenge.model.Cliente;
import com.example.MuralisChallenge.repository.ClienteRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {


    private ClienteRepository clienteRepository;


    @Override
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);

    }

    //editar clientes
    @Override
    public Cliente editarCliente(Cliente cliente){

        Optional<Cliente> clienteExistente = clienteRepository.findById(cliente.getId());

        if(clienteExistente.isPresent()){
            Cliente clienteEditado = clienteExistente.get();
            clienteEditado.setNome(cliente.getNome());
            clienteEditado.setCpf(cliente.getCpf());
            clienteEditado.setData_nascimento(cliente.getData_nascimento());
            clienteEditado.setEndereco(cliente.getEndereco());

            return clienteRepository.save(clienteEditado);
        }
        else{
            throw new RuntimeException("Cliente não encontrado");
        }

    }

    //exclusao clientes
    @Override
    public Cliente excluirCliente(Cliente cliente) {

        Optional<Cliente> clienteExistente = clienteRepository.findById(cliente.getId());
        if(clienteExistente.isPresent()){
            clienteRepository.delete(clienteExistente.get());
            return clienteExistente.get();
        }else {
            throw new RuntimeException("Cliente não encontrado");
        }

    }

    //busca pelo nome
    @Override
    public Cliente buscarClienteNome (String nome){
        Optional<Cliente> clienteExistente = clienteRepository.buscarPorNome(nome);
        if(clienteExistente.isPresent()){
            return clienteExistente.get();
        }else{
            throw new RuntimeException("Cliente não encontrado com esse nome" + nome );
        }

    }

    //busca pelo CPF
    public Cliente buscarClienteCpf(String cpf){
    Optional<Cliente> clienteExistente = clienteRepository.buscarPorCpf(cpf);
    if(clienteExistente.isPresent()){
        return clienteExistente.get();
    }else{
        throw new RuntimeException("Cliente não encontrado com esse cpf" + cpf );
    }
    }


    //ListarClientes
    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }


}
