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
public class ���� {
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
	
		
		shell.setSize(363, 183);
		shell.setLayout(new GridLayout(5, false));
	
		final Group group = new Group(shell, SWT.NONE);
		group.setLayout(new GridLayout(2, false));
		GridData gd_group=new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
		
		//2
		gd_group.grabExcessVerticalSpace=true;
		group.setLayoutData(gd_group);
		group.setText("eqeqeq");
		
		Label label_4 = new Label(group, SWT.NONE);
		label_4.setText("eqweqwe");
		dbName = new Text(group, SWT.BORDER);
		GridData gd_dbName =new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_dbName.widthHint = 90;
		gd_dbName.horizontalSpan=1;
		dbName.setLayoutData(gd_dbName);
		//dbName.setText(dBConfiguration.getDbName());
		dbName.setEnabled(false);
		
		Label label = new Label(group, SWT.NONE);
		label.setText("eqweqw");
		host = new Text(group, SWT.BORDER);
//		GridData gd_text_1 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_dbName.widthHint = 200;
		gd_dbName.horizontalSpan=1;
		host.setLayoutData(gd_dbName);
		//host.setText(dBConfiguration.getHost());
		host.setEnabled(false);
		

		
	
		GridData gridData1 = new GridData(SWT.END, SWT.RIGHT, true, false, 1, 1);
	//	testLable.setBounds(5, 121, 133, 17);
		
		new Label(shell, SWT.NONE).setLayoutData(gridData1);;
		new Label(shell, SWT.NONE).setLayoutData(gridData1);
	
	
	
		
		Button button = new Button(shell, SWT.RIGHT);
		button.setLayoutData(gridData1);
		
	
		button.setText("w	w");
	//	button.setBounds(137, 121, 60, 25);
		button.setFocus();
		
		Button button_1 = new Button(shell, SWT.RIGHT);
		
		button_1.setText("qweqe");
	//	button_1.setBounds(205, 121, 62, 25);
		button_1.setLayoutData(gridData1);
		Button button_2 = new Button(shell, SWT.RIGHT);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {}
		});
		button_2.setText("dadadasfdas");
		//button_2.setBounds(273, 121, 65, 25);
		button_2.setLayoutData(gridData1);

	

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
