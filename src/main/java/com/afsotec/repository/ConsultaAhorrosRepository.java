package com.afsotec.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConsultaAhorrosRepository {

    @Autowired
    private DataSource dataSource;

    public List<String> consultaAhorros(Integer empresa, String identificacion) {
        List<String> resultados = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            // Habilitar DBMS_OUTPUT
            try (CallableStatement enableDbmsOutput = connection.prepareCall("{call DBMS_OUTPUT.ENABLE(NULL)}")) {
                enableDbmsOutput.execute();
            }

            // Ejecutar el procedimiento almacenado
            try (CallableStatement callableStatement = connection.prepareCall("{call SP_CONSULTA_AHORROS(?, ?)}")) {
                callableStatement.setInt(1, empresa);
                callableStatement.setString(2, identificacion);
                callableStatement.execute();
            }

            // Capturar la salida de DBMS_OUTPUT
            try (CallableStatement fetchDbmsOutput = connection.prepareCall("{call DBMS_OUTPUT.GET_LINE(?, ?)}")) {
                fetchDbmsOutput.registerOutParameter(1, java.sql.Types.VARCHAR);
                fetchDbmsOutput.registerOutParameter(2, java.sql.Types.NUMERIC);

                while (true) {
                    fetchDbmsOutput.execute();
                    String line = fetchDbmsOutput.getString(1);
                    int status = fetchDbmsOutput.getInt(2);

                    if (status == 0) {
                        resultados.add(line);
                    } else {
                        break; // No hay más líneas para leer
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }
}