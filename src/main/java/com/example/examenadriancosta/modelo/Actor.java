package com.example.examenadriancosta.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;

    /*
    @ManyToOne
    private List<Pelicula> listaPelicula;
*/

}
