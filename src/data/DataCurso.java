package data;


import java.sql.*;
import java.util.LinkedList;

import entities.*;


public class DataCurso {
	
	public LinkedList<Curso> getAll() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Curso> cursos = new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from cursos");

			if(rs!=null) {
				while(rs.next()) {
					
					Curso curso =new Curso();
					curso.setId(rs.getInt("id_curso"));
					curso.setDescripcion(rs.getString("descripcion"));
					curso.setFecha_inicio(rs.getDate("fecha_inicio"));
					curso.setFecha_fin(rs.getDate("fecha_fin"));
					curso.setUrl(rs.getString("url_imagen"));
					curso.setNombre(rs.getString("nombre"));
					curso.setLikes(rs.getInt("likes"));
					
					cursos.add(curso);
				}
			}
			
		} catch (SQLException e) {
			throw e;
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		
		
		return cursos;
	}

	public Curso getById(int id) throws Exception {
		// TODO Auto-generated method stub
			Curso curso =new Curso();
			PreparedStatement stmt=null;
			ResultSet rs=null;
			try {
				stmt=DbConnector.getInstancia().getConn().prepareStatement(
						"select * from cursos where id_curso =?"
						);
				stmt.setInt(1,id);
				rs=stmt.executeQuery();
				if(rs!=null && rs.next()) {
										
					curso.setId(rs.getInt("id_curso"));
					curso.setDescripcion(rs.getString("descripcion"));
					curso.setFecha_inicio(rs.getDate("fecha_inicio"));
					curso.setFecha_fin(rs.getDate("fecha_fin"));
					curso.setUrl(rs.getString("url_imagen"));
					curso.setNombre(rs.getString("nombre"));
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
			
			return curso;
		}

	public void create(Curso nuevoCurso) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into cursos(descripcion, fecha_inicio, fecha_fin, nombre, url_imagen) values(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, nuevoCurso.getDescripcion());
			stmt.setTimestamp(2, new java.sql.Timestamp(nuevoCurso.getFecha_inicio().getTime()));
			stmt.setTimestamp(3, new java.sql.Timestamp(nuevoCurso.getFecha_fin().getTime()));
			stmt.setString(4, nuevoCurso.getNombre());
			stmt.setString(5, nuevoCurso.getUrl());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                nuevoCurso.setId(keyResultSet.getInt(1));
            }

			
		}  catch (SQLException e) {
			throw e;

		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
				throw e;

            }
		}
	}

	public void delete(Curso curso) throws Exception {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from cursos where id_curso =?");
			stmt.setInt(1, curso.getId());
			stmt.executeUpdate();
						
		}  catch (SQLException e) {
            throw e;
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw e;
            }
		}
		
	}

	public void edit(Curso curso) throws Exception {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update cursos set descripcion=?, fecha_inicio=?, fecha_fin=?, nombre=?, url_imagen=?  where id_curso=?"
							);
			stmt.setString(1, curso.getDescripcion());
			stmt.setTimestamp(2, new java.sql.Timestamp(curso.getFecha_inicio().getTime()));
			stmt.setTimestamp(3, new java.sql.Timestamp(curso.getFecha_fin().getTime()));
			stmt.setString(4, curso.getNombre());
			stmt.setString(5, curso.getUrl());
			stmt.setInt(6, curso.getId());
			stmt.executeUpdate();
						
		}  catch (SQLException e) {
            throw e;
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw e;
            }
		}
		
	}
	
