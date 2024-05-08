package co.ejercicio.actividad.operaciones;

import co.ejercicio.actividad.entidad.Ciudadano;

import java.util.List;

public interface operacionciudadano {

    public Ciudadano crear(Ciudadano ciudadano);

    public Ciudadano actualizar(Ciudadano ciudadano);

    public void borrar(Ciudadano ciudadano);

    public List<Ciudadano> consultarT();

    public Ciudadano consultarPK(String pk);
}


