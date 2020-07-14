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

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  Tabble��� {
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
		//����һ�� �ɶ�ѡ �ı�� ������������ʾ��ͷ�ͱ����
		final Table table=new Table(shell, SWT.MULTI|SWT.FULL_SELECTION);
		
		table.setHeaderVisible(true);
		
		table.setLinesVisible(true);
		//Ϊtable�������в������п���80
		TableColumn col1=new TableColumn(table, SWT.NONE);
		
		col1.setText("ID");
		
		col1.setWidth(80);
		
		TableColumn col2=new TableColumn(table, SWT.NONE);
		
		col2.setText("����");
		
		col2.setWidth(80);
		
		//����һ��Composite������������������ť
		Composite composite=new Composite(shell, SWT.NONE);
		
		composite.setLayout(new RowLayout());
		
		Button addButtonm=new Button(composite, SWT.NONE);
		
		addButtonm.setText("����");
		addButtonm.addSelectionListener(new SelectionAdapter() {
			         int i; 
					@Override
			        public void widgetSelected(SelectionEvent e) {
			        	// TODO �Զ����ɵķ������
			        	TableItem item=new TableItem(table, 0);
			        	//����Item
			        	item.setText(new String[]{""+i,"�¸�"+i});
			        	//��Item����
			        	i++;
					}
		});
			
		Button removeButtonm=new Button(composite, SWT.NONE);
		
		removeButtonm.setText("ɾ��");
		
		removeButtonm.addSelectionListener(new SelectionAdapter() {
			         int i; 
					@Override
			        public void widgetSelected(SelectionEvent e) {
			        	// TODO �Զ����ɵķ������
			        	int [] selinices=table.getSelectionIndices();
			        	//�õ����б�ѡ���¼����ţ�Ȼ�������Ž���¼ɾ��
			        	table.remove(selinices);
					}
		});
		//����Table�����˫���¼�������ʾ��˫���ļ�¼
		table.addMouseListener(new org.eclipse.swt.events.MouseAdapter() {

		@Override
		public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
			// TODO �Զ����ɵķ������
			int sellndex =table.getSelectionIndex();
			
			TableItem item=table.getItem(sellndex);
			
			String string="�� 1="+item.getText(0)+"\t�� 2="+item.getText(1);
			MessageDialog.openInformation(null, null, string);
			
			
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
