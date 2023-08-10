package com.backend.dao.impl;

import com.backend.dao.Idao;
import com.backend.entity.Odontologo;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class OdontologoDaoEnMemoria implements Idao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoEnMemoria.class);

    private List<Odontologo> odontologosEnMemoria;

    public OdontologoDaoEnMemoria(){
        odontologosEnMemoria = new ArrayList<>();
    }

    @Override
    public Odontologo registrarOdonlotolos(Odontologo odontologo) {
        odontologosEnMemoria.add(odontologo);
        LOGGER.info("El odontologo "+odontologo.getNombre()+" se a registrado");
        return odontologo;
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        LOGGER.info("Se obtuvieron "+odontologosEnMemoria.size()+" Odontologos");
        return odontologosEnMemoria;
    }
}
