package com.renren.api.sdk;

import java.io.IOException;
import java.net.SocketAddress;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.sql.Connection;
import com.renren.api.thrift.ConnectionInfo;
import com.renren.api.thrift.ConnectionService;
import com.sun.org.apache.xml.internal.dtm.ref.NodeLocator;

public class RaeMySQLClient implements Statement {
	public RaeMySQLClient mysqlClient;
	public String app_key = "";
//	public static String THRISERVERIP = "10.32.16.81";
	public static String THRISERVERIP = "125.39.95.81";
	public Statement stat;

	public RaeMySQLClient(String app_key) throws TException,
			NumberFormatException, IOException, ClassNotFoundException,
			SQLException {
		this.app_key = app_key;
		List<ConnectionInfo> conns = getConnections(this.app_key);
		ConnectionInfo conifo = conns.get(0);
		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql://"
//				+ conifo.getAddress() + ":" + Integer.valueOf(conifo.getPort())
//				+ "/db20120113", conifo.getUsername(), conifo.getUsername());
		Connection con = DriverManager.getConnection("jdbc:mysql://"
		+ "125.39.95.95" + ":" + 3306
		+ "/db20120113", "rae", "rae");
		this.stat = con.createStatement();

	}

	private List<ConnectionInfo> getConnections(String app_key)
			throws TException {
		TTransport transport = new TSocket(THRISERVERIP, 7911);
		System.out.println("Cnnect to Thrift Server " + THRISERVERIP + " port "
				+ 7911);
		TProtocol protocol = new TCompactProtocol(transport);
		ConnectionService.Client client = new ConnectionService.Client(protocol);
		transport.open();
		List<ConnectionInfo> infos = client
				.getConnection(app_key, "mysql" /* service type */);
		transport.close();
		return infos;
	}

	@Override
	public void addBatch(String sql) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel() throws SQLException {
		this.stat.cancel();

	}

	@Override
	public void clearBatch() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws SQLException {
		this.stat.close();

	}

	@Override
	public boolean execute(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return stat.execute(sql);
	}

	@Override
	public boolean execute(String sql, int autoGeneratedKeys)
			throws SQLException {
		return this.stat.execute(sql, autoGeneratedKeys);
	}

	@Override
	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		return this.stat.execute(sql, columnIndexes);
	}

	@Override
	public boolean execute(String sql, String[] columnNames)
			throws SQLException {
		return this.stat.execute(sql, columnNames);
	}

	@Override
	public int[] executeBatch() throws SQLException {
		return null;
	}

	@Override
	public ResultSet executeQuery(String sql) throws SQLException {
		return this.stat.executeQuery(sql);
	}

	@Override
	public int executeUpdate(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(String sql, int[] columnIndexes)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(String sql, String[] columnNames)
			throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFetchDirection() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFetchSize() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxRows() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getMoreResults(int current) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getQueryTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getResultSetType() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUpdateCount() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPoolable() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCursorName(String name) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEscapeProcessing(boolean enable) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxFieldSize(int max) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxRows(int max) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPoolable(boolean poolable) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setQueryTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String args[]) throws ClassNotFoundException,
			SQLException {
		RaeMySQLClient rae = null;
		try {
			rae = new RaeMySQLClient("sadfsadgdsfsaxfsdaewrwdfsadf");
			ResultSet rs = rae.executeQuery("show tables");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Integer age = rs.getObject("age") == null ? null : rs
						.getInt("age");
				System.out.println(id + ": " + name + " " + age);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != rae) {
				rae.close();
			}
		}

	}
}
