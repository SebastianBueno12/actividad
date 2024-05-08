package co.ejercicio.actividad.controlador;

import co.ejercicio.actividad.entidad.Ciudadano;
import co.ejercicio.actividad.operaciones.OperacionesCiudadano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ciudadanos")
public class ControladorCiudadano {

    @Autowired
    private OperacionesCiudadano operacionesCiudadano;

    @GetMapping("/listar")
    public String listarCiudadanos(Model model) {
        List<Ciudadano> ciudadanos = operacionesCiudadano.consultarT();
        model.addAttribute("ciudadanos", ciudadanos);
        return "ciudadanos/listar";
    }

    @GetMapping("/crear")
    public String crearCiudadano(Model model) {
        model.addAttribute("ciudadano", new Ciudadano());
        return "ciudadanos/crear";
    }

    @PostMapping("/guardar")
    public String guardarCiudadano(@ModelAttribute("ciudadano") Ciudadano ciudadano) {
        operacionesCiudadano.crear(ciudadano);
        return "redirect:/ciudadanos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarCiudadano(@PathVariable Long id, Model model) {
        Ciudadano ciudadano = operacionesCiudadano.consultarPK(id);
        model.addAttribute("ciudadano", ciudadano);
        return "ciudadanos/editar";
    }

    @PostMapping("/actualizar")
    public String actualizarCiudadano(@ModelAttribute("ciudadano") Ciudadano ciudadano) {
        operacionesCiudadano.actualizar(ciudadano);
        return "redirect:/ciudadanos/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCiudadano(@PathVariable Long id) {
        Ciudadano ciudadano = operacionesCiudadano.consultarPK(id);
        operacionesCiudadano.borrar(ciudadano);
        return "redirect:/ciudadanos/listar";
    }
}
