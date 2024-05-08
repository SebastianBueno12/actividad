package co.ejercicio.actividad.servicio;

import co.ejercicio.actividad.entidad.Ciudadano;
import co.ejercicio.actividad.operaciones.OperacionesCiudadano;
import co.ejercicio.actividad.repositorio.RepositorioCiudadano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosCiudadano implements OperacionesCiudadano {

    @Autowired
    private RepositorioCiudadano repositorioCiudadano;

    @Override
    public Ciudadano crear(Ciudadano ciudadano) {
        return repositorioCiudadano.save(ciudadano);
    }

    @Override
    public Ciudadano actualizar(Ciudadano ciudadano) {
        if (consultarPK(ciudadano.getId()) != null)
            return repositorioCiudadano.save(ciudadano);
        return null;
    }

    @Override
    public void borrar(Ciudadano ciudadano) {
        repositorioCiudadano.delete(ciudadano);
    }

    @Override
    public List<Ciudadano> consultarT() {
        return repositorioCiudadano.findAll();
    }

    @Override
    public Ciudadano consultarPK(Long id) {
        return repositorioCiudadano.findById(id).orElse(null);
    }
}


