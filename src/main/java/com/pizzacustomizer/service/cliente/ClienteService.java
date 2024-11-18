package com.pizzacustomizer.service.cliente;

import com.pizzacustomizer.broker.storage.cliente.IClienteStoragebroker;
import com.pizzacustomizer.model.dto.ClienteDto;
import com.pizzacustomizer.model.entity.Cliente;
import com.pizzacustomizer.util.ClienteMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    private final IClienteStorageBroker clienteStorageBroker;

    public ClienteService(IClienteStorageBroker clienteStorageBroker) {
        this.clienteStorageBroker = clienteStorageBroker;
    }

    @Override
    @Transactional
    public ClienteDto createCliente(ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.toEntity(clienteDto);
        Cliente createdCliente = clienteStorageBroker.create(cliente);
        return ClienteMapper.toDto(createdCliente);
    }

    @Override
    @Transactional
    public ClienteDto updateCliente(ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.toEntity(clienteDto);
        Cliente updatedCliente = clienteStorageBroker.update(cliente);
        return ClienteMapper.toDto(updatedCliente);
    }

    @Override
    public Optional<ClienteDto> findClienteById(Long id) {
        return clienteStorageBroker.findById(Cliente.class, id)
                .map(ClienteMapper::toDto);
    }

    @Override
    @Transactional
    public boolean deleteClienteById(Long id) {
        Optional<Cliente> clienteOptional = clienteStorageBroker.findById(Cliente.class, id);
        if (clienteOptional.isEmpty()) {
            return false;
        }
        clienteStorageBroker.delete(clienteOptional.get());
        return true;
    }
}
