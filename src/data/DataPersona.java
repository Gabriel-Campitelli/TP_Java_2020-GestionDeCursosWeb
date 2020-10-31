package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Persona;

public class DataPersona {
	
	public LinkedList<Persona> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Persona> pers= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select id_persona, dni,nombre,apellido,usuario,rol,email from personas");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Persona p=new Persona();
					p.setId_persona((Integer)rs.getInt("id_persona"));
					p.setDni(rs.getString("dni"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setUsuario(rs.getString("usuario"));
					p.setRol((Integer)rs.getInt("rol"));
					p.setEmail(rs.getString("email"));
					
					pers.add(p);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return pers;
	}
	
	public Persona getByUser(Persona per) throws Exception {
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id_persona,dni,nombre,apellido,rol,email,usuario from personas where email=? and contrasenia=?"
					);
			stmt.setString(1, per.getEmail());
			stmt.setString(2, per.getContrasenia());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setId_persona(rs.getInt("id_persona"));
				p.setDni(rs.getString("dni"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setUsuario(rs.getString("usuario"));
				p.setRol(rs.getInt("rol"));
				p.setEmail(rs.getString("email"));
							}
		} catch (SQLException e) {
			throw e;
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
	public Persona getByMail(Persona per) {
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id_persona,usuario,nombre,apellido,rol,dni from personas where email=?"
					);
			stmt.setString(1, per.getEmail());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setDni(rs.getString("dni"));
				p.setId_persona((Integer)rs.getInt("id_persona"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setUsuario(rs.getString("usuario"));
				p.setRol((Integer)rs.getInt("rol"));
				p.setEmail(per.getEmail());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
	public void addPersona(Persona p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into gestion_cursos.personas(dni, nombre, apellido , contrasenia, rol, email) values(?,?,?,?,?,?)"
							, PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			//stmt.setString(4, p.getUsuario());
			stmt.setString(4, p.getContrasenia());
			stmt.setInt(5, p.getRol());
			stmt.setString(6, p.getEmail());

			stmt.executeUpdate();

			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setId_persona(keyResultSet.getInt(1));
            }

			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
    }
	
	
	public Persona editPersona(Persona pOld, Persona p) {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update personas set nombre=?, apellido=?, usuario=?, contrasenia=?, rol=?, email=?, dni=? where id_persona=?"
							);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getUsuario());
			stmt.setString(4, p.getContrasenia());
			stmt.setInt(5, p.getRol());
			stmt.setString(6, p.getEmail());
			stmt.setString(7, p.getDni());
	
			stmt.setInt(8, pOld.getId_persona());

			stmt.executeUpdate();
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		return p;
    }
	
public Persona deletePersona(Persona p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from personas where id_persona=?"
							);
			stmt.setInt(1, p.getId_persona());
			
			stmt.executeUpdate();
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		return p;
    }
}
