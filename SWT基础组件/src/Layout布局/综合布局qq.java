package Layout布局;

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
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  综合布局qq {
	
	private StackLayout	stackLayout =new StackLayout();
	private	Composite yourDataComp;
	private Composite otherComp;
	private List selectList;
	private Composite rightComp;
//	private Image qqImage=new Image(null, null);
	public static void main(String[] args) {
		new 综合布局qq().open();
	}
	private void open() {
		// TODO 自动生成的方法存根
		Display display = Display.getDefault();
		//Display（显示） 事件+UI线程有关的通信
		final Shell shell = new Shell();
		//		shell程序主窗口
		shell.setSize(500, 500);
		shell.setText("个人设置");
		
		//	创建窗口中其他界面组件
		//	--------
		shell.setLayout(new GridLayout());
		//定义一个分割窗
		SashForm sashForm=new SashForm(shell, SWT.BORDER);
		sashForm.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		selectList = new List(sashForm, SWT. BORDER);
		//分割窗左边的列表
		selectList.setItems(new String[] {"个人资料","联系方式"});
		// selectL istaddSelectionL istener(new MySelectionL istener):
		//加选择监听器
		rightComp = new Composite(sashForm, SWT.NONE);
		//右边的堆栈式容器
		rightComp.setLayout(stackLayout);

	     //共两页。将生成面板的代码提出成自定义方法，保证代码结构的清晰
		yourDataComp = createYourDataComp(rightComp);
		//“个人资料”面板
		otherComp=createOtherComp(rightComp);
		// “联系方式”面板

	     stackLayout.topControl = yourDataComp;
	     //在堆栈布局上先显示“个人资料”面板
	     sashForm.setWeights(new int[] {1,4});
	   //分割窗口的左右空间比例
  //------底部的按钮组面板- -一-- --

	     Composite buttonComp = new Composite(shell, SWT.BORDER);
	      //用GridData使按钮组面板向其父容器Shell的右边界对齐
	      GridData gridData = new GridData();

      gridData.horizontalAlignment = GridData.END;
      buttonComp.setLayoutData(gridData);

      //设定按钮组面板内按钮为行列式布局，按钮间隔15像素
      RowLayout rowLayout = new RowLayout();
      rowLayout.spacing = 15;
      buttonComp.setLayout(rowLayout);
      //在buttonComp下建立3个按钮，用全角空格撑开按钮
      new Button(buttonComp, SWT.NONE).setText("  确定  ");
      new Button(buttonComp, SWT.NONE).setText("  取消  ");
      new Button(buttonComp, SWT.NONE).setText("	应用  ");

 //	————END——————
		//		shell.layout();// 应用界面布局
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
	private Composite createOtherComp(Composite rightComp2) {
		// TODO 自动生成的方法存根
		return null;
	}
	//个人资料面板生成
	private Composite createYourDataComp(Composite rightComp) {
		// TODO 自动生成的方法存根
		   Composite comp = new Composite(rightComp, SWT.NONE);
		   comp.setLayout(new GridLayout(6, false));
		   //面板被分成六列

		      new Label(comp, SWT.NONE).setText("用户号码");

		      Text	numberText = new Text(comp, SWT.READ_ONLY| SWT.BORDER);
		      //水平式铺满三行	createGridData 是自定义方法

		      numberText.setLayoutData(createGridData(GridData.FILL_HORIZONTAL, 3));

		      Composite photoComp = new Composite(comp, SWT.BORDER);
		      //图片面板
		      //水平和垂直对齐铺满，横占2行，竖占4行
		      photoComp.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL
		    		  |GridData.VERTICAL_ALIGN_FILL, 2, 4));

		      photoComp.setLayout(new GridLayout(2, false));
		      //面板分为两列
		    //  createlmageComp(photoComp, null);
		      //选择图片箭头型按钮，设置它向下对齐

		      Button photoButton =new Button(photoComp, SWT.ARROW| SWT.DOWN);
		      photoButton.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_END));
		      //“升级会员”	按钮，横占photoComp的两行 并横向对齐充满
		      Button updateButton = new Button(photoComp, SWT.NONE);

		      updateButton.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL,2));
		      updateButton.setText("升级为会员");

		      new Label(comp, SWT.NONE).setText("用户昵称");
		      Text nickText = new Text(comp, SWT.BORDER);
		      nickText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL, 3));

		      new Label(comp, SWT.NONE).setText("3 ");
		      Text descText = new Text(comp, SWT.BORDER);

		      descText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL, 3));
		      new Label(comp, SWT.NONE).setText("等  级: ");
		      Composite rankComp = new Composite(comp, SWT.BORDER);
		      GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		      gridData.horizontalSpan = 3;
		      gridData.heightHint = 20;
		      // Composite默认的高度太高故手工设定高度为20像素
		      rankComp.setLayoutData(gridData);
		      rankComp.setLayout(new RowLayout());
		      //createlmageComp(rankComp, moonlmage);
		      //createlmageComp(rankComp, starlmage);
		      //createlmageComp(rankComp, starlmage);
		      //createlmageComp(rankComp, moonlmage);

		      new Label(comp, SWT.NONE).setText("性  别: ");
		      new Combo(comp, SWT.NONE);

		      new Label(comp, SWT.NONE).setText("姓名: ");
		      Text nameText = new Text(comp, SWT.BORDER);
		      
		      new Label(comp, SWT.NONE).setText("年龄: ");
		      
		      Text oldText = new Text(comp, SWT.BORDER);
		      oldText.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		      new Label(comp, SWT.NONE).setText(" 毕业院校：");
		      Text schoolText = new Text(comp, SWT.BORDER);
		      schoolText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL, 3));

		      new Label(comp, SWT.NONE).setText("生肖： ");
		      Combo animalCombo = new Combo(comp, SWT.NONE);

		      animalCombo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		      new Label(comp, SWT.NONE).setText("职业 ");
		      Text jobText = new Text(comp, SWT .BORDER);

		      jobText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL, 3));

		      new Label(comp, SWT.NONE).setText("星座 ");

		      Combo constellationCombo = new Combo(comp, SWT.NONE);

		      constellationCombo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		      // 把“个人说明”标签由默认的居中，改为顶端对齐
		      Label introLabel = new Label(comp, SWT.NONE);

		      introLabel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		      introLabel.setText("个人说明： ");

		      Text introText = new Text(comp, SWT.BORDER |SWT.WRAP);
		      // WRAP 自动换行
		     introText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL
		    		 |GridData.FILL_VERTICAL, 5));

		      return comp;// 返回个人资料面板

	}
	private Object createGridData(int i, int j, int k) {
		// TODO 自动生成的方法存根
		return null;
	}
	private Object createGridData(int fillHorizontal, int i) {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
