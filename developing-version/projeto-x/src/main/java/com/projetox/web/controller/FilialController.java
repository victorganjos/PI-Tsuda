package com.projetox.web.controller;

import com.projetox.web.dao.FilialDAO;
import com.projetox.web.model.Filial;
import java.util.List;

/**
 * @author victor.ganjos
 */
public class FilialController {

    public static void salvar(String nome, String email, long cnpj, String telefone, String endereco, int numero, String complemento, String estado, String cidade, String bairro, String cep, String tipo) {
        Filial f = new Filial(nome, email, cnpj, telefone, endereco, numero, complemento, estado, cidade, bairro, cep, tipo);
        FilialDAO fDao = new FilialDAO();
        fDao.salvar(f);
    }

    public static void atualizar(int id, String nome, String email, long cnpj, String telefone, String endereco, int numero, String complemento, String estado, String cidade, String bairro, String cep, String tipo) {
        Filial f = new Filial(id, nome, email, cnpj, telefone, endereco, numero, complemento, estado, cidade, bairro, cep, tipo);
        FilialDAO fDao = new FilialDAO();
        fDao.atualizar(f);
    }

    public static void excluir(int id) {
        FilialDAO fDao = new FilialDAO();
        fDao.deletar(id);
    }

    public static List<Filial> consultarPorNome(String nome) {
        FilialDAO fDao = new FilialDAO();
        return fDao.consultarPorNome(nome);
    }

    public static List<Filial> consultarPorId(int id) {
        FilialDAO fDao = new FilialDAO();
        return fDao.consultarPorId(id);
    }

    public static List<Filial> consultar() {
        FilialDAO fDao = new FilialDAO();
        return fDao.consultar();
    }

}
