package com.etec.urna;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import java.io.*;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.Label;
import java.io.FileNotFoundException;

public class JanelaVotação extends JFrame {

	/**
	 * 
	 */
	public static AcessarBD conectar = new AcessarBD();
	public static JLabel numeroUrna;
	private JPanel contentPane;

	public static Label lbPartido,lbPresidente,lblVice;
	public static JLabel lblImagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaVotação frame = new JanelaVotação();
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
	public JanelaVotação() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 720);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Recursos//logo.png"));
		lblNewLabel.setBounds(12, 12, 320, 122);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" EteC Urna");
		lblNewLabel_1.setBorder(new LineBorder(Color.black));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Agent Orange", Font.BOLD, 90));
		lblNewLabel_1.setBounds(344, 12, 811, 122);
		contentPane.add(lblNewLabel_1);
		
		numeroUrna = new JLabel("");
		numeroUrna.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 40));
		numeroUrna.setBounds(678, 170, 374, 96);
		numeroUrna.setBackground(Color.GREEN);
		numeroUrna.setOpaque(true);
		numeroUrna.setBorder(new LineBorder(new Color(0, 0, 0), 10));  
		contentPane.add(numeroUrna);
		
		Button bt7 = new Button("7");
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarpainel("7");
				setArDados(new Integer(numeroUrna.getText()));
			
			}
		});
		
		bt7.setFont(new Font("Monospaced", Font.BOLD, 35));
		bt7.setBackground(new Color(204, 204, 204));
		bt7.setBounds(678, 282, 100, 71);
		contentPane.add(bt7);
		
		Button bt8 = new Button("8");
		bt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarpainel("8");
				setArDados(new Integer(numeroUrna.getText()));
				
			}
		});
		bt8.setFont(new Font("Monospaced", Font.BOLD, 35));
		bt8.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		bt8.setBounds(822, 282, 100, 71);
		contentPane.add(bt8);
		
		Button bt9 = new Button("9");
		bt9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarpainel("9");
				setArDados(new Integer(numeroUrna.getText()));
			}
		});
		bt9.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		bt9.setFont(new Font("Monospaced", Font.BOLD, 35));
		bt9.setBounds(952, 282, 100, 71);
		contentPane.add(bt9);
		
		Button bt4 = new Button("4");
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarpainel("4");
				setArDados(new Integer(numeroUrna.getText()));
			}
		});
		bt4.setFont(new Font("Monospaced", Font.BOLD, 35));
		bt4.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		bt4.setBounds(678, 380, 100, 71);
		contentPane.add(bt4);
		
		Button bt5 = new Button("5");
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarpainel("5");
				setArDados(new Integer(numeroUrna.getText()));
				
			
			}
		});
		bt5.setFont(new Font("Monospaced", Font.BOLD, 35));
		bt5.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		bt5.setBounds(822, 380, 100, 71);
		contentPane.add(bt5);
		
		Button bt6 = new Button("6");
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarpainel("6");
				setArDados(new Integer(numeroUrna.getText()));
			}
		});
		bt6.setFont(new Font("Monospaced", Font.BOLD, 35));
		bt6.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		bt6.setBounds(952, 380, 100, 71);
		contentPane.add(bt6);
		
		Button bt1 = new Button("1");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarpainel("1");
				setArDados(new Integer(numeroUrna.getText()));
			}
		});
		
		bt1.setFont(new Font("Monospaced", Font.BOLD, 35));
		bt1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		bt1.setBounds(678, 478, 100, 71);
		contentPane.add(bt1);
		
		Button bt2 = new Button("2");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarpainel("2");
				setArDados(new Integer(numeroUrna.getText()));
			}
		});
		bt2.setFont(new Font("Monospaced", Font.BOLD, 35));
		bt2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		bt2.setBounds(822, 478, 100, 71);
		contentPane.add(bt2);
		
		Button bt3 = new Button("3");
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarpainel("3");
				setArDados(new Integer(numeroUrna.getText()));
			}
		});
		bt3.setFont(new Font("Monospaced", Font.BOLD, 35));
		bt3.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		bt3.setBounds(952, 478, 100, 71);
		contentPane.add(bt3);
		
		Button bt0 = new Button("0");
		bt0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarpainel("0");
				setArDados(new Integer(numeroUrna.getText()));
			}
		});
		bt0.setFont(new Font("Monospaced", Font.BOLD, 35));
		bt0.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		bt0.setBounds(678, 573, 227, 71);
		contentPane.add(bt0);
		
		JButton btcorrige = new JButton("Corrige");
		btcorrige.setFont(new Font("Dialog", Font.BOLD, 25));
		btcorrige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apagarLabels();
			}
		});
		btcorrige.setBorder(new LineBorder(Color.black));
		btcorrige.setBackground(new Color(255, 255, 102));
		btcorrige.setBounds(911, 573, 148, 71);
		contentPane.add(btcorrige);
		
		lblImagem = new JLabel("Imagem");
		lblImagem.setBorder(new LineBorder(Color.BLACK, 3));
		lblImagem.setBounds(12, 170, 230, 260);
		contentPane.add(lblImagem);
		
		
		JLabel lblNewLabel_3 = new JLabel("Partido:");
		lblNewLabel_3.setBounds(267, 220, 70, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel label = new JLabel("Presidente:");
		label.setBounds(267, 265, 93, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel_4 = new JLabel("Vice-presidente:");
		lblNewLabel_4.setBounds(267, 307, 123, 15);
		contentPane.add(lblNewLabel_4);
		
		Button btconfirma = new Button("Confirma");
		btconfirma.setFont(new Font("Dialog", Font.PLAIN, 30));
		btconfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcessarBD.votar(new Integer(numeroUrna.getText()));
				tocarSom(); 
				apagarLabels();

			}
		});
		
		btconfirma.setBackground(new Color(0, 255, 0));
		btconfirma.setBounds(51, 564, 238, 80);
		contentPane.add(btconfirma);
		
		Button btbranco = new Button("Branco");
		btbranco.setFont(new Font("Dialog", Font.PLAIN, 30));
		btbranco.setBackground(new Color(240, 255, 240));
		btbranco.setBounds(344, 564, 238, 80);
		contentPane.add(btbranco);
		
		lbPartido = new Label(" ");
		lbPartido.setFont(new Font("Dialog", Font.BOLD, 12));
		lbPartido.setBounds(344, 214, 298, 21);
		contentPane.add(lbPartido);
		
		lbPresidente = new Label("");
		lbPresidente.setFont(new Font("Dialog", Font.BOLD, 12));
		lbPresidente.setBounds(374, 259, 298, 21);
		contentPane.add(lbPresidente);
		
		lblVice = new Label("");
		lblVice.setFont(new Font("Dialog", Font.BOLD, 12));
		lblVice.setBounds(396, 301, 285, 21);
		contentPane.add(lblVice);
		
		
	}
	public void mudarpainel(String valorBt){
		numeroUrna.setText(numeroUrna.getText().concat(valorBt));
	}
	public void setarimagem(){
		String partido = lbPartido.getText();
		if(lbPartido.getText() != null && lbPartido.getText() != ""  ){
			Image imagem = new ImageIcon(AcessarBD.getImagem(partido)).getImage().getScaledInstance(230, 260, 100);
			lblImagem.setIcon(new ImageIcon(imagem));
		}
			

	}
	public void setArDados(int id){
	
		lbPartido.setText(AcessarBD.getPartido(id));
		lbPresidente.setText(AcessarBD.getPresidente(id));
		lblVice.setText(AcessarBD.getVice(id));
		setarimagem();
		
	}
	public void apagarLabels(){
		numeroUrna.setText("");
		lblVice.setText("");
		lbPresidente.setText("");
		lbPartido.setText("");
		lblImagem.setIcon(new ImageIcon());
	}
	@SuppressWarnings("resource")
	public void tocarSom(){
		InputStream entrada;
		try {
			String string = "Recursos//som.mp3";
			entrada = ((InputStream)(new FileInputStream(string)));
			Player tocador= new Player(entrada); 
			tocador.play();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JavaLayerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}

