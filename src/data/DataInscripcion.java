package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import entities.Curso;
import entities.Inscripcion;

public class DataInscripcion {
	
	

	public void addInscripcion(Inscripcion i) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into inscripciones(inscripciones.id_persona, inscripciones.id_comision, inscripciones.like) values(?,?,?)"
							);
			stmt.setInt(1, i.getId_persona());
			stmt.setInt(2, i.getId_comision());
			stmt.setInt(3, i.getLike());

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
    }
	
	public void editLike(Inscripcion i, int id_curso) {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update inscripciones set inscripciones.like=? where id_persona=? and id_comision=?; " 
							);
			if(i.getLike() == 0) {
				stmt.setInt(1, 1);
			}
			else {
				stmt.setInt(1, 0);
			}
			stmt.setInt(2, i.getId_persona());
			stmt.setInt(3, i.getId_comision());
			
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
    }
	

	
	// NO TIENE SENTIDO
	//public void editInscripcion(Inscripcion iOld, Inscripcion i) {
	//}
	
	public void deleteInscripcion(Inscripcion i) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from inscripciones where id_persona=? and id_curso=?"
							);
			stmt.setInt(1, i.getId_persona());
			stmt.setInt(2, i.getId_comision());
			
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
    }
	
	public Inscripcion getInscripcionBy_Persona_Curso(int idPersona, int idCurso) {
		// TODO Auto-generated method stub
			Inscripcion insc = new Inscripcion();
			PreparedStatement stmt=null;
			ResultSet rs=null;
			try {
				stmt=DbConnector.getInstancia().getConn().prepareStatement(
						"SELECT inscripciones.* FROM inscripciones\r\n" + 
						"INNER JOIN\r\n" + 
						"comisiones ON inscripciones.id_comision = comisiones.id_comision\r\n" + 
						"WHERE comisiones.id_curso = ? and inscripciones.id_persona =?;"
						);
				stmt.setInt(1,idCurso);
				stmt.setInt(2,idPersona);
				rs=stmt.executeQuery();
				if(rs!=null && rs.next()) {
					
					insc.setId_comision(rs.getInt("id_comision"));
					insc.setId_persona(rs.getInt("id_persona"));
					insc.setLike(rs.getInt("like"));

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
			
			return insc;
		}

	public LinkedList<Inscripcion> getInscripcionesByPersona (int id_persona) throws Exception  {
		// TODO Auto-generated method stub
		LinkedList<Inscripcion> insc = new LinkedList<>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from inscripciones where inscripciones.id_persona = ?"
					);
			stmt.setInt(1,id_persona);

			rs=stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Inscripcion i = new Inscripcion();
					
					i.setId_comision(rs.getInt("id_comision"));
					i.setId_persona(rs.getInt("id_persona"));
					i.setLike(rs.getInt("like"));
					
					insc.add(i);
				}

			}
		} catch (SQLException e) {
			throw e;
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		
		return insc;
	}

	
	
}
