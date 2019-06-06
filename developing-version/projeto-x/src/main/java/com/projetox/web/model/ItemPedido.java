/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.model;

/**
 *
 * @author caio.hcpereira
 */
public class ItemPedido {
    private int codigoItemPedido;
    private int codigoPedido;
    private float quantidade;
    private float valorProduto;
    private int codigoProduto;

    public int getCodigoItemPedido() {
        return codigoItemPedido;
    }

    public void setCodigoItemPedido(int codigoItemPedido) {
        this.codigoItemPedido = codigoItemPedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    
}
