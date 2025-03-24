package com.example.MuralisChallenge.repository;

import com.example.MuralisChallenge.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {


    @Query("SELECT c FROM Contato c WHERE c.cliente.id = :clienteId")
    List<Contato> buscarClientePorId(@Param("clienteId") int clienteId);




}
