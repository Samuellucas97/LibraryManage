/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 *
 * @author SamDan
 */
public class Livro {

    private String titulo;
    private String autor;
    private String dataDeLancamento;
    private int quantidadeDeExemplares;
    
    Livro(String titulo, String autor, String dataDeLancamento, int quantidadeDeExemplares){
        
        this.titulo = titulo;
        this.autor = autor;
        this.dataDeLancamento = dataDeLancamento;
        this.quantidadeDeExemplares = quantidadeDeExemplares;
    }

    public int getQuantidadeDeExemplares() {
        return quantidadeDeExemplares;
    }
    
    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getDataDeLancamento() {
        return this.dataDeLancamento;
    }
    
}
