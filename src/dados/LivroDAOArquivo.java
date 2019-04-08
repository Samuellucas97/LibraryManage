/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import servicos.Livro;

/**
 *
 * @author José Welliton Nunes Júnior
 */
public class LivroDAOArquivo implements LivroDAO{
    
    private static LivroDAOArquivo instancia = null;
    private HashMap<String, Livro> hMapLivro;
    
    private LivroDAOArquivo() throws ServicoException{
        this.hMapLivro = new HashMap<>();
        lerArquivo("Livros");        
    }
    
    public static LivroDAOArquivo getInstancia() throws ServicoException{
        if(LivroDAOArquivo.instancia == null) LivroDAOArquivo.instancia = new LivroDAOArquivo();
                
        return LivroDAOArquivo.instancia;
    }
    
    private void limparRegistro(){
        this.hMapLivro.clear();
    }
    
    @Override
    public Livro consultaLivro(String idLivro) throws ServicoException{
        Livro livro = this.hMapLivro.get(idLivro);
        
        if(livro == null) throw new ServicoException("Livro não encotrado!");
        
        return livro;        
    }
       
    @Override
    public List<Livro> consultaLivros(List<String> params, List<String> keys) throws ServicoException{
        List<Livro> livros = new ArrayList<>();
        List<List<Livro> > listLivros = new ArrayList<>();
        
        if(params.size() != keys.size()) throw new ServicoException("Quantidade de chaves não confere com a quantidade de parametros!");
        
        int i = 0;
        for(String param : params) listLivros.add(this.consultaLivros(param, keys.get(i++)));
        
        Collections.sort(listLivros, (o1, o2) -> {
            if(o1.size() > o2.size()) return -1;
            else if (o1.size() < o2.size()) return 1; 
            return 0;
        });
        
        for(Iterator<List<Livro>> iterator = listLivros.iterator(); iterator.hasNext();) {
            List<Livro> next = iterator.next();
            if(livros.isEmpty()) livros.addAll(next);
            else{
                List<Livro> auxLivros = new ArrayList<>();
                auxLivros.addAll(livros);
                auxLivros.removeAll(next);
                livros.removeAll(auxLivros);
            }
            if(livros.isEmpty()) break;
        }
        
        if(livros.isEmpty()) throw new ServicoException("Nenhum livro encontrado!");
        
        return livros;
    }
    
    @Override
    public List<Livro> consultaLivros(String param, String key) throws ServicoException{
        List<Livro> livros = new ArrayList<>();
        
        for (Map.Entry<String, Livro> livro : this.hMapLivro.entrySet()) {
            Livro value = livro.getValue();
            
            switch(param){
                case "Assunto":
                    for(String assunto: value.getAssunto()){
                        if(assunto.toLowerCase().contains(key.toLowerCase())){
                            livros.add(value);
                            break;
                        }
                    }                    
                    break;
                case "Autor":
                    if(value.getAutor().toLowerCase().contains(key.toLowerCase())) livros.add(value);
                    break;
                case "CidadeDePublicacao":
                    if(value.getCidadeDePublicacao().toLowerCase().contains(key.toLowerCase())) livros.add(value);
                    break;
                case "DataDeLancamento":
                    if(value.getDataDeLancamento().toLowerCase().contains(key.toLowerCase())) livros.add(value);
                    break;
                case "Edicao":
                    if(value.getEdicao().toLowerCase().contains(key.toLowerCase())) livros.add(value);
                    break;
                case "Editora":
                    if(value.getEditora().toLowerCase().contains(key.toLowerCase())) livros.add(value);
                    break;
                case "EstadoLivro":
                    if(value.getEstadoLivro().toString().toLowerCase().contains(key.toLowerCase())) livros.add(value);
                    break;
                case "Titulo":
                    if(value.getTitulo().toLowerCase().contains(key.toLowerCase())) livros.add(value);
                    break;
                    //case "Avaliacao": fazer
                default:
                    if(value.getId().equals(key)) livros.add(value);
            }
            
        }
                
        if(livros.isEmpty()) throw new ServicoException("Nenhum livro encontrado!");
        
        return livros;
    }
    
