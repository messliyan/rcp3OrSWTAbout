package �������;

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
 * ��ť
 * 
 * @author ��ѱ�
 */
public class Button2 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		final Button radio1 = new Button(shell, SWT.RADIO);
		// �¼�������Ҫ���� ��һfinal
		radio1.setText("Ů");
		// ��ť�ϵ�����
		radio1.setSelection(true);
		// ��ť����ѡ��״̬
		radio1.setBounds(10, 10, 80, 25);
		// ���ð�ť��λ��

		final Button radio2 = new Button(shell, SWT.RADIO);
		radio2.setText("��");
		radio2.setBounds(10, 50, 80, 25);

		final Button check1 = new Button(shell, SWT.CHECK);
		check1.setText("����");
		check1.setBounds(100, 10, 80, 25);

		final Button check2 = new Button(shell, SWT.CHECK);
		check2.setText("����");
		check2.setBounds(100, 50, 80, 25);

		Button okButton = new Button(shell, SWT.NONE);
		okButton.setText("ȷ��");
		okButton.setBounds(10, 100, 100, 25);
		okButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
				String str = "����,";
				if (radio1.getSelection()) {
					// �жϰ�ť�Ƿ�ѡ��
					str += radio1.getText();
					// ȡ�ð�ť�ϵ�����
				}
				if (radio2.getSelection()) {
					str += radio2.getText();
				}
				str += "�����ã�";
				if (check1.getSelection()) {
					str += check1.getText();
				}
				if (check2.getSelection()) {
					str += check2.getText();
				}
				// ��Ϣ��ʾ��ĵ�һ������������Ϊ��
				MessageDialog.openInformation(null, null, str);
			}

		});

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
