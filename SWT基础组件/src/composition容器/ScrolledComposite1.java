package composition����;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
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
public	class  ScrolledComposite1 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello Woeld"); 
//	���������������������
//	--------
		 
		
		ScrolledComposite  scrolledComposite= new ScrolledComposite(shell, 
				SWT.BORDER|SWT.H_SCROLL|SWT.V_SCROLL);
			scrolledComposite.setBounds(12,6,256,148);
		//����һ��ScrolledComposite ʽ��Ϊ �����͡�
		//��ˮƽ�����͡�����ֱ������
			
		//����һ�����composite����������������������
		Composite composite=new Composite(scrolledComposite, SWT.NONE);
		composite.setSize(326, 237);
		//����setbound ���Ͻ��Զ��غ�
		scrolledComposite.setContent(composite);
		//����composite��scrolledComposite����
		
		//�����˸��ı����Ժ����������
		new Text(composite, SWT.BORDER).setBounds(12, 13, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(155, 13, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(10, 70, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(155, 70, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(10, 120, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(166, 120, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(10, 170, 132, 40);
		new Text(composite, SWT.BORDER).setBounds(156, 170, 132, 40);

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
