package Layout����;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  �ۺϲ���qq {
	
	private StackLayout	stackLayout =new StackLayout();
	private	Composite yourDataComp;
	private Composite otherComp;
	private List selectList;
	private Composite rightComp;
//	private Image qqImage=new Image(null, null);
	public static void main(String[] args) {
		new �ۺϲ���qq().open();
	}
	private void open() {
		// TODO �Զ����ɵķ������
		Display display = Display.getDefault();
		//Display����ʾ�� �¼�+UI�߳��йص�ͨ��
		final Shell shell = new Shell();
		//		shell����������
		shell.setSize(500, 500);
		shell.setText("��������");
		
		//	���������������������
		//	--------
		shell.setLayout(new GridLayout());
		//����һ���ָ
		SashForm sashForm=new SashForm(shell, SWT.BORDER);
		sashForm.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		selectList = new List(sashForm, SWT. BORDER);
		//�ָ��ߵ��б�
		selectList.setItems(new String[] {"��������","��ϵ��ʽ"});
		// selectL istaddSelectionL istener(new MySelectionL istener):
		//��ѡ�������
		rightComp = new Composite(sashForm, SWT.NONE);
		//�ұߵĶ�ջʽ����
		rightComp.setLayout(stackLayout);

	     //����ҳ�����������Ĵ���������Զ��巽������֤����ṹ������
		yourDataComp = createYourDataComp(rightComp);
		//���������ϡ����
		otherComp=createOtherComp(rightComp);
		// ����ϵ��ʽ�����

	     stackLayout.topControl = yourDataComp;
	     //�ڶ�ջ����������ʾ���������ϡ����
	     sashForm.setWeights(new int[] {1,4});
	   //�ָ�ڵ����ҿռ����
  //------�ײ��İ�ť�����- -һ-- --

	     Composite buttonComp = new Composite(shell, SWT.BORDER);
	      //��GridDataʹ��ť��������丸����Shell���ұ߽����
	      GridData gridData = new GridData();

      gridData.horizontalAlignment = GridData.END;
      buttonComp.setLayoutData(gridData);

      //�趨��ť������ڰ�ťΪ����ʽ���֣���ť���15����
      RowLayout rowLayout = new RowLayout();
      rowLayout.spacing = 15;
      buttonComp.setLayout(rowLayout);
      //��buttonComp�½���3����ť����ȫ�ǿո�ſ���ť
      new Button(buttonComp, SWT.NONE).setText("  ȷ��  ");
      new Button(buttonComp, SWT.NONE).setText("  ȡ��  ");
      new Button(buttonComp, SWT.NONE).setText("	Ӧ��  ");

 //	��������END������������
		//		shell.layout();// Ӧ�ý��沼��
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
	private Composite createOtherComp(Composite rightComp2) {
		// TODO �Զ����ɵķ������
		return null;
	}
	//���������������
	private Composite createYourDataComp(Composite rightComp) {
		// TODO �Զ����ɵķ������
		   Composite comp = new Composite(rightComp, SWT.NONE);
		   comp.setLayout(new GridLayout(6, false));
		   //��屻�ֳ�����

		      new Label(comp, SWT.NONE).setText("�û�����");

		      Text	numberText = new Text(comp, SWT.READ_ONLY| SWT.BORDER);
		      //ˮƽʽ��������	createGridData ���Զ��巽��

		      numberText.setLayoutData(createGridData(GridData.FILL_HORIZONTAL, 3));

		      Composite photoComp = new Composite(comp, SWT.BORDER);
		      //ͼƬ���
		      //ˮƽ�ʹ�ֱ������������ռ2�У���ռ4��
		      photoComp.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL
		    		  |GridData.VERTICAL_ALIGN_FILL, 2, 4));

		      photoComp.setLayout(new GridLayout(2, false));
		      //����Ϊ����
		    //  createlmageComp(photoComp, null);
		      //ѡ��ͼƬ��ͷ�Ͱ�ť�����������¶���

		      Button photoButton =new Button(photoComp, SWT.ARROW| SWT.DOWN);
		      photoButton.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_END));
		      //��������Ա��	��ť����ռphotoComp������ ������������
		      Button updateButton = new Button(photoComp, SWT.NONE);

		      updateButton.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL,2));
		      updateButton.setText("����Ϊ��Ա");

		      new Label(comp, SWT.NONE).setText("�û��ǳ�");
		      Text nickText = new Text(comp, SWT.BORDER);
		      nickText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL, 3));

		      new Label(comp, SWT.NONE).setText("3 ");
		      Text descText = new Text(comp, SWT.BORDER);

		      descText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL, 3));
		      new Label(comp, SWT.NONE).setText("��  ��: ");
		      Composite rankComp = new Composite(comp, SWT.BORDER);
		      GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		      gridData.horizontalSpan = 3;
		      gridData.heightHint = 20;
		      // CompositeĬ�ϵĸ߶�̫�߹��ֹ��趨�߶�Ϊ20����
		      rankComp.setLayoutData(gridData);
		      rankComp.setLayout(new RowLayout());
		      //createlmageComp(rankComp, moonlmage);
		      //createlmageComp(rankComp, starlmage);
		      //createlmageComp(rankComp, starlmage);
		      //createlmageComp(rankComp, moonlmage);

		      new Label(comp, SWT.NONE).setText("��  ��: ");
		      new Combo(comp, SWT.NONE);

		      new Label(comp, SWT.NONE).setText("����: ");
		      Text nameText = new Text(comp, SWT.BORDER);
		      
		      new Label(comp, SWT.NONE).setText("����: ");
		      
		      Text oldText = new Text(comp, SWT.BORDER);
		      oldText.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		      new Label(comp, SWT.NONE).setText(" ��ҵԺУ��");
		      Text schoolText = new Text(comp, SWT.BORDER);
		      schoolText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL, 3));

		      new Label(comp, SWT.NONE).setText("��Ф�� ");
		      Combo animalCombo = new Combo(comp, SWT.NONE);

		      animalCombo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		      new Label(comp, SWT.NONE).setText("ְҵ ");
		      Text jobText = new Text(comp, SWT .BORDER);

		      jobText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL, 3));

		      new Label(comp, SWT.NONE).setText("���� ");

		      Combo constellationCombo = new Combo(comp, SWT.NONE);

		      constellationCombo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		      // �ѡ�����˵������ǩ��Ĭ�ϵľ��У���Ϊ���˶���
		      Label introLabel = new Label(comp, SWT.NONE);

		      introLabel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		      introLabel.setText("����˵���� ");

		      Text introText = new Text(comp, SWT.BORDER |SWT.WRAP);
		      // WRAP �Զ�����
		     introText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL
		    		 |GridData.FILL_VERTICAL, 5));

		      return comp;// ���ظ����������

	}
	private Object createGridData(int i, int j, int k) {
		// TODO �Զ����ɵķ������
		return null;
	}
	private Object createGridData(int fillHorizontal, int i) {
		// TODO �Զ����ɵķ������
		return null;
	}
	
}
