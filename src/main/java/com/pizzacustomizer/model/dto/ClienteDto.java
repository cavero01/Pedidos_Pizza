package com.pizzacustomizer.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


public class ClienteDto {
    private Long id;
    private String nombre;
    private String direccion;
}
