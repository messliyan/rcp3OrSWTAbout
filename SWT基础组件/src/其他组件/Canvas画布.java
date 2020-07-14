package 其他组件;
import java.awt.Event;

import org.apache.commons.lang.ObjectUtils.Null;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  Canvas画布 {
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
		//SWT.H_CROLL|SWT.V_DCROLL样式可在画布上显示滚动条
		//SWT.DOCUBLE_BUFFERE双缓冲是Canvas的重要式样。
		//如果频繁的重绘画布，会导致画面闪烁。
		//用双缓存可以大大的消除闪烁
		
		final Canvas canvas=new Canvas(shell, SWT.BORDER);
		//监听canvas的重绘事件
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				// TODO 自动生成的方法存根
				//将图像显示canvas上，
				//（10,10）定位图像左上角距canvas左上角的距离
				Image image=(Image) canvas.getData();
			if (image!=null) {
				e.gc.drawImage(image, 10, 10);
			}
			}
		});
		final Image refershImage=new Image(display, "");
		
		final Image nextImage=new Image(display, "");
		
		Button button1=new Button(shell, SWT.NONE);
		
		button1.setText("图片1");
		
		button1.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
				canvas.setData(nextImage);
				canvas.redraw();
			}
		});
		
		
		Button button2=new Button(shell, SWT.NONE);
		
		button2.setText("图片二");
		button2.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
				canvas.setData(refershImage);
				canvas.redraw();
			}
		});
		
		Button clearButton=new Button(shell, SWT.NONE);
		
		clearButton.setText("清楚图像");
		clearButton.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
				canvas.setData(null);
				canvas.redraw();
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
