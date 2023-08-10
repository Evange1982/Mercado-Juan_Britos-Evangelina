package com.backend.test;

import com.backend.dao.impl.OdontologoDaoH2;
import com.backend.entity.Odontologo;
import com.backend.service.OdontologoService;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OdontologoServiceTest {

    @Test
    public void listarLosOdontologos() {
        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

        List<Odontologo> odontologos = odontologoService.listarOdontologos();

        assertFalse(odontologos.isEmpty());
        assertEquals(2,odontologos.size());
    }
}