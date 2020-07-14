/*
 *���������ʾ.java2019��2��18��
 *
 */
package �߳�;


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
 * @author ��ѱ�
 */

public class TaskUIǰ̨���������ʾ {
	private Task��̨���������ʾ task = new Task��̨���������ʾ(this);
	
	private Text taskcounText;//�������ı���
	
	private Button startButton;//��ִ�С���ť
	
	private Button stopButton;//��ֹͣ�� ��ť
	
	private ProgressBar progressBar;//������
	
	private Text consoleText;//���������־���ı���
	
	
	public static void main(String[] args) {
		new TaskUIǰ̨���������ʾ().open();
	}
	private void open() {
		// TODO �Զ����ɵķ������
		final Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
			shell.setLayout(new GridLayout());

			//�������ı���Ͱ�ť����

					Group group = new Group(shell, SWT.NONE);

					group .setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
					group.setLayout(new GridLayout(4, false));//�������ı���

					new Label(group, SWT.NONE).setText("������: ");
					taskcounText = new Text(group, SWT.BORDER);
					taskcounText.setText("100");//Ĭ��������100

					taskcounText.setLayoutData(new GridData(100, -1));

					taskcounText.addVerifyListener(new VerifyListener() {
						
						@Override
						public void verifyText(VerifyEvent e) {
							// TODO �Զ����ɵķ������
							e.doit = "0123456789".indexOf(e.text)>= 0;
						}
					});

					//ִ���ť

					startButton = new Button(group, SWT.PUSH);
					startButton.setText("ִ��");

					startButton.addSelectionListener(new SelectionAdapter() {

					      public void widgetSelected(SelectionEvent e){

					    	  setButtonState(false);//����������ť��Ч/��Ч
					      //�õ������������߳�ʹ�õı���Ҫ������Ϊfinal

					      final int taskCount = Integer.valueOf(taskcounText.getText());
					      progressBar.setMaximum(taskCount-1);//��������ĸ���
					      consoleText.insert("��̨�����߳̿�ʼ����....\n");
					      		

					      new Thread() {//Ϊ��̨�����¿� һ���߳�
					    	  public void run() {
					    		 task.start(taskCount);
					    	  }
					      }.start();

					      consoleText.insert("��̨�����߳���������\n");
					      }

						
					      });

					//ֹͣ��ť

					stopButton = new Button(group, SWT.PUSH);
					stopButton.setText("ֹͣ");
					stopButton.setEnabled(false);

					stopButton.addSelectionListener(new SelectionAdapter(){

					      public void widgetSelected(SelectionEvent e){

					     task.stop();//��̨����ֹͣ
					   //  startButton.setEnabled(true);
					      }
					      });
					
					
					
					//������

					progressBar = new ProgressBar(shell, SWT.NONE);

					progressBar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
					//��־�ı���

					consoleText = new Text(shell, SWT.MULTI|SWT.BORDER |SWT.V_SCROLL);
					consoleText.setLayoutData(new GridData(GridData.FILL_BOTH));
					//��������������������

					shell.layout();
					shell.open();

					shell.addDisposeListener(new DisposeListener() {
						
						@Override
						public void widgetDisposed(DisposeEvent e) {
							// TODO �Զ����ɵķ������
							task.stop();
						}
					});

//	��������END������������
//		shell.layout();// Ӧ�ý��沼��
//		shell.open();// ��shell������
		while (!shell.isDisposed()) {// ���������û�йر�
//			��һֱѭ��
			if (!display.readAndDispatch()) {// ���display��æ��
//				����display��������
				display.sleep();
			}
		}
		display.sleep();

	}
	//��������ť����Ч/��Ч״̬ true ִ�а�ť��Ч��ֹͣ��ť��Ч
	public void setButtonState(boolean flag) {
		if (!startButton.isDisposed()) startButton.setEnabled(!flag);
		if (!stopButton.isDisposed()) stopButton.setEnabled(!flag);
		
	}
	//��ǰ�ƶ�������
	public void moveProgress(int progress){
		if(!progressBar.isDisposed()) progressBar.setSelection(progress);
	}
	//��cinsoleText�ı�������־
	public void consoleprintln(String str){
		if(!consoleText.isDisposed()) consoleText.insert(str);
	}
}
