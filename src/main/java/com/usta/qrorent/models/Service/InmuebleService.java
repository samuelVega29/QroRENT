package com.usta.qrorent.models.Service;

import com.usta.qrorent.entities.InmuebleEntity;
import com.usta.qrorent.entities.UbicacionEntity;

public interface InmuebleService {
    void guardarInmueble(InmuebleEntity inmueble, UbicacionEntity ubicacion, Integer usuarioId);
}