package �������;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  List2�б�� {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		 final List list=new List(shell, SWT.MULTI);
			
		 list.setBounds(10, 10, 125, 80);
			 
			 //���ð�ť
			 Button setButton=new Button(shell, SWT.NONE);
			 setButton .setText(" ��ֵ");
			 setButton.setBounds(10, 100, 70, 40);
			 setButton.addSelectionListener(new SelectionAdapter() {
				 	@Override
				 	public void widgetSelected(SelectionEvent e) {
				 		// TODO �Զ����ɵķ������
				 		list.removeAll();
				 		//�����combo���Է����°��¡���ֵ����ťʱ��bug
				 		list.add("����");
				 		//����Combo��ʾֵ
				 		list.add("��ѧ");
				 		list.add("����");
				 		list.setData("����", "YW");
				 		//������ʾֵ�Ĵ���ֵ
				 		list.setData("��ѧ", "SX");
				 		list.setData("����", "ZZ");
				 		list.select(new int[] {0,2});
				 		//���õ�һ,����Ϊѡ����
				 	}
			});
			 
			 //ȡֵ��ť
			 Button getButton=new Button(shell, SWT.NONE);
			 getButton .setText("ȡֵ");
			 getButton.setBounds(80, 100, 70, 40);
			 getButton.addSelectionListener(new SelectionAdapter() {
				 	@Override
				 	public void widgetSelected(SelectionEvent e) {
				 		// TODO �Զ����ɵķ������
				 	String bud = "";
				 	for (String s : list.getSelection()) {
				 		//getSelection ��������ѡ������ɵ�String����
						bud+=s+list.getData(s)+",";
					}
				 		MessageDialog.openInformation(null, null, bud.toString());
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
