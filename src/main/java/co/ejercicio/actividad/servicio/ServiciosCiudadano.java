package co.ejercicio.actividad.servicio;

import co.ejercicio.actividad.entidad.Ciudadano;
import co.ejercicio.actividad.operaciones.operacionciudadano;
import co.ejercicio.actividad.repositorio.repositoriociudadano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiciosCiudadano implements operacionciudadano {

    @Autowired
    repositoriociudadano Repositoriociudadano;

    @Override
    public Ciudadano crear(Ciudadano ciudadano) {
        return Repositoriociudadano.save(ciudadano);
    }

    @Override
    public Ciudadano actualizar(Ciudadano ciudadano) {
        if (this.consultarPK(ciudadano.getCedula()) != null)
            return Repositoriociudadano.save(ciudadano);
        return null;
    }


    @Override
    public void borrar(Ciudadano ciudadano) {
        Repositoriociudadano.delete(ciudadano);
    }

    @Override
    public List<Ciudadano> consultarT() {
        return Repositoriociudadano.findAll();
    }

    @Override
    public Ciudadano consultarPK(String pk) {
        return Repositoriociudadano.findById(Long.valueOf(pk)).orElse(null);

    }

}

