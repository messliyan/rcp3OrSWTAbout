package 其他组件;

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
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */

public	class  Tray系统托盘 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
		final ToolTip tip=new ToolTip(shell, SWT.BALLOON|SWT.ICON_INFORMATION);
		//取得系统托盘对象
		final	Tray tray=shell.getDisplay().getSystemTray();
		
		if (tray!=null) {
		final TrayItem item=new TrayItem(tray,SWT.NONE);
		//创建托盘对象
		item.setToolTipText("QQ");	
		//托盘提示文字
		item.setImage(new Image(display, "icon/star.jpg"));
		
		item.setToolTip(tip);
		//生成菜单项,右键单击托盘图标时显示
		final Menu menu=new Menu(shell, SWT.POP_UP);
		
		final MenuItem showitem=new MenuItem(menu, SWT.PUSH);
		
		showitem.setText("&Hide");
		showitem.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
				boolean showFlag=shell.isVisible();
				
				shell.setVisible(!showFlag);
				
				showitem.setText(showFlag?"&SHow":"&Hide");
			
				tip.setText("QQ的托盘图标");
				tip.setMessage("右键单击图标，\n可以选择菜单");
				tip.setVisible(true);
			}
		});
		
		final MenuItem exititem=new MenuItem(menu, SWT.PUSH);
		
		exititem.setText("");
		exititem.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
			System.exit(0);
			}
		});
		//------ 为托盘添加事件-------
		item.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				// TODO 自动生成的方法存根
				System.out.println("鼠标单击");
			}
		});
		
		item.addListener(SWT.DefaultSelection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				// TODO 自动生成的方法存根
				System.out.println("鼠标双击");
			}
		});
	item.addListener(SWT.MenuDetect, new Listener() {
	
	@Override
	public void handleEvent(Event event) {
		// TODO 自动生成的方法存根
		menu.setVisible(true);//右键单击图标时，显示菜单
	}
});
	//效果：关闭窗口时最小化托盘
	shell.addShellListener(new ShellAdapter() {
	
		
		@Override
		public void shellIconified(ShellEvent e) {
			// TODO 自动生成的方法存根
			e.doit=false;
			//使窗口的关闭按钮无效
			shell.setVisible(false);
			showitem.setText("&show");
			tip.setText("QQ的托盘图标");
			tip.setMessage("右键单击图标。\n可以选择菜单");
			tip.setVisible(true);
		}
		});
		}else {
			tip.setText("该系统不支持托盘效果");
			tip.setLocation(400,400);
		}
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
