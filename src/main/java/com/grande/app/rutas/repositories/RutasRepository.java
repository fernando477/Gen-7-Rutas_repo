package com.grande.app.rutas.repositories;

import com.grande.app.rutas.models.Ruta;

import javax.swing.table.TableRowSorter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RutasRepository implements IRutasRepository{
    private Connection conn;
    public RutasRepository(Connection conn){
        this.conn = conn;
    }



    @Override
    public List<Ruta> lista() throws SQLException {
        return List.of();
    }

    @Override
    public Ruta getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Ruta ruta) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    @Override
    public Long guardarReturnId(Ruta ruta) throws SQLException {
        String  sql;
        Long resultado = -1L;

        sql = "insert into rutas (ID_RUTA, camion_id, chofer_id, " +
                "direccion_origen_id, direccion_destino_id, distancia," +
                "fecha_salida, " +
                "fecha_llegada_estimada, fecha_llegada_real, a_tiempo)" +
                "values (SEQUENCE4.NEXTVAL,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql,
                new String[]{"ID_RUTA"})){
            stmt.setLong(1, ruta.getCamionid());
            stmt.setLong(2, ruta.getChoferid());
            stmt.setLong(3, ruta.getDireccionOrigenid());
            stmt.setLong(4, ruta.getDireccionDestinoid());
            stmt.setFloat(5, ruta.getDistancia());
            stmt.setDate(6, Date.valueOf(ruta.getFechaSalida()));
            stmt.setDate(7, Date.valueOf(ruta.getFechaLlegadaEstimada()));
            stmt.setDate(8, Date.valueOf(ruta.getFechaLlegadaEstimada()));
            stmt.setInt(9, ruta.getaTiempo());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()){
                resultado = rs.getLong(1);
            }
        }
        return resultado;
    }
}
