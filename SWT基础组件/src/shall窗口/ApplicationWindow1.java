/*
 *ApplicationWindow1.java2019年1月29日
 *
 */
package shall窗口;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 *
 *@author 李佳斌
 */
public class ApplicationWindow1 extends ApplicationWindow {

	public static void main(String[] args) {
		new ApplicationWindow1(null).run();
	}
	public ApplicationWindow1(Shell parentShell) {
		super(parentShell);
		// TODO 自动生成的构造函数存根
		setShellStyle(SWT.DIALOG_TRIM|SWT.ON_TOP);
	//不可调整的框口 窗口在最前面
		
	}
	public void run() {
		setBlockOnOpen(true);
		//true指在执行open方法时，程序暂停往下执行
		open();
		Display.getCurrent().dispose();
	}
	
	//覆盖主类方法 创建主键
	@Override
	protected Control createContents(Composite parent) {
		// TODO 自动生成的方法存根
		
		getShell().setText("ApplicationWindow窗口");
		parent.setSize(300, 400);
		Label label=new Label(parent, SWT.CENTER);
		label.setText("大家好");
		return parent;
	}
}
