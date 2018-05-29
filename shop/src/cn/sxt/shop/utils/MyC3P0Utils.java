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
		ds = new ComboPooledDataSource();//ֱ��ʹ�ü��ɣ�������ʾ�����ã�����Զ�ʶ�������ļ�
	}

	public static DataSource getDataSource() {
		return ds;
	}

	public synchronized static Connection getConnection() {
		try {
			//�õ���ǰ�߳��ϰ󶨵�����
			Connection conn = tl.get();
			if (conn == null) { // �����߳���û�а�����
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
			// �õ���ǰ�߳��ϰ����ӿ�������
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
			tl.remove(); // ǧ��ע�⣬�����ǰ�߳��ϰ󶨵����ӣ���threadlocal�������Ƴ���Ӧ��ǰ�̵߳����ӣ�
		}
	}
}
