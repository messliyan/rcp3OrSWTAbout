package �������;

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
 *Button.java2019��1��28��
 *
 */
/**
 *
 * @author ��ѱ�
 */
public class Imageͼ�� {
	public static void main(String[] args) throws MalformedURLException {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		shell.setLayout(new FillLayout());
		
		Button button1=new Button(shell, SWT.NONE);
		
		button1.setText("ͼƬһ");
		
		Button button2=new Button(shell, SWT.NONE);
		
		button2.setText("ͼƬ��");
		
		
		
		
			//������ͼ��ע�����Ϊ������Ҫ����ͼ��ע���ImageRegistry,
		//������ʵ����Ŀ����ý�ImageRegistry���óɾ�̬����
		ImageRegistry imageRegistry = new ImageRegistry();
		
		//����һ��ͼ������������
		URL url = new URL("file:icon/1.jpg");
		ImageDescriptor imageDesc = ImageDescriptor.createFromURL(url);
		
		
		URL url3 = new URL("file:icon/star.jpg");
		ImageDescriptor imageDesc2 = ImageDescriptor.createFromURL(url3);
		
		//��ͼ��������(ImageDescriptor)��ӵ�ͼ��ע�����ֵΪ��refresh"
		imageRegistry.put("button1", imageDesc);
		
		imageRegistry.put("button2", imageDesc2);
		
		
		//��ͼ���ͼ��ע�����ȡ��
		Image image = imageRegistry.get("button1");
		
		Image image2 = imageRegistry.get("button2");
		
		
		button1.setImage(image);
		
		button2.setImage(image2);
		
	/*	//��ͼ��ע�����ȡ��ͼ��������
		ImageDescriptor imageDesc2 = imageRegistry.getDescriptor("refresh");

		//��ͼ���ע������Ƴ���������ͼ��������������ʹ�����ͼ��ͼ����Ȼ�ᱻ�ͷŵ���
		//��ʱ����ϾͲ�����ʾ��ͼ�����⣬���ע����ﲻ���ڼ�ֵ��refresh"��Ҳ���������쳣
		
		imageRegistry.remove("refresh");
		
		
		//ͼ��ע������٣����µ�����ͼ��Ҳ�ᱻ����
		imageRegistry.dispose();
*/

		
		
		
//	��������END������������
		//shell.layout();// Ӧ�ý��沼��
		shell.open();// ��shell������
		while (!shell.isDisposed()) {// ���������û�йر�
//			��һֱѭ��
			if (!display.readAndDispatch()) {// ���display��æ��
//				����display��������
				display.sleep();
			}
		}
		display.sleep();

	}

}
