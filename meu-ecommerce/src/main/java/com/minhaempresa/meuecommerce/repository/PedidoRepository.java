package com.minhaempresa.meuecommerce.repository;

import com.minhaempresa.meuecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
}
