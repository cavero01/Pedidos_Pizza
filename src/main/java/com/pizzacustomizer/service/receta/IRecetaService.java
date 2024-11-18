package com.pizzacustomizer.service.receta;

import com.pizzacustomizer.model.dto.RecetaDto;

import java.util.List;
import java.util.Optional;

public interface IRecetaService {
    RecetaDto createReceta(RecetaDto recetaDto);

    RecetaDto updateReceta(RecetaDto recetaDto);

    List<RecetaDto> findAllRecetas();

    Optional<RecetaDto> findRecetaById(Long id);
}
