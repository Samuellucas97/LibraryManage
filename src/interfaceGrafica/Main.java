package interfaceGrafica;

import java.awt.EventQueue;

/**
 * Implementação da Main
 * @author	Samuel Lucas de Moura Ferino
 * @since	08.03.2019 
 * @version	0.0.1
 */
public class Main {

	/**
	 * Método principal para executar a aplicação
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
