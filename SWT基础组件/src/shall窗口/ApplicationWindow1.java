/*
 *ApplicationWindow1.java2019��1��29��
 *
 */
package shall����;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 *
 *@author ��ѱ�
 */
public class ApplicationWindow1 extends ApplicationWindow {

	public static void main(String[] args) {
		new ApplicationWindow1(null).run();
	}
	public ApplicationWindow1(Shell parentShell) {
		super(parentShell);
		// TODO �Զ����ɵĹ��캯�����
		setShellStyle(SWT.DIALOG_TRIM|SWT.ON_TOP);
	//���ɵ����Ŀ�� ��������ǰ��
		
	}
	public void run() {
		setBlockOnOpen(true);
		//trueָ��ִ��open����ʱ��������ͣ����ִ��
		open();
		Display.getCurrent().dispose();
	}
	
	//�������෽�� ��������
	@Override
	protected Control createContents(Composite parent) {
		// TODO �Զ����ɵķ������
		
		getShell().setText("ApplicationWindow����");
		parent.setSize(300, 400);
		Label label=new Label(parent, SWT.CENTER);
		label.setText("��Һ�");
		return parent;
	}
}
