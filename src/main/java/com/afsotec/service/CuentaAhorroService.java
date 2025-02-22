package com.afsotec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CuentaAhorroService {

    @Autowired
    private DataSource dataSource;

    public List<Map<String, String>> consultaAhorros(Integer empresa, String identificacion) {
        List<Map<String, String>> resultados = new ArrayList<>();

        // SQL para llamar al procedimiento almacenado
        String sql = "{call SP_CONSULTA_AHORROS(?, ?)}";

        try (Connection connection = dataSource.getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)) {

            // Establecer los parámetros del procedimiento almacenado
            callableStatement.setInt(1, empresa);
            callableStatement.setString(2, identificacion);

            // Ejecutar el procedimiento almacenado
            callableStatement.execute();

            // Obtener el resultado del procedimiento almacenado
            try (ResultSet resultSet = callableStatement.getResultSet()) {
                while (resultSet.next()) {
                    Map<String, String> fila = new HashMap<>();
                    fila.put("empresa", resultSet.getString("EMPRESA"));
                    fila.put("nombre_corto_empresa", resultSet.getString("NOMBRE_CORTO_EMPRESA"));
                    fila.put("sucursal_id", resultSet.getString("SUCURSAL_ID"));
                    fila.put("nombre_sucursal", resultSet.getString("NOMBRE_SUCURSAL"));
                    fila.put("codigo", resultSet.getString("CODIGO"));
                    fila.put("mensaje", resultSet.getString("MENSAJE"));
                    fila.put("nsocio", resultSet.getString("NSOCIO"));
                    fila.put("identificacion", resultSet.getString("IDENTIFICACION"));
                    fila.put("nombre_completo", resultSet.getString("NOMBRE_COMPLETO"));
                    fila.put("ncuenta", resultSet.getString("NCUENTA"));
                    fila.put("titular", resultSet.getString("TITULAR"));
                    fila.put("idproducto", resultSet.getString("IDPRODUCTO"));
                    fila.put("nproducto", resultSet.getString("NPRODUCTO"));
                    fila.put("tipo_ahorro", resultSet.getString("TIPO_AHORRO"));
                    fila.put("estatus", resultSet.getString("ESTATUS"));
                    fila.put("stotal", resultSet.getString("STOTAL"));
                    fila.put("saldo_bloqueado", resultSet.getString("SALDO_BLOQUEADO"));
                    fila.put("saldo_transito", resultSet.getString("SALDO_TRANSITO"));
                    fila.put("sdisponible", resultSet.getString("SDISPONIBLE"));

                    resultados.add(fila);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultados;
    }
}