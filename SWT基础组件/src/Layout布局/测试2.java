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
public class 测试2 {

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
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
	
		shell.setSize(600, 450);
		
		
		
		shell.setText("eqweqq");
		shell.setLayout(new GridLayout(5, false));
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
//		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
//		gd_lblNewLabel.widthHint=60;
//		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("wqeeqe");
		localName = new Text(shell, SWT.BORDER);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		
		//1
		gd_text.grabExcessVerticalSpace=true;
		gd_text.widthHint = 140;
		localName.setLayoutData(gd_text);
		//localName.setText(dBConfiguration.getLocalName());
		localName.setEnabled(false);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		final Group group = new Group(shell, SWT.NONE);
		group.setLayout(new GridLayout(4, false));
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
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("eeqwe");
		port = new Text(group, SWT.BORDER);
//		GridData gd_text_2 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_dbName.widthHint = 90;
		gd_dbName.horizontalSpan=1;
		port.setLayoutData(gd_dbName);
		port.setText("eqweqeeq");
		port.setEnabled(false);
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setText("eqweq");
		userName = new Text(group, SWT.BORDER);
//		GridData gd_text_3 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_dbName.widthHint = 200;
		gd_dbName.horizontalSpan=1;
		userName.setLayoutData(gd_dbName);
		userName.setText("qeqweqweq");
		userName.setEnabled(false);
		
		
		
		final Label label_7 = new Label(group, SWT.NONE);
		label_7.setText("eqweqw");
		connectDirect = new Combo(group, SWT.NONE);
//		GridData gd_text_7 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_dbName.widthHint = 160;
		gd_dbName.horizontalSpan=1;
		connectDirect.setLayoutData(gd_dbName);
		
		connectDirect.setEnabled(false);
		
		final Label memorySpaceLabel = new Label(group, SWT.NONE);
		memorySpaceLabel.setText("ewqqe");
		memorySpace=new Combo(group, SWT.NONE);
		memorySpace.setLayoutData(gd_dbName);
		memorySpace.setText("eqewwq");
		memorySpace.setEnabled(false);
		
		
		Label procedureLabel = new Label(group, SWT.NONE);
		procedureLabel.setText("eqweq");
		
		procedureHost = new Text(group, SWT.BORDER);
		GridData gd_dbName_p =new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_dbName_p.widthHint = 406;
		gd_dbName_p.horizontalSpan=3;
		procedureHost.setLayoutData(gd_dbName_p);
		procedureHost.setText("qeweqq");
//		procedureHost.setStyleRanges(new StyleRange[]{style});
		procedureHost.setEnabled(false);
		
		final Group groupLdap = new Group(shell, SWT.NONE);
		groupLdap.setLayout(new GridLayout(4, false));
		GridData gd_group1=new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
		
		//3
		gd_group1.grabExcessVerticalSpace=true;
//		gd_group1.heightHint=150;
		groupLdap.setLayoutData(gd_group1);
		groupLdap.setText("eqweq");
		
		Label label_LdapHost = new Label(groupLdap, SWT.NONE);
		label_LdapHost.setText("Ldap服务器: ");
		Text ladpHost = new Text(groupLdap, SWT.BORDER);
		ladpHost.setLayoutData(gd_dbName);
		ladpHost.setText("eqweq");
		ladpHost.setEnabled(false);
		
		Label label_LdapPort = new Label(groupLdap, SWT.NONE);
		label_LdapPort.setText("BaseDN: ");
		Text ladpPort = new Text(groupLdap, SWT.BORDER);
		ladpPort.setLayoutData(gd_dbName);
		ladpPort.setText("eqweq");
		ladpPort.setEnabled(false);
		
		Label label_LdapUser = new Label(groupLdap, SWT.NONE);
		label_LdapUser.setText("上下文: ");
		Text ladpUser = new Text(groupLdap, SWT.BORDER);
		ladpUser.setLayoutData(gd_dbName);
		ladpUser.setText("eqwe");
		ladpUser.setEnabled(false);
		
//		Label label_LdapPwd = new Label(groupLdap, SWT.NONE);
//		label_LdapPwd.setText("LdapPwd: ");
//		Text ladpPwd = new Text(groupLdap, SWT.BORDER);
//		ladpPwd.setLayoutData(gd_dbName);
//		ladpPwd.setText(dBConfiguration.getLdapPwd());
//		ladpPwd.setEnabled(false);
		
		Label label_LdapDN = new Label(groupLdap, SWT.NONE);
		label_LdapDN.setText("LdapDN: ");
		Text ladpDN = new Text(groupLdap, SWT.BORDER);
		ladpDN.setLayoutData(gd_dbName);
		ladpDN.setText("eqwewqwqe");
		ladpDN.setEnabled(false);
		
		//testConnect.setLayoutData(gd_testConnect);
		new Label(shell,SWT.NONE);
        new Label(shell,SWT.NONE);
        new Label(shell,SWT.NONE);
        new Label(shell,SWT.NONE);
		Button button = new Button(shell, SWT.NONE);
		GridData gd_btnNewButton_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_1.widthHint = 65;
		gd_btnNewButton_1.heightHint = 25;
		button.setLayoutData(gd_btnNewButton_1);
		
		//4
		gd_group1.grabExcessVerticalSpace=true;
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {}
		});
		button.setText("eqwewqqw");
		
//		shellWidth = shell.getSize().x;
//		resizeListener1 = new ResizeListener(gd_dbName_p, shell);
//		procedureHost.addControlListener(resizeListener1);
	//	resizeListener = new ResizeListener(gd_dbName, gd_dbName_p ,shell);
//			resizeListener = new ResizeListener(gd_dbName_p, shell);
//		shell.addControlListener (resizeListener);
		
		//为数据类型下拉框添加事件
//		dbType.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				if(dbType.getText().equals("XCLOUD")){
//					GridData gd_group2=new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
//					gd_group2.heightHint=105;
//					group.setLayoutData(gd_group2);
//					shell.setSize(523, 225);
////					label_5.setVisible(true);
////					label_6.setVisible(true);
//					label_7.setVisible(true);
////					connectRetry.setVisible(true);
////					socketTimeOut.setVisible(true);
//					connectDirect.setVisible(true);
//					
//				}else {
//					GridData gd_group1=new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1);
//					gd_group1.heightHint=100;
//					group.setLayoutData(gd_group1);
//					shell.setSize(523, 216);
//					label_5.setVisible(false);
//					label_6.setVisible(false);
//					label_7.setVisible(false);
//					connectRetry.setVisible(false);
//					socketTimeOut.setVisible(false);
//					connectDirect.setVisible(false);
			//	}
//			}
//		});

	
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
