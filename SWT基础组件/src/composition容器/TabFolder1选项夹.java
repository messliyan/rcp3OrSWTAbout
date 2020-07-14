package composition����;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 * @author ��ѱ�
 */
public class TabFolder1ѡ��� {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell���������� 
		shell.setSize(500, 500);
		shell.setText("Hello Woeld"); 
//	���������������������
//	--------
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		// ����һ��TabFolder����
		tabFolder.setBounds(6, 5, 300, 300);
		// ����� �ָ��� �ұ�������Ӱ��
		{
			TabItem item = new TabItem(tabFolder, SWT.NONE);
			// ��һ��ѡ���
			item.setText("Item1");
			// TabFolder�н���һ��Group����
			Group group = new Group(tabFolder, SWT.NONE);
			group.setText("Radio Group");
			item.setControl(group);
			// ѡ��к�Group������ϵ

			// Group�ϴ���������ѡ��ť
			Button radio1 = new Button(group, SWT.RADIO);
			radio1.setText("Ů");
			// ��ť�ϵ�����
			radio1.setSelection(true);
			// ��ť����ѡ��״̬
			radio1.setBounds(10, 50, 80, 25);
			// ���ð�ť��λ��
			Button radio2 = new Button(group, SWT.RADIO);
			radio2.setText("��");
			radio2.setBounds(10, 100, 80, 25);
		}
		{
			TabItem item = new TabItem(tabFolder, SWT.NONE);
			item.setText("Item2");
			//�ڶ���ѡ���
			Composite comp = new Composite(tabFolder, SWT.NONE);
			// TabFolder�н���һ��Composite����
			item.setControl(comp);
			
			//Composite���������ı���
			Text text = new Text(comp, SWT.BORDER);
			text.setBounds(10, 50, 80, 25);

			Text text1 = new Text(comp, SWT.BORDER);
			text1.setBounds(10, 100, 80, 25);
		}

//	��������END������������
		shell.layout();// Ӧ�ý��沼��
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
