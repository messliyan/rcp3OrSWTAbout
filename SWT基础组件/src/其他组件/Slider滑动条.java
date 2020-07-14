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
public	class  Slider滑动条 {
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
		
		final Text text =new Text(shell, SWT.BORDER);
			
		final Slider slider=new Slider(shell, SWT.NONE);
		//创建滑动条。默认为水平型的，用样式SWT.VERTICAL变为垂直
		slider.setMinimum(0);
		//最小值
		slider.setMaximum(100);
		//最大值
		slider.setPageIncrement(5);
		//滑动间隔值
		slider.setSelection(25);
		//初始值
		int value=slider.getSelection();
		
		text.setText(String.valueOf(value));
	
		//监听滑动条的选择事件，并将值显示在文本框中
		slider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
				int value=slider.getSelection();
				
				text.setText(String.valueOf(value));
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
