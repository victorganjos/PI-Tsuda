package com.projetox.web.controller;

import com.projetox.web.dao.UsuarioDAO;
import com.projetox.web.model.Usuario;
import java.util.List;


public class UsuarioController {
    
    public static void Salvar(String nome, String username, String senha, String cargo, String filial){
        Usuario c = new Usuario(nome,username, senha, cargo, filial);
        UsuarioDAO usuario = new UsuarioDAO();
        usuario.salvar(c);
    }
    public static void Atualizar(int id, String nome, String username, String senha, String cargo, String filial){
        Usuario c = new Usuario(id, nome,username, senha, cargo, filial);
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
