package com.pizzacustomizer.service.promociondescuento;

import com.pizzacustomizer.model.dto.PromocionDescuentoDto;

import java.util.List;
import java.util.Optional;

public interface IPromocionDescuentoService {
    PromocionDescuentoDto createPromocionDescuento(PromocionDescuentoDto promocionDescuentoDto);

    PromocionDescuentoDto updatePromocionDescuento(PromocionDescuentoDto promocionDescuentoDto);

    List<PromocionDescuentoDto> findAllPromocionDescuentos();

    Optional<PromocionDescuentoDto> findPromocionDescuentoById(Long id);
}
