package ��swing;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Vector;

import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019��1��28��
 *
 */
/**
 * ��Swing����SWT��
 * 
 * @author ��ѱ�
 */
public class SwingTableInswt {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
//		shell����������
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
		shell.setLayout(new FillLayout());
//	���������������������
//	--
		//�½�SWT���
		Composite composite=new Composite(shell, SWT.NO_BACKGROUND|SWT.EMBEDDED);
		
		//��SWT������½�һ��Frame����
		Frame frame=SWT_AWT.new_Frame(composite);
		
		Panel panel=new Panel(new BorderLayout()) {
			
			@Override
			public void update(Graphics g) {
				// TODO �Զ����ɵķ������
			paint(g);
			}
			
		};
		
		//�������������
		
		frame.add(panel);
		
		JRootPane rootPane= new  JRootPane();
		
		panel.add(rootPane);
		
		java.awt.Container container=rootPane.getContentPane();
		
		int nrows=1000, ncolums=10;
		//˫�㼯��
		Vector rows=new Vector();
		for (int i = 0; i < nrows; i++) {
			
		Vector row=new Vector();
		for (int j = 0; j < ncolums; j++) {
			
		row.addElement("item"+i+"-"+j);
			
		}
		
			rows.addElement(row);
		}
		
		Vector colums= new Vector();
		for (int i = 0; i < ncolums; i++) {
			colums.addElement("Colum"+i);
			
		}
		
		JTable table=new JTable(rows,colums);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		table.createDefaultColumnsFromModel();
		
		JScrollPane scrollPane=new JScrollPane(table);
		
		container.setLayout(new BorderLayout());
		//�����Ҫ���
		container.add(scrollPane);
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
