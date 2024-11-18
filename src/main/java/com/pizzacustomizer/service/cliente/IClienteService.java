package com.pizzacustomizer.service.cliente;

import com.pizzacustomizer.model.dto.ClienteDto;

import java.util.Optional;

public interface IClienteService {
    ClienteDto createCliente(ClienteDto clienteDto);
    ClienteDto updateCliente(ClienteDto clienteDto);
    Optional<ClienteDto> findClienteById(Long id);
    boolean deleteClienteById(Long id);
}
