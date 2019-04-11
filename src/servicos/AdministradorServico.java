/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.AdministradorDAOArquivo;
import dados.ServicoException;
import dados.UsuarioDAOFactory;
import java.util.List;

/**
 * Implementa as regras de negócio de Administrador
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton Nunes Junior
 * @author Thiago da Costa Monteiro
 */
public class AdministradorServico extends FuncionarioServico{
    
    private static AdministradorDAOArquivo administradorDAOArquivo;
    private static LivroServico livroServico;
    
    /**
     * Construtor padrão
     * @throws dados.ServicoException
     */
    public AdministradorServico() throws ServicoException{
        super();
        AdministradorServico.livroServico = LivroServico.getInstance();
        AdministradorServico.administradorDAOArquivo = (AdministradorDAOArquivo) UsuarioDAOFactory.getIUsuarioDAO("AdministradorDAOArquivo");
    }
  

    /**
     * Bloqueia permanentemente o funcionário
     * @param funcionario Funcionário a ser bloqueado permanentemente
     * @throws ServicoException 
     */
    public void bloqueioPermanenteDeFuncionario(Funcionario funcionario) throws ServicoException{
        if ( funcionario instanceof Administrador ){
            Administrador administradorAlterado = this.copia((Administrador) funcionario);
            administradorAlterado.setEstadoUsuario(
                            Usuario.EstadoUsuario.BLOQUEADO_PERMANENTEMENTE);
            
            AdministradorServico.administradorDAOArquivo.alterar(
                            administradorAlterado.getLogin(), administradorAlterado);
        }
        
        if ( funcionario instanceof Operador ){
            Operador operadorAlterado = FuncionarioServico.getOperadorServico().copia((Operador) funcionario);
            operadorAlterado.setEstadoUsuario(
                            Usuario.EstadoUsuario.BLOQUEADO_PERMANENTEMENTE);
            
            FuncionarioServico.getOperadorServico().alterar(operadorAlterado.getLogin(), 
                                                            operadorAlterado, 
                                                            "EstadoOperador", 
                                                            "BLOQUEADO_PERMANENTEMENTE");
            
        }
    }
    
    /**
     * Bloqueia temporariamente o funcionário
     * @param funcionario Funcionário a ser bloqueado temporariamente
     * @throws ServicoException 
     */
    public void bloqueioTemporarioDeFuncionario(Funcionario funcionario) throws ServicoException{
       
        if ( funcionario instanceof Administrador ){
            Administrador administradorAlterado = this.copia((Administrador) funcionario);
            administradorAlterado.setEstadoUsuario(
                            Usuario.EstadoUsuario.BLOQUEADO_TEMPORARIAMENTE);
            
            AdministradorServico.administradorDAOArquivo.alterar(
                            administradorAlterado.getLogin(), administradorAlterado);
        }
        
        if ( funcionario instanceof Operador ){
            Operador operadorAlterado = FuncionarioServico.getOperadorServico().copia((Operador) funcionario);
            operadorAlterado.setEstadoUsuario(
                            Usuario.EstadoUsuario.BLOQUEADO_TEMPORARIAMENTE);
            
            FuncionarioServico.getOperadorServico().alterar(operadorAlterado.getLogin(), 
                                                            operadorAlterado, 
                                                            "EstadoOperador", 
                                                            "BLOQUEADO_TEMPORARIAMENTE");
            
        }
        
}

    @Override
    public Usuario autenticacao(String login, String senha) throws ServicoException {
        return AdministradorServico.administradorDAOArquivo.autenticacao(login, senha);
    }

    @Override
    public Object consulta(Object objeto) throws ServicoException {
        
        if(objeto instanceof Livro){
            return FuncionarioServico.getLivroServico().consultaLivro( ( (Livro) objeto).getId() );
        }
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            return this.consultarCliente( cliente.getLogin() );
        }
        if(objeto instanceof Operador){
            return OperadorServico.getOperadorServico().consulta(objeto);
        }
        if(objeto instanceof Administrador){
            return AdministradorServico.administradorDAOArquivo.consultar(
                                    ( (Administrador) objeto ).getLogin() 
                                                                         );
        }
                
