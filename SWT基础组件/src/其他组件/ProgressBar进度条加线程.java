package 其他组件;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  ProgressBar进度条加线程 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
		shell.setLayout(new RowLayout());
		
			
		final ProgressBar progree=new ProgressBar(shell, SWT.SMOOTH);
		//创建进度条。这里用平滑式样SWT.SMOOTH，默认为方格型
		progree.setMinimum(0);
		//最小值
		progree.setMaximum(100);
		//最大值
		
		//创建一个GO按钮
		Button button=new Button(shell, SWT.NONE);
		
		button.setText("GO");
		//监听滑动条的选择事件，并将值显示在文本框中
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
				new Thread() {
					public void run() {
					for (int i=1;i< 11; i++) {//每次循环进度条前进一格，同时停顿一秒
					final int i_copy= i; //匿名内部类访问的局域变量必须是final型的，所以中转一7 
					display.asyncExec(new Runnable() {
						
						@Override
						public void run() {
							// TODO 自动生成的方法存根
							progree.setSelection(i_copy*10);
						}
					});
					
					try { Thread.sleep(1000); } catch (Throwable e2){}//间隔秒

					}
					}
	}.start();
			}
		});
		//	————END——————
	
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
