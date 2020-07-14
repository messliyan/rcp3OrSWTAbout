package composition容器;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 * @author 李佳斌
 */
public class TabFolder1选项夹 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口 
		shell.setSize(500, 500);
		shell.setText("Hello Woeld"); 
//	创建窗口中其他界面组件
//	--------
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		// 定义一个TabFolder容器
		tabFolder.setBounds(6, 5, 300, 300);
		// 程序块 分割层次 且变量互不影响
		{
			TabItem item = new TabItem(tabFolder, SWT.NONE);
			// 第一个选项夹
			item.setText("Item1");
			// TabFolder中建立一个Group容器
			Group group = new Group(tabFolder, SWT.NONE);
			group.setText("Radio Group");
			item.setControl(group);
			// 选项夹和Group建立联系

			// Group上创建两个单选按钮
			Button radio1 = new Button(group, SWT.RADIO);
			radio1.setText("女");
			// 按钮上的文字
			radio1.setSelection(true);
			// 按钮处于选择状态
			radio1.setBounds(10, 50, 80, 25);
			// 设置按钮的位置
			Button radio2 = new Button(group, SWT.RADIO);
			radio2.setText("男");
			radio2.setBounds(10, 100, 80, 25);
		}
		{
			TabItem item = new TabItem(tabFolder, SWT.NONE);
			item.setText("Item2");
			//第二个选项夹
			Composite comp = new Composite(tabFolder, SWT.NONE);
			// TabFolder中建立一个Composite容器
			item.setControl(comp);
			
			//Composite创建两个文本框
			Text text = new Text(comp, SWT.BORDER);
			text.setBounds(10, 50, 80, 25);

			Text text1 = new Text(comp, SWT.BORDER);
			text1.setBounds(10, 100, 80, 25);
		}

//	————END——————
		shell.layout();// 应用界面布局
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
