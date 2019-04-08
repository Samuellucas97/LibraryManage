/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicos.Livro;

/**
 *
 * @author SamDan
 */
public class LivroDAOArquivo implements LivroDAO{
    
    private static LivroDAOArquivo instancia = null;
    private HashMap<String, Livro> hMapLivro;
    
    private LivroDAOArquivo(){
        this.hMapLivro = new HashMap<>();
        //String conteudoArquivo = lerArquivo("Livros.lm");
        //this.transformaStringEmHashMap(conteudoArquivo);
        lerArquivo("Livros.lm");
    }
    
    public static LivroDAOArquivo getInstancia(){
        if(LivroDAOArquivo.instancia == null) LivroDAOArquivo.instancia = new LivroDAOArquivo();
        
        return LivroDAOArquivo.instancia;
    }
    
    private void limparRegistro(){
        this.hMapLivro.clear();
        //adicionar repegar do arquivo
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
                    if(value.getAssunto().contains(key)) livros.add(value);
                    break;
                case "Autor":
                    if(value.getAutor().equals(key)) livros.add(value);
                    break;
                case "CidadeDePublicacao":
                    if(value.getCidadeDePublicacao().equals(key)) livros.add(value);
                    break;
                case "DataDeLancamento":
                    if(value.getDataDeLancamento().equals(key)) livros.add(value);
                    break;
                case "Edicao":
                    if(value.getEdicao().equals(key)) livros.add(value);
                    break;
                case "Editora":
                    if(value.getEditora().equals(key)) livros.add(value);
                    break;
                case "EstadoLivro":
                    if(value.getEstadoLivro().toString().equals(key)) livros.add(value);
                    break;
                case "Titulo":
                    if(value.getTitulo().equals(key)) livros.add(value);
                    break;
                default:
                    if(value.getId().equals(key)) livros.add(value);
            }
            
        }
                
        if(livros.isEmpty()) throw new ServicoException("Nenhum livro encontrado!");
        
        return livros;
    }
    
    @Override
    public void adicionarLivro(String idLivro, int quantidade) throws ServicoException{
        Livro livro = this.hMapLivro.get(idLivro);
        
        if(quantidade <= 0) throw new ServicoException("Quantidade inválida de exemplares!");
        
        if(livro == null) throw new ServicoException("Livro não encotrado!");
        
        livro.setQuantidadeDeTotalDeExemplares(livro.getQuantidadeDeTotalDeExemplares() + quantidade);
        
        this.salvarArquivo("Livros.lm");//, this.transformarHashMapEmString());
        
        throw new ServicoException("Quantidade desse livro adicionada com sucesso!");
    }
    
    @Override
    public void registrarLivro(Livro livro) throws ServicoException {
        Livro livroVerificação = this.hMapLivro.get(livro.getId());
        
        if(livroVerificação != null) throw new ServicoException("Livro com esse ID já registrado!");
        
        this.hMapLivro.put(livro.getId(), livro);
        this.salvarArquivo("Livros.lm");//, this.transformarHashMapEmString());
    }
    
    @Override
    public void alterarLivro(Livro livroAlterado) throws ServicoException{
        
    }
    
//    @Override
//    public void bloqueioTemporarioDeLivro(Livro livro) throws ServicoException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void bloqueioPermanenteDeLivro(Livro livro) throws ServicoException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void excluirLivro(Livro livro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void alterarLivro() throws ServicoException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void emprestimoDeLivro(Livro livro) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void efetuarDevolucaoDeLivro(Livro livro) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   
    
//    private void transformaStringEmHashMap(String conteudoArquivo){
//    
//        this.hMapLivro.clear();
//        
//        Cliente cliente = new Cliente();
//        
//        for(String linhaDoArquivo: conteudoArquivo.split("\n") ){
//
//            cliente.setLogin( linhaDoArquivo.split(";")[1].split(":")[1] );
//            cliente.setSenha( linhaDoArquivo.split(";")[2].split(":")[1] );
//            cliente.setNome( linhaDoArquivo.split(";")[3].split(":")[1] );
//            cliente.setTelefone( linhaDoArquivo.split(";")[4].split(":")[1] );
//            cliente.setIdade( Integer.parseInt(linhaDoArquivo.split(";")[5].split(":")[1] ));
//            cliente.setGenero( linhaDoArquivo.split(";")[6].split(":")[1] );
//            cliente.
//
//            hMapCliente.put( cliente.getLogin(), cliente);
//
//        }
//    
//    }    
//    
//    private String transformarHashMapEmString(){
//        
//    }
//    
//    public String verificacao(String idLivro) throws ServicoException{
//        
//        this.transformaStringEmHashMap(this.lerArquivo(""));
//        
//        Livro livroTemporario = this.hMapLivro.get(idLivro);
//        
//        if(this.clienteDAO.autenticar(login, senha).equals("OK")){
//            Usuario cliente = this.clienteDAO.buscar(login);
//            return cliente;
//        }
//           if(livroTemporario == null)   return "Livro não encontrado";     
//        
//        
//        return "OK";
//    }   
    	
    private void lerArquivo(String nomeDoArquivo){
        byte[] bytes;
        FileInputStream read;
        ByteArrayInputStream bis;
        
        ObjectInput in;
        
//        String leitura = new String();
                
        try{            
            //BufferedReader buffReader = new BufferedReader(new FileReader( nomeDoArquivo ));
            read = new FileInputStream(nomeDoArquivo);
            bytes = new byte[read.available()];
            read.read(bytes);
            
            bis = new ByteArrayInputStream(bytes);
            in = new ObjectInputStream(bis);
            this.hMapLivro = (HashMap<String, Livro>) in.readObject();
            
            //            while( buffReader.ready() ){              // -> LENDO CADA LINHA  
//                leitura += buffReader.readLine() + "\n";
//            }
//            
//            buffReader.close();
        }
        catch(FileNotFoundException e){  // -> Arquivo não existe
            System.err.println( e.getMessage() );
        }
        catch( NullPointerException | IOException e){
            System.err.println( e.getMessage() );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LivroDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        // -> OCORREU OUTRO ERRO, SENDO ESSE DESCONHECIDO
        
//        return leitura;
        
    }
    
    private boolean salvarArquivo(String nomeArquivo){//, String conteudoArquivo){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out;
        FileOutputStream writer;
        byte[] bytes;
	
//        if( conteudoArquivo.equals("") ) {
//                return false;
//        }
	
	try{
            //nomeArquivo += ".dat";
            
            out = new ObjectOutputStream(bos);
            out.writeObject(this.hMapLivro);
            out.flush();
            
            bytes = bos.toByteArray();
                        
            writer = new FileOutputStream(nomeArquivo);
            //FileWriter writer = new FileWriter(nomeArquivo);
            writer.write(bytes);
            //writer.write(conteudoArquivo);
            bos.close();
            writer.close(); 		
            return true;

        }
        catch(FileNotFoundException e){   // -> ARQUIVO NãO EXISTE
	    System.err.println( e.getMessage() );
            //System.out.println("Arquivo não criado");
	    return false;        
        }
        catch(IOException e){  // -> OCORREU OUTRO ERRO, SENDO ESSE DESCONHECIDO
            System.err.println( e.getMessage() );
            return false;
        }
    
    }   
    
}
