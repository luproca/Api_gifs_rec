package com.afsotec.controller;

import com.afsotec.dto.CuentaAhorroRequest;
import com.afsotec.service.CuentaAhorroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cuentas-ahorro")
public class CuentaAhorroController {

    @Autowired
    private CuentaAhorroService cuentaAhorroService;

    // Consulta personalizada: consulta-ahorro
    @PostMapping("/consulta-ahorro")
    public ResponseEntity<List<Map<String, String>>> consultaAhorro(@RequestBody CuentaAhorroRequest request) {
        Integer empresa = request.getEmpresa();
        String identificacion = request.getIdentificacion();

        // Llamar al servicio para ejecutar el procedimiento almacenado
        List<Map<String, String>> resultados = cuentaAhorroService.consultaAhorros(empresa, identificacion);

        return ResponseEntity.ok(resultados);
    }
}