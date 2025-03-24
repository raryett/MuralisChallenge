package com.example.MuralisChallenge.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false) // Define a FK corretamente
    private Cliente cliente;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String valor;

    private String observacao;

    // falta colocar a anotacao not null
    //Verificar como esta chamando a FK


}
