package composition����;
import org.apache.commons.lang.math.NumberUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
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
public	class  SashForm2�ָ {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		 
		
		SashForm sashForm=new SashForm(shell, SWT.NONE);
		//����һ���ָ
		new Text(sashForm, SWT.BORDER).setText("��");
		
		
		SashForm rightSashForm=new SashForm(sashForm, SWT.VERTICAL);
		//��Ƕһ���ָ�����
		new Text(rightSashForm, SWT.BORDER).setText("����");
		//���д��
		new Text(rightSashForm, SWT.BORDER).setText("����");
		
		//���÷ָ�и����Ŀ��֮�ȣ����У���=3:1:2
		sashForm.setWeights(new int[] {1,3});
		rightSashForm.setWeights(new int[] {5,2});
		sashForm.setBounds(10,10,200,200);
		
		
		
		
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
