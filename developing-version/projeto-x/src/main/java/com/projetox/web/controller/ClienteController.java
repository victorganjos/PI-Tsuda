package com.projetox.web.controller;

import com.projetox.web.dao.ClienteDAO;
import com.projetox.web.model.Cliente;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class ClienteController {
    
    public static void salvar(String nome, String email, long cpf, String telefone, String endereco, int numero, String complemento, String estado, String cidade, String bairro, String cep, String tipo){
        Cliente c = new Cliente(nome,email,cpf, telefone, endereco, numero, complemento, estado, cidade, bairro, cep, tipo);
        ClienteDAO cliente = new ClienteDAO();
        cliente.salvar(c);
    }
    public static void atualizar(int id, String nome, String email, long cpf, String telefone, String endereco, int numero, String complemento, String estado, String cidade, String bairro, String cep, String tipo){
        Cliente c = new Cliente(id, nome,email,cpf, telefone, endereco, numero, complemento, estado, cidade, bairro, cep, tipo);
        ClienteDAO cliente = new ClienteDAO();
        cliente.atualizar(c);
    }
    
    public static void excluir (int id){
        ClienteDAO cliente = new ClienteDAO();
        cliente.deletar(id);
    }
    public static List<Cliente> consultarPorNome(String nome){
        ClienteDAO cliente = new ClienteDAO();
        return cliente.consultarPorNome(nome);
    }
    public static List<Cliente> consultar(){
        ClienteDAO cliente = new ClienteDAO();
        return cliente.consultar();
    }
    
    public static List<Cliente> consultarPorId(int id){
        ClienteDAO cliente = new ClienteDAO();
        return cliente.consultarPorId(id);
    }
    public static List<Cliente> consultarPorCpf(long cpf){
        ClienteDAO cliente = new ClienteDAO();
        return cliente.consultarPorCpf(cpf);
    }
}
