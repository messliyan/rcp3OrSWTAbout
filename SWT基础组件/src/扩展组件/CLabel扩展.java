package ��չ���;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  CLabel��չ {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
			shell.setLayout(new FillLayout());

	      CLabel clabel = new CLabel(shell, SWT.NONE);
	      clabel.setText("Eclipse Mi");

	     // clabel.setlmage(new Image(display, "icons/project.gif

	      Color[] colors = {display.getSystemColor( SWT.COLOR_GREEN),

	      display.getSystemColor( SWT.COLOR_RED),display.getSystemColor( SWT.COLOR_BLUE)};
	      int [] percents = {  30, 100 };

	      clabel.setBackground(colors, percents);
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
