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
import servicos.Cliente;
import servicos.Usuario;

/**
 *
 * @author SamDan
 */
public class ClienteDAOArquivo extends UsuarioDAOArquivo{

    private HashMap<String, Cliente> hMapCliente;   

    public ClienteDAOArquivo() throws ServicoException {
        this.hMapCliente = new HashMap<>();        
        this.lerArquivo("Clientes");
    }    
    
    @Override
    protected void lerArquivo(String nomeDoArquivo) throws ServicoException {
        this.hMapCliente = (HashMap<String, Cliente>) Serializator.unserialize(nomeDoArquivo);
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
                List<Usuario> auxLivros = new ArrayList<>();
                auxLivros.addAll(clientes);
                auxLivros.removeAll(next);
                clientes.removeAll(auxLivros);
            }
            if(clientes.isEmpty()) break;
        }
        
        if(clientes.isEmpty()) throw new ServicoException("Nenhum cliente encontrado!");
        
        return clientes;
    }

    @Override
    public List<Usuario> consultaUsuarios(String param, String key) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrar(Usuario usuario) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Usuario usuario, Usuario usuarioAlterado) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Usuario usuario) throws ServicoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
            
//    public Cliente buscarCliente( String loginCliente ) throws ServicoException{
//       
//        try{
//        
//            return this.hMapCliente.get(loginCliente);
//        }catch( NullPointerException e){
//            throw new ServicoException( "Usuario nao existe" );
//        }
//        catch( ClassCastException e ){
//            throw new ServicoException( "O usuario nao eh um cliente");
//        }
//            
//    }
//
//    public void salvar(Cliente cliente) throws ServicoException {
//        
//    }
//    
//    @Override
//    protected void transformaStringEmHashMap(String conteudoArquivo){
//    
//        hMapCliente.clear();
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
//    @Override
//    protected String autenticar(String login, String senha) {
//        
//        Usuario usuarioTemporario = hMapCliente.get(login);
//        
//        if(  usuarioTemporario == null )
//            return "Login de usuario nao cadastrado";
//                
//        if( !senha.equals( usuarioTemporario.getSenha() ) )
//            return "Senha de usuario incorreta";
//                    
//        return "OK";
//     
//    }
//
//    @Override
//    public Usuario buscar(String login) throws NullPointerException {
//        return hMapCliente.get(login);
//    }
//
//    @Override
//    public void bloqueioPermanenteDeCliente(Cliente cliente) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void bloqueioTemporarioDeCliente(Cliente cliente) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
