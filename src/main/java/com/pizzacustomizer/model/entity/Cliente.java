package com.pizzacustomizer.model.entity;

import lombok.*;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.Entity;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos; // Relación con los pedidos del cliente
}