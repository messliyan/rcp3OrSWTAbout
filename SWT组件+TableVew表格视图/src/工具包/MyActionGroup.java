package 工具包;

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
 *菜单类
 *@author 李佳斌
 */
public class MyActionGroup extends ActionGroup {
	private TableViewer tv;

// 在Action要使用到TableViewer对象，所以通过构造函数把它传进来
	public MyActionGroup(TableViewer tv) {
		this.tv = tv;
	}

// 生成菜单Menu，并将两个Action传入
	public void fillContextMenu(IMenuManager mgr) {
// 加入两个Action对象到菜单管理器
		MenuManager menuManager = (MenuManager) mgr;
		menuManager.add(new OpenAction());
		menuManager.add(new RefreshAction());
// 生成Menu并挂在表格table上。menu和table两个对象互为对方的参数
		Table table = tv.getTable();
		Menu menu = menuManager.createContextMenu(table);
		table.setMenu(menu);
	}

// “打开”的Action类
	private class OpenAction extends Action {
		public OpenAction() {
			setText("打开");
		}

		public void run() {// 继承自Action的方法，动作代码写在此方法中
			IStructuredSelection selection = (IStructuredSelection) tv.getSelection();
			PeopleEntry o = (PeopleEntry) selection.getFirstElement();
			if (o == null)
				MessageDialog.openInformation(null, null, "请先选择记录");
			else
				MessageDialog.openInformation(null, null, o.getName());
		}
	}

// “刷新”的Action类
	private class RefreshAction extends Action {
		public RefreshAction() {
			setText("刷新");
		}

		public void run() {
			tv.refresh(); // 表格的刷新方法，界面会重新读取数据并显示
		}
	}
}