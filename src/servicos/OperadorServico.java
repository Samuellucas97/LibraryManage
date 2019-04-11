   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.OperadorDAOArquivo;
import dados.ServicoException;
import dados.UsuarioDAOFactory;
import java.util.List;

/**
 * Implementa as regras de negócio relativas ao operador
 * @author Samuel Lucas de Moura Ferino
 * @author José Wellinton 
 */
public class OperadorServico extends FuncionarioServico{
  
    private static OperadorDAOArquivo operadorDAOArquivo;
    private static LivroServico livroServico;

    /**
     * Construtor da classe IOperadorServico
     * @throws dados.ServicoException
     */
    public OperadorServico() throws ServicoException {
        FuncionarioServico.Inicializar();
        OperadorServico.operadorDAOArquivo = (OperadorDAOArquivo) 
                UsuarioDAOFactory.getIUsuarioDAO("OperadorDAOArquivo");
        OperadorServico.livroServico = LivroServico.getInstance();
    }
    
    /**
     * Efetua a devolução de um livro
     * @param livro Livro a ser devolvido
     * @throws ServicoException 
     */    
    public void efetuarDevolucaoDeLivro(Livro livro) throws ServicoException{
        OperadorServico.livroServico.efetuarDevolucaoDeLivro(livro);
    }
    /**
     * Efetua o empréstimo de um livro
     * @param livro Livro a ser emprestado
     * @throws ServicoException 
     */
    public void emprestimoDeLivro(Livro livro) throws ServicoException{
        OperadorServico.livroServico.efetuarEmprestimoDeLivro(livro);
    }    

    @Override
    public Usuario autenticacao(String login, String senha) throws ServicoException {
        return OperadorServico.operadorDAOArquivo.autenticacao(login, senha);
    }

    @Override
    public Object consulta(Object objeto) throws ServicoException {
        if(objeto instanceof Livro){
            Livro livro = (Livro) objeto;
            return this.consultarLivro(livro.getId());
        }
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            return this.consultarCliente(cliente.getLogin());
        }
        else throw new ServicoException("Objeto passado inválido!");
    }

    @Override
    public Object consultaLista(Object objeto, List<String> params, List<String> keys) throws ServicoException {
        if(objeto instanceof Livro){
            Livro livro = (Livro) objeto;
            return this.consultaLivroLista(params, keys);
        }
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            return this.consultaClienteLista(cliente, params, keys);
        }
        if(objeto instanceof Operador){
            Operador operador = (Operador) objeto;
            return OperadorServico.operadorDAOArquivo.consultaUsuarios(params, keys);
        }
        else throw new ServicoException("Objeto passado inválido!");
    }

    @Override
    public Object consultaLista(Object objeto, String param, String key) throws ServicoException {
        if(objeto instanceof Livro){
            Livro livro = (Livro) objeto;
            return this.consultaLivroLista(param, key);
        }
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            return this.consultaClienteLista(cliente, param, key);
        }
        if(objeto instanceof Operador){
            Operador operador = (Operador) objeto;
            return OperadorServico.operadorDAOArquivo.consultaUsuarios(param, key);
        }
        else throw new ServicoException("Objeto passado inválido!");
    }
    

    @Override
    public void registrar(Object objeto) throws ServicoException {
        if(objeto instanceof Livro){
            Livro livro = (Livro) objeto;
            this.registrarLivro(livro);
        }
        if(objeto instanceof Cliente){
            Cliente cliente = (Cliente) objeto;
            FuncionarioServico.getClienteServico().registrar(cliente);
        }
        if(objeto instanceof Operador){
            Operador operador = (Operador) objeto;
            OperadorServico.operadorDAOArquivo.registrar(operador);
        }        
        else throw new ServicoException("Objeto passado inválido!"); 
    }
    
    @Override
    public void alterar(String id, Object objeto, String param, String key) throws ServicoException {
        if(objeto instanceof Operador){
            Operador operadorAlterado = this.copia((Operador) objeto);
            if(!id.equals(operadorAlterado.getLogin())) throw new ServicoException("Login do cliente(id) passado inválido!");
            
            switch(param){
                case "Login":
                    operadorAlterado.setLogin(key);                    
                    break;
                case "Senha":
                    operadorAlterado.setSenha(key);
                case "Nome":
                    operadorAlterado.setNome(key);
                    break;
                case "Telefone":
                    operadorAlterado.setTelefone(key); // fazer verificações de validade no futuro distante!
                case "Idade": 
                    Integer idade = Integer.getInteger(key);
                    if(idade == null) throw new ServicoException("Valor da idade invalida!");
                    operadorAlterado.setIdade(idade);
                    break;
                case "Genero":
                    if("MASCULINO".toLowerCase().contains(key.toLowerCase()))                        
                        operadorAlterado.setGenero(Usuario.Genero.MASCULINO);                    
                    else if("FEMININO".toLowerCase().contains(key.toLowerCase()))
                        operadorAlterado.setGenero(Usuario.Genero.FEMININO);
                    else
                        throw new ServicoException("Valor do gênero invalido!");
                    break;
                case "Salario":
                    Float salario = Float.valueOf(key);
                    if(salario == null) throw new ServicoException("Valor do salario invalida!");
                    operadorAlterado.setSalario(salario);                
                case "EstadoOperador":                    
                    if("DISPONIVEL".toLowerCase().contains(key.toLowerCase()))
                        operadorAlterado.setEstadoUsuario(Usuario.EstadoUsuario.DISPONIVEL);                    
                    else if("BLOQUEADO_TEMPORARIAMENTE".toLowerCase().contains(key.toLowerCase()))
                        operadorAlterado.setEstadoUsuario(Usuario.EstadoUsuario.BLOQUEADO_TEMPORARIAMENTE);
                    else if("BLOQUEADO_PERMANENTEMENTE".toLowerCase().contains(key.toLowerCase()))
                        operadorAlterado.setEstadoUsuario(Usuario.EstadoUsuario.BLOQUEADO_PERMANENTEMENTE);
                    else{
                        throw new ServicoException("Estado do usuário inválido!");
                    }
                    break;
                default:
                    throw new ServicoException("O parâmetro" + key +  " é invalido!");
            }          
            OperadorServico.operadorDAOArquivo.alterar(id ,operadorAlterado);
        }        
        else throw new ServicoException("Objeto passado inválido!"); 
    }    

    @Override
    public void excluir(Object objeto) throws ServicoException {
        if(objeto instanceof Operador){
            Operador operador = (Operador) objeto;
            OperadorServico.operadorDAOArquivo.excluir(operador);
        }
        else throw new ServicoException("Objeto passado inválido!");
    }

    private Operador copia(Operador operador) throws ServicoException {
        Operador operadorCopiado = new Operador();

        operadorCopiado.setLogin(operador.getLogin());        
        operadorCopiado.setIdade(operador.getIdade());
        operadorCopiado.setNome(operador.getNome());
        operadorCopiado.setSenha(operador.getSenha());
        operadorCopiado.setTelefone(operador.getTelefone());
        operadorCopiado.setGenero(operador.getGenero());
        operadorCopiado.setSalario(operador.getSalario());
        operadorCopiado.setHMapRankingUsuario(operador.getHMapRankingUsuario());
        
        return operadorCopiado;
    }
    
}
