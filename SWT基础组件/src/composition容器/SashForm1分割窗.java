package composition容器;
import org.apache.commons.lang.math.NumberUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
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
public	class  SashForm1分割窗 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	-------- 
		SashForm sashForm=new SashForm(shell, SWT.NONE);
		//定义一个分割窗
		
		//SashForm中建立三个文本框，默认从左到右排列
		Text text1=new Text(sashForm, SWT.BORDER);
		text1.setText("左");
		new Text(sashForm, SWT.BORDER).setText("中");
		//简洁写法
		new Text(sashForm, SWT.BORDER).setText("右");
		
		//设置分割窗中各栏的宽度之比，左：中：右=3:1:2
		sashForm.setWeights(new int[] {3,1,2});
		
		sashForm.setBounds(10,10,200,200);
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
