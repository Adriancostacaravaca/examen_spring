package com.example.examenadriancosta.repositorios;

import com.example.examenadriancosta.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioProductos extends JpaRepository<Producto,
        Long> {
    public ArrayList<Producto> findAll();
    public Producto findById(long id);
    public void deleteById(long id);
    public Producto save(Producto persona);
}
