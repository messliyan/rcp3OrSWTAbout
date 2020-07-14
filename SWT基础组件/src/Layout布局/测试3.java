package Layout布局;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;



/*
 *Button.java2019年1月28日
 *
 */
/**
 * 按钮
 * 
 * @author 李佳斌
 */
public class 测试3 {
	private static Text localName;
	//
	private static Text dbType;
	private static Text host;
	private static Text port;
	private static Text userName;
	private static Text metaStoreIP;
	private  static Text metaStorePort;
	private static  Label testConnect; 
	private static Text dbName;
//	private Text connectRetry;
//	private Text socketTimeOut;
	private static Combo connectDirect;
	private static Combo memorySpace;
	private String str="eqweqw";
	
	public static Text procedureHost;
	private String oldLocalName;
		private static Text text;
		private static Text text_1;
		private static Label testLable;
		private static TreeItem treeItem;
		
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
	
		Spinner	sliceNumSpinner = new Spinner(shell, SWT.BORDER);
		
	
		
shell.setSize(350, 180);
shell.setText("eqeqw");
shell.setLayout(new GridLayout(3,false));

Label isDimLlabel = new Label(shell, SWT.NONE);
isDimLlabel.setText("eqwe");

 
//问题在这里
Combo isDimCombo = new Combo(shell, SWT.READ_ONLY);

isDimCombo.add("YES");
isDimCombo.add("NO");
isDimCombo.select(0);



		

	

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
