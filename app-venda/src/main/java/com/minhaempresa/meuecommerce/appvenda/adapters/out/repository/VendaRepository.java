package com.minhaempresa.meuecommerce.appvenda.adapters.out.repository;

import com.minhaempresa.meuecommerce.appvenda.adapters.out.repository.entidades.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<VendaEntity, String> {
}
