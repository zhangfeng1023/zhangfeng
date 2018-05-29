package cn.sxt.shop.dao.impl;

import java.sql.SQLException;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.sxt.shop.entity.Dinnertable;
import cn.sxt.shop.utils.ComPoolUtil;
import cn.sxt.shop.utils.MyC3P0Utils;

/**
 * 餐桌接口的实现类    DAO实现层与数据库直接打交道
 *
 */
public class DinnertableDAOImpl implements cn.sxt.shop.dao.DinnertableDAO {
	
	public List<Dinnertable> getAll() {
		
		List<Dinnertable> dinnerTables = null;
		try {
			dinnerTables = ComPoolUtil.getQueryRunner().query(
					"select  * from dinnertable",
					new BeanListHandler<Dinnertable>(Dinnertable.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dinnerTables;
	}

	public int removeDinnerTableByID(int id) {
		//创建查询器赋给数据库
		QueryRunner qr = new QueryRunner();
		String sql = "delete  from dinnertable where id = ?";
		int rowCount = 0;
		try {
			rowCount = qr.update(MyC3P0Utils.getConnection(), sql,id);	
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			MyC3P0Utils.closeConnection();
		}
		return rowCount;
	}

	public int editDinnerTable(Dinnertable dt) {
		String sql = "update  dinnertable set tablename=?,tablestatus=?,orderdate=? where id=?";
		int rowCount = 0;
		try {
			rowCount = ComPoolUtil.getQueryRunner().update(sql, dt.getTablename(),dt.getTablestatus(),dt.getOrderdate(),dt.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public int addDinnerTable(Dinnertable dt) {
		String sql = "insert  into  dinnertable(id,tablename,tablestatus,orderdate) values(?,?,?,?)";
		int rowCount = 0;
		try {
			rowCount = ComPoolUtil.getQueryRunner().update(sql,dt.getId(),dt.getTablename(),dt.getTablestatus(),dt.getOrderdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

}

