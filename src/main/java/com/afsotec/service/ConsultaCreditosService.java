package com.afsotec.service;

import com.afsotec.repository.ConsultaCreditosRepository;
import com.afsotec.response.ConsultaCreditosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.afsotec.model.Creditos;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaCreditosService {

    @Autowired
    private ConsultaCreditosRepository consultaCreditosRepository;

    public List<ConsultaCreditosResponse> consultarCreditos(Integer empresaId, String identificacion) {
        List<Creditos> resultados = consultaCreditosRepository.findCreditosByIdentificacion(empresaId, identificacion);
        List<ConsultaCreditosResponse> creditos = new ArrayList<>();

        for (Creditos credito : resultados) {
            ConsultaCreditosResponse response = new ConsultaCreditosResponse();
            response.setEmpresaId(credito.getEmpresaId());
            response.setNombreEmpresa(credito.getNombreEmpresa());
            response.setSucursalId(credito.getSucursalId());
            response.setNombreSucursal(credito.getNombreSucursal());
            response.setSocioId(credito.getSocioId());
            response.setNumeroCredito(credito.getNumeroCredito());
            response.setIdentificacion(credito.getIdentificacion());
            response.setNombres(credito.getNombres());
            response.setTipoCredito(credito.getTipoCredito());
            response.setDescripcionCredito(credito.getDescripcionCredito());
            response.setEstatusCredito(credito.getEstatusCredito());
            response.setSaldoCapital(credito.getSaldoCapital());
            response.setAmortizacion(credito.getAmortizacion());
            response.setInteres(credito.getInteres());
            response.setMora(credito.getMora());
            response.setGestion(credito.getGestion());
            response.setSeguro(credito.getSeguro());
            response.setTotal(credito.getTotal());
            response.setMail(credito.getMail());
            response.setCelular(credito.getCelular());
            response.setCuentaAhorroId(credito.getCuentaAhorroId());
            response.setEstatusCuenta(credito.getEstatusCuenta());
            response.setNombreProducto(credito.getNombreProducto());

            creditos.add(response);
        }

        return creditos;
    }
}