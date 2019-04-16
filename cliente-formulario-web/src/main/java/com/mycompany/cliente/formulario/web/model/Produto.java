package com.mycompany.cliente.formulario.web.model;

/**
 *
 * @author layssa.fodias
 */
public class Produto {
    
    private int id;
    private String titulo;
    private String Subtitulo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return Subtitulo;
    }

    public void setSubtitulo(String Subtitulo) {
        this.Subtitulo = Subtitulo;
    }

    public void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
