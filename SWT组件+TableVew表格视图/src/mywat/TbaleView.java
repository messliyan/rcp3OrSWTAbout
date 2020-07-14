/*
 *HollowWorld.java2019��1��25��
 *
 */
package mywat;



import java.util.List;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;

import dao.PeopleEntry;
import dao.PeopleFactory;
import ���߰�.BoolActionGroup;
import ���߰�.MyActionGroup;
import ���߰�.MySorter;
import ���߰�.TableViewerContentProvider;
import ���߰�.TableViewerlabelProvider;

/**
 *
 * @author ��ѱ�
 */
public class TbaleView {
	public static void main(String[] args) {
		
		open () ;
		
	}
		
	public static void open () {
		// TODO �Զ����ɵķ������
		final Display display = new Display();
//		Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell=new Shell();
//		shell����������
	shell.setSize(727,553);
	//shell.setText("Company");
//	���������������������
	
	shell.setLayout(new FillLayout());
	ViewForm viewForm = new ViewForm(shell, SWT.NONE); //���ֻ���ViewForm
	viewForm.setLayout(new FillLayout());
	 TableViewer tv = new TableViewer(viewForm, SWT.CHECK | SWT.MULTI ); //��������shell��ΪviewForm

	final CheckboxTableViewer ctv = new CheckboxTableViewer(tv.getTable());
	//��������һ����ͬ�Ĵ��루ʡ�ԣ�
	//����������
	ToolBar toolBar = new ToolBar(viewForm, SWT.FLAT); // ����һ��ToolBar����
	ToolBarManager toolBarManager = new ToolBarManager(toolBar); // ����һ��toolBar�Ĺ�����
	

	//��һ��:����һ��TableViewer����ʽ��:MULTI�ɶ�ѡ��H SCROLL��ˮƽ��������
	//V_ SCROLI1�д�ֱ��������BORDER�б߿�FULL SELECTION����ѡ��

	/*TableViewer tv=new TableViewer(shell, SWT.MULTI |SWT.BORDER|SWT.FULL_SELECTION);
	//�ڶ���:ͨ������ں���Table�������ò��ַ�ʽ
*/	Table table = tv.getTable();

	table.setHeaderVisible(true); //��ʾ��ͷ
	table.setLinesVisible(true); //��ʾ�����

	TableLayout layout = new TableLayout(); //ר���ڱ��Ĳ���
	table.setLayout(layout);

	//������:��TableColumn�ഴ�������

	/*layout.addColumnData(new ColumnWeightData(13));
	// ID�п�13����
	new TableColumn(table, SWT.NONE).setText("ID��");
	
	layout.addColumnData(new ColumnWeightData(40));
	
	new TableColumn(table, SWT.NONE).setText("����");
	
	layout.addColumnData(new ColumnWeightData(20));
	
	new TableColumn(table, SWT.NONE).setText("�Ա�");
	
	layout.addColumnData(new ColumnWeightData(20));
	
	new TableColumn(table, SWT.NONE).setText("����");

	  layout.addColumnData(new ColumnWeightData(60));

      new TableColumn(table, SWT.NONE).setText("��¼����ʱ��");*/
	//Ϊ�������������¼�������
	layout.addColumnData(new ColumnWeightData(13));
	TableColumn col1 = new TableColumn(table, SWT.NONE);
	col1.setText("ID��");
	col1.addSelectionListener(new SelectionAdapter() {
	boolean asc = true; // ��¼��һ�ε�����ʽ��Ĭ��Ϊ����
	public void widgetSelected(SelectionEvent e) {
	// asc=true��ID�������������������ý���
	tv.setSorter(asc ? MySorter.ID_ASC : MySorter.ID_DESC);
	asc = !asc;// �õ���һ������ʽ
	}
	});
	
	layout.addColumnData(new ColumnWeightData(40));
	TableColumn col2 = new TableColumn(table, SWT.NONE);
	col2.setText("����");
	col2.addSelectionListener(new SelectionAdapter() {
	boolean asc = true;
	public void widgetSelected(SelectionEvent e) {
	tv.setSorter(asc ? MySorter.NAME_ASC : MySorter.NAME_DESC);
	asc = !asc;
	}
	});
      // ���Ĳ� �������������ͱ�ǩ��

      tv.setContentProvider(new TableViewerContentProvider());
      tv.setLabelProvider(new TableViewerlabelProvider());
      addListener(tv);
      

    //����һ��ActionGroup���󣬲�����fillContextMenu��������ťע�뵽�˵�������
    MyActionGroup actionGroup = new MyActionGroup(tv); 
    actionGroup.fillContextMenu(new MenuManager());
      //���岽����TableView��setInput����������������
      Object data = PeopleFactory.getPeoples();
      tv.setInput(data);
      BoolActionGroup boolGroup = new BoolActionGroup(tv,ctv); 
      boolGroup.fillActionToolBars(toolBarManager); //��Actionͨ��toolBarManagerע��ToolBar��
  	// ���ñ��͹������ڲ����е�λ��
  	viewForm.setContent(tv.getControl()); // ���壺���
  	viewForm.setTopLeft(toolBar); 
	
//	��������END������������
	//shell.layout();//Ӧ�ý��沼��

// ���˱�Ե��������
shell.open();
		while (!shell.isDisposed()) {//���������û�йر�
//			��һֱѭ��
			if (!display.readAndDispatch()) //���display��æ��
//				����display��������
				display.sleep();
			
		
	}
		display.dispose();
	}
	 private static void addListener(TableViewer tv) {
	    	// ���˫���¼�����
	    	tv.addDoubleClickListener(new IDoubleClickListener() {
	    	public void doubleClick(DoubleClickEvent event) {
	    	//�õ�����ѡ����������װ�˱���б�ѡ��ļ�¼��Ϣ
	    	IStructuredSelection selection = (IStructuredSelection) event.getSelection();
	    	// �õ���ѡ��ĵ�һ��ʵ����󣨱������ж�ѡ��������������ת��
	    	PeopleEntry o = (PeopleEntry) selection.getFirstElement();
	    	// ����һ����ʾ��
	    	MessageDialog.openInformation(null, "��ʾ", o.getName());
	    	}
	    	});

	    	// ѡ���¼�������������
	    	tv.addSelectionChangedListener(new ISelectionChangedListener() {
	    	public void selectionChanged(SelectionChangedEvent event) {
	    	// �¼�������롭�����ԣ�
	    	}
	    	});
	    	}
}
