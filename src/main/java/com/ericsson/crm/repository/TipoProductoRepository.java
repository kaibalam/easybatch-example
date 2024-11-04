package com.ericsson.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ericsson.crm.model.TipoProducto;

@Repository
public interface TipoProductoRepository  extends JpaRepository<TipoProducto, Integer> {

}