public void countLike(int id_curso, int like) throws Exception {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update cursos set likes = ? + cursos.likes where id_curso=?"
							);
			
			if(like == 1) {
				stmt.setInt(1, 1);
			}
			else {
				stmt.setInt(1, -1);
			}
			stmt.setInt(2, id_curso);
			stmt.executeUpdate();
						
		}  catch (SQLException e) {
            throw e;
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	throw e;
            }
		}
		
	}
	
	
	public LinkedList<Curso> getByIdPersona (int id) throws Exception {
		// TODO Auto-generated method stub
			
			PreparedStatement stmt=null;
			ResultSet rs=null;
			LinkedList<Curso> cursos = new LinkedList<>();
			try {
				stmt=DbConnector.getInstancia().getConn().prepareStatement(
	"SELECT cursos.id_curso, cursos.descripcion, cursos.fecha_inicio, cursos.fecha_fin, cursos.url_imagen,\r\n" + 
	"cursos.nombre, cursos.likes \r\n" + 
	"FROM (select inscripciones.id_comision from inscripciones where id_persona = ?) inscripciones\r\n" + 
	"INNER JOIN comisiones\r\n" + 
	"ON inscripciones.id_comision = comisiones.id_comision\r\n" + 
	"INNER JOIN cursos\r\n" + 
	"ON cursos.id_curso = comisiones.id_curso;"
						);
				stmt.setInt(1,id);
				rs=stmt.executeQuery();
				if(rs!=null) {
					while(rs.next()) {
						
						Curso curso =new Curso();
						curso.setId(rs.getInt("id_curso"));
						curso.setDescripcion(rs.getString("descripcion"));
						curso.setFecha_inicio(rs.getDate("fecha_inicio"));
						curso.setFecha_fin(rs.getDate("fecha_fin"));
						curso.setUrl(rs.getString("url_imagen"));
						curso.setNombre(rs.getString("nombre"));
						curso.setLikes(rs.getInt("likes"));
						
						cursos.add(curso);
					}
				}
				
			} catch (SQLException e) {
				throw e;
				
			} finally {
				try {
					if(rs!=null) {rs.close();}
					if(stmt!=null) {stmt.close();}
					DbConnector.getInstancia().releaseConn();
				} catch (SQLException e) {
					throw e;
				}
			}
			
			
			return cursos;
		}
	
	public LinkedList<Curso> getByLikes() throws Exception {
		// TODO Auto-generated method stub
			
			PreparedStatement stmt=null;
			ResultSet rs=null;
			LinkedList<Curso> cursos = new LinkedList<>();
			try {
				stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from cursos\r\n" + 
					"order by likes desc LIMIT 4"
						);
				rs=stmt.executeQuery();
				if(rs!=null) {
					while(rs.next()) {
						
						Curso curso =new Curso();
						curso.setId(rs.getInt("id_curso"));
						curso.setDescripcion(rs.getString("descripcion"));
						curso.setFecha_inicio(rs.getDate("fecha_inicio"));
						curso.setFecha_fin(rs.getDate("fecha_fin"));
						curso.setUrl(rs.getString("url_imagen"));
						curso.setNombre(rs.getString("nombre"));
						curso.setLikes(rs.getInt("likes"));
						
						cursos.add(curso);
					}
				}
				
			} catch (SQLException e) {
				throw e;
				
			} finally {
				try {
					if(rs!=null) {rs.close();}
					if(stmt!=null) {stmt.close();}
					DbConnector.getInstancia().releaseConn();
				} catch (SQLException e) {
					throw e;
				}
			}
			
			
			return cursos;
		}
	
	public LinkedList<Curso> getByNombre (String nombre) throws Exception {
		// TODO Auto-generated method stub
			PreparedStatement stmt=null;
			ResultSet rs=null;
			LinkedList<Curso> cursos = new LinkedList<>();
			nombre="%"+nombre+"%";
			try {
				stmt=DbConnector.getInstancia().getConn().prepareStatement(
						"select * from cursos where nombre like ?"
						);
				stmt.setString(1,nombre);
				rs=stmt.executeQuery();
				while(rs!=null && rs.next()) {
					Curso curso = new Curso();					
					curso.setId(rs.getInt("id_curso"));
					curso.setDescripcion(rs.getString("descripcion"));
					curso.setFecha_inicio(rs.getDate("fecha_inicio"));
					curso.setFecha_fin(rs.getDate("fecha_fin"));
					curso.setUrl(rs.getString("url_imagen"));
					curso.setNombre(rs.getString("nombre"));
					curso.setLikes(rs.getInt("likes"));
					cursos.add(curso);
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
			
			return cursos;
		}
	
}
	


