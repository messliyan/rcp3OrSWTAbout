package 其他组件;

import java.awt.Event;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang.ObjectUtils.Null;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
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
 * @author 李佳斌
 */
public class Image图像 {
	public static void main(String[] args) throws MalformedURLException {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
		shell.setLayout(new FillLayout());
		
		Button button1=new Button(shell, SWT.NONE);
		
		button1.setText("图片一");
		
		Button button2=new Button(shell, SWT.NONE);
		
		button2.setText("图片二");
		
		
		
		
			//创建个图像注册表。因为程序需要共享图像注册表ImageRegistry,
		//所以在实际项目中最好将ImageRegistry设置成静态变量
		ImageRegistry imageRegistry = new ImageRegistry();
		
		//创建一个图像描述符对象
		URL url = new URL("file:icon/1.jpg");
		ImageDescriptor imageDesc = ImageDescriptor.createFromURL(url);
		
		
		URL url3 = new URL("file:icon/star.jpg");
		ImageDescriptor imageDesc2 = ImageDescriptor.createFromURL(url3);
		
		//将图像描述符(ImageDescriptor)添加到图像注册表，键值为“refresh"
		imageRegistry.put("button1", imageDesc);
		
		imageRegistry.put("button2", imageDesc2);
		
		
		//将图像从图像注册表中取出
		Image image = imageRegistry.get("button1");
		
		Image image2 = imageRegistry.get("button2");
		
		
		button1.setImage(image);
		
		button2.setImage(image2);
		
	/*	//从图像注册表中取出图像描述符
		ImageDescriptor imageDesc2 = imageRegistry.getDescriptor("refresh");

		//将图像从注册表里移除，井销毁图像。如果有组件正在使用这个图像，图像依然会被释放掉，
		//这时组件上就不会显示此图像。另外，如果注册表里不存在键值“refresh"，也不会引起异常
		
		imageRegistry.remove("refresh");
		
		
		//图像注册表销毁，其下的所有图像也会被销毁
		imageRegistry.dispose();
*/

		
		
		
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
