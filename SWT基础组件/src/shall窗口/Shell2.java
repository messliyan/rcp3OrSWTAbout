package shall����;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
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
public	class  Shell2 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("������");
		shell.setLayout(new RowLayout());
		
//	���������������������
//	--------
		Button button=new Button(shell, SWT.NONE);
		button .setText("���´���");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
			shell.setVisible(false);
			//����������
			
			//�����´���
			final Shell newshell=new Shell(shell,SWT.CLOSE);
			newshell.setSize(327, 253);
			newshell.setText("�´���");
			newshell.setLayout(new RowLayout());
			//�����ر��¼������´��ڹر�ʱ��ʾ������
			newshell.addDisposeListener(new DisposeListener() {
				
				@Override
				public void widgetDisposed(DisposeEvent e) {
					// TODO �Զ����ɵķ������
					if (!shell.isVisible()) {
						shell.setVisible(true);
					}
				}
			});
			final Button visublebutton=new Button(newshell, SWT.NONE);
			visublebutton.setText("��ʾ/����������");
			visublebutton.addSelectionListener(new SelectionAdapter() {
			private boolean flag=true;
			@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO �Զ����ɵķ������
					shell.setVisible(flag);
					flag=!flag;
					//shellΪ������ ����new shellҲ����
					
					//������ʾnew shell
					newshell.setVisible(true);
					newshell.setActive();
					//����
				}
			
			});
			newshell.open();
			
			}
		});
		
		
		
//	��������END������������
		//shell.layout();// Ӧ�ý��沼��
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
