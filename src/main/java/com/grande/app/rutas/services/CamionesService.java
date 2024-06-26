package com.grande.app.rutas.services;

import com.grande.app.rutas.models.Camion;
import com.grande.app.rutas.models.Chofer;
import com.grande.app.rutas.repositories.CamionesRespository;
import com.grande.app.rutas.repositories.ChoferesRepository;
import com.grande.app.rutas.repositories.IRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CamionesService implements IServis<Camion>{
    private IRepository<Camion> camionesRepo;

    public CamionesService(Connection conn){
        camionesRepo = new CamionesRespository(conn );
    }

    @Override
    public List<Camion> listas() {
        try {
            return camionesRepo.lista();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Camion> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Camion camion) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
