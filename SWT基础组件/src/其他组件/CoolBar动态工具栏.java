package �������;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  CoolBar��̬������ {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
	shell.setLayout(new FillLayout());
	//��viewform��Ϊ�ײ��������������Ͳ���
	final	ViewForm viewForm=new ViewForm(shell, SWT.NONE);
	viewForm.setLayout(new FillLayout());
	
	//��viewForm�����д����ı���
	final Text text=new Text(viewForm, SWT.BORDER|SWT.V_SCROLL);
	viewForm.setContent(text);
	//�����ı���ΪViewForm�������
	
	//
	CoolBar coolBar=new CoolBar(viewForm, SWT.NONE);
	{
		//��ViewForm�����ﴴ��������������Ӱ�ť�¼�
		ToolBar toolBar=new ToolBar(coolBar, SWT.NONE);
		ToolItem getItem = new ToolItem(toolBar, SWT.PUSH);
		getItem.setText("ȡ��");
		
		ToolItem clearItem = new ToolItem(toolBar, SWT.PUSH);
		clearItem.setText("���");
		
		CoolItem coolItem=new CoolItem(coolBar, SWT.NONE);
		coolItem.setControl(toolBar);
		//
		toolBar.pack();
		Point size=toolBar.getSize();
		coolItem.setSize(size);
		coolItem.setMinimumSize(size);
	}
	
	{
		ToolBar toolBar=new ToolBar(coolBar, SWT.NONE);
		ToolItem toolItem = new ToolItem(toolBar, SWT.PUSH);
		//toolItem.setText("ȡ��");
		
//		ToolItem clearItem = new ToolItem(toolBar, SWT.PUSH);
//		clearItem.setText("���");
		CoolItem coolItem=new CoolItem(coolBar, SWT.NONE);
		coolItem.setControl(toolBar);
		//
		toolBar.pack();
		Point size=toolBar.getSize();
		coolItem.setSize(size);
		coolItem.setMinimumSize(size);
	}
	viewForm.setTopLeft(coolBar);
	
	
	coolBar.addControlListener(new ControlAdapter() {
		@Override
		public void controlResized(ControlEvent e) {
			// TODO �Զ����ɵķ������
			viewForm.layout();
		}
	});
	//���ù�������viewForm��λ��Ϊ���˿��� 
	//�˾�������toolBar�������֮��
	
//	��������END������������
	//	shell.layout();// Ӧ�ý��沼��
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
