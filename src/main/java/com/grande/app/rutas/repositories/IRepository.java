package com.grande.app.rutas.repositories;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

public interface IRepository <T>{

    List<T> lista() throws SQLException;

    T getById (Long id) throws SQLException;
    void guardar (T t) throws SQLException;
    void eliminar (Long id ) throws SQLException;
}
