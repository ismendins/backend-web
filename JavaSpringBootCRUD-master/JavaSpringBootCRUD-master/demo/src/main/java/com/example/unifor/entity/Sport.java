package com.example.unifor.entity;


import jakarta.persistence.*;

@Entity
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_place")
    private Place place;

}
