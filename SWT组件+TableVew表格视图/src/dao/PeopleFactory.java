/*
 *DateFactory.java2019��2��15��
 *
 */
package dao;
/**
 *
 *@author ��ѱ�
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeopleFactory {
public static List<PeopleEntry>getPeoples(){
	//��������peopleEntryʵ���� ������List�����з���
	ArrayList<PeopleEntry>list=new ArrayList<PeopleEntry>();//�����ľ�̬����
	
	
	{//��һ��ʵ����
		PeopleEntry o=new PeopleEntry();
		o.setld(new Long(1));
		o.setName("���");
		o.setSex(true);
		o.setAge(28);
		o.setCreateDate(new Date());
		list.add(o);
		
		
		
	}
	{
		PeopleEntry o=new PeopleEntry();
		o.setld(new Long(2));
		o.setName("�մ�");
		o.setSex(true);
		o.setAge(18);
		o.setCreateDate(new Date());
		list.add(o);
	}
	
	{
		PeopleEntry o=new PeopleEntry();
		o.setld(new Long(3));
		o.setName("��Ϊ");
		o.setSex(true);
		o.setAge(48);
		o.setCreateDate(new Date());
		list.add(o);
	}
	
	return list;
	
	
}
}
