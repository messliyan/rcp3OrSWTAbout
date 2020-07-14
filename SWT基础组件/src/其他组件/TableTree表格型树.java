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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  TableTree表格型树 {
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
		//创建一个Tree对象，并显示表头和表格线
		final Tree tree=new Tree(shell, SWT.BORDER);
		
		tree.setHeaderVisible(true);
		
		tree.setLinesVisible(true);
		
		
		//加入三列
		TreeColumn col1 = new TreeColumn(tree, SWT.LEAD);
		
		col1.setText("姓名");
		
		col1.setWidth(100);
		
		TreeColumn col2 = new TreeColumn(tree, SWT.LEAD);
		
		col2.setText("职位");
		
		col2.setWidth(80);
		
		TreeColumn col3 = new TreeColumn(tree, SWT.LEAD);
		
		col3.setText("特点");
		
		col3.setWidth(100);
		
		//第一个记录树
		TreeItem Item1=new TreeItem(tree, SWT.NONE);
		
		Item1.setText("ppt项小组");
		
		createItem(Item1,"黄俊","组长","技术全面");
		
		createItem(Item1,"黄于","程序员","编程超快");
		
		createItem(Item1,"李俊","程序员","技术");
		
		createItem(Item1,"李俊","程序员","晚八点");
		
		
		//第二个记录树
		TreeItem Item2=new TreeItem(tree, SWT.NONE);
		
		Item2.setText("中国足球队");
		
		createItem(Item2,"陈刚","后勤","擦鞋很专业");
		
		
		
		//监听树的选择事件，并将所选记录的文字显示在窗口标题栏
		tree.addSelectionListener(new SelectionAdapter() {
			         int i; 
					@Override
			        public void widgetSelected(SelectionEvent e) {
			        	// TODO 自动生成的方法存根
			        	
						
						TreeItem[] items=tree.getSelection();
			        	//创建Item
						TreeItem oItem=items[0];
			        	shell.setText(oItem.getText(0)+","
						+oItem.getText(1)+","+oItem.getText(2));
			        	
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

	private static void createItem(TreeItem treeItem
			,String a,String b,String c) {
		// TODO 自动生成的方法存根
		new TreeItem(treeItem, SWT.NONE).setText(new String[] {a,b,c});
	}

}
