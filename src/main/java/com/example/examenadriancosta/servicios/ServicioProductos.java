package com.example.examenadriancosta.servicios;

import com.example.examenadriancosta.modelo.Producto;
import com.example.examenadriancosta.repositorios.RepositorioProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProductos {
    @Autowired
    RepositorioProductos repositorioProductos;
    public List<Producto> findAll(){
        return repositorioProductos.findAll();
    }
    public Producto findById(long id){
        return repositorioProductos.findById(id);
    }
    public Producto save(Producto producto){
        return repositorioProductos.save(producto);
    }
    public void update(long id, Producto producto){
        Producto productoexiste = repositorioProductos.findById(id);

        if (productoexiste != null) {
            productoexiste.setNombre(producto.getNombre());
            productoexiste.setMarca(producto.getMarca());
            productoexiste.setDesperfecto(producto.getDesperfecto());
            productoexiste.setTipoProducto(producto.getTipoProducto());
            repositorioProductos.save(productoexiste);
        }
    }
    public void deleteById(long id){
        repositorioProductos.deleteById(id);
    }
}

