package com.minhaempresa.meuecommerce.apppagamento.adapters.out.repository;

import com.minhaempresa.meuecommerce.apppagamento.adapters.out.repository.entidades.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, String> {
}
