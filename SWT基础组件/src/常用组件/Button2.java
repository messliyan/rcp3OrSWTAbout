package 常用组件;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019年1月28日
 *
 */
/**
 * 按钮
 * 
 * @author 李佳斌
 */
public class Button2 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
		final Button radio1 = new Button(shell, SWT.RADIO);
		// 事件代码中要访问 加一final
		radio1.setText("女");
		// 按钮上的文字
		radio1.setSelection(true);
		// 按钮处于选择状态
		radio1.setBounds(10, 10, 80, 25);
		// 设置按钮的位置

		final Button radio2 = new Button(shell, SWT.RADIO);
		radio2.setText("男");
		radio2.setBounds(10, 50, 80, 25);

		final Button check1 = new Button(shell, SWT.CHECK);
		check1.setText("篮球");
		check1.setBounds(100, 10, 80, 25);

		final Button check2 = new Button(shell, SWT.CHECK);
		check2.setText("旅游");
		check2.setBounds(100, 50, 80, 25);

		Button okButton = new Button(shell, SWT.NONE);
		okButton.setText("确定");
		okButton.setBounds(10, 100, 100, 25);
		okButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
				String str = "李明,";
				if (radio1.getSelection()) {
					// 判断按钮是否选中
					str += radio1.getText();
					// 取得按钮上的文字
				}
				if (radio2.getSelection()) {
					str += radio2.getText();
				}
				str += "。爱好：";
				if (check1.getSelection()) {
					str += check1.getText();
				}
				if (check2.getSelection()) {
					str += check2.getText();
				}
				// 信息提示框的第一二个参数可以为空
				MessageDialog.openInformation(null, null, str);
			}

		});

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
