package com.backend.test;

import com.backend.dao.impl.OdontologoDaoEnMemoria;
import com.backend.entity.Odontologo;
import com.backend.service.OdontologoService;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OdontologoServiceTestEnMemoria {

    @Test
    public void grabarEnMemoriaTest(){
        OdontologoService odontologoServiceEnMemoria = new OdontologoService(new OdontologoDaoEnMemoria());

        odontologoServiceEnMemoria.registrarOdontologo(new Odontologo(1, 10, "Juan", "Mercado"));
        odontologoServiceEnMemoria.registrarOdontologo(new Odontologo(1, 11, "Evangelina", "Britos"));

        List<Odontologo> listaDeOdontologos = odontologoServiceEnMemoria.listarOdontologos();

        assertFalse(listaDeOdontologos.isEmpty());
        assertEquals(2, listaDeOdontologos.size());
    }
}
