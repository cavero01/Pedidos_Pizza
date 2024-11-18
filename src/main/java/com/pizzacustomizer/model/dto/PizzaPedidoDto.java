package com.pizzacustomizer.model.dto;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PizzaPedidoDto {
    private Long id;
    private PizzaDto pizza;
    private double costo; 
    private boolean promocion; 
}
