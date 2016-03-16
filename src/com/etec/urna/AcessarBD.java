package com.etec.urna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JOptionPane;
/*Classe ultilizada para acessar a base de dados 
 * Desenvolvedor: Gustavo Camargo
 * Criada em: 17/02/2014
 * Ultima modificação: 17/02/2014 às 22:27;  
 * Total de modicações apartir da criação: 1;
 * Métodos:
 * id = numero da chapa;
 * 		getConexão = cria conexão;
 * 		getPartido(int id) = retorna o partido;
 * 		getPresidente(int id) = retorna o presidente da chapa
 * 		getVice(int id) = retorn o vice da chapa;
 * 		getQtddevotos(int id) retorna qtd de votos; */

public class AcessarBD {
	private static Connection connection;
	private static String partido;
	private static String presidente;
	private static String vice;
	private static String qtddevotos;
	private static Statement st;
	private static ResultSet rt;
	private static String query = "select *from urna where numero =";
	private static String imagem;
	
	public AcessarBD() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:Recursos//partidos.db");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Não foi possivel localizar a base de dados");
		}
	}

	public static String getImagem(String partido) {
		
		try{
			imagem = executarQuery("select *from urna where partido ='"+partido+"'", "imagens");
		}catch(Exception e){
			e.printStackTrace();
			imagem = "Recursos//defaul.jpg";
		}

		return imagem;
	}

	public static String getPartido(int id) {
		partido = executarQuery(query.concat(Integer.toString(id)),"partido");
		return partido;
	}
	public static void votar(int partido) {
		Integer votos = new Integer(getQtddevotos(partido));
		votos++;
		String queryVoto = "update urna set qtdvotos = "+votos+" where numero ="+partido;
		try {
			st = connection.createStatement();
			st.executeUpdate(queryVoto);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel localizar a base de dados");
			e.printStackTrace();
		}
	}

	public static String getPresidente(int id) {
		presidente = executarQuery(query.concat(Integer.toString(id)),"presidente");
		return presidente;
	}
	public static String getVice(int id) {
		vice = executarQuery(query.concat(Integer.toString(id)),"vice");
		return vice;
	}
	public static String getQtddevotos(int id) {
		qtddevotos = executarQuery(query.concat(Integer.toString(id)),"qtdvotos");
		return qtddevotos;
	}
	public Connection getConexão(){
		return connection;
	}
	public static String executarQuery(String query, String coluna){
		String resultado = null;
		try {
			st = connection.createStatement();
			rt = st.executeQuery(query);
			while(rt.next()){
				resultado = rt.getString(coluna);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}
	public static void updateTudo(String numero,String partido, String presidente,String vice, String imagem){
		String query = "insert into urna(numero,partido,presidente,vice,imagens,qtdvotos) values("+numero+",'"+partido+"','"+presidente+"','"+vice+"','"+imagem+"',0)";
		try {
			st = connection.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
