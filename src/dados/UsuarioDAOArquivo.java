/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 * Classe abstrada de manipulação de dados em arquivo.
 * @author  Samuel Lucas de Moura Ferino
 *          José Wellinton Nunes Júnior
 */
public abstract class UsuarioDAOArquivo implements UsuarioDAO{

    protected abstract void lerArquivo(String nomeDoArquivo) throws ServicoException;
    
    protected abstract boolean salvarArquivo(String nomeArquivo) throws ServicoException;
    
}
