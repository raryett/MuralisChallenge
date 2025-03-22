package com.example.MuralisChallenge.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable= false )
    private String nome;

    @Column(nullable= false, unique=true)
    private String cpf;

    @Column(nullable= false)
    private Date data_nascimento;

    private String endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Contato> contatos;
    // como 1 cliente pode ter varios contatos devemos passar os objetos como lista
    //verfificar como e feito a liberacao  para uso do id para a tabela contato









}
