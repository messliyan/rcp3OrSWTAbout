package ���߰�;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.actions.*;

import dao.PeopleEntry;
/**
 *�˵���
 *@author ��ѱ�
 */
public class MyActionGroup extends ActionGroup {
	private TableViewer tv;

// ��ActionҪʹ�õ�TableViewer��������ͨ�����캯������������
	public MyActionGroup(TableViewer tv) {
		this.tv = tv;
	}

// ���ɲ˵�Menu����������Action����
	public void fillContextMenu(IMenuManager mgr) {
// ��������Action���󵽲˵�������
		MenuManager menuManager = (MenuManager) mgr;
		menuManager.add(new OpenAction());
		menuManager.add(new RefreshAction());
// ����Menu�����ڱ��table�ϡ�menu��table��������Ϊ�Է��Ĳ���
		Table table = tv.getTable();
		Menu menu = menuManager.createContextMenu(table);
		table.setMenu(menu);
	}

// ���򿪡���Action��
	private class OpenAction extends Action {
		public OpenAction() {
			setText("��");
		}

		public void run() {// �̳���Action�ķ�������������д�ڴ˷�����
			IStructuredSelection selection = (IStructuredSelection) tv.getSelection();
			PeopleEntry o = (PeopleEntry) selection.getFirstElement();
			if (o == null)
				MessageDialog.openInformation(null, null, "����ѡ���¼");
			else
				MessageDialog.openInformation(null, null, o.getName());
		}
	}

// ��ˢ�¡���Action��
	private class RefreshAction extends Action {
		public RefreshAction() {
			setText("ˢ��");
		}

		public void run() {
			tv.refresh(); // ����ˢ�·�������������¶�ȡ���ݲ���ʾ
		}
	}
}