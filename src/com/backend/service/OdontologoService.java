package com.backend.service;

import com.backend.dao.Idao;
import com.backend.entity.Odontologo;

import java.util.List;

public class OdontologoService
{
    private Idao<Odontologo> odontologoIdao;

    public OdontologoService(Idao<Odontologo> odontologoIdao){
        this.odontologoIdao = odontologoIdao;
    }


    public Odontologo registrarOdontologo(Odontologo odontologo){
        return odontologoIdao.registrarOdonlotolos(odontologo);
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoIdao.listarOdontologos();
    }
}
