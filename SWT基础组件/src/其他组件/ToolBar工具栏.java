package �������;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
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
public	class  ToolBar������ {
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
	ViewForm viewForm=new ViewForm(shell, SWT.NONE);
	viewForm.setLayout(new FillLayout());
	
	//��viewForm�����д����ı���
	final Text text=new Text(viewForm, SWT.BORDER|SWT.WRAP|SWT.V_SCROLL);
	viewForm.setContent(text);
	//�����ı���ΪViewForm�������
	
	//��ViewForm�����ﴴ��������������Ӱ�ť�¼�
	ToolBar toolBar=new ToolBar(viewForm, SWT.NONE);
	ToolItem getItem = new ToolItem(toolBar, SWT.NONE);
	getItem.setText("ȡ��");
	//getItem.setImage(new Image(display, "") );
	//�ڶ�����Ϊ���·��
	getItem.addSelectionListener(new SelectionAdapter() {
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO �Զ����ɵķ������
			String string=text.getText();
		MessageDialog.openInformation(null	, null, string);
	}
	
	});
	ToolItem clearItem = new ToolItem(toolBar, SWT.PUSH);
	clearItem.setText("���");
	//clearItem.setImage(new Image(display, ""));
	clearItem.addSelectionListener(new SelectionAdapter() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			// TODO �Զ����ɵķ������
			text.setText("");
			//����ı�������
		}
	});
	viewForm.setTopLeft(toolBar);
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
