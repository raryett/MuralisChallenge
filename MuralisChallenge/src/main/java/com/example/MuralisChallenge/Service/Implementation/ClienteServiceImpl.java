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

    //busca pelo nome ou CPF


    //ListarClientes
    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }


}
