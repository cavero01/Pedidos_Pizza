package com.pizzacustomizer.model.dto;

import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PedidoDto {
    private Long id;
    private ClienteDto cliente;
    private List<PizzaDto> pizzas; 
    private String metodoEntrega;
    private double costoDelivery;
    private double total;
    private Date fechaCreacion;
}