package com.pizzacustomizer.broker.storage.cliente;


import java.util.Optional;
import com.pizzacustomizer.broker.storage.IStorageBroker;
import com.pizzacustomizer.model.entity.Cliente;

public interface IClienteStorageBroker extends IStorageBroker {

    Cliente saveCliente (Cliente cliente);

    Cliente updateCliente(Cliente cliente);

    Optional<Cliente> findClienteById(Long id);

}