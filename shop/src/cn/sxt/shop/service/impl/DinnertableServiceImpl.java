package cn.sxt.shop.service.impl;

import java.util.List;

import cn.sxt.shop.dao.DinnertableDAO;
import cn.sxt.shop.dao.impl.DinnertableDAOImpl;
import cn.sxt.shop.entity.Dinnertable;
import cn.sxt.shop.service.DinnertableService;
/**
 * 
 *  餐桌业务层实现类
 *
 */
public class DinnertableServiceImpl implements DinnertableService {
	DinnertableDAO dao = new DinnertableDAOImpl();
	
	public List<Dinnertable> getAll() {
		
		return dao.getAll();
	}

	public int removeDinnerTableByID(int id) {
		return dao.removeDinnerTableByID(id);
	}

	public boolean editDinnerTable(Dinnertable dt) {
		return dao.editDinnerTable(dt)>0?true:false;
	}

	public boolean addDinnerTable(Dinnertable dt) {
		return dao.addDinnerTable(dt)>0?true:false;
	}

}
