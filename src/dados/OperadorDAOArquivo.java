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
import servicos.Operador;
import servicos.Usuario;

/**
 *
 * @author José Welliton Nunes Júnior
 */
public class OperadorDAOArquivo extends UsuarioDAOArquivo {
    
    private final String nomeDoArquivo = "Operadores";
    private HashMap<String, Operador> hMapOperador;

   @Override
    protected void lerArquivo(String nomeDoArquivo) throws ServicoException {
        this.hMapOperador = (HashMap<String, Operador>) Serializator.unserialize(this.hMapOperador,nomeDoArquivo);
    }

    @Override
    protected boolean salvarArquivo(String nomeArquivo) throws ServicoException {
        Serializator.serialize(this.hMapOperador, nomeArquivo);
        return true;
    }

    @Override
    public Usuario autenticacao(String login, String senha) throws ServicoException {
        if(this.hMapOperador.containsKey(login)){
            Operador operador = this.hMapOperador.get(login);
            if(operador.getSenha().equals(senha)) return operador;
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
        if(this.hMapOperador.containsKey(login)) return this.hMapOperador.get(login);
        else throw new ServicoException("Operador não encontrado!");
    }

    @Override
    public List<Usuario> consultaUsuarios(List<String> params, List<String> keys) throws ServicoException {
        List<Usuario> operadores = new ArrayList<>();
        List<List<Usuario> > listOperadores = new ArrayList<>();
        
        if(params.size() != keys.size()) throw new ServicoException("Quantidade de chaves não confere com a quantidade de parâmetros!");
        
        int i = 0;
        for(String param : params) listOperadores.add(this.consultaUsuarios(param, keys.get(i++)));
                
        Collections.sort(listOperadores, (o1, o2) -> {
            if(o1.size() > o2.size()) return -1;
            else if (o1.size() < o2.size()) return 1; 
            return 0;
        });
        
        for(Iterator<List<Usuario>> iterator = listOperadores.iterator(); iterator.hasNext();) {
            List<Usuario> next = iterator.next();
            if(operadores.isEmpty()) operadores.addAll(next);
            else{
                List<Usuario> auxOperadores = new ArrayList<>();
                auxOperadores.addAll(operadores);
                auxOperadores.removeAll(next);
                operadores.removeAll(auxOperadores);
            }
            if(operadores.isEmpty()) break;
        }
        
        if(operadores.isEmpty()) throw new ServicoException("Nenhum cliente encontrado!");
        
        return operadores;
    }

    @Override
    public List<Usuario> consultaUsuarios(String param, String key) throws ServicoException {
        List<Usuario> operadores = new ArrayList<>();
        
        for (Map.Entry<String, Operador> operador : this.hMapOperador.entrySet()) {
            Operador value = operador.getValue();
            
            switch(param){
                case "Login":
                    if(value.getLogin().equals(key)) operadores.add(value);                    
                    break;
                case "Nome":
                    if(value.getNome().toLowerCase().contains(key.toLowerCase())) operadores.add(value);
                    break;
                case "Idade":
                    if(String.valueOf(value.getIdade()).equals(key)) operadores.add(value);
                    break;
                case "Genero":
                    if(value.getGenero().toString().toLowerCase().contains(key.toLowerCase())) operadores.add(value);
                    break;
                case "Salario":
                    if(String.valueOf(value.getSalario()).equals(key)) operadores.add(value);
                    break;
                default:
                    
            }
        }
        if(operadores.isEmpty()) throw new ServicoException("Nenhum Operador encontrado!");
        
        return operadores;
    }
        

    @Override
    public void registrar(Usuario usuario) throws ServicoException {
        if(!this.hMapOperador.containsKey(usuario.getLogin())){
            this.hMapOperador.put(usuario.getLogin(),(Operador) usuario);
            this.salvarArquivo(this.nomeDoArquivo);
        }              
        else throw new ServicoException("Cliente com esse login já registrado!");
    }

    @Override
    public void alterar(String usuarioLogin, Usuario usuarioAlterado) throws ServicoException {
         if(usuarioLogin.equals(usuarioAlterado.getLogin())){
            this.hMapOperador.remove(usuarioLogin);
            this.hMapOperador.put(usuarioAlterado.getLogin(), (Operador) usuarioAlterado);
            this.salvarArquivo(this.nomeDoArquivo);
        }
        else{
            if(this.hMapOperador.containsKey(usuarioAlterado.getLogin())){
                throw new ServicoException("A alteração não foi concluida! \n O login escolhido já é utilizado");
            }
            else{
                this.hMapOperador.remove(usuarioLogin);
                this.hMapOperador.put(usuarioAlterado.getLogin(), (Operador) usuarioAlterado);
                this.salvarArquivo(this.nomeDoArquivo);
            }
        }
    }

    @Override
    public void excluir(Usuario usuario) throws ServicoException {
        boolean verification =  this.hMapOperador.remove(usuario.getLogin(), (Operador) usuario);
        if(!verification) throw new ServicoException("Esse usuário não existe no registro e não pode ser excluído!");
        
        this.salvarArquivo(this.nomeDoArquivo);
    }
 
    
}
