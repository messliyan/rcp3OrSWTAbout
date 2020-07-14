/*
 *ViewerSorter.java2019��2��25��
 *
 */
package ���߰�;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import dao.PeopleEntry;

/**
 *��������
 *@author ��ѱ�
 */
public class MySorter extends ViewerSorter {
	// ÿ�ж�Ӧһ����ͬ�ĳ�����������ʾҪ�����෴����ʾҪ����
	private static final int ID = 1;
	private static final int NAME = 2;
	//�����ʹ������������
	public static final MySorter ID_ASC=new MySorter(ID);
	public static final MySorter ID_DESC=new MySorter(-ID);
	public static final MySorter NAME_ASC=new MySorter(NAME);
	public static final MySorter NAME_DESC=new MySorter(-NAME);
	// ��ǰ��Ҫ������У�ȡ�������ID��NAME��ֵ�����෴��
	private int sortType;

	// ���캯����private����ʾ�������ⲿ����MySorter����
	private MySorter(int sortType) {
	this.sortType = sortType;
	}
	

	// ��ؼ��ıȽϷ���compare����д��ViewerSorter����������ֵ��һ��intֵ��������
	//obj1�Ƶ�obj2֮ǰ������obj1��obj2��λ�ò�����������obj1�Ƶ�obj2֮��
	public int compare(Viewer viewer, Object obj1, Object obj2) {
	// ����������¼��ʵ���ࣩ��Ȼ�����и������ǵ��Ⱥ�˳��
	PeopleEntry o1 = (PeopleEntry) obj1;
	PeopleEntry o2 = (PeopleEntry) obj2;
	switch (sortType) {
	case ID: {
	Long l1 = o1.getId();
	Long l2 = o2.getId();
	// Long��compareTo��������ֵ����������ֵ1,0,-1�� 
	//��l1��l2�򷵻�1����l1��l2�򷵻�0����l1��l2�򷵻�-1
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