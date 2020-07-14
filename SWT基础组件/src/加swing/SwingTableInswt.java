package 加swing;

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
 *Button.java2019年1月28日
 *
 */
/**
 * 将Swing加入SWT中
 * 
 * @author 李佳斌
 */
public class SwingTableInswt {
	public static void main(String[] args) {
		Display display = Display.getDefault();
//		Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
//		shell程序主窗口
		shell.setSize(500, 500);
		shell.setText("Hello Woeld");
		shell.setLayout(new FillLayout());
//	创建窗口中其他界面组件
//	--
		//新建SWT组件
		Composite composite=new Composite(shell, SWT.NO_BACKGROUND|SWT.EMBEDDED);
		
		//在SWT组件上新建一个Frame容器
		Frame frame=SWT_AWT.new_Frame(composite);
		
		Panel panel=new Panel(new BorderLayout()) {
			
			@Override
			public void update(Graphics g) {
				// TODO 自动生成的方法存根
			paint(g);
			}
			
		};
		
		//容器中添加容器
		
		frame.add(panel);
		
		JRootPane rootPane= new  JRootPane();
		
		panel.add(rootPane);
		
		java.awt.Container container=rootPane.getContentPane();
		
		int nrows=1000, ncolums=10;
		//双层集合
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
		//添加想要组件
		container.add(scrollPane);
//	————END——————
	//	shell.layout();// 应用界面布局
		shell.open();// 打开shell主窗口
		while (!shell.isDisposed()) {// 如果主窗口没有关闭
//			则一直循环
			if (!display.readAndDispatch()) {// 如果display不忙，
//				就让display处于休眠
				display.sleep();
			}
		}
		display.sleep();

	}

}
