package com.pizzacustomizer.service.promociondescuento;

import com.pizzacustomizer.broker.storage.promociondescuento.IPromocionDescuentoStoragebroker;
import com.pizzacustomizer.model.dto.PromocionDescuentoDto;
import com.pizzacustomizer.model.entity.PromocionDescuento;
import com.pizzacustomizer.util.PromocionDescuentoMapper;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PromocionDescuentoService implements IPromocionDescuentoService {

    private final IPromocionDescuentoStoragebroker promocionDescuentoStorageBroker;

    public PromocionDescuentoService(IPromocionDescuentoStoragebroker promocionDescuentoStorageBroker) {
        this.promocionDescuentoStorageBroker = promocionDescuentoStorageBroker;
    }

    @Override
    @Transactional
    public PromocionDescuentoDto createPromocionDescuento(PromocionDescuentoDto promocionDescuentoDto) {
        PromocionDescuento promocionDescuento = PromocionDescuentoMapper.toEntity(promocionDescuentoDto);
        PromocionDescuentoDto createdPromocionDescuento = PromocionDescuentoMapper.toDto(
                promocionDescuentoStorageBroker.create(promocionDescuento)
        );
        return createdPromocionDescuento;
    }

    @Override
    @Transactional
    public PromocionDescuentoDto updatePromocionDescuento(PromocionDescuentoDto promocionDescuentoDto) {
        PromocionDescuento promocionDescuento = PromocionDescuentoMapper.toEntity(promocionDescuentoDto);
        PromocionDescuentoDto updatedPromocionDescuento = PromocionDescuentoMapper.toDto(
                promocionDescuentoStorageBroker.update(promocionDescuento)
        );
        return updatedPromocionDescuento;
    }

    @Override
    public List<PromocionDescuentoDto> findAllPromocionDescuentos() {
        return promocionDescuentoStorageBroker.findAll(PromocionDescuento.class).stream()
                .map(PromocionDescuentoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PromocionDescuentoDto> findPromocionDescuentoById(Long id) {
        return promocionDescuentoStorageBroker.findById(PromocionDescuento.class, id)
                .map(PromocionDescuentoMapper::toDto);
    }
}
