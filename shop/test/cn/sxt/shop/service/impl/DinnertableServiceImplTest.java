package cn.sxt.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.sxt.shop.entity.Dinnertable;
import cn.sxt.shop.service.DinnertableService;

/**
 * ��Ԫ����Junit����ʹ�õĲ���
 * 1.����Junit.jar��
 * 2.дһ��void�����޲η���
 * �ڷ����������һ��@Testע��
 * @author Administrator
 */
public class DinnertableServiceImplTest {
	DinnertableService service= new DinnertableServiceImpl();
	
	@Test
	public void getAll(){//�������Բ���ȫ����Ϣ
		List<Dinnertable> tables = service.getAll();
		System.out.println(tables);
		for(Dinnertable tableName : tables){
			System.out.println("����id="+tableName.getTablename());
		}
		System.out.println("��ѯ�ɹ�");
	}
	
//	@Test
//	public void removeDinnerTableByID(){//����idɾ��������Ϣ
//		int id = 13;
//		int count = service.removeDinnerTableByID(id);
//		System.out.println(count);
//		System.out.println("ɾ���ɹ�");
//	}
//	
//	@Test
//	public void editDinnerTable(){//�޸Ĳ�����Ϣ
//		//��õ�ǰϵͳʱ��
//		Date date = new Date();
//		Dinnertable dt = new Dinnertable(15,"�ɶ�",0,date);
//		boolean bool = service.editDinnerTable(dt);
//		System.out.println("ҵ��㷵�ص�ֵ��"+bool);
//		if(bool){
//			System.out.println("�޸ĳɹ�");
//		}
//	
//	}
//	
	@Test
	public void addDinnerTable(){//����������Ϣ
		//��õ�ǰϵͳʱ��
		Date date = new Date();
		Dinnertable dt = new Dinnertable(11,"����",0,date);
		boolean bool = service.addDinnerTable(dt);
		System.out.println(bool);
		if(bool){
			System.out.println("�����ɹ�");
		}
	}
}
