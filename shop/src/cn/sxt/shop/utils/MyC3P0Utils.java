package cn.sxt.shop.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MyC3P0Utils {
	public static void main(String[] args) {
		System.out.println(MyC3P0Utils.getConnection());
	}
	
	private static DataSource ds;

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	static {
		ds = new ComboPooledDataSource();//直接使用即可，不用显示的配置，其会自动识别配置文件
	}

	public static DataSource getDataSource() {
		return ds;
	}

	public synchronized static Connection getConnection() {
		try {
			//得到当前线程上绑定的连接
			Connection conn = tl.get();
			if (conn == null) { // 代表线程上没有绑定连接
				conn = ds.getConnection();
				tl.set(conn);
			}
			return conn;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void startTransaction() {
		try {
			// 得到当前线程上绑定连接开启事务
			Connection conn=getConnection();
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void commitTransaction() {
		try {
			Connection conn = tl.get();
			if (conn != null) {
				conn.commit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void closeConnection() {
		try {
			Connection conn = tl.get();
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			tl.remove(); // 千万注意，解除当前线程上绑定的链接（从threadlocal容器中移除对应当前线程的链接）
		}
	}
}
