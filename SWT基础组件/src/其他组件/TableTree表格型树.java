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
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  TableTree������� {
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
		//����һ��Tree���󣬲���ʾ��ͷ�ͱ����
		final Tree tree=new Tree(shell, SWT.BORDER);
		
		tree.setHeaderVisible(true);
		
		tree.setLinesVisible(true);
		
		
		//��������
		TreeColumn col1 = new TreeColumn(tree, SWT.LEAD);
		
		col1.setText("����");
		
		col1.setWidth(100);
		
		TreeColumn col2 = new TreeColumn(tree, SWT.LEAD);
		
		col2.setText("ְλ");
		
		col2.setWidth(80);
		
		TreeColumn col3 = new TreeColumn(tree, SWT.LEAD);
		
		col3.setText("�ص�");
		
		col3.setWidth(100);
		
		//��һ����¼��
		TreeItem Item1=new TreeItem(tree, SWT.NONE);
		
		Item1.setText("ppt��С��");
		
		createItem(Item1,"�ƿ�","�鳤","����ȫ��");
		
		createItem(Item1,"����","����Ա","��̳���");
		
		createItem(Item1,"�","����Ա","����");
		
		createItem(Item1,"�","����Ա","��˵�");
		
		
		//�ڶ�����¼��
		TreeItem Item2=new TreeItem(tree, SWT.NONE);
		
		Item2.setText("�й������");
		
		createItem(Item2,"�¸�","����","��Ь��רҵ");
		
		
		
		//��������ѡ���¼���������ѡ��¼��������ʾ�ڴ��ڱ�����
		tree.addSelectionListener(new SelectionAdapter() {
			         int i; 
					@Override
			        public void widgetSelected(SelectionEvent e) {
			        	// TODO �Զ����ɵķ������
			        	
						
						TreeItem[] items=tree.getSelection();
			        	//����Item
						TreeItem oItem=items[0];
			        	shell.setText(oItem.getText(0)+","
						+oItem.getText(1)+","+oItem.getText(2));
			        	
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

	private static void createItem(TreeItem treeItem
			,String a,String b,String c) {
		// TODO �Զ����ɵķ������
		new TreeItem(treeItem, SWT.NONE).setText(new String[] {a,b,c});
	}

}
