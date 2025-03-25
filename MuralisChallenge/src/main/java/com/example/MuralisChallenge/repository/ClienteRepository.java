package com.example.MuralisChallenge.repository;

import com.example.MuralisChallenge.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    //aqui eu vou colocar os metodos personalizados, caso nao tenha pode deixar vazio.

    @Query("SELECT b FROM Cliente b WHERE b.nome LIKE %:buscarPor% OR b.cpf LIKE %:buscarPor%")
    List<Cliente> buscarPorNomeouCpf(@Param("buscarPor") String buscarPor);

}
