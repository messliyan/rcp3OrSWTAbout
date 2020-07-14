package 其他组件;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  ToolBar工具栏 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
	shell.setLayout(new FillLayout());
	//用viewform作为底层容器，并充满型布局
	ViewForm viewForm=new ViewForm(shell, SWT.NONE);
	viewForm.setLayout(new FillLayout());
	
	//在viewForm容器中创建文本框
	final Text text=new Text(viewForm, SWT.BORDER|SWT.WRAP|SWT.V_SCROLL);
	viewForm.setContent(text);
	//设置文本框为ViewForm的主组件
	
	//在ViewForm容器里创建工具栏，并添加按钮事件
	ToolBar toolBar=new ToolBar(viewForm, SWT.NONE);
	ToolItem getItem = new ToolItem(toolBar, SWT.NONE);
	getItem.setText("取得");
	//getItem.setImage(new Image(display, "") );
	//第二参数为相对路径
	getItem.addSelectionListener(new SelectionAdapter() {
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO 自动生成的方法存根
			String string=text.getText();
		MessageDialog.openInformation(null	, null, string);
	}
	
	});
	ToolItem clearItem = new ToolItem(toolBar, SWT.PUSH);
	clearItem.setText("清除");
	//clearItem.setImage(new Image(display, ""));
	clearItem.addSelectionListener(new SelectionAdapter() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			// TODO 自动生成的方法存根
			text.setText("");
			//清除文本的文字
		}
	});
	viewForm.setTopLeft(toolBar);
	//设置工具栏在viewForm中位置为顶端靠左 
	//此句必须放在toolBar构建完成之后
	
//	————END——————
	//	shell.layout();// 应用界面布局
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
