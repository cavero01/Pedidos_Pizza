package com.pizzacustomizer.model.dto;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PizzaDto {
    private Long id;
    private String nombre;               
    private String size;               
    private double costo;                
    private List<IngredienteDto> ingredientes; 
    private Long recetaId;           
}
