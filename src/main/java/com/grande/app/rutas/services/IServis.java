package com.grande.app.rutas.services;

import java.util.List;
import java.util.Optional;

public interface IServis <T>{

    List<T> listas();

    Optional<T> getById(Long id);

    void guardar (T t);

    void eliminar (Long id);
}
