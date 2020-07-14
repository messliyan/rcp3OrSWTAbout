/*
 *DateFactory.java2019年2月15日
 *
 */
package dao;
/**
 *
 *@author 李佳斌
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeopleFactory {
public static List<PeopleEntry>getPeoples(){
	//创建三个peopleEntry实体类 并加入List集合中返回
	ArrayList<PeopleEntry>list=new ArrayList<PeopleEntry>();//工厂的静态方法
	
	
	{//第一个实体类
		PeopleEntry o=new PeopleEntry();
		o.setld(new Long(1));
		o.setName("李刚");
		o.setSex(true);
		o.setAge(28);
		o.setCreateDate(new Date());
		list.add(o);
		
		
		
	}
	{
		PeopleEntry o=new PeopleEntry();
		o.setld(new Long(2));
		o.setName("刚大");
		o.setSex(true);
		o.setAge(18);
		o.setCreateDate(new Date());
		list.add(o);
	}
	
	{
		PeopleEntry o=new PeopleEntry();
		o.setld(new Long(3));
		o.setName("李为");
		o.setSex(true);
		o.setAge(48);
		o.setCreateDate(new Date());
		list.add(o);
	}
	
	return list;
	
	
}
}
