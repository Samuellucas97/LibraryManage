/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.ClienteDAOArquivo;
import dados.ServicoException;
import dados.UsuarioDAOFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Representa um funcionário
 * @author  Samuel Lucas de Moura Ferino
 * @author  José Wellinton Nunes Júnior
 * 
 */
public class ClienteServico implements IUsuarioServico{
 
    private static ClienteDAOArquivo clienteDAOArquivo;
    private static ILivroServico livroServico;
    
    /**
     * Construtor padrão
     * @throws dados.ServicoException
     */
    public ClienteServico() throws ServicoException{ 
            ClienteServico.livroServico = LivroServico.getInstance();      
            ClienteServico.clienteDAOArquivo = (ClienteDAOArquivo) UsuarioDAOFactory.getUsuarioDAO("ClienteDAOArquivo");
    }
    
    /**
     * Insere ranking no livro
     * @param idLivro identificador do livro;
     * @return 
     */
    private void inserirRankingLivro(String idLivro, Cliente cliente){
        
        /// Dúvida: é para inserir esse livro no atributo ranking da classe Cliente?
        ///         E se for, eu o adiciono com qual ranking
                
    }
    
    /**
     * Salva o cliente no sistema
     * @param login Login do cliente
     * @param senha Senha do cliente
     * @param nome  Nome do cliente
     * @param telefone  Telefone do cliente
     * @param idade Idade do cliente
     * @param genero    Gênero do cliente    
     * @throws ServicoException 
     */
    public void salvar( String login, 
                        String senha, 
                        String nome,
                        String telefone,
                        int idade,
                        String genero ) throws ServicoException{
    
        Cliente cliente = new Cliente();
        
        cliente.setLogin(login);
        cliente.setSenha(senha);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setIdade(idade);
        cliente.setGenero(genero);
        
        this.clienteDAOArquivo.registrar(cliente );
            
    }
    
    /**
     * Consulta cliente  
     * @param loginCliente  Cliente a ser consultado
     * @return Cliente buscado
     * @throws ServicoException 
     */
    public Cliente consultarCliente( String loginCliente ) throws ServicoException{
        return (Cliente) clienteDAOArquivo.consultar(loginCliente);
    }
    
    /**
     * Bloqueia cliente permanentemente
     * @param cliente Cliente a ser bloqueado permanentemente
     */
    public void bloqueioPermanenteDeCliente(Cliente cliente) {
        this.alterar(cliente, "EstadoCliente", "BLOQUEADO_PERMANENTEMENTE");
    }

    /**
     * Bloqueia cliente temporariamente
     * @param cliente Cliente a ser bloqueado temporariamente
     */
    public void bloqueioTemporarioDeCliente(Cliente cliente) {
        this.alterar(cliente, "EstadoCliente", "BLOQUEADO_TEMPORARIAMENTE");
    }

    public void avaliarLivro( notaLivro) throws ServicoException {
        
    }

