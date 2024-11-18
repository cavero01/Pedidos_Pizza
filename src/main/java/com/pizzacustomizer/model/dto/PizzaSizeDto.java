package com.pizzacustomizer.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PizzaSizeDto {
    private Long id;
    private String nombre; 
    private double precioBase; 
}

