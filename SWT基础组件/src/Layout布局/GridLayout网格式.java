package Layout布局;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019年1月28日
 *
 */
/**
 * 	
 *@author 李佳斌
 */
public	class  GridLayout网格式 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
		GridLayout gridLayout=new GridLayout(2,false);
		shell.setLayout(gridLayout);
		new Button(shell, SWT.NONE).setText("确      定");
		new Button(shell, SWT.NONE).setText("取消");
		new Button(shell, SWT.NONE).setText("帮助");
		new Button(shell, SWT.NONE).setText("b3"); 
		new Button(shell, SWT.NONE).setText("button2");
		new Button(shell, SWT.NONE).setText("button4");
		new Button(shell, SWT.NONE).setText("button5");
	
//	————END——————
//		shell.layout();// 应用界面布局
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
