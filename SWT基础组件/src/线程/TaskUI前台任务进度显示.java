/*
 *任务进度显示.java2019年2月18日
 *
 */
package 线程;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

/**
 *
 * @author 李佳斌
 */

public class TaskUI前台任务进度显示 {
	private Task后台任务进度显示 task = new Task后台任务进度显示(this);
	
	private Text taskcounText;//任务数文本框
	
	private Button startButton;//“执行”按钮
	
	private Button stopButton;//“停止” 按钮
	
	private ProgressBar progressBar;//进度条
	
	private Text consoleText;//用于输出日志的文本框
	
	
	public static void main(String[] args) {
		new TaskUI前台任务进度显示().open();
	}
	private void open() {
		// TODO 自动生成的方法存根
		final Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
			shell.setLayout(new GridLayout());

			//任务数文本框和按钮的组

					Group group = new Group(shell, SWT.NONE);

					group .setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
					group.setLayout(new GridLayout(4, false));//任务数文本框

					new Label(group, SWT.NONE).setText("任务数: ");
					taskcounText = new Text(group, SWT.BORDER);
					taskcounText.setText("100");//默认任务数100

					taskcounText.setLayoutData(new GridData(100, -1));

					taskcounText.addVerifyListener(new VerifyListener() {
						
						@Override
						public void verifyText(VerifyEvent e) {
							// TODO 自动生成的方法存根
							e.doit = "0123456789".indexOf(e.text)>= 0;
						}
					});

					//执行铵钮

					startButton = new Button(group, SWT.PUSH);
					startButton.setText("执行");

					startButton.addSelectionListener(new SelectionAdapter() {

					      public void widgetSelected(SelectionEvent e){

					    	  setButtonState(false);//设置两个按钮有效/无效
					      //得到任务数。多线程使用的变量要求类型为final

					      final int taskCount = Integer.valueOf(taskcounText.getText());
					      progressBar.setMaximum(taskCount-1);//设进度条的格数
					      consoleText.insert("后台处理线程开始启动....\n");
					      		

					      new Thread() {//为后台任务新开 一个线程
					    	  public void run() {
					    		 task.start(taskCount);
					    	  }
					      }.start();

					      consoleText.insert("后台处理线程启动结束\n");
					      }

						
					      });

					//停止按钮

					stopButton = new Button(group, SWT.PUSH);
					stopButton.setText("停止");
					stopButton.setEnabled(false);

					stopButton.addSelectionListener(new SelectionAdapter(){

					      public void widgetSelected(SelectionEvent e){

					     task.stop();//后台任务停止
					   //  startButton.setEnabled(true);
					      }
					      });
					
					
					
					//进度条

					progressBar = new ProgressBar(shell, SWT.NONE);

					progressBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
					//日志文本框

					consoleText = new Text(shell, SWT.MULTI|SWT.BORDER |SWT.V_SCROLL);
					consoleText.setLayoutData(new GridData(GridData.FILL_BOTH));
					//——————————

					shell.layout();
					shell.open();

					shell.addDisposeListener(new DisposeListener() {
						
						@Override
						public void widgetDisposed(DisposeEvent e) {
							// TODO 自动生成的方法存根
							task.stop();
						}
					});

//	————END——————
//		shell.layout();// 应用界面布局
//		shell.open();// 打开shell主窗口
		while (!shell.isDisposed()) {// 如果主窗口没有关闭
//			则一直循环
			if (!display.readAndDispatch()) {// 如果display不忙，
//				就让display处于休眠
				display.sleep();
			}
		}
		display.sleep();

	}
	//设置两按钮的有效/无效状态 true 执行按钮有效，停止按钮无效
	public void setButtonState(boolean flag) {
		if (!startButton.isDisposed()) startButton.setEnabled(!flag);
		if (!stopButton.isDisposed()) stopButton.setEnabled(!flag);
		
	}
	//向前移动进度条
	public void moveProgress(int progress){
		if(!progressBar.isDisposed()) progressBar.setSelection(progress);
	}
	//向cinsoleText文本输入日志
	public void consoleprintln(String str){
		if(!consoleText.isDisposed()) consoleText.insert(str);
	}
}
