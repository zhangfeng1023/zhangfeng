package cn.sxt.shop.service;

import java.util.List;



import cn.sxt.shop.entity.Dinnertable;



/**
 * 餐桌的DAO接口
 *
 */
public interface DinnertableService {

	/**
	 * 查询所有的餐桌信息
	 * @return   餐桌List集合
	 */
	public List<Dinnertable> getAll();
	
	/**
	 * 根据页面过来的ID删除所有的餐桌信息
	 * @param id
	 * @return 受影响的行数
	 */
	public int removeDinnerTableByID(int id);
	
	/**
	 * 修改餐桌信息
	 * @param dt
	 * @return 受影响的行数
	 */
	public boolean editDinnerTable(Dinnertable dt);
	
	/**
	 * 新增餐桌信息
	 * @param dt
	 * @return 受影响的行数
	 */
	
	public boolean addDinnerTable(Dinnertable dt);
	
	
	
	
}
