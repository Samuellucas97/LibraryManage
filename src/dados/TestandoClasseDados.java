/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicos.Livro;

/**
 *
 * @author Junior
 */
public class TestandoClasseDados {
    
    public static void main(String args[]){
        List<Livro> livros = new ArrayList<>();
        ArrayList<String> assunto = new ArrayList<>();
        Livro livro;
        LivroDAO livroDAO = LivroDAOArquivo.getInstancia();
        
        try {
            assunto.add("Suspense");
            assunto.add("Ficção");
            livro = new Livro("978-85-457-0367-1", Livro.EstadoLivro.DISPONIVEL, "Português", 1, "Moderna", "A volta dos perdedores", "Welliton", "São Paulo", assunto, "25/06/2008", 1, 0);
            livros.add(livro);
            assunto = new ArrayList<>();
            assunto.add("Reportagem");
            assunto.add("Jornalismo");
            livro = new Livro("978-85-457-0367-4", Livro.EstadoLivro.DISPONIVEL, "Inglês", 1, "Rocco", "Out Here!!!", "Welliton", "New York", assunto, "30/05/2008", 1, 0);
            livros.add(livro);
            assunto = new ArrayList<>();
            assunto.add("Drama");
            assunto.add("Ficção Científica");
            livro = new Livro("978-85-457-0367-0", Livro.EstadoLivro.DISPONIVEL, "Português", 1, "JBC", "Akira", "Katsuhiro Otomo", "Japão", assunto, "20/12/1982", 1, 0);
            livros.add(livro);
            assunto = new ArrayList<>();
            for (Livro next : livros) {
                livroDAO.registrarLivro(next);
            }            
        
        } catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
}
