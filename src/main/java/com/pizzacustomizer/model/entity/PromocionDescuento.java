package com.pizzacustomizer.model.entity;

import lombok.*;

import java.util.List;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "promociondescuento")
public class PromocionDescuento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoPromocion; 
    private String descripcion; 
    @ManyToMany(mappedBy = "promociones")
    private List<Dia> dias;
}
