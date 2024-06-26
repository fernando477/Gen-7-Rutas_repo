package com.grande.app.rutas.repositories;

import com.grande.app.rutas.models.Camion;
import com.grande.app.rutas.models.Chofer;
import com.grande.app.rutas.models.enums.Marcas;
import com.grande.app.rutas.models.enums.Tipos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CamionesRespository implements IRepository<Camion>{
    private Connection conn;

    public CamionesRespository(Connection conn){
        this.conn = conn;
    }



    @Override
    public List<Camion> lista() throws SQLException {

        List <Camion> camiones = new ArrayList<>();

        try (Statement stmt= conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from camiones")) {
            while (rs.next()){
                Camion a = this.getCamion(rs);
                camiones.add(a);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return camiones;
    }

    @Override
    public Camion getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Camion camion) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    private Camion getCamion(ResultSet rs) throws SQLException {
        Camion a = new Camion();

        a.setId(rs.getLong("ID_CAMION"));
        a.setMatricula(rs.getString("MATRICULA"));
        //buscar la forma de trabajar enums
        a.setTipoCamion(Tipos.valueOf(rs.getString("TIPO_CAMION")));
        a.setModelo(rs.getInt("MODELO"));
        //buscar la forma de trabajar enums
        a.setMarca(Marcas.valueOf(rs.getString("MARCA")));
        a.setCapacidad(rs.getInt("CAPACIDAD"));
        a.setKilometro(rs.getDouble("KULOMETRAJE"));
        a.setDisponibilidad(rs.getBoolean("DISPONIBILIDAD"));
        return  a;

    }

}
