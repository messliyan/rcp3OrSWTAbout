package 其他组件;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  Menu菜单类 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello World");
//	创建窗口中其他界面组件
//	--------
		//创建主菜单 ：文件、帮助
	Menu	mainMenu=new Menu(shell,SWT.BAR);
	//设置菜单栏bar
	shell.setMenuBar(mainMenu);
	
	
	/*右键菜单
	 * Menu mainMenu=new Menu(shell,SWT.POP_UP)；
	 * shell.setMenu(mainMenu);
	 * 
	 */
	MenuItem fileitem=new MenuItem(mainMenu, SWT.CASCADE);
	
	
	fileitem.setText("文件(&F)");
	
	MenuItem helpitem=new MenuItem(mainMenu, SWT.CASCADE);
	helpitem.setText("帮助(&H)");
	
	//创建“文件”菜单下的子菜单：新建、退出
	Menu fileMenu=new Menu(shell,SWT.DROP_DOWN);
	
	fileitem.setMenu(fileMenu);
	
	MenuItem newFileitem=new MenuItem(fileMenu,SWT.CASCADE);
	
	newFileitem.setText("新建(&N)");
	
	MenuItem exititem=new MenuItem(fileMenu,SWT.CASCADE);
	
	exititem.setText("退出");
	
	//创建“文本—>新建”菜单下的子菜单：项目、包、类、接口、其他
	Menu newFileMenu=new Menu(shell,SWT.DROP_DOWN);
	
	newFileitem.setMenu(newFileMenu);
	
	MenuItem newProjectItem=new MenuItem(newFileMenu , SWT.PUSH);
	
	newProjectItem.setText("项目\tCtrl+N");
	//\t相当于Tab键，起到间隔的作用
	
	newProjectItem.setAccelerator(SWT.CTRL+'N');
	// 定义快捷键Ctrl+N
	//newProjectItem.setImage(new Image(device, data));

	//监听菜单项的选择事件
	newProjectItem.addSelectionListener(new SelectionAdapter(
			) {
		@Override
		public void widgetSelected(SelectionEvent e) {
			// TODO 自动生成的方法存根
			MessageDialog.openInformation(null, "", "");
			
		}
	});
	//建立其他菜单项
	new MenuItem(newFileMenu, SWT.SEPARATOR);
	//分隔符
	new MenuItem(newFileMenu, SWT.PUSH).setText("包");;
	
	new MenuItem(newFileMenu, SWT.PUSH).setText("类");;
	
	new MenuItem(newFileMenu, SWT.PUSH).setText("接口");;
	
	new MenuItem(newFileMenu, SWT.SEPARATOR);
	
	new MenuItem(newFileMenu, SWT.PUSH).setText("其他(&O)");;
	
	
	
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
