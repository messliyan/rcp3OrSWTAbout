package Layout����;


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
 *Button.java2019��1��28��
 *
 */
/**
 * 	
 *@author ��ѱ�
 */
public	class  GridLayout����ʽ {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		GridLayout gridLayout=new GridLayout(2,false);
		shell.setLayout(gridLayout);
		new Button(shell, SWT.NONE).setText("ȷ      ��");
		new Button(shell, SWT.NONE).setText("ȡ��");
		new Button(shell, SWT.NONE).setText("����");
		new Button(shell, SWT.NONE).setText("b3"); 
		new Button(shell, SWT.NONE).setText("button2");
		new Button(shell, SWT.NONE).setText("button4");
		new Button(shell, SWT.NONE).setText("button5");
	
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
