package 常用组件;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  List2列表框 {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
		 final List list=new List(shell, SWT.MULTI);
			
		 list.setBounds(10, 10, 125, 80);
			 
			 //设置按钮
			 Button setButton=new Button(shell, SWT.NONE);
			 setButton .setText(" 设值");
			 setButton.setBounds(10, 100, 70, 40);
			 setButton.addSelectionListener(new SelectionAdapter() {
				 	@Override
				 	public void widgetSelected(SelectionEvent e) {
				 		// TODO 自动生成的方法存根
				 		list.removeAll();
				 		//先清空combo，以防多下按下“设值”按钮时出bug
				 		list.add("语文");
				 		//加入Combo显示值
				 		list.add("数学");
				 		list.add("政治");
				 		list.setData("语文", "YW");
				 		//设置显示值的代表值
				 		list.setData("数学", "SX");
				 		list.setData("政治", "ZZ");
				 		list.select(new int[] {0,2});
				 		//设置第一,三项为选择项
				 	}
			});
			 
			 //取值按钮
			 Button getButton=new Button(shell, SWT.NONE);
			 getButton .setText("取值");
			 getButton.setBounds(80, 100, 70, 40);
			 getButton.addSelectionListener(new SelectionAdapter() {
				 	@Override
				 	public void widgetSelected(SelectionEvent e) {
				 		// TODO 自动生成的方法存根
				 	String bud = "";
				 	for (String s : list.getSelection()) {
				 		//getSelection 返回所有选择项组成的String数组
						bud+=s+list.getData(s)+",";
					}
				 		MessageDialog.openInformation(null, null, bud.toString());
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
