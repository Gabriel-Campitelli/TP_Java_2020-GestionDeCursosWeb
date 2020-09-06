package data;


import java.sql.*;
import java.util.LinkedList;

import entities.*;

public class DataComision {
	
	public LinkedList<Comision> getAll() {
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Comision> comisiones = new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from comisiones");

			if(rs!=null) {
				while(rs.next()) {
					
					Comision c =new Comision();
					c.setIdComision(rs.getInt("id_comision"));
					c.setIdCurso(rs.getInt("id_curso"));
					c.setDiaSemana(rs.getString("dia_semana"));
					c.setCupo(rs.getInt("cupo"));
					c.setHoraInicio(rs.getTime("hora_inicio").toString());
					c.setHoraFin(rs.getTime("hora_fin").toString());
					
					comisiones.add(c);
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
		
		
		return comisiones;
	}
	
	public void addComision(Comision nuevaComision) {
		// TODO Auto-generated method stub
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into comisiones(id_curso,cupo, dia_semana, hora_inicio, hora_fin) values(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, nuevaComision.getIdCurso());
			stmt.setInt(2, nuevaComision.getCupo());
			stmt.setString(3, nuevaComision.getDiaSemana());
			Time horaInicio = Time.valueOf(nuevaComision.getHoraInicio());
			stmt.setTime(4, horaInicio);
			Time horaFin = Time.valueOf(nuevaComision.getHoraFin());
			stmt.setTime(5, horaFin);
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                nuevaComision.setIdComision(keyResultSet.getInt(1));
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
	
	public void delete(Comision comision) {
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from comisiones where id_comision =?");
			stmt.setInt(1, comision.getIdComision());
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
	

	public void edit(Comision comision) {
			
			PreparedStatement stmt= null;
			ResultSet keyResultSet=null;
			try {
				stmt=DbConnector.getInstancia().getConn().
						prepareStatement(
								"update comisiones set id_curso=?, cupo=?, dia_semana=?, hora_inicio=?, hora_fin=? where id_comision=?"
								);
				stmt.setInt(1, comision.getIdCurso());
				stmt.setInt(2, comision.getCupo());
				stmt.setString(3, comision.getDiaSemana());
				Time horaInicio = Time.valueOf(comision.getHoraInicio());
				stmt.setTime(4, horaInicio);
				Time horaFin = Time.valueOf(comision.getHoraFin());
				stmt.setTime(5, horaFin);
				stmt.setInt(6, comision.getIdComision());
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

	public LinkedList<Comision> getComisionesByCurso(int id) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Comision> comisiones = new LinkedList<>();
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
				"select * from comisiones where id_curso = ?"
					);
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Comision c =new Comision();
					c.setIdComision(rs.getInt("id_comision"));
					c.setIdCurso(rs.getInt("id_curso"));
					c.setDiaSemana(rs.getString("dia_semana"));
					c.setCupo(rs.getInt("cupo"));
					c.setHoraInicio(rs.getTime("hora_inicio").toString());
					c.setHoraFin(rs.getTime("hora_fin").toString());
					
					comisiones.add(c);
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
		
		
		return comisiones;
	}
	
	public LinkedList<Comision> getComisionesByIdPersona(int id) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Comision> comisiones = new LinkedList<>();
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
				"SELECT comisiones.* \r\n" + 
				"				FROM (select inscripciones.id_comision from inscripciones where id_persona = ?) inscripciones \r\n" + 
				"				INNER JOIN comisiones comisiones  \r\n" + 
				"				ON inscripciones.id_comision = comisiones.id_comision;"
					);
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Comision c =new Comision();
					c.setIdComision(rs.getInt("id_comision"));
					c.setIdCurso(rs.getInt("id_curso"));
					c.setDiaSemana(rs.getString("dia_semana"));
					c.setCupo(rs.getInt("cupo"));
					c.setHoraInicio(rs.getTime("hora_inicio").toString());
					c.setHoraFin(rs.getTime("hora_fin").toString());
					
					comisiones.add(c);
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
		
		
		return comisiones;
	}
	
}
