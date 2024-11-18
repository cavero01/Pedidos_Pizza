package com.pizzacustomizer.broker.storage.promociondescuento;

import com.pizzacustomizer.model.entity.PromocionDescuento;

import java.util.List;
import java.util.Optional;

public interface IPromocionDescuentoStoragebroker {
    PromocionDescuento create(PromocionDescuento promocionDescuento);
    PromocionDescuento update(PromocionDescuento promocionDescuento);
    List<PromocionDescuento> findAll(Class<PromocionDescuento> type);
    Optional<PromocionDescuento> findById(Class<PromocionDescuento> type, Long id);
}
