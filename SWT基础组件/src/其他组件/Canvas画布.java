package �������;
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
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  Canvas���� {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		shell.setLayout(new RowLayout());
		//SWT.H_CROLL|SWT.V_DCROLL��ʽ���ڻ�������ʾ������
		//SWT.DOCUBLE_BUFFERE˫������Canvas����Ҫʽ����
		//���Ƶ�����ػ滭�����ᵼ�»�����˸��
		//��˫������Դ���������˸
		
		final Canvas canvas=new Canvas(shell, SWT.BORDER);
		//����canvas���ػ��¼�
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				// TODO �Զ����ɵķ������
				//��ͼ����ʾcanvas�ϣ�
				//��10,10����λͼ�����ϽǾ�canvas���Ͻǵľ���
				Image image=(Image) canvas.getData();
			if (image!=null) {
				e.gc.drawImage(image, 10, 10);
			}
			}
		});
		final Image refershImage=new Image(display, "");
		
		final Image nextImage=new Image(display, "");
		
		Button button1=new Button(shell, SWT.NONE);
		
		button1.setText("ͼƬ1");
		
		button1.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
				canvas.setData(nextImage);
				canvas.redraw();
			}
		});
		
		
		Button button2=new Button(shell, SWT.NONE);
		
		button2.setText("ͼƬ��");
		button2.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
				canvas.setData(refershImage);
				canvas.redraw();
			}
		});
		
		Button clearButton=new Button(shell, SWT.NONE);
		
		clearButton.setText("���ͼ��");
		clearButton.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
				canvas.setData(null);
				canvas.redraw();
			}
		});	
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
