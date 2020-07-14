/*
 *HollowWorld.java2019年1月25日
 *
 */
package mywat;



import java.util.List;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;

import dao.PeopleEntry;
import dao.PeopleFactory;
import 工具包.BoolActionGroup;
import 工具包.MyActionGroup;
import 工具包.MySorter;
import 工具包.TableViewerContentProvider;
import 工具包.TableViewerlabelProvider;

/**
 *
 * @author 李佳斌
 */
public class TbaleView {
	public static void main(String[] args) {
		
		open () ;
		
	}
		
	public static void open () {
		// TODO 自动生成的方法存根
		final Display display = new Display();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell=new Shell();
//		shell程序主窗口
	shell.setSize(727,553);
	//shell.setText("Company");
//	创建窗口中其他界面组件
	
	shell.setLayout(new FillLayout());
	ViewForm viewForm = new ViewForm(shell, SWT.NONE); //布局基座ViewForm
	viewForm.setLayout(new FillLayout());
	 TableViewer tv = new TableViewer(viewForm, SWT.CHECK | SWT.MULTI ); //父容器由shell改为viewForm

	final CheckboxTableViewer ctv = new CheckboxTableViewer(tv.getTable());
	//……和上一节相同的代码（省略）
	//创建工具栏
	ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT); // 创建一个ToolBar容器
	ToolBarManager toolBarManager = new ToolBarManager(toolBar); // 创建一个toolBar的管理器
	

	//第一步:创建一个TableViewer对象。式样:MULTI可多选、H SCROLL有水平滚动条、
	//V_ SCROLI1有垂直滚动条、BORDER有边框、FULL SELECTION整行选择

	/*TableViewer tv=new TableViewer(shell, SWT.MULTI |SWT.BORDER|SWT.FULL_SELECTION);
	//第二步:通过表格内含的Table对象设置布局方式
*/	Table table = tv.getTable();

	table.setHeaderVisible(true); //显示表头
	table.setLinesVisible(true); //显示表格线

	TableLayout layout = new TableLayout(); //专用于表格的布局
	table.setLayout(layout);

	//第三步:用TableColumn类创建表格列

	/*layout.addColumnData(new ColumnWeightData(13));
	// ID列宽13像素
	new TableColumn(table, SWT.NONE).setText("ID号");
	
	layout.addColumnData(new ColumnWeightData(40));
	
	new TableColumn(table, SWT.NONE).setText("姓名");
	
	layout.addColumnData(new ColumnWeightData(20));
	
	new TableColumn(table, SWT.NONE).setText("性别");
	
	layout.addColumnData(new ColumnWeightData(20));
	
	new TableColumn(table, SWT.NONE).setText("年龄");

	  layout.addColumnData(new ColumnWeightData(60));

      new TableColumn(table, SWT.NONE).setText("记录建立时间");*/
	//为表格列添加排序事件监听器
	layout.addColumnData(new ColumnWeightData(13));
	TableColumn col1 = new TableColumn(table, SWT.NONE);
	col1.setText("ID号");
	col1.addSelectionListener(new SelectionAdapter() {
	boolean asc = true; // 记录上一次的排序方式，默认为升序
	public void widgetSelected(SelectionEvent e) {
	// asc=true则ID的升序排序器，否则用降序
	tv.setSorter(asc ? MySorter.ID_ASC : MySorter.ID_DESC);
	asc = !asc;// 得到下一次排序方式
	}
	});
	
	layout.addColumnData(new ColumnWeightData(40));
	TableColumn col2 = new TableColumn(table, SWT.NONE);
	col2.setText("姓名");
	col2.addSelectionListener(new SelectionAdapter() {
	boolean asc = true;
	public void widgetSelected(SelectionEvent e) {
	tv.setSorter(asc ? MySorter.NAME_ASC : MySorter.NAME_DESC);
	asc = !asc;
	}
	});
      // 第四步 ：设置内容器和标签器

      tv.setContentProvider(new TableViewerContentProvider());
      tv.setLabelProvider(new TableViewerlabelProvider());
      addListener(tv);
      

    //生成一个ActionGroup对象，并调用fillContextMenu方法将按钮注入到菜单对象中
    MyActionGroup actionGroup = new MyActionGroup(tv); 
    actionGroup.fillContextMenu(new MenuManager());
      //第五步：用TableView的setInput方法将数据输入表格
      Object data = PeopleFactory.getPeoples();
      tv.setInput(data);
      BoolActionGroup boolGroup = new BoolActionGroup(tv,ctv); 
      boolGroup.fillActionToolBars(toolBarManager); //将Action通过toolBarManager注入ToolBar中
  	// 设置表格和工具栏在布局中的位置
  	viewForm.setContent(tv.getControl()); // 主体：表格
  	viewForm.setTopLeft(toolBar); 
	
//	————END——————
	//shell.layout();//应用界面布局

// 顶端边缘：工具栏
shell.open();
		while (!shell.isDisposed()) {//如果主窗口没有关闭
//			则一直循环
			if (!display.readAndDispatch()) //如果display不忙，
//				就让display处于休眠
				display.sleep();
			
		
	}
		display.dispose();
	}
	 private static void addListener(TableViewer tv) {
	    	// 鼠标双击事件监听
	    	tv.addDoubleClickListener(new IDoubleClickListener() {
	    	public void doubleClick(DoubleClickEvent event) {
	    	//得到表格的选择对象，里面封装了表格中被选择的记录信息
	    	IStructuredSelection selection = (IStructuredSelection) event.getSelection();
	    	// 得到所选择的第一条实体对象（表格可以有多选），并进行类型转换
	    	PeopleEntry o = (PeopleEntry) selection.getFirstElement();
	    	// 弹出一个提示框
	    	MessageDialog.openInformation(null, "提示", o.getName());
	    	}
	    	});

	    	// 选择事件（单击）监听
	    	tv.addSelectionChangedListener(new ISelectionChangedListener() {
	    	public void selectionChanged(SelectionChangedEvent event) {
	    	// 事件处理代码……（略）
	    	}
	    	});
	    	}
}
