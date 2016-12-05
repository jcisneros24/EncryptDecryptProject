package com.hiveit.pe.sf.encryptdecrypt.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JFEncryptDecrypt extends JFrame {

	private JPanel contentPane;
	public JTextField txtCodEncrypt;
	public JTextField txtCodEncrypted;
	public JButton btnExecute;
	public JLabel lblResult;
	private JLabel lblCodeDecrypt;
	public JTextField txtCodDecrypt;
	private JLabel lblOpction;
	public JComboBox comboBox;
	public JTextField txtKey;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFEncryptDecrypt frame = new JFEncryptDecrypt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFEncryptDecrypt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEncryptDecrypt = new JLabel("Encrypt / Decrypt");
		lblEncryptDecrypt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEncryptDecrypt.setBounds(186, 11, 129, 14);
		contentPane.add(lblEncryptDecrypt);
		
		JLabel lblCodeEncrypt = new JLabel("Code Encrypt :");
		lblCodeEncrypt.setBounds(24, 87, 94, 14);
		contentPane.add(lblCodeEncrypt);
		
		txtCodEncrypt = new JTextField();
		txtCodEncrypt.setBounds(129, 84, 246, 20);
		contentPane.add(txtCodEncrypt);
		txtCodEncrypt.setColumns(10);
		
		btnExecute = new JButton("Execute");
		btnExecute.setBounds(27, 208, 91, 23);
		contentPane.add(btnExecute);
		
		lblResult = new JLabel("Result:");
		lblResult.setBounds(54, 252, 46, 14);
		contentPane.add(lblResult);
		
		txtCodEncrypted = new JTextField();
		txtCodEncrypted.setBounds(128, 249, 246, 20);
		contentPane.add(txtCodEncrypted);
		txtCodEncrypted.setColumns(10);
		
		lblCodeDecrypt = new JLabel("Code Decrypt :");
		lblCodeDecrypt.setBounds(24, 127, 94, 14);
		contentPane.add(lblCodeDecrypt);
		
		txtCodDecrypt = new JTextField();
		txtCodDecrypt.setBounds(127, 124, 248, 20);
		contentPane.add(txtCodDecrypt);
		txtCodDecrypt.setColumns(10);
		
		lblOpction = new JLabel("Opction:");
		lblOpction.setBounds(54, 37, 56, 14);
		contentPane.add(lblOpction);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Encrypt", "Decrypt"}));
		comboBox.setBounds(129, 33, 246, 22);
		contentPane.add(comboBox);
		
		JLabel lblKey = new JLabel("Key Decrypt :");
		lblKey.setBounds(27, 169, 94, 14);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(126, 166, 249, 20);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
	}
}
