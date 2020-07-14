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
public	class  GridLayout����ʽ2 {
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
		new Button(shell, SWT.NONE).setText("b1");
		new Button(shell, SWT.NONE).setText("button");
		
		//����һ��GridData����b3��ռ���пռ�
		Button b3=new Button(shell, SWT.NONE);
		b3.setText("b3");
		GridData gridData=new GridData();
		gridData.horizontalSpan=2;
		
		b3.setLayoutData(gridData);
		
	
		new Button(shell, SWT.NONE).setText("button4");
		new Button(shell, SWT.NONE).setText("button5");
		Button b6=new Button(shell, SWT.NONE);
		
		b6.setText("b6");
		
		//ȫմ�����ռ�İ�ť
		b6.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		//����һ��ȫ������ռ����İ�ť
		Button b7=new Button(shell, SWT.NONE);
		b7.setText("b7");
		GridData gridData2=new GridData(GridData.FILL_BOTH);
	/*	��ʽ	HORIZONTAL_ALIGN_FILL	ˮƽ��������������ӵ�пռ䣩
		
				FILL_HORIZOTAL	��������ˮƽ
			
				FILL_BOTH	˫����ռʽ*/
		gridData2.horizontalSpan=2;
		
		gridData2.horizontalAlignment=GridData.FILL;
	/*	����	horizontalSpan =��	������ռ�ռ䣨��ť�����ӣ�

				horizontalAlignment=GriData.��ʽ	ˮƽ���뷽ʽ

				horrizonrtalIndex=�� �������
					
				widthHint =��	������

				GradExessHorizontalSpace	ˮƽ��ռ�ռ�*/
		b7.setLayoutData(gridData2);
		
		
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
