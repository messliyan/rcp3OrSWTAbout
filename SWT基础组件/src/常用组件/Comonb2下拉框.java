package �������;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  Comonb2������ {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		 final Combo combo=new Combo(shell, SWT.READ_ONLY);
		//����һ��ֻ����������
		 combo.setBounds(10, 50, 125, 25);
		 
		 //���ð�ť
		 Button setButton=new Button(shell, SWT.NONE);
		 setButton .setText(" ��ֵ");
		 setButton.setBounds(10, 100, 40, 40);
		 setButton.addSelectionListener(new SelectionAdapter() {
			 	@Override
			 	public void widgetSelected(SelectionEvent e) {
			 		// TODO �Զ����ɵķ������
			 		combo.removeAll();
			 		//�����combo���Է����°��¡���ֵ����ťʱ��bug
			 		combo.add("����");
			 		//����Combo��ʾֵ
			 		combo.add("��ѧ");
			 		combo.add("����");
			 		combo.setData("����", "YW");
			 		//������ʾֵ�Ĵ���ֵ
			 		combo.setData("��ѧ", "SX");
			 		combo.setData("����", "ZZ");
			 		combo.select(0);
			 		//���õ�һ��Ϊ��ǰ��
			 	}
		});
		 
		 //ȡֵ��ť
		 Button getButton=new Button(shell, SWT.NONE);
		 getButton .setText("ȡֵ");
		 getButton.setBounds(70, 100, 70, 40);
		 getButton.addSelectionListener(new SelectionAdapter() {
			 	@Override
			 	public void widgetSelected(SelectionEvent e) {
			 		// TODO �Զ����ɵķ������
			 		String str=combo.getText();
			 		//ȡ����ʾֵ
			 		String data=(String) combo.getData(str);
			 		//ȡ�ô���ֵ
			 		MessageDialog.openInformation(null, null, str+data);
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
