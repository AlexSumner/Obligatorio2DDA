package com.example.oblig.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.oblig.Entity.ProductEntity;
import com.example.oblig.Service.ProductService;
import com.example.oblig.Utils.AppExeption;

@Controller
@RequestMapping("/products")
public class ProductContoller {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> agregarProducto(@RequestBody ProductEntity productEntity) {
        try {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productService.save(productEntity));
        } catch (AppExeption e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema.");
        }
    }

    @DeleteMapping("{codProd}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int codProd) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.delete(codProd));
        } catch (AppExeption e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema.");
        }
    }

    @PutMapping
    public ResponseEntity<?> modificarProducto(@RequestBody ProductEntity productEntity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.update(productEntity));
        } catch (AppExeption e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
    }

    @GetMapping("{codProd}")
    public ResponseEntity<?> buscarProducto(@PathVariable int codProd) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.getByCod(codProd));
        } catch (AppExeption e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el sistema");
        }
    }
}
