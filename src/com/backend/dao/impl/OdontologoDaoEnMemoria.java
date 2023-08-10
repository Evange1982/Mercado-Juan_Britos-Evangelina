package com.backend.dao.impl;
import com.backend.dao.Idao;
import com.backend.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OdontologoDaoEnMemoria implements Idao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoEnMemoria.class);

    private Map<Integer, Odontologo> odontologosEnMemoria;

    public OdontologoDaoEnMemoria(){
        odontologosEnMemoria = new HashMap<Integer, Odontologo>();
    }

    @Override
    public Odontologo registrarOdonlotolos(Odontologo odontologo) {
        odontologosEnMemoria.put(odontologo.getId(), odontologo);
        LOGGER.info("El odontologo "+odontologo.getNombre()+" se a registrado");
        return odontologo;
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        List<Odontologo> listaDeOdontologos = new ArrayList<>(odontologosEnMemoria.values());
        LOGGER.info("Se obtuvieron "+listaDeOdontologos.size()+" Odontologos");
        return listaDeOdontologos;
    }
}
