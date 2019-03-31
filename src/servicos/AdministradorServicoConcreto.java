/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dados.AdministradorDAO;
import dados.AdministradorDAOArquivo;
import dados.ServicoException;

/**
 *
 * @author SamDan
 */
public class AdministradorServicoConcreto extends FuncionarioServicoConcreto implements AdministradorServico{
    
    private AdministradorDAO administradorDAO = new AdministradorDAOArquivo();
    private LivroServicoConcreto livroServico = new LivroServicoConcreto();
    
    public AdministradorServicoConcreto(){
        super();
    }
    
    @Override
    public void excluirLivro(Livro livro) throws ServicoException{
        livroServico.excluirLivro(livro);
    }
    
    public void consultarFuncionario() throws ServicoException{}
    public void alterarFuncionario() throws ServicoException{}
    
    public void registrarFuncionario(Funcionario funcionario) throws ServicoException{
//        administradorDAO.registrarFuncionario();
    }
    
    public void excluirUsuario(Usuario usuario) throws ServicoException{
//        administradorDAO.excluirUsuario(usuario);
    }
    
    public void bloqueioPermanenteDeFuncionario(Funcionario funcionario) throws ServicoException{
//        administradorDAO.bloqueioPermanenteDeFuncionario(funcionario);
    }
    
    public void bloqueioTemporarioDeFuncionario(Funcionario funcionario) throws ServicoException{
//        administradorDAO.bloqueioTemporarioDeFuncionario(funcionario);
    }
    
}
