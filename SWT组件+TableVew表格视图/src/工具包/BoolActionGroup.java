package 工具包;

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
 * 标签器。如果说内容器是对输入表格的数据集作处理， 那么标签器则是对数据集中的单个实体对象进行处理和转化，
 * 由标签器来决定实体对象中的字段显示在表格的哪一-列中
 * 
 * @author 李佳斌
 */
public class BoolActionGroup extends ActionGroup {
	private TableViewer tv;
	private CheckboxTableViewer ctv; //多选框

// 在Action要使用到TableViewer对象，所以通过构造函数把它传进来
	public BoolActionGroup(TableViewer tv) {
		this.tv = tv;
	}

// 生成菜单Menu，并将两个Action传入
	/*public void fillContextMenu(IMenuManager mgr) {
// 加入两个Action对象到菜单管理器
		MenuManager menuManager = (MenuManager) mgr;
		menuManager.add(new OpenAction());
		menuManager.add(new RefreshAction());
// 生成Menu并挂在表格table上。menu和table两个对象互为对方的参数
		Table table = tv.getTable();
		Menu menu = menuManager.createContextMenu(table);
		table.setMenu(menu);
	}*/

	public BoolActionGroup(TableViewer tv2, CheckboxTableViewer ctv) {
		// TODO 自动生成的构造函数存根
		 this.tv = tv2;
	        this.ctv = ctv;
		
	}

	private class AddAction extends Action {
		public AddAction() {
			 setHoverImageDescriptor(getImageDesc("database.png"));// 正常状态下的图标
			setText("增加");
		}

		public void run() {
			PeopleEntry o = createPeople();// 创建一个新实体对象
			tv.add(o);// 增加到表格界面中
			List list = (List) tv.getInput();
			list.add(o); // 增加到数据模型的List容器中
// ....向数据库增加记录（略）
		}

		private PeopleEntry createPeople() {// 创建一个新实体对象
			PeopleEntry o = new PeopleEntry();
			o.setld(5L);
			o.setName("新人");
			o.setSex(true);
			o.setAge(15);
			o.setCreateDate(new Date());
			return o;
		}
	}

	private class RemoveAction extends Action {
		public RemoveAction() {
			// setHoverImageDescriptor(getImageDesc("remove.gif"));// 正常状态下的图标
// 按钮无效状态下的图标。不设也可以，当按钮失效时会自动使正常图片变灰
			// setDisabledImageDescriptor(getImageDesc("disremove.gif"));
			setText("删除");
		}

// 这里演示了如何从表格中删除所选的多个记录
		public void run() {
			if (ctv != null) {
			     Object[ ] checkObj = ctv.getCheckedElements(); // 取得打勾的记录
			if (checkObj.length == 0) {// 判断是否有勾选复选框
			MessageDialog.openInformation(null, "提示", "请先勾选记录");
			return;
			}
			
			for (int i = 0; i < checkObj.length; i++) {
				PeopleEntry o = (PeopleEntry) checkObj[i];
				ctv.remove(o);// 从表格界面上删除
				List list = (List) tv.getInput();
				list.remove(o);// 从数据模型的List容器中删除
				// ....，从数据库中删除记录（略）
				}
				  
			}else {
				
				IStructuredSelection s = (IStructuredSelection) tv.getSelection();// 得到选择的对象集
				if (s.isEmpty()) {// 判断是否有选择
					MessageDialog.openInformation(null, "提示", "请先选择");
					return;
					}
			for (Iterator it = s.iterator(); it.hasNext();) {
				PeopleEntry o = (PeopleEntry) it.next();
				tv.remove(o);// 从表格界面上删除
				List list = (List) tv.getInput();
				list.remove(o); // 从数据模型的List容器中删除
// ....，从数据库中删除记录（略）
			}
			}
		}
	}

// 自定义方法。生成Action对象，并通过工具栏管理器ToolBarManager填充进工具栏
    private class SelectAllAction extends Action {
        public SelectAllAction() {
          //  setHoverImageDescriptor(getImageDesc("selectall.gif"));
            setText("全选");
        }
        public void run() {
            if (ctv != null) ctv.setAllChecked(true); //将所有复选框打勾
        }
}

//新增的“全不选”Action
    private class DeselectAction extends Action {
        public DeselectAction() {
           // setHoverImageDescriptor(getImageDesc("deselect.gif"));
            setText("全不选");
        }
        public void run() {
            if (ctv != null) ctv.setAllChecked(false); //取消所有复选框打勾
        }
    }

    //修改此方法将“全选”、“全不选”加入
    public void fillActionToolBars(ToolBarManager actionBarManager) {
    	// 创建Action对象，一个按钮对应一个个的Action
    	//Action refreshAction = new RefreshAction();
    	Action addAction = new AddAction();
    	Action removeAction = new RemoveAction();
    	// 将按钮通过工具栏管理器ToolBarManager填充进工具栏,如果用add(action)
    	// 也是可以的，只不过只有文字没有图像。要显示图像需要将Action包装成
    	// ActionContributionItem，在这里我们将包装的处理过程写成了一个方法
    	//actionBarManager.add(createContributionItem(refreshAction));
    	actionBarManager.add(createContributionItem(addAction));
    	actionBarManager.add(createContributionItem(removeAction));
    	actionBarManager.update(true);// 更新工具栏，否则工具栏不显示任何按钮
        Action selAllAction = new SelectAllAction();
        Action deselAction = new DeselectAction();
       
        actionBarManager.add(createContributionItem(selAllAction));
        actionBarManager.add(createContributionItem(deselAction));
        actionBarManager.update(true); // 更新工具栏，否则工具栏不显示任何按钮
    }

// 将Action包装成ActionContributionItem类的方法。实际上Action加入到
// ToolBarManager或MenuManager里时，也做了ActionContributionItem的包装，
// 大家看它ToolBarManager的add(IAction)的源代码即知
	
	//共享贡献项（IAction）
	private IContributionItem createContributionItem(IAction action) {
		ActionContributionItem aci = new ActionContributionItem(action);
		//设置表现模式
		aci.setMode(ActionContributionItem.MODE_FORCE_TEXT);// 显示图像+文字
		return aci;
	}

// 得到一个图像的ImageDescriptor对象
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