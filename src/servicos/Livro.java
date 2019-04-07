/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ServicoException;
import java.util.ArrayList;

/**
 *  Representa um livro
 */
public class Livro {

    /**
     * Representa uma data temporal
     * @author Samuel Lucas de Moura Ferino
     */
    public class Data {

        private String dia;
        private String mes;
        private String ano;
        private String data; /// USADO APENAS INTERNAMENTE

        /**
         * Construtor da classe Data
         * @param data  Data em formato de string a ser armazenada
         * @throws ServicoException 
         */
        Data(String data) throws ServicoException{

            String diaTemporario = data.split("/")[0];
            String mesTemporario = data.split("/")[1];
            String anoTemporario = data.split("/")[2];

            if( diaTemporario.length() != 2
                ||    Integer.parseInt( diaTemporario ) < 1 
                || ( Integer.parseInt( diaTemporario ) > 31  && (  Integer.parseInt( mesTemporario ) == 1  || 
                                                                Integer.parseInt( mesTemporario ) == 3  || Integer.parseInt( mesTemporario ) == 5 || 
                                                                Integer.parseInt( mesTemporario ) == 7  || Integer.parseInt( mesTemporario ) == 8 ||
                                                                Integer.parseInt( mesTemporario ) == 10 || Integer.parseInt( mesTemporario ) == 12  ) 

                || ( Integer.parseInt( diaTemporario ) > 30  && (  Integer.parseInt( mesTemporario ) == 4  || Integer.parseInt( mesTemporario ) == 6 || 
                                                                Integer.parseInt( mesTemporario ) == 9  || Integer.parseInt( mesTemporario ) == 11 ) )

                || ( Integer.parseInt( diaTemporario ) > 28  && (  Integer.parseInt( mesTemporario ) == 2 )    )

                )  
               )
                throw new ServicoException("Dia invalido");

            if( mesTemporario.length() != 2 || 
                Integer.parseInt(mesTemporario) < 1 || 
                Integer.parseInt(mesTemporario) > 12 )
                throw new ServicoException("Mes invalido");

            if( anoTemporario.length() != 4  ||
                Integer.parseInt(anoTemporario) < 1920 ||
                Integer.parseInt(anoTemporario) > 2050 )
                throw new ServicoException("Ano invalido");

            this.dia = diaTemporario;
            this.mes = mesTemporario;
            this.ano = anoTemporario;
            this.data = data;
        }

        public String getDia() {
            return this.dia;
        }

        public String getMes() {
            return this.mes;
        }

        public String getAno() {
            return this.ano;
        }

        /**
         * Envia a string que contém a data
         * @return  A data em formato de string
         */
        @Override
        public String toString(){
            return this.data;
        }
    }
    
    /**
     * Representa o estado de um livro
     */
    public enum EstadoLivro{
        DISPONIVEL,
        ALUGADO;
    }
    
    private final String id;
    private final EstadoLivro estadoLivro;
    private final String edicao;
    private final int volume;
    private final String editora;
    private final String titulo;
    private final String autor;
    private final String cidadeDePublicacao;
    private final ArrayList<String> assunto;
    private final Data dataDeLancamento;
    private final int quantidadeDeTotalDeExemplares;
    private final int quantidadeDeExemplaresEmprestados;
    
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
