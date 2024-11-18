package com.pizzacustomizer.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pizzacustomizer.model.entity.PromocionDescuento;

@Repository
public interface PromocionDescuentoRepository extends CrudRepository <PromocionDescuento,Long> {
    
}
