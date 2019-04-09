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
import servicos.Administrador;
import servicos.Funcionario;
import servicos.Usuario;

/**
 *
 * @author SamDan
 */
public class AdministradorDAOArquivo extends FuncionarioDAOArquivo{

    private final String nomeDoArquivo = "Administradores";
    private HashMap<String, Administrador> hMapAdministrador;

   @Override
    protected void lerArquivo(String nomeDoArquivo) throws ServicoException {
        this.hMapAdministrador = (HashMap<String, Administrador>) Serializator.unserialize(this.hMapAdministrador,nomeDoArquivo);
    }

    @Override
    protected boolean salvarArquivo(String nomeArquivo) throws ServicoException {
        Serializator.serialize(this.hMapAdministrador, nomeArquivo);
        return true;
    }

    @Override
    public Usuario autenticacao(String login, String senha) throws ServicoException {
        if(this.hMapAdministrador.containsKey(login)){
            Administrador administrador = this.hMapAdministrador.get(login);
            if(administrador.getSenha().equals(senha)) return administrador;
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
        if(this.hMapAdministrador.containsKey(login)) return this.hMapAdministrador.get(login);
        else throw new ServicoException("Administrador não encontrado!");
    }

    @Override
    public List<Usuario> consultaUsuarios(List<String> params, List<String> keys) throws ServicoException {
        List<Usuario> administradores = new ArrayList<>();
        List<List<Usuario> > listAdministradores = new ArrayList<>();
        
        if(params.size() != keys.size()) throw new ServicoException("Quantidade de chaves não confere com a quantidade de parâmetros!");
        
        int i = 0;
        for(String param : params) listAdministradores.add(this.consultaUsuarios(param, keys.get(i++)));
                
        Collections.sort(listAdministradores, (o1, o2) -> {
            if(o1.size() > o2.size()) return -1;
            else if (o1.size() < o2.size()) return 1; 
            return 0;
        });
        
        for(Iterator<List<Usuario>> iterator = listAdministradores.iterator(); iterator.hasNext();) {
            List<Usuario> next = iterator.next();
            if(administradores.isEmpty()) administradores.addAll(next);
            else{
                List<Usuario> auxAdministrares = new ArrayList<>();
                auxAdministrares.addAll(administradores);
                auxAdministrares.removeAll(next);
                administradores.removeAll(auxAdministrares);
            }
            if(administradores.isEmpty()) break;
        }
        
        if(administradores.isEmpty()) throw new ServicoException("Nenhum administrador encontrado!");
        
        return administradores;
    }

    @Override
    public List<Usuario> consultaUsuarios(String param, String key) throws ServicoException {
        List<Usuario> administradores = new ArrayList<>();
        
        for (Map.Entry<String, Administrador> operador : this.hMapAdministrador.entrySet()) {
            Administrador value = operador.getValue();
            
            switch(param){
                case "Login":
                    if(value.getLogin().equals(key)) administradores.add(value);                    
                    break;
                case "Nome":
                    if(value.getNome().toLowerCase().contains(key.toLowerCase())) administradores.add(value);
                    break;
                case "Idade":
                    if(String.valueOf(value.getIdade()).equals(key)) administradores.add(value);
                    break;
                case "Genero":
                    if(value.getGenero().toString().toLowerCase().contains(key.toLowerCase())) administradores.add(value);
                    break;
                case "Salario":
                    if(String.valueOf(value.getSalario()).equals(key)) administradores.add(value);
                    break;
                default:
                    
            }
        }
        if(administradores.isEmpty()) throw new ServicoException("Nenhum Operador encontrado!");
        
        return administradores;
    }

    @Override
    public void registrar(Usuario usuario) throws ServicoException {
        if(!this.hMapAdministrador.containsKey(usuario.getLogin())){
            this.hMapAdministrador.put(usuario.getLogin(),(Administrador) usuario);
            this.salvarArquivo(this.nomeDoArquivo);
        }              
        else throw new ServicoException("Administrador com esse login já registrado!");
    }

    @Override
    public void alterar(String usuarioLogin, Usuario usuarioAlterado) throws ServicoException {
         if(usuarioLogin.equals(usuarioAlterado.getLogin())){
            this.hMapAdministrador.remove(usuarioLogin);
            this.hMapAdministrador.put(usuarioAlterado.getLogin(), (Administrador) usuarioAlterado);
            this.salvarArquivo(this.nomeDoArquivo);
        }
        else{
            if(this.hMapAdministrador.containsKey(usuarioAlterado.getLogin())){
                throw new ServicoException("A alteração não foi concluida! \n O login escolhido já é utilizado");
            }
            else{
                this.hMapAdministrador.remove(usuarioLogin);
                this.hMapAdministrador.put(usuarioAlterado.getLogin(), (Administrador) usuarioAlterado);
                this.salvarArquivo(this.nomeDoArquivo);
            }
        }
    }

    @Override
    public void excluir(Usuario usuario) throws ServicoException {
        boolean verification =  this.hMapAdministrador.remove(usuario.getLogin(), (Administrador) usuario);
        if(!verification) throw new ServicoException("Esse usuário não existe no registro e não pode ser excluído!");
        
        this.salvarArquivo(this.nomeDoArquivo);
    }
 
    
    
}
