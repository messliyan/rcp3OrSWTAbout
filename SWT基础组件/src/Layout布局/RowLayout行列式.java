package Layout����;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
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
public	class  RowLayout����ʽ {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		RowLayout rowLayout=new RowLayout();
		shell.setLayout(rowLayout);
		rowLayout.marginWidth=20;
		
		rowLayout.marginHeight=10;
		rowLayout.spacing=15;
		//rowLayout.type=SWT.VERTICAL;//��������
		//rowLayout.wrap=false;		//ȡ���Զ�����
		//	rowLayout.pack=false;//��ť��С��ͬ
			rowLayout.justify=true;//һ����ռ�����
		new Button(shell, SWT.NONE).setText("ȷ      ��");
		
		new Button(shell, SWT.NONE).setText("ȡ��");
		Button button=new Button(shell, SWT.NONE);
		button.setText("����");
		RowData rowData=new RowData(99,49);
		rowData.exclude=true;
		button.setLayoutData(rowData);
		new Button(shell, SWT.NONE).setText("����");
		
	
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
