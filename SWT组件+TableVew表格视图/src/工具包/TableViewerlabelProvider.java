/*
 *TreeViewerLabelProvider.java2019��2��15��
 *
 */
package ���߰�;

import java.security.KeyStore.Entry;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import dao.PeopleEntry;



/**
 *��ǩ�������˵�������Ƕ�����������ݼ�������
	��ô��ǩ�����Ƕ����ݼ��еĵ���ʵ�������д����ת����
	�ɱ�ǩ��������ʵ������е��ֶ���ʾ�ڱ�����һ-����
 *@author ��ѱ�
 */
public class TableViewerlabelProvider implements ITableLabelProvider {

	
	//��������ͼ��
	/*private Image[] images = new Image[] {
			new Image(null, "icons/refresh.gif"),
			new Image(null, "icons/starjpg"),
			new Image(null, "icons/moon.jpg")};*/
	//�ɴ˷����������ݼ�¼�ڱ���ÿһ����ʾʲô���֡�
	//element ������һ��ʵ�������  col�ǵ�ǰҪ���õ��е��кţ�0�ǵ�һ��
	public String getColumnText(Object element, int col) {
	PeopleEntry o = (PeopleEntry) element; //����ת��
	if (col== 0)//��1��Ҫ��ʾʲô����
	return o.getld().toString();
	if(col== 1)
	return o.getName();
	if(col== 2) 
	return o.isSex() ?"��":"Ů";
	
	if(col == 3)
	return String.valueOf(o.getAge()); //��int��תΪString ��
	if(col== 4)
	return o.getCreateDate().toString();
	return null; //�������Է��ؿ�ֵ

	}
	//getColumnText����������ʾ���֣�������������ʾͼƬ
	/*public Image getColumnlmage(Object element, int col) {
		PeopleEntry o = (PeopleEntry) element;
		//ֻ�á��¸ա�������¼��ʾͼƬ
	if (o.getName().equals("�¸�")
	||o.getName().equals("����")) {
	if(col== 0)//1��һ��Ҫ��ʾ��ͼƬ
	return images[0];
	if (col == 2)//�����Ա���ʾ��ͬ��ͼ��
	return o.isSex() ? images[1] : images[2];

	}
	return null; //�������Է��ؿ�ֵ

	}
	//��TableViewer ���󱻹ر�ʱ����ִ�д˷���
	public void dispose() {
	//������SWT�����ԭ��:�Լ����������ͷ�
		for (Image image : images) {
			image.dispose();
		}
	}*/
	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO �Զ����ɵķ������
		return false;
	}
	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO �Զ����ɵķ������
		
	}
	
	@Override
	public void dispose() {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO �Զ����ɵķ������
		return null;
	}
	
}

