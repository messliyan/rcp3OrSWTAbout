package �������;


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
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  Menu�˵��� {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello World");
//	���������������������
//	--------
		//�������˵� ���ļ�������
	Menu	mainMenu=new Menu(shell,SWT.BAR);
	//���ò˵���bar
	shell.setMenuBar(mainMenu);
	
	
	/*�Ҽ��˵�
	 * Menu mainMenu=new Menu(shell,SWT.POP_UP)��
	 * shell.setMenu(mainMenu);
	 * 
	 */
	MenuItem fileitem=new MenuItem(mainMenu, SWT.CASCADE);
	
	
	fileitem.setText("�ļ�(&F)");
	
	MenuItem helpitem=new MenuItem(mainMenu, SWT.CASCADE);
	helpitem.setText("����(&H)");
	
	//�������ļ����˵��µ��Ӳ˵����½����˳�
	Menu fileMenu=new Menu(shell,SWT.DROP_DOWN);
	
	fileitem.setMenu(fileMenu);
	
	MenuItem newFileitem=new MenuItem(fileMenu,SWT.CASCADE);
	
	newFileitem.setText("�½�(&N)");
	
	MenuItem exititem=new MenuItem(fileMenu,SWT.CASCADE);
	
	exititem.setText("�˳�");
	
	//�������ı���>�½����˵��µ��Ӳ˵�����Ŀ�������ࡢ�ӿڡ�����
	Menu newFileMenu=new Menu(shell,SWT.DROP_DOWN);
	
	newFileitem.setMenu(newFileMenu);
	
	MenuItem newProjectItem=new MenuItem(newFileMenu , SWT.PUSH);
	
	newProjectItem.setText("��Ŀ\tCtrl+N");
	//\t�൱��Tab�����𵽼��������
	
	newProjectItem.setAccelerator(SWT.CTRL+'N');
	// �����ݼ�Ctrl+N
	//newProjectItem.setImage(new Image(device, data));

	//�����˵����ѡ���¼�
	newProjectItem.addSelectionListener(new SelectionAdapter(
			) {
		@Override
		public void widgetSelected(SelectionEvent e) {
			// TODO �Զ����ɵķ������
			MessageDialog.openInformation(null, "", "");
			
		}
	});
	//���������˵���
	new MenuItem(newFileMenu, SWT.SEPARATOR);
	//�ָ���
	new MenuItem(newFileMenu, SWT.PUSH).setText("��");;
	
	new MenuItem(newFileMenu, SWT.PUSH).setText("��");;
	
	new MenuItem(newFileMenu, SWT.PUSH).setText("�ӿ�");;
	
	new MenuItem(newFileMenu, SWT.SEPARATOR);
	
	new MenuItem(newFileMenu, SWT.PUSH).setText("����(&O)");;
	
	
	
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
