package ��չ���;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *������ʾ
 *@author ��ѱ�
 */
public	class  StyledText��չ {
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

	    	Text label=new Text(shell, SWT.None);
	    	label.setFocus();
	      StyledText text = new StyledText(shell, SWT.BORDER | SWT.SINGLE | SWT.MULTI);
	      

	      StyleRange styleRange = new StyleRange();//����һ��ʽ��
	      styleRange.start = 3;//��ʼ�ַ�(���ĺ���ĸ����һ���ַ�)
	      styleRange.length = "Eclipse'".length();//Ӧ�õ��ַ���
	      styleRange.fontStyle = SWT.BOLD;//����

	      styleRange.foreground = display.getSystemColor(SWT.COLOR_BLUE);//1ǰ��ɫ:��
	      styleRange.background = display.getSystemColor(SWT.COLOR_RED);// ����ɫ:��
	      styleRange.underline = true;// �»���
	      styleRange.strikeout = true;//ɾ����
	      
	      text.setText("�鼮: Eclipse �����ŵ���ͨ");
	      
	      text.setStyleRange(styleRange);
	      
	      
	      
	      text.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (text.getText().trim().equals("�鼮: Eclipse �����ŵ���ͨ")) {
					text.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (text.getText().trim().equals("")) {
					text.setText("�鼮: Eclipse �����ŵ���ͨ");
					text.setStyleRanges(new StyleRange[] { styleRange });
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
