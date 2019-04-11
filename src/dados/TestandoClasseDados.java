/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.ArrayList;
import java.util.List;
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
        ILivroDAO livroDAO;
        
        try {
            livroDAO = LivroDAOArquivo.getInstancia();
            assunto.add("Suspense");
            assunto.add("Ficção");
            livro = new Livro("978-85-457-0367-1", "Português", 1, "Moderna", "A volta dos perdedores", "Welliton", assunto, "25/06/2008", 1);
            livros.add(livro);
            assunto = new ArrayList<>();
            assunto.add("Reportagem");
            assunto.add("Jornalismo");
            livro = new Livro("978-85-457-0367-4", "Inglês", 1, "Rocco", "Out Here!!!", "Welliton", assunto, "30/05/2008", 1);
            livros.add(livro);
            assunto = new ArrayList<>();
            assunto.add("Drama");
            assunto.add("Ficção Científica");
            livro = new Livro("978-85-457-0367-0", "Português", 1, "JBC", "Akira", "Katsuhiro Otomo", assunto, "20/12/1982", 1);
            livros.add(livro);
            assunto = new ArrayList<>();
            for (Livro next : livros) {
                livroDAO.registrarLivro(next);
            }
//            livro = livroDAO.consultaLivro("978-85-457-0367-0");
//            livroDAO.excluirLivro(livro);

//            List<Livro> livrosBuscados = livroDAO.consultaLivros("Titulo", "A");
//            
//            System.out.println("Livros encontrados: ");
//            for (Livro livroBuscado : livrosBuscados) {
//                System.out.println("ID: " + livroBuscado.getId());
//                System.out.println("Titulo: " + livroBuscado.getTitulo());
//            }
            
        } catch (ServicoException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
}