/*
 *treeviewercontentProvider.java2019��2��15��
 *
 */
package ���߰�;

import java.util.List;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * ���������ɴ�������뵽�������ݽ���ɸѡ��ת��������Ҫʵ�ֽӿڵ�3�ַ����� ����getElements����Ҫ�����������������������õ�����ʵ�־�����
 * 
 * @author ��ѱ�
 */
public class TableViewerContentProvider implements IStructuredContentProvider {

	// �����뵽�������ݼ��Ͻ���ɸѡ��ת������������ݼ�ȫ��Ҫת�������飬ÿһ������Ԫ��
	// ����һ��ʵ�������Ҳ���Ǳ���е�һ����¼
	public Object[] getElements(Object element) {
		// ����element����ͨ��setinput(Object input)����Ķ���input
		// �����������setInput��List����
		if (element instanceof List)// ��һ��List�����ж�
			return ((List) element).toArray(); // �����ݼ�Listת��Ϊ����

		else
			return new Object[0]; // ���List�����򷵻�һ��������
	}

	// ��TableViewer���󱻹ر�ʱ����ִ�д˷���
	public void dispose() {
	}

	// ��TableViewer �ٴε���setInput()ʱ����ִ�д˷���

}
