package Layout����;

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
 *Button.java2019��1��28��
 *
 */
/**
 * ��ť
 * 
 * @author ��ѱ�
 */
public class ����3 {
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
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		
		shell.setText("Hello Woeld");
//	���������������������
//	--------
	
		Spinner	sliceNumSpinner = new Spinner(shell, SWT.BORDER);
		
	
		
shell.setSize(350, 180);
shell.setText("eqeqw");
shell.setLayout(new GridLayout(3,false));

Label isDimLlabel = new Label(shell, SWT.NONE);
isDimLlabel.setText("eqwe");

 
//����������
Combo isDimCombo = new Combo(shell, SWT.READ_ONLY);

isDimCombo.add("YES");
isDimCombo.add("NO");
isDimCombo.select(0);



		

	

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
