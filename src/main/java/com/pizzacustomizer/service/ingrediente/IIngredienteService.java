package com.pizzacustomizer.service.ingrediente;

import com.pizzacustomizer.model.dto.IngredienteDto;

import java.util.List;
import java.util.Optional;

public interface IIngredienteService {
    IngredienteDto createIngrediente(IngredienteDto ingredienteDto);

    IngredienteDto updateIngrediente(IngredienteDto ingredienteDto);

    List<IngredienteDto> findAllIngredientes();

    Optional<IngredienteDto> findIngredienteById(Long id);
}
