package com.example.MuralisChallenge.repository;

import com.example.MuralisChallenge.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    //aqui eu vou colocar os metodos personalizados, caso nao tenha pode deixar vazio.
    Optional<Cliente> buscarPorCpf(String cpf);
    Optional<Cliente> buscarPorNome(String nome);


}
