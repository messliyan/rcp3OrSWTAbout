package 其他组件;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
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
public	class  CoolBar动态工具栏 {
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
	final	ViewForm viewForm=new ViewForm(shell, SWT.NONE);
	viewForm.setLayout(new FillLayout());
	
	//在viewForm容器中创建文本框
	final Text text=new Text(viewForm, SWT.BORDER|SWT.V_SCROLL);
	viewForm.setContent(text);
	//设置文本框为ViewForm的主组件
	
	//
	CoolBar coolBar=new CoolBar(viewForm, SWT.NONE);
	{
		//在ViewForm容器里创建工具栏，并添加按钮事件
		ToolBar toolBar=new ToolBar(coolBar, SWT.NONE);
		ToolItem getItem = new ToolItem(toolBar, SWT.PUSH);
		getItem.setText("取得");
		
		ToolItem clearItem = new ToolItem(toolBar, SWT.PUSH);
		clearItem.setText("清除");
		
		CoolItem coolItem=new CoolItem(coolBar, SWT.NONE);
		coolItem.setControl(toolBar);
		//
		toolBar.pack();
		Point size=toolBar.getSize();
		coolItem.setSize(size);
		coolItem.setMinimumSize(size);
	}
	
	{
		ToolBar toolBar=new ToolBar(coolBar, SWT.NONE);
		ToolItem toolItem = new ToolItem(toolBar, SWT.PUSH);
		//toolItem.setText("取得");
		
//		ToolItem clearItem = new ToolItem(toolBar, SWT.PUSH);
//		clearItem.setText("清除");
		CoolItem coolItem=new CoolItem(coolBar, SWT.NONE);
		coolItem.setControl(toolBar);
		//
		toolBar.pack();
		Point size=toolBar.getSize();
		coolItem.setSize(size);
		coolItem.setMinimumSize(size);
	}
	viewForm.setTopLeft(coolBar);
	
	
	coolBar.addControlListener(new ControlAdapter() {
		@Override
		public void controlResized(ControlEvent e) {
			// TODO 自动生成的方法存根
			viewForm.layout();
		}
	});
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
