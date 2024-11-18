package com.pizzacustomizer.util;

import com.pizzacustomizer.model.entity.PromocionDescuento;
import com.pizzacustomizer.model.dto.PromocionDescuentoDto;

public class PromocionDescuentoMapper {

    public static PromocionDescuentoDto toDto(PromocionDescuento entity) {
        PromocionDescuentoDto dto = new PromocionDescuentoDto();
        dto.setId(entity.getId());
        dto.setTipoPromocion(entity.getTipoPromocion());
        dto.setDescripcion(entity.getDescripcion());
        return dto;
    }

    public static PromocionDescuento toEntity(PromocionDescuentoDto dto) {
        PromocionDescuento entity = new PromocionDescuento();
        entity.setId(dto.getId());
        entity.setTipoPromocion(dto.getTipoPromocion());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }
}