        else throw new ServicoException("Objeto passado inválido!");    
        
    }

    @Override
    public Object consultaLista(Object objeto, List<String> params, List<String> keys) throws ServicoException {
        if(objeto instanceof Livro){
            return FuncionarioServico.getLivroServico().consultaLivros(params, keys);
        }
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            return this.consultaClienteLista(cliente, params, keys);
        }
        if(objeto instanceof Operador){
            return OperadorServico.getOperadorServico().consultaLivroLista(params, keys);
        }
        if(objeto instanceof Administrador){
            return AdministradorServico.administradorDAOArquivo.consultaFuncionarios(params, keys);
        }
                
        else throw new ServicoException("Objeto passado inválido!");    
    }

    @Override
    public Object consultaLista(Object objeto, String param, String key) throws ServicoException {
        
        if(objeto instanceof Livro){
            return FuncionarioServico.getLivroServico().consultaLivros(param, key);
        }
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            return this.consultaClienteLista(cliente, param, key);
        }
        if(objeto instanceof Operador){
            return OperadorServico.getOperadorServico().consultaLivroLista(param, key);
        }
        if(objeto instanceof Administrador){
            return AdministradorServico.administradorDAOArquivo.consultaFuncionarios(param, key);
        }
                
        else throw new ServicoException("Objeto passado inválido!");    
    }

    @Override
    public void registrar(Object objeto) throws ServicoException {
        
        if(objeto instanceof Livro){
            this.registrarLivro((Livro) objeto);
        }
        
        if(objeto instanceof Cliente){
            FuncionarioServico.getClienteServico().registrar(objeto);
        }
                       
        if(objeto instanceof Administrador){
            Administrador administrador = (Administrador) objeto;
            AdministradorServico.administradorDAOArquivo.registrar(administrador);
        }
        
        if(objeto instanceof Operador){
            Operador operador = (Operador) objeto;
            FuncionarioServico.getOperadorServico().registrar(operador);
        }
        else throw new ServicoException("Objeto passado inválido!");   
    
    }

    @Override
    public void alterar(String id, Object objeto, String param, String key) throws ServicoException {
        
        if(objeto instanceof Livro){
            FuncionarioServico.getLivroServico().alterar( (Livro)objeto, param, key);
        }
        
        if(objeto instanceof Cliente){
            FuncionarioServico.getClienteServico().alterar(id, objeto,param, key);
        }
        
        if(objeto instanceof Operador){
            OperadorServico.getOperadorServico().alterar(id, objeto,param, key);
        }
        
        if(objeto instanceof Administrador){
            Administrador administradorAlterado = this.copia((Administrador) objeto);
            if(!id.equals(administradorAlterado.getLogin())) throw new ServicoException("Login do cliente(id) passado inválido!");
            
            switch(param){
                case "Login":
                    administradorAlterado.setLogin(key);                    
                    break;
                case "Senha":
                    administradorAlterado.setSenha(key);
                case "Nome":
                    administradorAlterado.setNome(key);
                    break;
                case "Telefone":
                    administradorAlterado.setTelefone(key); // fazer verificações de validade no futuro distante!
                case "Idade": 
                    Integer idade = Integer.getInteger(key);
                    if(idade == null) throw new ServicoException("Valor da idade invalida!");
                    administradorAlterado.setIdade(idade);
                    break;
                case "Genero":
                    if("MASCULINO".toLowerCase().contains(key.toLowerCase()))                        
                        administradorAlterado.setGenero(Usuario.Genero.MASCULINO);                    
                    else if("FEMININO".toLowerCase().contains(key.toLowerCase()))
                        administradorAlterado.setGenero(Usuario.Genero.FEMININO);
                    else
                        throw new ServicoException("Valor do gênero invalido!");
                    break;
                case "Salario":
                    Float salario = Float.valueOf(key);
                    if(salario == null) throw new ServicoException("Valor do salario invalida!");
                    administradorAlterado.setSalario(salario);                
                case "EstadoOperador":                    
                    if("DISPONIVEL".toLowerCase().contains(key.toLowerCase()))
                        administradorAlterado.setEstadoUsuario(Usuario.EstadoUsuario.DISPONIVEL);                    
                    else if("BLOQUEADO_TEMPORARIAMENTE".toLowerCase().contains(key.toLowerCase()))
                        administradorAlterado.setEstadoUsuario(Usuario.EstadoUsuario.BLOQUEADO_TEMPORARIAMENTE);
                    else if("BLOQUEADO_PERMANENTEMENTE".toLowerCase().contains(key.toLowerCase()))
                        administradorAlterado.setEstadoUsuario(Usuario.EstadoUsuario.BLOQUEADO_PERMANENTEMENTE);
                    else{
                        throw new ServicoException("Estado do usuário inválido!");
                    }
                    break;
                default:
                    throw new ServicoException("O parâmetro" + key +  " é invalido!");
            }          
            AdministradorServico.administradorDAOArquivo.alterar(id ,administradorAlterado);
        }        
        else throw new ServicoException("Objeto passado inválido!");}

    @Override
    public void excluir(Object objeto) throws ServicoException {
        
        if(objeto instanceof Livro){
            Livro livro = (Livro) objeto;
            AdministradorServico.getLivroServico().excluirLivro(livro);
        }
        
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            FuncionarioServico.getClienteServico().excluir(cliente);
        }
               
        
        if(objeto instanceof Administrador){
            Administrador administrador = (Administrador) objeto;
            AdministradorServico.administradorDAOArquivo.excluir(administrador);
        }
        
        if(objeto instanceof Operador){
            Operador operador = (Operador) objeto;
            FuncionarioServico.getOperadorServico().excluir(operador);
        }
        else throw new ServicoException("Objeto passado inválido!");
    }
    
    private Administrador copia(Administrador administrador) throws ServicoException {
        Administrador administradorCopiado = new Administrador();

        administradorCopiado.setLogin(administrador.getLogin());        
        administradorCopiado.setIdade(administrador.getIdade());
        administradorCopiado.setNome(administrador.getNome());
        administradorCopiado.setSenha(administrador.getSenha());
        administradorCopiado.setTelefone(administrador.getTelefone());
        administradorCopiado.setGenero(administrador.getGenero());
        administradorCopiado.setSalario(administrador.getSalario());
        administradorCopiado.setHMapRankingUsuario(administrador.getHMapRankingUsuario());
        
        return administradorCopiado;
    }

}
