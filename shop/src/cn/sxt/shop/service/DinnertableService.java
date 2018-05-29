package cn.sxt.shop.service;

import java.util.List;



import cn.sxt.shop.entity.Dinnertable;



/**
 * ������DAO�ӿ�
 *
 */
public interface DinnertableService {

	/**
	 * ��ѯ���еĲ�����Ϣ
	 * @return   ����List����
	 */
	public List<Dinnertable> getAll();
	
	/**
	 * ����ҳ�������IDɾ�����еĲ�����Ϣ
	 * @param id
	 * @return ��Ӱ�������
	 */
	public int removeDinnerTableByID(int id);
	
	/**
	 * �޸Ĳ�����Ϣ
	 * @param dt
	 * @return ��Ӱ�������
	 */
	public boolean editDinnerTable(Dinnertable dt);
	
	/**
	 * ����������Ϣ
	 * @param dt
	 * @return ��Ӱ�������
	 */
	
	public boolean addDinnerTable(Dinnertable dt);
	
	
	
	
}
