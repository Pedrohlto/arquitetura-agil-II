package com.minhaempresa.meuecommerce.appestoque.adapters.out.repository;

import com.minhaempresa.meuecommerce.appestoque.adapters.out.repository.entidades.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, String> {
}
