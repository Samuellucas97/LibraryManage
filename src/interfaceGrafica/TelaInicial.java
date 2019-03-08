package interfaceGrafica;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

/**
 * Implementação da Tela Inicial
 * @author	Samuel Lucas de Moura Ferino
 * @since	08.03.2019 
 * @version	0.0.1
 */
public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;

	/**
	 * Construtor padrão
	 */
	public TelaInicial() {

		inicializaTela();
		label_Login();
		textField_Login();
		comboBox_OpcoesBusca();
		label_Senha();
		textField_Senha();
		button_Confirmar();
		
	}
	
	private void inicializaTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	
	/**
	 * Adiciona um rótulo Login
	 */
	private void label_Login() {
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(191, 14, 85, 15);
		contentPane.add(lblLogin);
		
	}
	
	private void textField_Login() {
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(239, 12, 68, 19);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);		
				
	}
	
	private void comboBox_OpcoesBusca() {
		JComboBox comboBoxOpcoesBusca = new JComboBox();
		comboBoxOpcoesBusca.setBounds(43, 38, 68, 24);
		comboBoxOpcoesBusca.addItem("Título");
		comboBoxOpcoesBusca.addItem("Autor");
		comboBoxOpcoesBusca.addItem("Editora");
		contentPane.add(comboBoxOpcoesBusca);

	}
	
	private void label_Senha() {
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(312, 14, 70, 15);
		contentPane.add(lblSenha);
	}
	
	private void textField_Senha() {
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(360, 12, 68, 19);
		contentPane.add(textFieldSenha);
		textFieldSenha.setColumns(10);
	}
	
	private void  button_Confirmar() {
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(280, 43, 117, 25);
		contentPane.add(btnConfirmar);
	}
}
