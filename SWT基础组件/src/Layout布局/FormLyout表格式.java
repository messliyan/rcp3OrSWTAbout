package Layout����;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
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
public	class  FormLyout���ʽ {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
	FormLayout formLayout=new FormLayout();
	formLayout.marginWidth=100;
	formLayout.marginHeight=50;
	shell.setLayout(formLayout);
	new Button(shell, SWT.NONE).setText("button1");
	//ʹ��FormData
	Button button2 = new Button(shell, SWT.NONE);
	FormData formData=new FormData();
	button2.setLayoutData(formData);
	button2.setText("button2");
	
	
	Button button3 = new Button(shell, SWT.NONE);
	FormData formData2=new FormData(200,50);
	button3.setLayoutData(formData2);
	button3.setText("button3");
	
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
