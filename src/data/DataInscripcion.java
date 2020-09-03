package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entities.Inscripcion;

public class DataInscripcion {

	public void addInscripcion(Inscripcion i) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into gestion_cursos.inscripciones(gestion_cursos.inscripciones.id_persona, gestion_cursos.inscripciones.id_curso, gestion_cursos.inscripciones.like) values(?,?,?)"
							);
			stmt.setInt(1, i.getId_persona());
			stmt.setInt(2, i.getId_curso());
			stmt.setBoolean(3, i.getLike());

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
	
	public void editLike(Inscripcion i) {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update inscripciones set inscripciones.like=? where id_persona=? and id_curso=?"
							);

			stmt.setBoolean(1, i.getLike());
			stmt.setInt(2, i.getId_persona());
			stmt.setInt(3, i.getId_curso());
				
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
			stmt.setInt(2, i.getId_curso());
			
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
	
	
}
