package Layout布局;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
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
public	class  RowLayout行列式 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
		RowLayout rowLayout=new RowLayout();
		shell.setLayout(rowLayout);
		rowLayout.marginWidth=20;
		
		rowLayout.marginHeight=10;
		rowLayout.spacing=15;
		//rowLayout.type=SWT.VERTICAL;//竖着排列
		//rowLayout.wrap=false;		//取消自动换行
		//	rowLayout.pack=false;//按钮大小相同
			rowLayout.justify=true;//一起随空间拉伸
		new Button(shell, SWT.NONE).setText("确      定");
		
		new Button(shell, SWT.NONE).setText("取消");
		Button button=new Button(shell, SWT.NONE);
		button.setText("存在");
		RowData rowData=new RowData(99,49);
		rowData.exclude=true;
		button.setLayoutData(rowData);
		new Button(shell, SWT.NONE).setText("帮助");
		
	
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
