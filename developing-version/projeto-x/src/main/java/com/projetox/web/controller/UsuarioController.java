package com.projetox.web.controller;

import com.projetox.web.dao.UsuarioDAO;
import com.projetox.web.model.Usuario;
import java.util.List;


public class UsuarioController {
    
    public static void Salvar(String nome, String filial, String cargo, String setor, String CPF, String RG, String data, String endereco, String numero, String complemento, String estado, String cidade, String bairro, String cep, String telefone, String celular, String email, String infoAdcionais){
        Usuario c = new Usuario(nome,filial, cargo, setor, CPF, RG, data, endereco, numero, complemento, estado, cidade, bairro, cep, telefone, celular, email, infoAdcionais);
        UsuarioDAO usuario = new UsuarioDAO();
        usuario.salvar(c);
    }
    public static void Atualizar(int id, String nome, String filial, String cargo, String setor, String CPF, String RG, String data, String endereco, String numero, String complemento, String estado, String cidade, String bairro, String cep, String telefone, String celular, String email, String infoAdcionais){
        Usuario c = new Usuario(id, nome,filial, cargo, setor, CPF, RG, data, endereco, numero, complemento, estado, cidade, bairro, cep, telefone, celular, email, infoAdcionais);
        UsuarioDAO usuario = new UsuarioDAO();
        usuario.atualizar(c);
    }
    
    public static void Excluir (int id){
        UsuarioDAO usuario = new UsuarioDAO();
        usuario.deletar(id); 
    }
    public static List<Usuario> consultarPorNome(String nome){
        UsuarioDAO usuario = new UsuarioDAO();
        return usuario.consultarPorNome(nome);
    }
    public static List<Usuario> consultar(){
        UsuarioDAO usuario = new UsuarioDAO();
        return usuario.consultar();
    }
    
    public static List<Usuario> pesquisar(int id){
        UsuarioDAO usuario = new UsuarioDAO();
        return usuario.pesquisar(id);
    }
}
