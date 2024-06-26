package com.grande.app.rutas.repositories;

import com.grande.app.rutas.models.Chofer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChoferesRepository implements IRepository<Chofer>{

    private Connection conn;

    public ChoferesRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Chofer> lista() throws SQLException {
        List <Chofer> choferes = new ArrayList<>();

        try (Statement stmt= conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from choferes")) {

            while (rs.next()) {
                Chofer a = this.getChofer(rs);
                choferes.add(a);
            }

        } catch (SQLException e){
            throw new SQLException(e);
        }
        return choferes;
    }

    @Override
    public Chofer getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Chofer chofer) throws SQLException {
        String sql = "";

        if (chofer.getId() != null && chofer.getId() > 0 ){
            sql = "update choferes set nombre=?, ap_paterno=?, "+
                    "ap_materno=?, licencia=?, telefon=?, "+
                    "fecha_nacimiento=?, disponibilidad=?, "+
                    "where id_chofer=?";
        }else {
            sql = "insert into choferes(id_chofer, nombre," +
                    "ap_paterno, ap_materno, licencia, telefon, " +
                    "fecha_nacimiento, disponibilidad)"+
                    "values(-1,?,?,?,?,?,?,?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            if (chofer.getId() != null && chofer.getId() > 0){
                stmt.setString(1,chofer.getNombre());
                stmt.setString(2, chofer.getApPaterno());
                stmt.setString(2, chofer.getLicencias());
                stmt.setString(3, chofer.getTelefono());
                stmt.setDate(6, Date
                        .valueOf(chofer.getFechaNacimiento()));
                stmt.setInt(7, chofer.getDisponibilidad() ? 1:0);
                stmt.setLong(8, chofer.getId());

            } else{
                stmt.setString(1,chofer.getNombre());
                stmt.setString(2, chofer.getApPaterno());
                stmt.setString(3, chofer.getApMaterno());
                stmt.setString(4,chofer.getLicencias());
                stmt.setString(5, chofer.getTelefono());
                stmt.setDate(6, Date
                        .valueOf(chofer.getFechaNacimiento()));
                stmt.setInt(7, chofer.getDisponibilidad() ? 1:0);
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    private Chofer getChofer (ResultSet rs) throws SQLException{
        Chofer a = new Chofer();

        a.setId(rs.getLong("ID_CHOFER"));
        a.setNombre(rs.getString("NOMBRE"));
        a.setApPaterno(rs.getString("AP_PATERNO"));
        a.setApMaterno(rs.getString("AP_MATERNO"));
        a.setLicencias(rs.getString("LICENCIA"));
        a.setTelefono(rs.getString("TELEFON"));
        a.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
        a.setDisponibilidad(rs.getBoolean("DISPONIBILIDAD"));
        return  a;

    }
}
