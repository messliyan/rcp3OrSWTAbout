package Layout布局;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 * @author 李佳斌
 */
public class StackLayout堆栈式 {
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
		// shell应用充满式布局

		// comp1容器 应用堆栈式布局
		final Composite composite1 = new Composite(shell, SWT.BORDER);
		final StackLayout stackLayout = new StackLayout();
		composite1.setLayout(stackLayout);
		// comp1中添加两按钮（默认为空） 
		final Button radio = new Button(composite1, SWT.RADIO);
		radio.setText("RIO");
		final Button check = new Button(composite1, SWT.CHECK);
		check.setText("CHECK");
		// 新容器中添加俩控制它门显示的按钮
		final Composite composite2 = new Composite(shell, SWT.BORDER);
		final RowLayout rowLayout = new RowLayout();
		composite2.setLayout(rowLayout);
		// comp1中添加两按钮（默认为空）
		final Button button1 = new Button(composite2, SWT.NONE);
		button1.setText("RADIO");
		button1.addSelectionListener(new SelectionAdapter() {
			// 单击事件
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
				/*
				 * ********** 下面两句是StackLayout的关键 *********
				 */
				stackLayout.topControl = radio;
				// radio设为最上层
				composite1.layout();
				// 重新布局 刷新页面
			}
		});
		final Button button2 = new Button(composite2, SWT.NONE);
		button2.setText("CHECK");
		// 按钮2显示CHECK
		button2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
				stackLayout.topControl = check;
				// radio设为最上层
				composite1.layout();
				// 重新布局 刷新页面
			}
		});

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
