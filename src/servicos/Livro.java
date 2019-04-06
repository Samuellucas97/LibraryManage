/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;
import java.util.ArrayList;

/**
 *
 * @author SamDan
 */
public class Livro {

    public enum EstadoLivro{
        DISPONIVEL,
        ALUGADO;
    }

    private String id;
    private EstadoLivro estadoLivro;
            
            
    private String edicao;
    private int volume;
    private String editora;
    private String titulo;
    private String autor;
    private String cidadeDePublicacao;
    private ArrayList<String> assunto;
    private Data dataDeLancamento;
    private int quantidadeDeTotalDeExemplares;
    private int quantidadeDeExemplaresEmprestados;
    
    Livro(  String  id, 
            EstadoLivro estadoLivro,
            String  edicao,
            int     volume,
            String  editora,
            String  titulo, 
            String  autor, 
            String cidadeDePublicacao,
            ArrayList<String> assunto,
            String  dataDeLancamento, 
            int quantidadeTotalDeExemplares,
            int quantidadeDeExemplaresEmprestados) throws ServicoException{
        
        this.id = id;
        this.estadoLivro = estadoLivro;
        this.edicao = edicao;
        this.volume = volume;
        this.editora = editora;
        this.titulo = titulo;
        this.autor = autor;
        this.cidadeDePublicacao = cidadeDePublicacao;
        this.dataDeLancamento =  new Data(dataDeLancamento);
        this.assunto = assunto;
        this.quantidadeDeTotalDeExemplares = quantidadeTotalDeExemplares;
        this.quantidadeDeExemplaresEmprestados = quantidadeDeExemplaresEmprestados;
    }
   
    public String getId(){
        return this.id;
    }
    
    public EstadoLivro getEstadoLivro(){
        return this.estadoLivro;
    }
    
    public String getEdicao() {
        return this.edicao;
    }

    public int getVolume() {
        return this.volume;
    }

    public String getEditora() {
        return this.editora;
    }

    public ArrayList<String> getAssunto() {
        return this.assunto;
    }
       
    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getCidadeDePublicacao() {
        return cidadeDePublicacao;
    }

    public String getDataDeLancamento() {
        return this.dataDeLancamento.toString();
    }
    
    public int getQuantidadeDeExemplaresEmprestados(){
        return this.quantidadeDeExemplaresEmprestados;
    }
    
    public int getQuantidadeDeTotalDeExemplares() {
        return this.quantidadeDeTotalDeExemplares;
    }
}
