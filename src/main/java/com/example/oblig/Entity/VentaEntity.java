package com.example.oblig.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VentaEntity {
    @Id
    private int nroVenta;

    @Column
    private List<ProductEntity> listaProductos;

    @Column
    private int totalVenta;

    @Column
    private ClientEntity cliente;

    @Column
    private String fchCompra;

    @Column
    private VendedorEntity vendedor;

    public int getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(int nroVenta) {
        this.nroVenta = nroVenta;
    }

    public List<ProductEntity> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductEntity> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(int totalVenta) {
        this.totalVenta = totalVenta;
    }

    public ClientEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClientEntity cliente) {
        this.cliente = cliente;
    }

    public String getFchCompra() {
        return fchCompra;
    }

    public void setFchCompra(String fchCompra) {
        this.fchCompra = fchCompra;
    }

    public VendedorEntity getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorEntity vendedor) {
        this.vendedor = vendedor;
    }

    public VentaEntity(int nroVenta, List<ProductEntity> listaProductos, int totalVenta, ClientEntity cliente,
            String fchCompra, VendedorEntity vendedor) {
        this.nroVenta = nroVenta;
        this.listaProductos = listaProductos;
        this.totalVenta = totalVenta;
        this.cliente = cliente;
        this.fchCompra = fchCompra;
        this.vendedor = vendedor;
    }

    public VentaEntity() {
    }
}