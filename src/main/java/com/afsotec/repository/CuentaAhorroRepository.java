package com.afsotec.repository;

import com.afsotec.model.CuentaAhorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaAhorroRepository extends JpaRepository<CuentaAhorro, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}