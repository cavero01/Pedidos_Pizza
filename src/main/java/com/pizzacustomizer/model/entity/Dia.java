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
@Table(name = "dia")
public class Dia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; 

    @ManyToMany
    @JoinTable(
        name = "dia_promocion",
        joinColumns = @JoinColumn(name = "dia_id"),
        inverseJoinColumns = @JoinColumn(name = "promocion_id")
    )
    private List<PromocionDescuento> promociones; 
}
