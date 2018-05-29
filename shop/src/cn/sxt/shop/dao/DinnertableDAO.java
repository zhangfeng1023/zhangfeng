package cn.sxt.shop.dao;

import java.util.List;



import cn.sxt.shop.entity.Dinnertable;

/**
 * ������DAO�ӿ�
 *
 */
public interface DinnertableDAO {

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
	public int editDinnerTable(Dinnertable dt);
	/**
	 *����������Ϣ
	 * @param dt
	 * @return ��Ӱ�������
	 */
	public int addDinnerTable(Dinnertable dt);
	
}
