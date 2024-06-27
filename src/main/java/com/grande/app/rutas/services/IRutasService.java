package com.grande.app.rutas.services;

import com.grande.app.rutas.models.Camion;
import com.grande.app.rutas.models.Chofer;
import com.grande.app.rutas.models.Ruta;

import java.util.List;

public interface IRutasService extends IServis<Ruta>{
    List<Camion> lidtarCamiones();
    List<Chofer> listarChofer();
    Long guardarReturnId(Ruta ruta);
}
