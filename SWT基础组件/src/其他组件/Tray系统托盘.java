package �������;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */

public	class  Trayϵͳ���� {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		final ToolTip tip=new ToolTip(shell, SWT.BALLOON|SWT.ICON_INFORMATION);
		//ȡ��ϵͳ���̶���
		final	Tray tray=shell.getDisplay().getSystemTray();
		
		if (tray!=null) {
		final TrayItem item=new TrayItem(tray,SWT.NONE);
		//�������̶���
		item.setToolTipText("QQ");	
		//������ʾ����
		item.setImage(new Image(display, "icon/star.jpg"));
		
		item.setToolTip(tip);
		//���ɲ˵���,�Ҽ���������ͼ��ʱ��ʾ
		final Menu menu=new Menu(shell, SWT.POP_UP);
		
		final MenuItem showitem=new MenuItem(menu, SWT.PUSH);
		
		showitem.setText("&Hide");
		showitem.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
				boolean showFlag=shell.isVisible();
				
				shell.setVisible(!showFlag);
				
				showitem.setText(showFlag?"&SHow":"&Hide");
			
				tip.setText("QQ������ͼ��");
				tip.setMessage("�Ҽ�����ͼ�꣬\n����ѡ��˵�");
				tip.setVisible(true);
			}
		});
		
		final MenuItem exititem=new MenuItem(menu, SWT.PUSH);
		
		exititem.setText("");
		exititem.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
			System.exit(0);
			}
		});
		//------ Ϊ��������¼�-------
		item.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				// TODO �Զ����ɵķ������
				System.out.println("��굥��");
			}
		});
		
		item.addListener(SWT.DefaultSelection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				// TODO �Զ����ɵķ������
				System.out.println("���˫��");
			}
		});
	item.addListener(SWT.MenuDetect, new Listener() {
	
	@Override
	public void handleEvent(Event event) {
		// TODO �Զ����ɵķ������
		menu.setVisible(true);//�Ҽ�����ͼ��ʱ����ʾ�˵�
	}
});
	//Ч�����رմ���ʱ��С������
	shell.addShellListener(new ShellAdapter() {
	
		
		@Override
		public void shellIconified(ShellEvent e) {
			// TODO �Զ����ɵķ������
			e.doit=false;
			//ʹ���ڵĹرհ�ť��Ч
			shell.setVisible(false);
			showitem.setText("&show");
			tip.setText("QQ������ͼ��");
			tip.setMessage("�Ҽ�����ͼ�ꡣ\n����ѡ��˵�");
			tip.setVisible(true);
		}
		});
		}else {
			tip.setText("��ϵͳ��֧������Ч��");
			tip.setLocation(400,400);
		}
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
