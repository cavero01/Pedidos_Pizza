package com.pizzacustomizer.service.pedido;

import com.pizzacustomizer.broker.storage.pedido.IPedidoStoragebroker;
import com.pizzacustomizer.model.dto.PedidoDto;
import com.pizzacustomizer.model.entity.Pedido;
import com.pizzacustomizer.util.PedidoMapper;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService implements IPedidoService {

    private final IPedidoStoragebroker pedidoStorageBroker;

    public PedidoService(IPedidoStoragebroker pedidoStorageBroker) {
        this.pedidoStorageBroker = pedidoStorageBroker;
    }

    @Override
    @Transactional
    public PedidoDto createPedido(PedidoDto pedidoDto) {
        Pedido pedido = PedidoMapper.toEntity(pedidoDto);
        PedidoDto createdPedido = PedidoMapper.toDto(pedidoStorageBroker.create(pedido));
        return createdPedido;
    }

    @Override
    @Transactional
    public PedidoDto updatePedido(PedidoDto pedidoDto) {
        Pedido pedido = PedidoMapper.toEntity(pedidoDto);
        PedidoDto updatedPedido = PedidoMapper.toDto(pedidoStorageBroker.update(pedido));
        return updatedPedido;
    }

    @Override
    public List<PedidoDto> findAllPedidos() {
        return pedidoStorageBroker.findAll(Pedido.class).stream()
                .map(PedidoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PedidoDto> findPedidoById(Long id) {
        return pedidoStorageBroker.findById(Pedido.class, id)
                .map(PedidoMapper::toDto);
    }
}
