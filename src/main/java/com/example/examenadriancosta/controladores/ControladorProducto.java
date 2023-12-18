package com.example.examenadriancosta.controladores;

import com.example.examenadriancosta.modelo.Producto;
import com.example.examenadriancosta.servicios.ServicioProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorProducto {

    @Autowired
    ServicioProductos repo;


    // Cogemos las direcciones indicadas en el GetMapping y mostramos la vista index
    @GetMapping({"/", "/index", "/index.html"})
    public String paginaInicial(Model model){

        model.addAttribute("listaProductos", repo.findAll());

        return "index";
    }

    // Cogemos la direccion indicada en el GetMapping, creo un nuevo producto y mostramos la vista formulario
    @GetMapping({"/producto/crear"})
    public String crearProducto(Model model){

        model.addAttribute("producto", new Producto());

        return "formulario";
    }

    // Cogemos la dirección indicada en el PostMapping que hemos utilizado en el formulario, guardo producto pasado por parametro y redireccionamos al index
    @PostMapping({"/producto/crear/submit"})
    public String crearProductoEnviar(@ModelAttribute("producto") Producto producto){

        repo.save(producto);

        return "redirect:/index";
    }

    // Cogemos la direccion indicada en el GetMapping, busco producto con la id del parametro y muestro el formulario
    @GetMapping({"/producto/modificar/{id}"})
    public String modificarProducto(Model model, @PathVariable long id){

        Producto producto = repo.findById(id);

        model.addAttribute("producto", producto);

        return "formulario";
    }

    // Cogemos la dirección indicada en el PostMapping que hemos utilizado en el formulario, actualizo producto pasado por parametro filtrando por su ID y redireccionamos al index
    @PostMapping({"/producto/modificar/submit"})
    public String modificarProductoEnviar(@ModelAttribute("producto") Producto producto){

        repo.update(producto.getId(), producto);

        return "redirect:/index";
    }

    // Cogemos la direccion indicada en el GetMapping y eliminamos la producto con id indicada por parámetro
    @GetMapping("/producto/eliminar/{id}")
    public String eliminarProducto(@PathVariable long id){
        repo.deleteById(id);

        return "redirect:/index";
    }

}
