package com.afsotec.service;

import com.afsotec.dto.ConsultaAhorrosResponse;
import com.afsotec.repository.ConsultaAhorrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaAhorrosService {

    @Autowired
    private ConsultaAhorrosRepository consultaAhorrosRepository;

    public List<ConsultaAhorrosResponse> consultaAhorros(Integer empresa, String identificacion) {
        return consultaAhorrosRepository.consultaAhorros(empresa, identificacion);
    }
}