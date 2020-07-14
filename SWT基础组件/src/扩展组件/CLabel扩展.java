package 扩展组件;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  CLabel扩展 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
			shell.setLayout(new FillLayout());

	      CLabel clabel = new CLabel(shell, SWT.NONE);
	      clabel.setText("Eclipse Mi");

	     // clabel.setlmage(new Image(display, "icons/project.gif

	      Color[] colors = {display.getSystemColor( SWT.COLOR_GREEN),

	      display.getSystemColor( SWT.COLOR_RED),display.getSystemColor( SWT.COLOR_BLUE)};
	      int [] percents = {  30, 100 };

	      clabel.setBackground(colors, percents);
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
