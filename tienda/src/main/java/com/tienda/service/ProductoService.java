package com.tienda.service;

import com.tienda.entity.Categoria;
import com.tienda.entity.Producto;
import com.tienda.repository.CategoriaRepository;
import com.tienda.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Producto crearProducto(double precioOriginal, String nombreCategoria) {
        Categoria categoria = categoriaRepository.findByNombreIgnoreCase(nombreCategoria)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        double descuento = precioOriginal * categoria.getPorcentajeDescuento();
        double precioFinal = (precioOriginal - descuento) + 5.0;

        Producto producto = new Producto();
        producto.setPrecioOriginal(precioOriginal);
        producto.setCategoria(categoria);
        producto.setPrecioFinal(precioFinal);
        return productoRepository.save(producto);
    }
}
