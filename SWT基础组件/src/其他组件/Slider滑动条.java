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
public	class  Slider������ {
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
		
		final Text text =new Text(shell, SWT.BORDER);
			
		final Slider slider=new Slider(shell, SWT.NONE);
		//������������Ĭ��Ϊˮƽ�͵ģ�����ʽSWT.VERTICAL��Ϊ��ֱ
		slider.setMinimum(0);
		//��Сֵ
		slider.setMaximum(100);
		//���ֵ
		slider.setPageIncrement(5);
		//�������ֵ
		slider.setSelection(25);
		//��ʼֵ
		int value=slider.getSelection();
		
		text.setText(String.valueOf(value));
	
		//������������ѡ���¼�������ֵ��ʾ���ı�����
		slider.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
				int value=slider.getSelection();
				
				text.setText(String.valueOf(value));
			}
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
