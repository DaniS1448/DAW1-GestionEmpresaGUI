package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Departamento;


public class BBDDps {
	private static final String URL = "jdbc:mysql://localhost:3306/empresa";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";

	private Conexion unaConexion;
	private Connection connection;

	public BBDDps() throws SQLException {

		unaConexion = new Conexion(URL, USUARIO, CLAVE);
	}

	// *********************************INSERCIONES************ *************************
	//** Departamento
	public boolean insertarDepartamento(Departamento d) throws SQLException {

		// -----------conectamos
		unaConexion.conectar();
		connection = unaConexion.getJdbcConnection();

		// -----------generamos la sentencia
		String sql = "INSERT INTO departamento (nom_departamento) VALUES (?)";

		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, d.getNomDepartamento());

		// -----------------ejecutamos
		boolean rowInserted = pStatement.executeUpdate() > 0;

		// -------------cerramos y desconectamos
		pStatement.close();
		unaConexion.desconectar();
		return rowInserted;
	}

	
	//*******INSERTAR TODOS LOS DEPARTAMENTOS *******************************************************************
	public boolean insertarListaDepartamentos(List<Departamento> listaD) throws SQLException {
		boolean rowInserted=false;
		// -----------conectamos
		unaConexion.conectar();
		connection = unaConexion.getJdbcConnection();

		// -----------generamos la sentencia
		String sql = "INSERT INTO departamento (nom_departamento) VALUES (?)";

		PreparedStatement pStatement = connection.prepareStatement(sql);
		for (Departamento d: listaD) {
			pStatement.setString(1, d.getNomDepartamento());

		// -----------------ejecutamos
			rowInserted= pStatement.executeUpdate() > 0;
		}
		// -------------cerramos y desconectamos
		pStatement.close();
		unaConexion.desconectar();
		return rowInserted;
	}
	
	// **********************************SELECCIONES****************************************************************
	// ** Obtener id del departamento
	public int seleccionarCodDepartamento(String nombre) throws SQLException {
		int id = 0;
		// -----------conectamos
		unaConexion.conectar();
		connection = unaConexion.getJdbcConnection();

		// -----------generamos la sentencia
		String sql = "SELECT cod_departamento FROM departamento WHERE nom_departamento= ? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, nombre);

		// -----------ejecutamos la consulta
		ResultSet rs = statement.executeQuery();

		// -----------transformamos la estructura
		if (rs.next()) {
			id = rs.getInt(1);
		}

		// ----------cerramos y desconectamos
		rs.close();
		unaConexion.desconectar();

		return id;
	}



	//**Obtener departamento por id
	public Departamento obtenerPorId(int id) throws SQLException {
		Departamento d = null;

		// -----------conectamos
		unaConexion.conectar();
		connection = unaConexion.getJdbcConnection();

		// -----------generamos la sentencia
		String sql = "SELECT * FROM articulos WHERE id= ? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		// -----------ejecutamos la consulta
		ResultSet rs = statement.executeQuery();

		// -----------transformamos la estructura
		if (rs.next()) {
			d = new Departamento(rs.getString("nombre"));
		}

		// ----------cerramos y desconectamos
		rs.close();
		unaConexion.desconectar();

		return d;
	}
	
	
	//** Obtener la lista de departamentos
		public List<Departamento> seleccionarDepartamentos() throws SQLException {

			List<Departamento> listaE = new ArrayList<Departamento>();

			String sqlQuery = "SELECT * FROM departamento";

			Statement sentencia = null;
			ResultSet rs = null;
			// -----------conectamos
			unaConexion.conectar();
			connection = unaConexion.getJdbcConnection();

			sentencia = connection.createStatement();
			rs = sentencia.executeQuery(sqlQuery);
			while (rs.next()) {

				int cod = rs.getInt(1);
				String nombre = rs.getString(2);
				listaE.add(new Departamento(cod,nombre));
			}

			// ----------cerramos y desconectamos
			rs.close();
			unaConexion.desconectar();

			return listaE;
		}
	
	
	// ********************************************************ACTUALIZACIÓN********************************************
	
	
	

	//*****************************ELIMINAR**************************************************
	
	
	public boolean eliminarDepartamento(int id) throws SQLException {
		boolean rowEliminar = false;

		// ----------conectamos
		unaConexion.conectar();
		connection = unaConexion.getJdbcConnection();

		// -------generamos la sentencia
		String sql = "DELETE FROM departamento WHERE cod_departamento=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, id);

		rowEliminar = pStatement.executeUpdate() > 0;

		// cerramos y desconectamos
		pStatement.close();
		unaConexion.desconectar();

		return rowEliminar;
	}

	//**********************DESCONECTAR ******************************************************
	public void desconectar() throws SQLException {

		unaConexion.desconectar();
	}

	
}
