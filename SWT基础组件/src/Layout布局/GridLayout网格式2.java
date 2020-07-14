package Layout布局;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019年1月28日
 *
 */
/**
 * 	
 *@author 李佳斌
 */
public	class  GridLayout网格式2 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
		GridLayout gridLayout=new GridLayout(2,false);
		shell.setLayout(gridLayout);
		new Button(shell, SWT.NONE).setText("b1");
		new Button(shell, SWT.NONE).setText("button");
		
		//定义一个GridData对象。b3抢占两列空间
		Button b3=new Button(shell, SWT.NONE);
		b3.setText("b3");
		GridData gridData=new GridData();
		gridData.horizontalSpan=2;
		
		b3.setLayoutData(gridData);
		
	
		new Button(shell, SWT.NONE).setText("button4");
		new Button(shell, SWT.NONE).setText("button5");
		Button b6=new Button(shell, SWT.NONE);
		
		b6.setText("b6");
		
		//全沾满它空间的按钮
		b6.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		//定义一个全充满抢占两格的按钮
		Button b7=new Button(shell, SWT.NONE);
		b7.setText("b7");
		GridData gridData2=new GridData(GridData.FILL_BOTH);
	/*	样式	HORIZONTAL_ALIGN_FILL	水平对齐铺满（铺满拥有空间）
		
				FILL_HORIZOTAL	铺满整个水平
			
				FILL_BOTH	双向抢占式*/
		gridData2.horizontalSpan=2;
		
		gridData2.horizontalAlignment=GridData.FILL;
	/*	属性	horizontalSpan =数	横向抢占空间（按钮老样子）

				horizontalAlignment=GriData.样式	水平对齐方式

				horrizonrtalIndex=数 组件右移
					
				widthHint =数	组件宽度

				GradExessHorizontalSpace	水平抢占空间*/
		b7.setLayoutData(gridData2);
		
		
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
