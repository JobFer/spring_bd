package com.mitocode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mitocode.beans.Marca;

@Repository
public class DAOMarcaImpl implements DAOMarca {

	@Autowired
	private DataSource dataSource;
	
	public void registrar(Marca marca) throws Exception {
//		System.out.println("Registrando...");
		
		String sql = "INSERT INTO MARCA (ID, NOMBRE) VALUES(?,?)";
		Connection con = null;
		
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, marca.getId());
			ps.setString(2, marca.getNombre());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			throw e;
		} finally{
			if(con != null)
				con.close();
		}

	}

}
