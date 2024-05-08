package co.ejercicio.actividad.repositorio;


import co.ejercicio.actividad.entidad.Ciudadano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositoriociudadano extends JpaRepository<Ciudadano, Long> {
}

