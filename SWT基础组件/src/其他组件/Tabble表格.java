package 其他组件;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  Tabble表格 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello World");
//	创建窗口中其他界面组件
//	--------
		shell.setLayout(new FillLayout());
		//创建一个 可多选 的表格 ，并设置它显示表头和表格线
		final Table table=new Table(shell, SWT.MULTI|SWT.FULL_SELECTION);
		
		table.setHeaderVisible(true);
		
		table.setLinesVisible(true);
		//为table增加两列并设置列宽都是80
		TableColumn col1=new TableColumn(table, SWT.NONE);
		
		col1.setText("ID");
		
		col1.setWidth(80);
		
		TableColumn col2=new TableColumn(table, SWT.NONE);
		
		col2.setText("姓名");
		
		col2.setWidth(80);
		
		//创建一个Composite容器，并放入两个按钮
		Composite composite=new Composite(shell, SWT.NONE);
		
		composite.setLayout(new RowLayout());
		
		Button addButtonm=new Button(composite, SWT.NONE);
		
		addButtonm.setText("新增");
		addButtonm.addSelectionListener(new SelectionAdapter() {
			         int i; 
					@Override
			        public void widgetSelected(SelectionEvent e) {
			        	// TODO 自动生成的方法存根
			        	TableItem item=new TableItem(table, 0);
			        	//创建Item
			        	item.setText(new String[]{""+i,"陈刚"+i});
			        	//给Item设置
			        	i++;
					}
		});
			
		Button removeButtonm=new Button(composite, SWT.NONE);
		
		removeButtonm.setText("删除");
		
		removeButtonm.addSelectionListener(new SelectionAdapter() {
			         int i; 
					@Override
			        public void widgetSelected(SelectionEvent e) {
			        	// TODO 自动生成的方法存根
			        	int [] selinices=table.getSelectionIndices();
			        	//得到所有被选择记录的序号，然后根据序号将记录删除
			        	table.remove(selinices);
					}
		});
		//监听Table的鼠标双击事件，并显示被双击的记录
		table.addMouseListener(new org.eclipse.swt.events.MouseAdapter() {

		@Override
		public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
			// TODO 自动生成的方法存根
			int sellndex =table.getSelectionIndex();
			
			TableItem item=table.getItem(sellndex);
			
			String string="列 1="+item.getText(0)+"\t列 2="+item.getText(1);
			MessageDialog.openInformation(null, null, string);
			
			
		}
		
		});
		
//	————END——————
		//shell.layout();// 应用界面布局
		shell.open();// 打开shell主窗口
		while (!shell.isDisposed()) {// 如果主窗口没有关闭
//			则一直循环
			if (!display.readAndDispatch()) {// 如果display不忙，
//				就让display处于休眠
				display.sleep();
			}
		}
		display.sleep();

	}

}
