package �������;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  Tree�� {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(327, 253);
		shell.setText("Hello World");
//	���������������������
//	--------
		shell.setLayout(new FillLayout());
		//����һ��Tree����SWT.SINLE��ѡ��SWT.MULTI�ɶ�ѡ
		final Tree tree=new Tree(shell, SWT.SINGLE);
		
		TreeItem chinaItem=new TreeItem(tree, SWT.NONE);
		
		chinaItem.setText("�й�");
		
		new TreeItem(chinaItem, SWT.NULL).setText("����");
		
		new TreeItem(chinaItem, SWT.NULL).setText("̨��");
		
		new TreeItem(chinaItem, SWT.NULL).setText("����");
		
		new TreeItem(tree, SWT.NULL).setText("����");
		
		//��������Tree�Ľ��ʱ�����������ʾ�ڴ��ڱ�������
		tree.addSelectionListener(new SelectionAdapter() {
			         int i; 
					@Override
			        public void widgetSelected(SelectionEvent e) {
			        	// TODO �Զ����ɵķ������
			        	
						
						TreeItem[] items=tree.getSelection();
			        	//����Item
			        	shell.setText(items[0].getText());
			        	
					}
		});
			
		
		
//	��������END������������
		//shell.layout();// Ӧ�ý��沼��
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
