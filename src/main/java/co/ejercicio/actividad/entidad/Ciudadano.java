package co.ejercicio.actividad.entidad;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ciudadanos")
@Builder
@ToString
public class Ciudadano {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String cedula;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String telefono;
}

