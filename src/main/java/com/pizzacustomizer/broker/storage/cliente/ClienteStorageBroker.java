package com.pizzacustomizer.broker.storage.cliente;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.pizzacustomizer.broker.storage.StorageBroker;
import com.pizzacustomizer.model.entity.Cliente;
import com.pizzacustomizer.model.repository.ClienteRepository;


@Service
public class ClienteStorageBroker extends StorageBroker implements IClienteStorageBroker {

    private final ClienteRepository clienteRepository;

    public ClienteStorageBroker(ClienteRepository clienteRepository)
    {this.clienteRepository = clienteRepository;
    }

    public ClienteRepository getClienteRepository(){
        return clienteRepository;
    }

    @Override
    public Cliente saveCliente (Cliente cliente){
        return create(cliente);
    }

    @Override
    public Cliente updateCliente (Cliente cliente){
        return update(cliente);
    }

    @Override
    public Optional <Cliente> findClienteById(Long id){
    return findById(Cliente.class, id);
    }
    
}


