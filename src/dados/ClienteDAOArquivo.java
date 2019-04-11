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
import servicos.Cliente;
import servicos.Livro;
import servicos.Usuario;

/**
 *
 * @author José Welliton Nunes Júnior
 */
public class ClienteDAOArquivo extends UsuarioDAOArquivo{
    
    private final String nomeDoArquivo = "Clientes";
    private HashMap<String, Cliente> hMapCliente;   

    public ClienteDAOArquivo() throws ServicoException {
        this.hMapCliente = new HashMap<>();       
        this.lerArquivo(this.nomeDoArquivo);
    }
    
    @Override
    protected void lerArquivo(String nomeDoArquivo) throws ServicoException {
        this.hMapCliente = (HashMap<String, Cliente>) Serializator.unserialize(this.hMapCliente,nomeDoArquivo);
    }

    @Override
    protected boolean salvarArquivo(String nomeArquivo) throws ServicoException {
        Serializator.serialize(this.hMapCliente, nomeArquivo);
        return true;
    }

    @Override
    public Usuario autenticacao(String login, String senha) throws ServicoException {
        if(this.hMapCliente.containsKey(login)){
            Cliente cliente = this.hMapCliente.get(login);
            if(cliente.getSenha().equals(senha)) return cliente;
            else{
                throw new ServicoException("Senha inválida! Tente novamente.");
            }
        }
        else{
            throw new ServicoException("Login inválido! Tente novamente.");
        }
    }

    @Override
    public Usuario consultar(String login) throws ServicoException {
        if(this.hMapCliente.containsKey(login)) return this.hMapCliente.get(login);
        else throw new ServicoException("Cliente não encontrado!");
    }

    @Override
    public List<Usuario> consultaUsuarios(List<String> params, List<String> keys) throws ServicoException {
        List<Usuario> clientes = new ArrayList<>();
        List<List<Usuario> > listClientes = new ArrayList<>();
        
        if(params.size() != keys.size()) throw new ServicoException("Quantidade de chaves não confere com a quantidade de parâmetros!");
        
        int i = 0;
        for(String param : params) listClientes.add(this.consultaUsuarios(param, keys.get(i++)));
                
        Collections.sort(listClientes, (o1, o2) -> {
            if(o1.size() > o2.size()) return -1;
            else if (o1.size() < o2.size()) return 1; 
            return 0;
        });
        
        for(Iterator<List<Usuario>> iterator = listClientes.iterator(); iterator.hasNext();) {
            List<Usuario> next = iterator.next();
            if(clientes.isEmpty()) clientes.addAll(next);
            else{
                List<Usuario> auxClientes = new ArrayList<>();
                auxClientes.addAll(clientes);
                auxClientes.removeAll(next);
                clientes.removeAll(auxClientes);
            }
            if(clientes.isEmpty()) break;
        }
        
        if(clientes.isEmpty()) throw new ServicoException("Nenhum cliente encontrado!");
        
        return clientes;
    }

    @Override
    public List<Usuario> consultaUsuarios(String param, String key) throws ServicoException {
        List<Usuario> clientes = new ArrayList<>();
        
        for (Map.Entry<String, Cliente> cliente : this.hMapCliente.entrySet()) {
            Cliente value = cliente.getValue();
            
            switch(param){
                case "Login":
                    if(value.getLogin().equals(key)) clientes.add(value);                    
                    break;
                case "Nome":
                    if(value.getNome().toLowerCase().contains(key.toLowerCase())) clientes.add(value);
                    break;
                case "Idade":
                    if(String.valueOf(value.getIdade()).equals(key)) clientes.add(value);
                    break;
                case "Genero":
                    if(value.getGenero().toString().toLowerCase().contains(key.toLowerCase())) clientes.add(value);
                    break;
                case "NumeroEmprestimos":
                    if(String.valueOf(value.getNumeroEmprestimos()).equals(key)) clientes.add(value);
                    break;
                case "NumeroDevolucoes":
                    if(String.valueOf(value.getNumeroDevolucoes()).equals(key)) clientes.add(value);
                    break;
                case "RankingCliente": 
                    if(String.valueOf(value.getRankingInt()).equals(key)) clientes.add(value);
                    break;
                case "LivrosAlugados":
                    for(Livro livro: value.getLivrosAlugados()){
                        if(livro.getTitulo().toLowerCase().contains(key.toLowerCase())){
                            clientes.add(value);
                            break;
                        }
                    }                    
                    break;
                default:
                    
            }
            
        }
                
        if(clientes.isEmpty()) throw new ServicoException("Nenhum cliente encontrado!");
        
        return clientes;
    }

    @Override
    public void registrar(Usuario usuario) throws ServicoException {
        if(!this.hMapCliente.containsKey(usuario.getLogin())){
            this.hMapCliente.put(usuario.getLogin(),(Cliente) usuario);
            this.salvarArquivo(this.nomeDoArquivo);
        }              
        else throw new ServicoException("Cliente com esse login já registrado!");
    }

    @Override
    public void alterar(String usuarioLogin, Usuario usuarioAlterado) throws ServicoException {
         if(usuarioLogin.equals(usuarioAlterado.getLogin())){
            this.hMapCliente.remove(usuarioLogin);
            this.hMapCliente.put(usuarioAlterado.getLogin(), (Cliente) usuarioAlterado);
            this.salvarArquivo(this.nomeDoArquivo);
        }
        else{
            if(this.hMapCliente.containsKey(usuarioAlterado.getLogin())){
                throw new ServicoException("A alteração não foi concluida! \n O login escolhido já é utilizado");
            }
            else{
                this.hMapCliente.remove(usuarioLogin);
                this.hMapCliente.put(usuarioAlterado.getLogin(), (Cliente) usuarioAlterado);
                this.salvarArquivo(this.nomeDoArquivo);
            }
        }
    }

    @Override
    public void excluir(Usuario usuario) throws ServicoException {
        boolean verification =  this.hMapCliente.remove(usuario.getLogin(), (Cliente) usuario);
        if(!verification) throw new ServicoException("Esse usuário não existe no registro e não pode ser excluído!");
        
        this.salvarArquivo(this.nomeDoArquivo);
    }
    
    public Livro consultaLivro(String idLivro) throws ServicoException{
        return LivroDAOArquivo.getInstancia().consultaLivro(idLivro);
    }
       
    public List<Livro> consultaLivros(List<String> params, List<String> keys) throws ServicoException{
        return LivroDAOArquivo.getInstancia().consultaLivros(params, keys);
    }
    
    public List<Livro> consultaLivros(String param, String key) throws ServicoException{
        return LivroDAOArquivo.getInstancia().consultaLivros(param, key);
    }
    
}
