package com.pizzacustomizer.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class IngredienteDto {
    private Long id;
    private String nombre; 
    private double costo;
}