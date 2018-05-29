package cn.sxt.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.sxt.shop.entity.Dinnertable;
import cn.sxt.shop.service.DinnertableService;

/**
 * 单元测试Junit测试使用的步骤
 * 1.导入Junit.jar包
 * 2.写一个void类型无参方法
 * 在方法上面打上一个@Test注释
 * @author Administrator
 */
public class DinnertableServiceImplTest {
	DinnertableService service= new DinnertableServiceImpl();
	
	@Test
	public void getAll(){//测试所以餐桌全部信息
		List<Dinnertable> tables = service.getAll();
		System.out.println(tables);
		for(Dinnertable tableName : tables){
			System.out.println("餐桌id="+tableName.getTablename());
		}
		System.out.println("查询成功");
	}
	
//	@Test
//	public void removeDinnerTableByID(){//根据id删除餐桌信息
//		int id = 13;
//		int count = service.removeDinnerTableByID(id);
//		System.out.println(count);
//		System.out.println("删除成功");
//	}
//	
//	@Test
//	public void editDinnerTable(){//修改餐桌信息
//		//获得当前系统时间
//		Date date = new Date();
//		Dinnertable dt = new Dinnertable(15,"成都",0,date);
//		boolean bool = service.editDinnerTable(dt);
//		System.out.println("业务层返回的值："+bool);
//		if(bool){
//			System.out.println("修改成功");
//		}
//	
//	}
//	
	@Test
	public void addDinnerTable(){//新增餐桌信息
		//获得当前系统时间
		Date date = new Date();
		Dinnertable dt = new Dinnertable(11,"北京",0,date);
		boolean bool = service.addDinnerTable(dt);
		System.out.println(bool);
		if(bool){
			System.out.println("新增成功");
		}
	}
}
