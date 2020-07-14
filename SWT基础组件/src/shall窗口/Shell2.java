package shall窗口;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  Shell2 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("主窗口");
		shell.setLayout(new RowLayout());
		
//	创建窗口中其他界面组件
//	--------
		Button button=new Button(shell, SWT.NONE);
		button .setText("打开新窗口");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
			shell.setVisible(false);
			//隐藏主窗口
			
			//创建新窗口
			final Shell newshell=new Shell(shell,SWT.CLOSE);
			newshell.setSize(327, 253);
			newshell.setText("新窗口");
			newshell.setLayout(new RowLayout());
			//监听关闭事件。当新窗口关闭时显示主窗口
			newshell.addDisposeListener(new DisposeListener() {
				
				@Override
				public void widgetDisposed(DisposeEvent e) {
					// TODO 自动生成的方法存根
					if (!shell.isVisible()) {
						shell.setVisible(true);
					}
				}
			});
			final Button visublebutton=new Button(newshell, SWT.NONE);
			visublebutton.setText("显示/隐藏主窗口");
			visublebutton.addSelectionListener(new SelectionAdapter() {
			private boolean flag=true;
			@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO 自动生成的方法存根
					shell.setVisible(flag);
					flag=!flag;
					//shell为父容器 所以new shell也隐藏
					
					//重新显示new shell
					newshell.setVisible(true);
					newshell.setActive();
					//激活
				}
			
			});
			newshell.open();
			
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
