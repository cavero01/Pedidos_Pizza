package com.pizzacustomizer.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PromocionDescuentoDto {
    private Long id;
    private String tipoPromocion; 
    private String descripcion;   
}
