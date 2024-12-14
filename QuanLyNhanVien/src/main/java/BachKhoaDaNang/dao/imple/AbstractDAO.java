package BachKhoaDaNang.dao.imple;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import BachKhoaDaNang.Mapper.IRowMapper;
import BachKhoaDaNang.dao.IGenericDAO;

public class AbstractDAO<T> implements IGenericDAO<T>{
	ResourceBundle bundle= ResourceBundle.getBundle("db");
	// Method to get the connection to the database
    public Connection getConnection() {
        try {
            // Load MySQL JDBC Driver
        		Class.forName(bundle.getString("driverName"));
        		String url = bundle.getString("url");
        		String user = bundle.getString("user");
        		String passWord = bundle.getString("password");
        		return DriverManager.getConnection(url, user,passWord);
        } catch (ClassNotFoundException| SQLException e) {
           e.printStackTrace();
           return null;
        }
    }

    // Method to close the connection, statement, and result set
    public void closeResources(Connection con, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   @SuppressWarnings("hiding")
@Override
	public <T> ArrayList<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {
	   ArrayList<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			closeResources(connection, statement, resultSet);
		}
	}

   private void setParameter(PreparedStatement statement, Object... parameters) {
	    try {
	        for (int i = 0; i < parameters.length; i++) {
	            Object parameter = parameters[i];
	            int index = i + 1;
	            if (parameter instanceof Long) {
	                statement.setLong(index, (Long) parameter);
	            } else if (parameter instanceof String) {
	                statement.setString(index, (String) parameter);
	            } else if (parameter instanceof Integer) {
	                statement.setInt(index, (Integer) parameter);
	            } else if (parameter instanceof Timestamp) {
	                statement.setTimestamp(index, (Timestamp) parameter);
	            } else if (parameter instanceof Date) {
	                statement.setDate(index, new java.sql.Date(((Date) parameter).getTime()));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}



	@Override
	public int executeUpdate(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		int rowaffect = 0;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			rowaffect =statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return rowaffect;
	}


	@Override
	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			int count = 0;
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
	}
}
