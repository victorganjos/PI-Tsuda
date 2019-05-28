/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.model;

/**
 *
 * @author Fabio
 */
public class VendaDois {
    private int id;
    private int idCliente;
    private double valorTotal;
    private String dataVenda;

    public VendaDois() {
    }

    public VendaDois(int id, int idCliente, double valorTotal, String dataVenda) {
        this.id = id;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    public VendaDois(int idCliente, double valorTotal, String dataVenda) {
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    
}
