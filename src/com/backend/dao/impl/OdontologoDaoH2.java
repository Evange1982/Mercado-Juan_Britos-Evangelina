package com.backend.dao.impl;

import com.backend.dao.H2Connection;
import com.backend.dao.Idao;
import com.backend.entity.Odontologo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class OdontologoDaoH2 implements Idao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public Odontologo registrarOdonlotolos(Odontologo odontologo) {
        Connection conexion = null;
        Odontologo odontologo1 = null;

        try {
            conexion = H2Connection.getConnection();

            PreparedStatement ps = conexion.prepareStatement("INSER INTO ODONTOLOGOS(MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, odontologo.getMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            while(rs.next()){
                odontologo1 = getOdontologo(rs.getInt("1"), odontologo.getMatricula(), odontologo.getNombre(), odontologo.getApellido());
            }

            conexion.commit();

            LOGGER.info("El odontologo "+odontologo.getNombre()+" se a registrado");

        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
        
        return odontologo1;
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        Connection conexion = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            conexion = H2Connection.getConnection();

            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM ODONTOLOGOS");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                odontologos.add(getOdontologo(rs.getInt("ID"), rs.getInt("MATRICULA"), rs.getString("NOMBRE"), rs.getString("APELLIDO")));
            }

            LOGGER.info("Se obtuvieron "+odontologos.size()+" Odontologos");

        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }finally {
            try {
                conexion.close();//Cierre de la conexión a la base de datos.
            } catch (Exception exception) {
                LOGGER.error("Ocurrió un problema al intentar cerrar la base de datos. " + exception.getMessage());
                exception.printStackTrace();
            }
        }

        return odontologos;
    }

  private Odontologo getOdontologo(int id, int matricula, String nombre, String apellido){
        return new Odontologo(id, matricula, nombre, apellido);
  }


}
