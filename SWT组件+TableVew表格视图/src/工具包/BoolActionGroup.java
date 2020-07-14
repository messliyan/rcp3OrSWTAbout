package ���߰�;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.actions.ActionGroup;

import dao.PeopleEntry;


/**
 * ��ǩ�������˵�������Ƕ�����������ݼ������� ��ô��ǩ�����Ƕ����ݼ��еĵ���ʵ�������д����ת����
 * �ɱ�ǩ��������ʵ������е��ֶ���ʾ�ڱ�����һ-����
 * 
 * @author ��ѱ�
 */
public class BoolActionGroup extends ActionGroup {
	private TableViewer tv;
	private CheckboxTableViewer ctv; //��ѡ��

// ��ActionҪʹ�õ�TableViewer��������ͨ�����캯������������
	public BoolActionGroup(TableViewer tv) {
		this.tv = tv;
	}

// ���ɲ˵�Menu����������Action����
	/*public void fillContextMenu(IMenuManager mgr) {
// ��������Action���󵽲˵�������
		MenuManager menuManager = (MenuManager) mgr;
		menuManager.add(new OpenAction());
		menuManager.add(new RefreshAction());
// ����Menu�����ڱ��table�ϡ�menu��table��������Ϊ�Է��Ĳ���
		Table table = tv.getTable();
		Menu menu = menuManager.createContextMenu(table);
		table.setMenu(menu);
	}*/

	public BoolActionGroup(TableViewer tv2, CheckboxTableViewer ctv) {
		// TODO �Զ����ɵĹ��캯�����
		 this.tv = tv2;
	        this.ctv = ctv;
		
	}

	private class AddAction extends Action {
		public AddAction() {
			 setHoverImageDescriptor(getImageDesc("database.png"));// ����״̬�µ�ͼ��
			setText("����");
		}

		public void run() {
			PeopleEntry o = createPeople();// ����һ����ʵ�����
			tv.add(o);// ���ӵ���������
			List list = (List) tv.getInput();
			list.add(o); // ���ӵ�����ģ�͵�List������
// ....�����ݿ����Ӽ�¼���ԣ�
		}

		private PeopleEntry createPeople() {// ����һ����ʵ�����
			PeopleEntry o = new PeopleEntry();
			o.setld(5L);
			o.setName("����");
			o.setSex(true);
			o.setAge(15);
			o.setCreateDate(new Date());
			return o;
		}
	}

	private class RemoveAction extends Action {
		public RemoveAction() {
			// setHoverImageDescriptor(getImageDesc("remove.gif"));// ����״̬�µ�ͼ��
// ��ť��Ч״̬�µ�ͼ�ꡣ����Ҳ���ԣ�����ťʧЧʱ���Զ�ʹ����ͼƬ���
			// setDisabledImageDescriptor(getImageDesc("disremove.gif"));
			setText("ɾ��");
		}

// ������ʾ����δӱ����ɾ����ѡ�Ķ����¼
		public void run() {
			if (ctv != null) {
			     Object[ ] checkObj = ctv.getCheckedElements(); // ȡ�ô򹴵ļ�¼
			if (checkObj.length == 0) {// �ж��Ƿ��й�ѡ��ѡ��
			MessageDialog.openInformation(null, "��ʾ", "���ȹ�ѡ��¼");
			return;
			}
			
			for (int i = 0; i < checkObj.length; i++) {
				PeopleEntry o = (PeopleEntry) checkObj[i];
				ctv.remove(o);// �ӱ�������ɾ��
				List list = (List) tv.getInput();
				list.remove(o);// ������ģ�͵�List������ɾ��
				// ....�������ݿ���ɾ����¼���ԣ�
				}
				  
			}else {
				
				IStructuredSelection s = (IStructuredSelection) tv.getSelection();// �õ�ѡ��Ķ���
				if (s.isEmpty()) {// �ж��Ƿ���ѡ��
					MessageDialog.openInformation(null, "��ʾ", "����ѡ��");
					return;
					}
			for (Iterator it = s.iterator(); it.hasNext();) {
				PeopleEntry o = (PeopleEntry) it.next();
				tv.remove(o);// �ӱ�������ɾ��
				List list = (List) tv.getInput();
				list.remove(o); // ������ģ�͵�List������ɾ��
// ....�������ݿ���ɾ����¼���ԣ�
			}
			}
		}
	}

// �Զ��巽��������Action���󣬲�ͨ��������������ToolBarManager����������
    private class SelectAllAction extends Action {
        public SelectAllAction() {
          //  setHoverImageDescriptor(getImageDesc("selectall.gif"));
            setText("ȫѡ");
        }
        public void run() {
            if (ctv != null) ctv.setAllChecked(true); //�����и�ѡ���
        }
}

//�����ġ�ȫ��ѡ��Action
    private class DeselectAction extends Action {
        public DeselectAction() {
           // setHoverImageDescriptor(getImageDesc("deselect.gif"));
            setText("ȫ��ѡ");
        }
        public void run() {
            if (ctv != null) ctv.setAllChecked(false); //ȡ�����и�ѡ���
        }
    }

    //�޸Ĵ˷�������ȫѡ������ȫ��ѡ������
    public void fillActionToolBars(ToolBarManager actionBarManager) {
    	// ����Action����һ����ť��Ӧһ������Action
    	//Action refreshAction = new RefreshAction();
    	Action addAction = new AddAction();
    	Action removeAction = new RemoveAction();
    	// ����ťͨ��������������ToolBarManager����������,�����add(action)
    	// Ҳ�ǿ��Եģ�ֻ����ֻ������û��ͼ��Ҫ��ʾͼ����Ҫ��Action��װ��
    	// ActionContributionItem�����������ǽ���װ�Ĵ������д����һ������
    	//actionBarManager.add(createContributionItem(refreshAction));
    	actionBarManager.add(createContributionItem(addAction));
    	actionBarManager.add(createContributionItem(removeAction));
    	actionBarManager.update(true);// ���¹����������򹤾�������ʾ�κΰ�ť
        Action selAllAction = new SelectAllAction();
        Action deselAction = new DeselectAction();
       
        actionBarManager.add(createContributionItem(selAllAction));
        actionBarManager.add(createContributionItem(deselAction));
        actionBarManager.update(true); // ���¹����������򹤾�������ʾ�κΰ�ť
    }

// ��Action��װ��ActionContributionItem��ķ�����ʵ����Action���뵽
// ToolBarManager��MenuManager��ʱ��Ҳ����ActionContributionItem�İ�װ��
// ��ҿ���ToolBarManager��add(IAction)��Դ���뼴֪
	
	//�������IAction��
	private IContributionItem createContributionItem(IAction action) {
		ActionContributionItem aci = new ActionContributionItem(action);
		//���ñ���ģʽ
		aci.setMode(ActionContributionItem.MODE_FORCE_TEXT);// ��ʾͼ��+����
		return aci;
	}

// �õ�һ��ͼ���ImageDescriptor����
	private ImageDescriptor getImageDesc(String fileName) {
		try {
			URL url = new URL("file:icons/" + fileName);
			return ImageDescriptor.createFromURL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}