    public List<Livro> listaLivrosAlugados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object avaliarLivro(Livro get, int intValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void avaliarLivro(int notaLivro) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Cliente copia(Cliente cliente) throws ServicoException{
        ArrayList<String> listAssunto;
        String[] assuntos;
        Cliente clienteCopiado = new Cliente();

        clienteCopiado.setId(cliente.getId());
        clienteCopiado.setEdicao(cliente.getEdicao());
        clienteCopiado.setVolume(cliente.getVolume());
        clienteCopiado.setEditora(cliente.getEditora());
        clienteCopiado.setTitulo(cliente.getTitulo());
        clienteCopiado.setAutor(cliente.getAutor());

        listAssunto = new ArrayList<>();
        assuntos = (String[]) cliente.getAssunto().toArray();
        listAssunto.addAll(Arrays.asList(assuntos));
        clienteCopiado.setAssunto(listAssunto);

        clienteCopiado.setDataDeLancamento(cliente.getDataDeLancamento());
        clienteCopiado.setQuantidadeDeTotalDeExemplares(cliente.getQuantidadeDeTotalDeExemplares());
        clienteCopiado.setQuantidadeDeExemplaresEmprestados(cliente.getQuantidadeDeExemplaresEmprestados());
        clienteCopiado.setEstadoLivro(cliente.getEstadoLivro());

        return clienteCopiado;
    }

public void alterar(Cliente cliente, List<String> params, List<String> keys) throws ServicoException{     
    //String idLivro = livro.getId();
    Cliente clienteAlterado = this.copia(livro);

    if(params.size() != keys.size()) 
        throw new ServicoException("Quantidade de chaves não confere com a quantidade de parâmetros!");

    int cont = 0;
    for(String param : params) {
        clienteAlterado = this.alterarSemSalvar(clienteAlterado, param, keys.get(cont++));
    }

    this.clienteDAO.alterarLivro(cliente.getId(), clienteAlterado);
}

public void alterar(Livro livro, String param, String key) throws ServicoException{
    Livro livroAlterado = this.copia(livro);
    ArrayList<String> listAssunto;
    String[] assuntos;

    switch(param){
        case "ID":
            livroAlterado.setId(key);
            break;
        case "Edicao":
            livroAlterado.setEdicao(key);
            break;
        case "Volume":
            try {
                Integer it = new Integer(key);
                livroAlterado.setVolume(it);                    
            }
            catch(NumberFormatException ex){
                throw new ServicoException("Volume inválido!");
            }
            break;                
        case "Editora":
            livroAlterado.setEditora(key);
            break;
        case "Titulo":
            livroAlterado.setTitulo(key);
            break;
        case "Autor":
            livroAlterado.setAutor(key);
            break;
        case "Assunto":
            listAssunto = new ArrayList<>();
            assuntos = key.split(",");
            listAssunto.addAll(Arrays.asList(assuntos));
            livroAlterado.setAssunto(listAssunto);
            break;
        case "DataDeLancamento":
            livroAlterado.setDataDeLancamento(key);
            break;
        case "QuantidadeTotalDeExemplares":
            try {
                Integer it = new Integer(key);
                livroAlterado.setQuantidadeDeTotalDeExemplares(it);                   
            }
            catch(NumberFormatException ex){
                throw new ServicoException("Quantidade total de exemplares inválida!");
            }
            break;
        case "QuantidadeDeExemplaresEmprestados":
            try {
                Integer it = new Integer(key);
                livroAlterado.setQuantidadeDeExemplaresEmprestados(it);
            }
            catch(NumberFormatException ex){
                throw new ServicoException("Quantidade de exemplares emprestados inválida!");
            }
            break;
        case "EstadoLivro":
            if("DISPONIVEL".toLowerCase().contains(key.toLowerCase())){
                if(livro.getQuantidadeDeTotalDeExemplares() > livro.getQuantidadeDeExemplaresEmprestados())
                    livroAlterado.setEstadoLivro(Livro.EstadoLivro.DISPONIVEL);
                else
                    throw new ServicoException("Estado do livro não permitido!");
            }
            else if("ALUGADO".toLowerCase().contains(key.toLowerCase())){
                if(livro.getQuantidadeDeTotalDeExemplares() == livro.getQuantidadeDeExemplaresEmprestados())
                    livroAlterado.setEstadoLivro(Livro.EstadoLivro.ALUGADO);
                else
                    throw new ServicoException("Estado do livro não permitido!");
            }
            else if("BLOQUEADO_TEMPORARIAMENTE".toLowerCase().contains(key.toLowerCase()))
                livroAlterado.setEstadoLivro(Livro.EstadoLivro.BLOQUEADO_TEMPORARIAMENTE);

            else if("BLOQUEADO_PERMANENTEMENTE".toLowerCase().contains(key.toLowerCase()))
                livroAlterado.setEstadoLivro(Livro.EstadoLivro.BLOQUEADO_PERMANENTEMENTE);

            else{
                throw new ServicoException("Estado do livro inválido!");
            }
            break;
        default:

    }        
    this.livroDAO.alterarLivro(livro.getId(), livroAlterado);
}

private Livro alterarSemSalvar(Livro livro, String param, String key) throws ServicoException{
    Livro livroAlterado = this.copia(livro);
    ArrayList<String> listAssunto;
    String[] assuntos;

    switch(param){
        case "ID":
            livroAlterado.setId(key);
            break;
        case "Edicao":
            livroAlterado.setEdicao(key);
            break;
        case "Volume":
            try {
                Integer it = new Integer(key);
                livroAlterado.setVolume(it);                    
            }
            catch(NumberFormatException ex){
                throw new ServicoException("Volume inválido!");
            }
            break;                
        case "Editora":
            livroAlterado.setEditora(key);
            break;
        case "Titulo":
            livroAlterado.setTitulo(key);
            break;
        case "Autor":
            livroAlterado.setAutor(key);
            break;
        case "Assunto":
            listAssunto = new ArrayList<>();
            assuntos = key.split(",");
            listAssunto.addAll(Arrays.asList(assuntos));
            livroAlterado.setAssunto(listAssunto);
            break;
        case "DataDeLancamento":
            livroAlterado.setDataDeLancamento(key);
            break;
        case "QuantidadeTotalDeExemplares":
            try {
                Integer it = new Integer(key);
                livroAlterado.setQuantidadeDeTotalDeExemplares(it);                   
            }
            catch(NumberFormatException ex){
                throw new ServicoException("Quantidade total de exemplares inválida!");
            }
            break;
        case "QuantidadeDeExemplaresEmprestados":
            try {
                Integer it = new Integer(key);
                livroAlterado.setQuantidadeDeExemplaresEmprestados(it);
            }
            catch(NumberFormatException ex){
                throw new ServicoException("Quantidade de exemplares emprestados inválida!");
            }
            break;
        case "EstadoLivro":
            if("DISPONIVEL".toLowerCase().contains(key.toLowerCase())){
                if(livro.getQuantidadeDeTotalDeExemplares() > livro.getQuantidadeDeExemplaresEmprestados())
                    livroAlterado.setEstadoLivro(Livro.EstadoLivro.DISPONIVEL);
                else
                    throw new ServicoException("Estado do livro não permitido!");
            }
            else if("ALUGADO".toLowerCase().contains(key.toLowerCase())){
                if(livro.getQuantidadeDeTotalDeExemplares() == livro.getQuantidadeDeExemplaresEmprestados())
                    livroAlterado.setEstadoLivro(Livro.EstadoLivro.ALUGADO);
                else
                    throw new ServicoException("Estado do livro não permitido!");
            }
            else if("BLOQUEADO_TEMPORARIAMENTE".toLowerCase().contains(key.toLowerCase()))
                livroAlterado.setEstadoLivro(Livro.EstadoLivro.BLOQUEADO_TEMPORARIAMENTE);

            else if("BLOQUEADO_PERMANENTEMENTE".toLowerCase().contains(key.toLowerCase()))
                livroAlterado.setEstadoLivro(Livro.EstadoLivro.BLOQUEADO_PERMANENTEMENTE);

            else{
                throw new ServicoException("Estado do livro inválido!");
            }
            break;
        default:

    }
    return livroAlterado;
}

    @Override
    public Usuario autenticacao(String login, String senha) throws ServicoException {
        return this.clienteDAOArquivo.autenticacao(login, senha);
    }

    @Override
    public void consulta(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(String id, Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
