/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.model;

import java.util.Date;

/**
 *
 * @author caio.hcpereira
 */
public class Venda {
    private int id;
    private int cliente;
    private String formaPagamento;
    private float valorTotal;
    private String dataVenda;
    private String nomeCliente;
    
    public Venda() {
    }
    
    
    public Venda(int cliente, String formaPagamento, float valorTotal, String dataVenda) {
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    public Venda(int id, int cliente, String formaPagamento, float valorTotal, String dataVenda) {
        this.id = id;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }
    
        public Venda(int id, int cliente, String formaPagamento, float valorTotal, String dataVenda, String nomeCliente) {
        this.id = id;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.nomeCliente = nomeCliente;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    
    
}
