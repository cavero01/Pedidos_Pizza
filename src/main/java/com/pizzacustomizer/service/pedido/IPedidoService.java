package com.pizzacustomizer.service.pedido;

import com.pizzacustomizer.model.dto.PedidoDto;

import java.util.List;
import java.util.Optional;

public interface IPedidoService {
    PedidoDto createPedido(PedidoDto pedidoDto);

    PedidoDto updatePedido(PedidoDto pedidoDto);

    List<PedidoDto> findAllPedidos();

    Optional<PedidoDto> findPedidoById(Long id);
}
