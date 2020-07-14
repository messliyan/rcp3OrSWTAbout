package Layout����;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019��1��28��
 *
 */
/**
 * 	
 *@author ��ѱ�
 */
public	class  FormAttachment���������� {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
	shell.setLayout(new FormLayout());
	Button button2 = new Button(shell, SWT.NONE);
	FormData formData=new FormData();
	formData.top=new FormAttachment(60,0);
	//��������Ϸ��ٷ�֮��ʮ��
	button2.setLayoutData(formData);
	button2.setText("button2");
	
	
	Text text=new Text(shell, SWT.BORDER);
	text.setLayoutData(new	FormData(200,50));
	
	//���岢����FormData
	FormData formData1=new FormData();
	//��text1Ϊ��׼ƫ��60����
	FormAttachment formAttachment=new FormAttachment(text,60);
	//FormAttachment formAttachment=new FormAttachment(text,60,SWT.LEFT);����3Ϊ��ѡֵ
	//���� SWT.DEFAULT	SWT.LEFT	SWT.CENTER SWT.RIGHT	SWT.TOP	SWT.BOTTOM
	formData1.top=formAttachment;
	formData1.left=formAttachment;
	//��buttonӦ����FormData
	
	Button button4 = new Button(shell, SWT.NONE);
	button4.setText("button4");
	button4.setLayoutData(formData1);
	
//	��������END������������
//		shell.layout();// Ӧ�ý��沼��
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
