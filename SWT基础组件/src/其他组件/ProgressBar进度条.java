package �������;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  ProgressBar������ {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		shell.setLayout(new RowLayout());
		
			
		final ProgressBar progree=new ProgressBar(shell, SWT.SMOOTH);
		//������������������ƽ��ʽ��SWT.SMOOTH��Ĭ��Ϊ������
		progree.setMinimum(0);
		//��Сֵ
		progree.setMaximum(100);
		//���ֵ
		
		//����һ��GO��ť
		Button button=new Button(shell, SWT.NONE);
		
		button.setText("GO");
		//������������ѡ���¼�������ֵ��ʾ���ı�����
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
				for (int i = 0; i < 11; i++) {
					//ÿ��ѭ��������ǰ��һ��ͬʱͣ��һ��
					progree.setSelection(i*10);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}	}
	});
		//	��������END������������
	
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
