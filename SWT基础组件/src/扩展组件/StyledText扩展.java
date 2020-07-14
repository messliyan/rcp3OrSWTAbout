package 扩展组件;
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
 *Button.java2019年1月28日
 *
 */
/**
 *智能提示
 *@author 李佳斌
 */
public	class  StyledText扩展 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
	    	shell.setLayout(new FillLayout());

	    	Text label=new Text(shell, SWT.None);
	    	label.setFocus();
	      StyledText text = new StyledText(shell, SWT.BORDER | SWT.SINGLE | SWT.MULTI);
	      

	      StyleRange styleRange = new StyleRange();//创建一个式样
	      styleRange.start = 3;//开始字符(中文和字母都算一个字符)
	      styleRange.length = "Eclipse'".length();//应用的字符数
	      styleRange.fontStyle = SWT.BOLD;//粗体

	      styleRange.foreground = display.getSystemColor(SWT.COLOR_BLUE);//1前景色:蓝
	      styleRange.background = display.getSystemColor(SWT.COLOR_RED);// 背景色:红
	      styleRange.underline = true;// 下划线
	      styleRange.strikeout = true;//删除线
	      
	      text.setText("书籍: Eclipse 从入门到精通");
	      
	      text.setStyleRange(styleRange);
	      
	      
	      
	      text.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (text.getText().trim().equals("书籍: Eclipse 从入门到精通")) {
					text.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (text.getText().trim().equals("")) {
					text.setText("书籍: Eclipse 从入门到精通");
					text.setStyleRanges(new StyleRange[] { styleRange });
				}

			}
		});
//	————END——————
		shell.layout();// 应用界面布局
		shell.open();// 打开shell主窗口
		while (!shell.isDisposed()) {// 如果主窗口没有关闭
//			则一直循环
			if (!display.readAndDispatch()) {// 如果display不忙，
//				就让display处于休眠
				display.sleep();
			}
		}
		display.sleep();

	}

}
