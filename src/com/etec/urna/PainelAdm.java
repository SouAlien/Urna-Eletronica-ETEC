package com.etec.urna;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.Box;
import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JToggleButton;

public class PainelAdm extends JFrame {
	private JTextField partido;
	private JTextField numero;
	private JTextField presidente;
	private JTextField vice;
	private JLabel lbimagem,lblcaminho;
	private String caminho,nome,saidaString;
	private static Path saida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelAdm frame = new PainelAdm();
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
	public PainelAdm() {
		getContentPane().setBackground(new Color(255, 255, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 571);
		getContentPane().setLayout(null);
		
		JLabel lblPainelDeAdministrao = new JLabel("Painel de Administração");
		lblPainelDeAdministrao.setFont(new Font("Dialog", Font.BOLD, 38));
		lblPainelDeAdministrao.setBounds(0, 12, 609, 111);
		getContentPane().add(lblPainelDeAdministrao);
		
		JTabbedPane painel = new JTabbedPane(JTabbedPane.TOP);
		
		painel.setBounds(0, 108, 563, 402);
		getContentPane().add(painel);
		
		JPanel panel = new JPanel();
		panel.setBackground(painel.getBackground());
		painel.addTab("Add Partido", null, panel, null);
		painel.setForegroundAt(0, new Color(255, 0, 0));
	
		panel.setLayout(null);
		
		lbimagem = new JLabel("Imagem");
		lbimagem.setForeground(new Color(255, 255, 255));
		lbimagem.setBackground(new Color(255, 255, 255));
		
		lbimagem.setBorder(new LineBorder(Color.black,1));
		lbimagem.setBounds(12, 12, 133, 119);
		panel.add(lbimagem);
		
		JButton btnSelecionarImaem = new JButton("Selecionar Imagem");
		btnSelecionarImaem.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser fc = new JFileChooser();
				   int opcao = fc.showOpenDialog(lbimagem);
				   if (opcao == JFileChooser.APPROVE_OPTION) {
					nome = fc.getSelectedFile().getName();
				    caminho = fc.getSelectedFile().getAbsolutePath();
				    Image imagem = new ImageIcon(caminho).getImage().getScaledInstance(lbimagem.getWidth(), lbimagem.getHeight(), 10);
				    lbimagem.setIcon(new ImageIcon(imagem));
				    lblcaminho.setText(caminho);
				    
				    
				   } 
			}
		});
		btnSelecionarImaem.setBounds(163, 89, 185, 25);
		panel.add(btnSelecionarImaem);
		
		partido = new JTextField();
		partido.setBounds(163, 148, 246, 19);
		panel.add(partido);
		partido.setColumns(10);
		
		JLabel lblPartido = new JLabel("Partido:");
		lblPartido.setBounds(48, 150, 70, 15);
		panel.add(lblPartido);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(48, 191, 70, 15);
		panel.add(lblNumero);
		
		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(163, 189, 39, 19);
		panel.add(numero);
		
		JLabel label = new JLabel("Presidente:");
		label.setBounds(48, 232, 87, 15);
		panel.add(label);
		
		presidente = new JTextField();
		presidente.setColumns(10);
		presidente.setBounds(163, 230, 246, 19);
		panel.add(presidente);
		
		JLabel label_1 = new JLabel("Vice Presidente:");
		label_1.setBounds(48, 275, 116, 15);
		panel.add(label_1);
		
		vice = new JTextField();
		vice.setColumns(10);
		vice.setBounds(163, 273, 246, 19);
		panel.add(vice);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nome != null){
					moverArquivo(nome);

				}
				verificareUpar();

				
			}
		});
		btnNewButton.setBounds(409, 325, 117, 25);
		panel.add(btnNewButton);
		
		lblcaminho = new JLabel("");

		lblcaminho.setBounds(163, 55, 387, 15);
		panel.add(lblcaminho);
		
		Panel panel_1 = new Panel();
		painel.addTab("Apuração", null, panel_1, null);

	}
	public void moverArquivo(String nome){

		try {
			saidaString = "Recursos//urna".concat(nome);
			saida = Paths.get(saidaString);
			Files.copy(Paths.get(caminho), saida);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Insira uma imagem");
			e.printStackTrace();
			
		}
	}
	public void verificareUpar(){

		if(lblcaminho.getText().isEmpty() ){
			JOptionPane.showMessageDialog(null, "Por favor preencha o campo do Presidente");
		}
		if(partido.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Por favor preencha o campo do Partido");
		}
		if(vice.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Por favor preencha o campo do vice");
		}
		if(lblcaminho.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Por favor insira uma imagem");
		}
		if(numero.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Por favor insira um numero");
		}
		String partidoU = partido.getText();
		String presidenteU = presidente.getText();
		String ViceU = vice.getText();
		String num = numero.getText();
		new AcessarBD();
		AcessarBD.updateTudo(num,partidoU,presidenteU,ViceU,saidaString);
	}
}
