package �������;
import org.apache.commons.lang.math.NumberUtils;
import org.eclipse.swt.SWT;
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
public	class  Text2 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		 Text text=new Text(shell, SWT.BORDER);
		 text.setTextLimit(10);
		 //�������ֻ������10���ַ�
		 text.setBounds(10, 50, 125, 25);
		 text.addVerifyListener(new VerifyListener() {
			//�����������ÿһ�ΰ������ᴥ��
			@Override
			public void verifyText(VerifyEvent e) {
				// TODO �Զ����ɵķ������
				String inStr=e.text;
				//��ǰ������ַ� ע���text.getText()����һ��ֵ
				System.out.println(inStr);
				//��ӡ��������
				if (inStr.length()>0) {
					//���ո��ʱ inStr="",����Ϊ0
					//doit �������Ϊtrue�����ַ�������ʾ���ı���,����������
					e.doit=NumberUtils.isDigits(inStr);
					//�ж�instr�Ƿ�Ϊ�������ַ�
				}
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
