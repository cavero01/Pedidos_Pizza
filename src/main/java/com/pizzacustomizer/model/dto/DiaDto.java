package com.pizzacustomizer.model.dto;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DiaDto {
    private Long id;
    private String nombre; 
    private List<PromocionDescuentoDto> promociones;
}