    @Override
    public void adicionarQuantidadeLivro(String idLivro, int quantidade) throws ServicoException{
        Livro livro = this.hMapLivro.get(idLivro);
        
        if(livro == null) throw new ServicoException("Livro não encotrado!");
        
        if(quantidade <= 0) throw new ServicoException("Quantidade inválida de exemplares!");
              
        livro.setQuantidadeDeTotalDeExemplares(livro.getQuantidadeDeTotalDeExemplares() + quantidade);
        
        if(livro.getEstadoLivro().compareTo(Livro.EstadoLivro.ALUGADO) == 0) livro.setEstadoLivro(Livro.EstadoLivro.DISPONIVEL);
        
        this.salvarArquivo("Livros");
        
        throw new ServicoException("Quantidade desse livro adicionada com sucesso!");
    }
    
    @Override
    public void removerQuantidadeLivro(String idLivro, int quantidade) throws ServicoException{
        Livro livro = this.hMapLivro.get(idLivro);
        
        if(livro == null) throw new ServicoException("Livro não encotrado!");
        
        if(quantidade < (livro.getQuantidadeDeTotalDeExemplares() - livro.getQuantidadeDeExemplaresEmprestados())) throw new ServicoException("Quantidade inválida de exemplares!");
        
        livro.setQuantidadeDeTotalDeExemplares(livro.getQuantidadeDeTotalDeExemplares() - quantidade);
        
        if(livro.getEstadoLivro().compareTo(Livro.EstadoLivro.DISPONIVEL) == 0 && (livro.getQuantidadeDeTotalDeExemplares() - livro.getQuantidadeDeExemplaresEmprestados())== 0) 
            livro.setEstadoLivro(Livro.EstadoLivro.ALUGADO);
        
        this.salvarArquivo("Livros");
        
        throw new ServicoException("Quantidade desse livro adicionada com sucesso!");
        
    }
    
    @Override
    public void registrarLivro(Livro livro) throws ServicoException {
        Livro livroVerificação = this.hMapLivro.get(livro.getId());
        
        if(livroVerificação != null) throw new ServicoException("Livro com esse ID já registrado!");
        
        this.hMapLivro.put(livro.getId(), livro);
        this.salvarArquivo("Livros");//, this.transformarHashMapEmString());
    }
    
    @Override
    public void alterarLivro(Livro livro, Livro livroAlterado) throws ServicoException{
        if(livro.getId().equals(livroAlterado.getId())){
            this.hMapLivro.remove(livro.getId());
            this.hMapLivro.put(livroAlterado.getId(), livroAlterado);
            this.salvarArquivo("Livros");
        }
        else{
            if(this.hMapLivro.containsKey(livroAlterado.getId())){
                throw new ServicoException("A alteração não foi concluida! \n O ID escolhido já é utilizado");
            }
            else{
                this.hMapLivro.remove(livro.getId());
                this.hMapLivro.put(livroAlterado.getId(), livroAlterado);
                this.salvarArquivo("Livros");
            }
        }
    }

    @Override
    public void excluirLivro(Livro livro) throws ServicoException {
        boolean verification =  this.hMapLivro.remove(livro.getId(), livro);
        if(!verification) throw new ServicoException("Esse livro não existe no catálogo e não pode ser excluído!");
        
        this.salvarArquivo("Livros");
    }

    private void lerArquivo(String nomeDoArquivo) throws ServicoException{
          this.hMapLivro = (HashMap<String, Livro>) Serializator.unserialize(nomeDoArquivo);
    }
    
    private boolean salvarArquivo(String nomeArquivo) throws ServicoException{
        Serializator.serialize(this.hMapLivro, nomeArquivo);
        return true;
    }   
    
}
