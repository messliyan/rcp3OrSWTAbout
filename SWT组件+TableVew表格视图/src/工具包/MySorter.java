/*
 *ViewerSorter.java2019年2月25日
 *
 */
package 工具包;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import dao.PeopleEntry;

/**
 *表格的排序
 *@author 李佳斌
 */
public class MySorter extends ViewerSorter {
	// 每列对应一个不同的常量，正数表示要升序、相反数表示要降序
	private static final int ID = 1;
	private static final int NAME = 2;
	//给外界使用排序器对象
	public static final MySorter ID_ASC=new MySorter(ID);
	public static final MySorter ID_DESC=new MySorter(-ID);
	public static final MySorter NAME_ASC=new MySorter(NAME);
	public static final MySorter NAME_DESC=new MySorter(-NAME);
	// 当前所要排序的列，取自上面的ID、NAME两值或其相反数
	private int sortType;

	// 构造函数用private，表示不能在外部创建MySorter对象
	private MySorter(int sortType) {
	this.sortType = sortType;
	}
	

	// 最关键的比较方法compare，改写自ViewerSorter。方法返回值是一个int值：正数则
	//obj1移到obj2之前；零则obj1和obj2的位置不动；负数则obj1移到obj2之后
	public int compare(Viewer viewer, Object obj1, Object obj2) {
	// 传入两条记录（实体类），然后依列给出它们的先后顺序
	PeopleEntry o1 = (PeopleEntry) obj1;
	PeopleEntry o2 = (PeopleEntry) obj2;
	switch (sortType) {
	case ID: {
	Long l1 = o1.getId();
	Long l2 = o2.getId();
	// Long的compareTo方法返回值有三个可能值1,0,-1： 
	//如l1＞l2则返回1；如l1＝l2则返回0；如l1＜l2则返回-1
	return l1.compareTo(l2);
	}
	case -ID: {
	Long l1 = o1.getId();
	Long l2 = o2.getId();
	return l2.compareTo(l1);
	}
	case NAME: {
	String s1 = o1.getName();
	String s2 = o2.getName();
	return s1.compareTo(s2);
	}
	case -NAME: {
	String s1 = o1.getName();
	String s2 = o2.getName();
	return s2.compareTo(s1);
	}
	}
	return 0;
	}
	}