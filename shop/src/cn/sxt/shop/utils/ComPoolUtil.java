package cn.sxt.shop.utils;



import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ComPoolUtil {

	static ComboPooledDataSource dataSource = null;
	
	static{
		//��ʼ�����ӳصĶ���
		dataSource  = new ComboPooledDataSource();  //���ص���default-config 
		
//		dataSource  = new ComboPooledDataSource("oracleConfig");  //���ص���Oracle-config 
		
	}
	
	
	//����DBUtil �ĺ��Ŀ�����  QueryRunner
	public static QueryRunner getQueryRunner(){
		//���Ŀ�����
		QueryRunner runner = new QueryRunner(dataSource);
		
		return runner;
	}
	
	public static void main(String[] args) {
//		QueryRunner runner = new QueryRunner(dataSource);
		try {
			Connection conn = dataSource.getConnection();
			
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
