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
import java.util.HashMap;
import java.util.List;
import servicos.Usuario.Genero;

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
            ClienteServico.clienteDAOArquivo = (ClienteDAOArquivo) UsuarioDAOFactory.getIUsuarioDAO("ClienteDAOArquivo");
    }
    
    /**
     * Insere ranking no livro
     * @param idLivro identificador do livro;
     * @param ranking
     * @param cliente 
     * @throws dados.ServicoException 
     */
    public void inserirRankingLivro(String idLivro, int ranking, Cliente cliente) throws ServicoException{
        if(ranking < 0 || ranking > 5) 
            throw new ServicoException("Ranking para livro inválido!");
        
        Cliente clienteAlterado = this.copia(cliente);
        HashMap<String, ArrayList<Boolean> > rankingLivros = clienteAlterado.getHMapId_RankingLivros();
        
        if(!rankingLivros.containsKey(idLivro)) 
            throw new ServicoException("Livro não registrado no catalogo de emprestimos!");

        ArrayList<Boolean> rankingLivro = rankingLivros.get(idLivro);
        
        for(int i = 0; i < ranking; i++){
            rankingLivro.set(i, true);
        }
                
        ClienteServico.clienteDAOArquivo.alterar(cliente.getLogin(), clienteAlterado);                       
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
                        Usuario.Genero genero ) throws ServicoException{
    
        Cliente cliente = new Cliente();
        
        cliente.setLogin(login);
        cliente.setSenha(senha);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setIdade(idade);
        cliente.setGenero(genero);
        
        ClienteServico.clienteDAOArquivo.registrar(cliente );            
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
     * @throws dados.ServicoException
     */
    public void bloqueioPermanenteDeCliente(Cliente cliente) throws ServicoException {
        this.alterar(cliente.getLogin(), cliente, "EstadoCliente", "BLOQUEADO_PERMANENTEMENTE");
    }

    /**
     * Bloqueia cliente temporariamente
     * @param cliente Cliente a ser bloqueado temporariamente
     * @throws dados.ServicoException
     */
    public void bloqueioTemporarioDeCliente(Cliente cliente) throws ServicoException {
        this.alterar(cliente.getLogin(),cliente, "EstadoCliente", "BLOQUEADO_TEMPORARIAMENTE");
    }
    
    /**
     * Bloqueia cliente temporariamente
     * @param cliente Cliente a ser bloqueado temporariamente
     * @throws dados.ServicoException
     */
    public void desbloqueioDeCliente(Cliente cliente) throws ServicoException {
        this.alterar(cliente.getLogin(),cliente, "EstadoCliente", "DISPONIVEL");
    }

    public void avaliarLivro(int notaLivro) throws ServicoException {
        
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
        Cliente clienteCopiado = new Cliente();

        clienteCopiado.setLogin(cliente.getLogin());        
        clienteCopiado.setIdade(cliente.getIdade());
        clienteCopiado.setNome(cliente.getNome());
        clienteCopiado.setSenha(cliente.getSenha());
        clienteCopiado.setTelefone(cliente.getTelefone());
        clienteCopiado.setGenero(cliente.getGenero());
        clienteCopiado.setNumeroDevolucoes(cliente.getNumeroDevolucoes());
        clienteCopiado.setNumeroEmprestimos(cliente.getNumeroEmprestimos());
        clienteCopiado.setRankingCliente(cliente.getRankingCliente());
        clienteCopiado.setHMapId_DataDeEmprestimoLivros(cliente.getHMapId_DataDeEmprestimoLivros());
        clienteCopiado.setHMapId_RankingLivros(cliente.getHMapId_RankingLivros());
        clienteCopiado.setLivrosAlugados(cliente.getLivrosAlugados());      
        
        return clienteCopiado;
    }

//public void alterar(Cliente cliente, List<String> params, List<String> keys) throws ServicoException{     
//    //String idLivro = livro.getId();
//    Cliente clienteAlterado = this.copia(livro);
//
//    if(params.size() != keys.size()) 
//        throw new ServicoException("Quantidade de chaves não confere com a quantidade de parâmetros!");
//
//    int cont = 0;
//    for(String param : params) {
//        clienteAlterado = this.alterarSemSalvar(clienteAlterado, param, keys.get(cont++));
//    }
//
//    this.clienteDAO.alterarLivro(cliente.getId(), clienteAlterado);
//}

//public void alterar(Livro livro, String param, String key) throws ServicoException{
//    Livro livroAlterado = this.copia(livro);
//    ArrayList<String> listAssunto;
//    String[] assuntos;
//
//    switch(param){
//        case "ID":
//            livroAlterado.setId(key);
//            break;
//        case "Edicao":
//            livroAlterado.setEdicao(key);
//            break;
//        case "Volume":
//            try {
//                Integer it = new Integer(key);
//                livroAlterado.setVolume(it);                    
//            }
//            catch(NumberFormatException ex){
//                throw new ServicoException("Volume inválido!");
//            }
//            break;                
//        case "Editora":
//            livroAlterado.setEditora(key);
//            break;
//        case "Titulo":
//            livroAlterado.setTitulo(key);
//            break;
//        case "Autor":
//            livroAlterado.setAutor(key);
//            break;
//        case "Assunto":
//            listAssunto = new ArrayList<>();
//            assuntos = key.split(",");
//            listAssunto.addAll(Arrays.asList(assuntos));
//            livroAlterado.setAssunto(listAssunto);
//            break;
//        case "DataDeLancamento":
//            livroAlterado.setDataDeLancamento(key);
//            break;
//        case "QuantidadeTotalDeExemplares":
//            try {
//                Integer it = new Integer(key);
//                livroAlterado.setQuantidadeDeTotalDeExemplares(it);                   
//            }
//            catch(NumberFormatException ex){
//                throw new ServicoException("Quantidade total de exemplares inválida!");
//            }
//            break;
//        case "QuantidadeDeExemplaresEmprestados":
//            try {
//                Integer it = new Integer(key);
//                livroAlterado.setQuantidadeDeExemplaresEmprestados(it);
//            }
//            catch(NumberFormatException ex){
//                throw new ServicoException("Quantidade de exemplares emprestados inválida!");
//            }
//            break;
//        case "EstadoLivro":
//            if("DISPONIVEL".toLowerCase().contains(key.toLowerCase())){
//                if(livro.getQuantidadeDeTotalDeExemplares() > livro.getQuantidadeDeExemplaresEmprestados())
//                    livroAlterado.setEstadoLivro(Livro.EstadoLivro.DISPONIVEL);
//                else
//                    throw new ServicoException("Estado do livro não permitido!");
//            }
//            else if("ALUGADO".toLowerCase().contains(key.toLowerCase())){
//                if(livro.getQuantidadeDeTotalDeExemplares() == livro.getQuantidadeDeExemplaresEmprestados())
//                    livroAlterado.setEstadoLivro(Livro.EstadoLivro.ALUGADO);
//                else
//                    throw new ServicoException("Estado do livro não permitido!");
//            }
//            else if("BLOQUEADO_TEMPORARIAMENTE".toLowerCase().contains(key.toLowerCase()))
//                livroAlterado.setEstadoLivro(Livro.EstadoLivro.BLOQUEADO_TEMPORARIAMENTE);
//
//            else if("BLOQUEADO_PERMANENTEMENTE".toLowerCase().contains(key.toLowerCase()))
//                livroAlterado.setEstadoLivro(Livro.EstadoLivro.BLOQUEADO_PERMANENTEMENTE);
//
//            else{
//                throw new ServicoException("Estado do livro inválido!");
//            }
//            break;
//        default:
//
//    }        
//    this.livroDAO.alterarLivro(livro.getId(), livroAlterado);
//}

//private Livro alterarSemSalvar(Livro livro, String param, String key) throws ServicoException{
//    Livro livroAlterado = this.copia(livro);
//    ArrayList<String> listAssunto;
//    String[] assuntos;
//
//    switch(param){
//        case "ID":
//            livroAlterado.setId(key);
//            break;
//        case "Edicao":
//            livroAlterado.setEdicao(key);
//            break;
//        case "Volume":
//            try {
//                Integer it = new Integer(key);
//                livroAlterado.setVolume(it);                    
//            }
//            catch(NumberFormatException ex){
//                throw new ServicoException("Volume inválido!");
//            }
//            break;                
//        case "Editora":
//            livroAlterado.setEditora(key);
//            break;
//        case "Titulo":
//            livroAlterado.setTitulo(key);
//            break;
//        case "Autor":
//            livroAlterado.setAutor(key);
//            break;
//        case "Assunto":
//            listAssunto = new ArrayList<>();
//            assuntos = key.split(",");
//            listAssunto.addAll(Arrays.asList(assuntos));
//            livroAlterado.setAssunto(listAssunto);
//            break;
//        case "DataDeLancamento":
//            livroAlterado.setDataDeLancamento(key);
//            break;
//        case "QuantidadeTotalDeExemplares":
//            try {
//                Integer it = new Integer(key);
//                livroAlterado.setQuantidadeDeTotalDeExemplares(it);                   
//            }
//            catch(NumberFormatException ex){
//                throw new ServicoException("Quantidade total de exemplares inválida!");
//            }
//            break;
//        case "QuantidadeDeExemplaresEmprestados":
//            try {
//                Integer it = new Integer(key);
//                livroAlterado.setQuantidadeDeExemplaresEmprestados(it);
//            }
//            catch(NumberFormatException ex){
//                throw new ServicoException("Quantidade de exemplares emprestados inválida!");
//            }
//            break;
//        case "EstadoLivro":
//            if("DISPONIVEL".toLowerCase().contains(key.toLowerCase())){
//                if(livro.getQuantidadeDeTotalDeExemplares() > livro.getQuantidadeDeExemplaresEmprestados())
//                    livroAlterado.setEstadoLivro(Livro.EstadoLivro.DISPONIVEL);
//                else
//                    throw new ServicoException("Estado do livro não permitido!");
//            }
//            else if("ALUGADO".toLowerCase().contains(key.toLowerCase())){
//                if(livro.getQuantidadeDeTotalDeExemplares() == livro.getQuantidadeDeExemplaresEmprestados())
//                    livroAlterado.setEstadoLivro(Livro.EstadoLivro.ALUGADO);
//                else
//                    throw new ServicoException("Estado do livro não permitido!");
//            }
//            else if("BLOQUEADO_TEMPORARIAMENTE".toLowerCase().contains(key.toLowerCase()))
//                livroAlterado.setEstadoLivro(Livro.EstadoLivro.BLOQUEADO_TEMPORARIAMENTE);
//
//            else if("BLOQUEADO_PERMANENTEMENTE".toLowerCase().contains(key.toLowerCase()))
//                livroAlterado.setEstadoLivro(Livro.EstadoLivro.BLOQUEADO_PERMANENTEMENTE);
//
//            else{
//                throw new ServicoException("Estado do livro inválido!");
//            }
//            break;
//        default:
//
//    }
//    return livroAlterado;
//}

    @Override
    public Usuario autenticacao(String login, String senha) throws ServicoException {
        return ClienteServico.clienteDAOArquivo.autenticacao(login, senha);
    }
    
    @Override
    public Object consultaLista(Object objeto, String param, String key) throws ServicoException{
        if(objeto instanceof Livro){
            Livro livro = (Livro) objeto;
            return ClienteServico.clienteDAOArquivo.consultaLivros(param, key);
        }
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            return ClienteServico.clienteDAOArquivo.consultaUsuarios(param, key);
        }
        else throw new ServicoException("Objeto passado inválido!"); 
    }    
    
    @Override
    public Object consultaLista(Object objeto, List<String> params, List<String> keys) throws ServicoException{
        if(objeto instanceof Livro){
            Livro livro = (Livro) objeto;
            return ClienteServico.clienteDAOArquivo.consultaLivros(params, keys);
        }
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            return ClienteServico.clienteDAOArquivo.consultaUsuarios(params, keys);
        }
        else throw new ServicoException("Objeto passado inválido!");        
    }

    @Override
    public Object consulta(Object objeto) throws ServicoException{
        if(objeto instanceof Livro){
            Livro livro = (Livro) objeto;
            return ClienteServico.clienteDAOArquivo.consultaLivro(livro.getId());
        }
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            return ClienteServico.clienteDAOArquivo.consultar(cliente.getLogin());
        }
        else throw new ServicoException("Objeto passado inválido!"); 
    }

    @Override
    public void registrar(Object objeto) throws ServicoException{       
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            ClienteServico.clienteDAOArquivo.registrar(cliente);
        }
        else throw new ServicoException("Objeto passado inválido!"); 
    }

    @Override
    public void alterar(String id, Object objeto,String param, String key) throws ServicoException{
        if(objeto instanceof Cliente){
            Cliente clienteAlterado = this.copia((Cliente) objeto);
            if(!id.equals(clienteAlterado.getLogin())) throw new ServicoException("Login do cliente(id) passado inválido!");
            
            switch(param){
                case "Login":
                    clienteAlterado.setLogin(key);                    
                    break;
                case "Nome":
                    clienteAlterado.setNome(key);
                    break;
                case "Idade": 
                    Integer idade = Integer.getInteger(key);
                    if(idade == null) throw new ServicoException("Valor da idade invalida!");
                    clienteAlterado.setIdade(idade);
                    break;
                case "Genero":
                    if("MASCULINO".toLowerCase().contains(key.toLowerCase()))                        
                        clienteAlterado.setGenero(Genero.MASCULINO);                    
                    else if("FEMININO".toLowerCase().contains(key.toLowerCase()))
                        clienteAlterado.setGenero(Genero.FEMININO);
                    else
                        throw new ServicoException("Valor do gênero invalido!");
                    break;
                case "NumeroEmprestimos":
                    Integer numeroEmprestimos = Integer.getInteger(key);
                    if(numeroEmprestimos == null) throw new ServicoException("Valor de numero de emprestimos invalido!");
                    clienteAlterado.setNumeroEmprestimos(numeroEmprestimos);
                    break;
                case "NumeroDevolucoes":
                    Integer numeroDevolucoes = Integer.getInteger(key);
                    if(numeroDevolucoes == null) throw new ServicoException("Valor de numero de devoluções invalido!");
                    clienteAlterado.setNumeroDevolucoes(numeroDevolucoes);
                    break;
                case "RankingCliente": 
                    Integer rankingCliente = Integer.getInteger(key);
                    if(rankingCliente == null) throw new ServicoException("Valor do ranking do cliente inválido!");
                    clienteAlterado.setRankingClienteInt(rankingCliente);
                    break;
                case "EstadoCliente":
                    
                    clienteAlterado.set
                    
                default:
                    
            }
            
            ClienteServico.clienteDAOArquivo.alterar(id ,clienteAlterado);
        }
        else throw new ServicoException("Objeto passado inválido!"); 
    }

    @Override
    public void excluir(Object objeto) throws ServicoException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    public List<Livro> consultaLivros(List<String> params, List<String> keys) throws ServicoException{
        return ClienteServico.clienteDAOArquivo.consultaLivros(params, keys);
    }
    
    public List<Livro> consultaLivros(String param, String key) throws ServicoException{
        return ClienteServico.clienteDAOArquivo.consultaLivros(param, key);        
    }
    
}
