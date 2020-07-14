package 常用组件;
import org.apache.commons.lang.math.NumberUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
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
public	class  Text2 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
		 Text text=new Text(shell, SWT.BORDER);
		 text.setTextLimit(10);
		 //限制最多只能输入10个字符
		 text.setBounds(10, 50, 125, 25);
		 text.addVerifyListener(new VerifyListener() {
			//检验监听器，每一次按键都会触发
			@Override
			public void verifyText(VerifyEvent e) {
				// TODO 自动生成的方法存根
				String inStr=e.text;
				//当前输入的字符 注意和text.getText()不是一个值
				System.out.println(inStr);
				//打印出来看看
				if (inStr.length()>0) {
					//按空格键时 inStr="",长度为0
					//doit 属性如果为true，则字符允许显示到文本框,反正不容许
					e.doit=NumberUtils.isDigits(inStr);
					//判断instr是否为整数型字符
				}
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
