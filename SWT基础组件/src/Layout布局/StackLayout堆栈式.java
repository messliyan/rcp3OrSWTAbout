package Layout����;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 * @author ��ѱ�
 */
public class StackLayout��ջʽ {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		shell.setLayout(new FillLayout());
		// shellӦ�ó���ʽ����

		// comp1���� Ӧ�ö�ջʽ����
		final Composite composite1 = new Composite(shell, SWT.BORDER);
		final StackLayout stackLayout = new StackLayout();
		composite1.setLayout(stackLayout);
		// comp1���������ť��Ĭ��Ϊ�գ� 
		final Button radio = new Button(composite1, SWT.RADIO);
		radio.setText("RIO");
		final Button check = new Button(composite1, SWT.CHECK);
		check.setText("CHECK");
		// �����������������������ʾ�İ�ť
		final Composite composite2 = new Composite(shell, SWT.BORDER);
		final RowLayout rowLayout = new RowLayout();
		composite2.setLayout(rowLayout);
		// comp1���������ť��Ĭ��Ϊ�գ�
		final Button button1 = new Button(composite2, SWT.NONE);
		button1.setText("RADIO");
		button1.addSelectionListener(new SelectionAdapter() {
			// �����¼�
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
				/*
				 * ********** ����������StackLayout�Ĺؼ� *********
				 */
				stackLayout.topControl = radio;
				// radio��Ϊ���ϲ�
				composite1.layout();
				// ���²��� ˢ��ҳ��
			}
		});
		final Button button2 = new Button(composite2, SWT.NONE);
		button2.setText("CHECK");
		// ��ť2��ʾCHECK
		button2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
				stackLayout.topControl = check;
				// radio��Ϊ���ϲ�
				composite1.layout();
				// ���²��� ˢ��ҳ��
			}
		});

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
