package composition容器;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
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
public	class  ScrolledComposite1 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello Woeld"); 
//	创建窗口中其他界面组件
//	--------
		 
		
		ScrolledComposite  scrolledComposite= new ScrolledComposite(shell, 
				SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
			scrolledComposite.setBounds(12,6,256,148);
		//定义一个ScrolledComposite 式样为 深陷型、
		//带水平滚动型、带垂直滚动型
			
		//定义一个面板composite，此面板来容纳其他的组件
		Composite composite=new Composite(scrolledComposite, SWT.NONE);
		composite.setSize(326, 237);
		//不用setbound 左上角自动重合
		scrolledComposite.setContent(composite);
		//定义composite被scrolledComposite控制
		
		//建立八个文本框，以横二竖四排列
		new Text(composite, SWT.BORDER).setBounds(12, 13, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(155, 13, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(10, 70, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(155, 70, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(10, 120, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(166, 120, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(10, 170, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(156, 170, 132, 40);

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
