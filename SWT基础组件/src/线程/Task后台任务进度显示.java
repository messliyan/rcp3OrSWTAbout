/*
 *���������ʾ.java2019��2��18��
 *
 */
package �߳�;

import org.eclipse.swt.widgets.Display;

/**
 *
 *@author ��ѱ�
 */
public class Task��̨���������ʾ {
	private TaskUIǰ̨���������ʾ taskGUI;//�õ�ǰ̨����Ķ�������
	
	private boolean stopFlag;//ֹͣ��̨����ı�־
	
	//ͨ�����캯������ǰ̨������Ķ�������
	public Task��̨���������ʾ(TaskUIǰ̨���������ʾ taskUIǰ̨���������ʾ) {
		// TODO �Զ����ɵĹ��캯�����
		this.taskGUI=taskUIǰ̨���������ʾ;
	}
	//ֹͣ��̨����
	public void stop() {
		// TODO �Զ����ɵķ������
		stopFlag=true;
	}

	public void start(int taskCount) {//��ʼ��̨����
		// TODO �Զ����ɵķ������
		stopFlag = false;//�޸�ֹͣ��־
		log("��̨�߳̿�ʼִ������...\n");
		for (int i= 0;i< taskCount; i++){
		if (stopFlag)//һ�����ֱ�־����Ϊֹͣ�����˳�ѭ��
		break;
		//ÿ��0.1���ѭ��������ģ��һ����ʱ�ϳ�������
		try { Thread.sleep(100);}
		catch (InterruptedException e) {
			log(e. getMessage());}
		log("����"+ (i+ 1)+ "�������\n");
		notilyOneTaskFinish(i);//֪ͨ�����-һ������

		}
		log("��̨�߳̽���ִ������!!!!!!\n");
		notifyAlTasksFinish();//֪ͨ���������������
	}
	
		private void log(final String str) {
			Display.getDefault().syncExec(new Runnable() {
				
				@Override
				public void run() {
					// TODO �Զ����ɵķ������
					taskGUI.consoleprintln(str); //��ǰ̨�����consoleText����ַ���
				}
			});
		
	}
		private void notilyOneTaskFinish(final int progress) {
		 Display.getDefault().syncExec(new Runnable() {
		public void run() {
		taskGUI.moveProgress(progress); //�ƶ�ǰ̨����Ľ�����

		}
		});
	}
	private void notifyAlTasksFinish() {
		// TODO �Զ����ɵķ������
		 Display.getDefault().syncExec(new Runnable() {
				public void run() { //�޸Ľ���״̬��ť����ִ�а�ť��Ч��ֹͣ��ť��Ч
				taskGUI.setButtonState(true);

				}
				});
	}

}
