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
import org.eclipse.swt.widgets.TreeItem;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  Tree树 {
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
		//创建一个Tree对象。SWT.SINLE单选，SWT.MULTI可多选
		final Tree tree=new Tree(shell, SWT.SINGLE);
		
		TreeItem chinaItem=new TreeItem(tree, SWT.NONE);
		
		chinaItem.setText("中国");
		
		new TreeItem(chinaItem, SWT.NULL).setText("北京");
		
		new TreeItem(chinaItem, SWT.NULL).setText("台湾");
		
		new TreeItem(chinaItem, SWT.NULL).setText("桂林");
		
		new TreeItem(tree, SWT.NULL).setText("美国");
		
		//当单攻击Tree的结点时，结点文字显示于窗口标题栏中
		tree.addSelectionListener(new SelectionAdapter() {
			         int i; 
					@Override
			        public void widgetSelected(SelectionEvent e) {
			        	// TODO 自动生成的方法存根
			        	
						
						TreeItem[] items=tree.getSelection();
			        	//创建Item
			        	shell.setText(items[0].getText());
			        	
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
