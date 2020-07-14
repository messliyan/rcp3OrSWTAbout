/*
 *任务进度显示.java2019年2月18日
 *
 */
package 线程;

import org.eclipse.swt.widgets.Display;

/**
 *
 *@author 李佳斌
 */
public class Task后台任务进度显示 {
	private TaskUI前台任务进度显示 taskGUI;//得到前台界面的对象引用
	
	private boolean stopFlag;//停止后台处理的标志
	
	//通过构造函数传入前台界面类的对象引用
	public Task后台任务进度显示(TaskUI前台任务进度显示 taskUI前台任务进度显示) {
		// TODO 自动生成的构造函数存根
		this.taskGUI=taskUI前台任务进度显示;
	}
	//停止后台处理
	public void stop() {
		// TODO 自动生成的方法存根
		stopFlag=true;
	}

	public void start(int taskCount) {//开始后台处理
		// TODO 自动生成的方法存根
		stopFlag = false;//修改停止标志
		log("后台线程开始执行任务...\n");
		for (int i= 0;i< taskCount; i++){
		if (stopFlag)//一旦发现标志被设为停止，则退出循环
		break;
		//每隔0.1秒次循环，用于模拟一个需时较长的任务
		try { Thread.sleep(100);}
		catch (InterruptedException e) {
			log(e. getMessage());}
		log("任务"+ (i+ 1)+ "处理完毕\n");
		notilyOneTaskFinish(i);//通知完成了-一个任务

		}
		log("后台线程结束执行任务!!!!!!\n");
		notifyAlTasksFinish();//通知已完成了所有任务
	}
	
		private void log(final String str) {
			Display.getDefault().syncExec(new Runnable() {
				
				@Override
				public void run() {
					// TODO 自动生成的方法存根
					taskGUI.consoleprintln(str); //向前台界面的consoleText输出字符串
				}
			});
		
	}
		private void notilyOneTaskFinish(final int progress) {
		 Display.getDefault().syncExec(new Runnable() {
		public void run() {
		taskGUI.moveProgress(progress); //移动前台界面的进度条

		}
		});
	}
	private void notifyAlTasksFinish() {
		// TODO 自动生成的方法存根
		 Display.getDefault().syncExec(new Runnable() {
				public void run() { //修改界面状态按钮，让执行按钮有效，停止按钮无效
				taskGUI.setButtonState(true);

				}
				});
	}

}
