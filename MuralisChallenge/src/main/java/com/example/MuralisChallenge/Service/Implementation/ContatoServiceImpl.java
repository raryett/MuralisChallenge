package com.example.MuralisChallenge.Service.Implementation;

import com.example.MuralisChallenge.Service.ContatoService;
import com.example.MuralisChallenge.model.Cliente;
import com.example.MuralisChallenge.model.Contato;
import com.example.MuralisChallenge.repository.ContatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContatoServiceImpl implements ContatoService {

    private ContatoRepository contatoRepository ;

    @Override
    public Contato salvarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public List<Contato> buscarClientePorId(int clienteId) {
        return contatoRepository.buscarClientePorId(clienteId);
    }


    @Override
    public Contato editarContato(int contatoId, Contato novoContato) {
       Optional<Contato> contatoExistente = contatoRepository.findById(contatoId);

       if(contatoExistente.isPresent()) {
           Contato contatoEditado = contatoExistente.get();
           contatoEditado.setTipo(novoContato.getTipo());
           contatoEditado.setValor(novoContato.getValor());
           contatoEditado.setObservacao(novoContato.getObservacao());
           return contatoRepository.save(contatoEditado);
       }else {
           throw new RuntimeException("Contato não encontrado");
       }

    }

    @Override
    public Contato excluirContato(Contato contato) {
        Optional<Contato> contatoEncontrado = contatoRepository.findById(contato.getId());
        if (contatoEncontrado.isPresent()) {
            contatoRepository.delete(contatoEncontrado.get());
            return contatoEncontrado.get();
        } else {
            throw new RuntimeException("Contato não encontrado");
        }
    }

}



