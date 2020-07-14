package Layout布局;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
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
public	class  FormAttachment布局数据类 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
	shell.setLayout(new FormLayout());
	Button button2 = new Button(shell, SWT.NONE);
	FormData formData=new FormData();
	formData.top=new FormAttachment(60,0);
	//距离框体上方百分之六十处
	button2.setLayoutData(formData);
	button2.setText("button2");
	
	
	Text text=new Text(shell, SWT.BORDER);
	text.setLayoutData(new	FormData(200,50));
	
	//定义并设置FormData
	FormData formData1=new FormData();
	//以text1为基准偏移60像素
	FormAttachment formAttachment=new FormAttachment(text,60);
	//FormAttachment formAttachment=new FormAttachment(text,60,SWT.LEFT);参数3为可选值
	//包括 SWT.DEFAULT	SWT.LEFT	SWT.CENTER SWT.RIGHT	SWT.TOP	SWT.BOTTOM
	formData1.top=formAttachment;
	formData1.left=formAttachment;
	//将button应用于FormData
	
	Button button4 = new Button(shell, SWT.NONE);
	button4.setText("button4");
	button4.setLayoutData(formData1);
	
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
