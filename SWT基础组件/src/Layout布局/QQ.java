package Layout布局;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class QQ {

	private StackLayout stackLayout = new StackLayout();
	private Composite otherComp;
	private Composite yourDataComp;
	private List selectList;
	private Composite rightComp;
	private Image qqImage = new Image(null,"icons/home.png");
	private Image moonImage = new Image(null,"icons/open_in_app.png");
	private Image starImage = new Image(null,"icons/save_edit.png");
	
	public static void main(String[] args) {
		new QQ().open();
	} 

	private void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(5660, 650);
		shell.setText("个人设置");
		shell.setLayout(new GridLayout());
	
		SashForm sashForm = new SashForm(shell,SWT.BORDER);
		sashForm.setLayoutData(new GridData(GridData.FILL_BOTH));
		selectList = new List(sashForm,SWT.BORDER);
		selectList.setItems(new String[] {"个人资料","联系方式"});
		selectList.addSelectionListener(new MySelectionListener());
		
		rightComp = new Composite(sashForm,SWT.NONE);
		rightComp.setLayout(stackLayout);
		
		yourDataComp = createYourDataComp(rightComp);
		otherComp = createOtherComp(rightComp);
		
		stackLayout.topControl = yourDataComp;
		sashForm.setWeights(new int[] {1,4});
		
		Composite buttonComp = new Composite(shell, SWT.BORDER);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.END;
		buttonComp.setLayoutData(gridData);
		
		RowLayout rowLayout = new RowLayout();
		rowLayout.spacing = 15;
		buttonComp.setLayout(rowLayout);
		
		new Button(buttonComp,SWT.NONE).setText(" 确定 ");
		new Button(buttonComp,SWT.NONE).setText(" 取消 ");
		new Button(buttonComp,SWT.NONE).setText(" 应用 ");
		
		shell.layout();
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	//联系方式面板
	private Composite createOtherComp(Composite rightComp) {
		Composite comp = new Composite(rightComp, SWT.NONE);
		comp.setLayout(new FillLayout());
		new Label(comp,SWT.NONE).setText("联系方式面板");
		return comp;
	}
	//个人资料面板生成
	private Composite createYourDataComp(Composite rightComp) {
		Composite comp = new Composite(rightComp, SWT.NONE);
		comp.setLayout(new GridLayout(6, false));
		
		new Label(comp, SWT.NONE).setText("用户号码");
		Text numberText = new Text(comp,SWT.READ_ONLY | SWT.BORDER);
		numberText.setLayoutData(createGridData(GridData.FILL_HORIZONTAL,3));
		
		Composite photoComp =new Composite(comp, SWT.BORDER);
		photoComp.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL|GridData.VERTICAL_ALIGN_FILL,2,4));
		createImageComp(photoComp,qqImage);
		Button photoButton = new Button(photoComp,SWT.ARROW | SWT.DOWN);
		photoButton.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_END));
		
		Button updateButton = new Button(photoComp,SWT.NONE);
		updateButton.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL,2));
		updateButton.setText("升级成为会员");
		
		new Label(comp,SWT.NONE).setText("用户昵称");
		Text nickText = new Text(comp,SWT.BORDER);
		nickText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL,3));
		
		new Label(comp,SWT.NONE).setText("个性签名");
		Text descText = new Text(comp,SWT.BORDER);
		descText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL,3));
		
		new Label(comp,SWT.BORDER).setText("等级");
		Composite rankComp = new Composite(comp,SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 3;
		gridData.heightHint = 20;
		rankComp.setLayoutData(gridData);
		rankComp.setLayout(new RowLayout());
		createImageComp(rankComp,moonImage);
		createImageComp(rankComp,starImage);
		createImageComp(rankComp,starImage);
		createImageComp(rankComp,moonImage);
		
		new Label(comp,SWT.NONE).setText("性    别");
		new Combo(comp, SWT.NONE);
		
		new Label(comp,SWT.NONE).setText("姓名: ");
		Text nameText = new Text(comp,SWT.BORDER);
		nameText.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		
		new Label(comp,SWT.NONE).setText("年龄: ");
		Text oldText = new Text(comp,SWT.BORDER);
		oldText.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		
		
		new Label(comp,SWT.NONE).setText("毕业院校: ");
		Text schoolText = new Text(comp,SWT.BORDER);
		schoolText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL,3));
		
		new Label(comp,SWT.NONE).setText("生肖: ");
		Combo animalCombo = new Combo(comp,SWT.NONE);
		animalCombo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		
		new Label(comp,SWT.NONE).setText("职业: ");
		Text jobText = new Text(comp,SWT.BORDER);
		jobText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL,3));
		
		new Label(comp,SWT.NONE).setText("星座: ");
		Combo constellationCombo = new Combo(comp,SWT.NONE);
		constellationCombo.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		
		Label introLabel = new Label(comp,SWT.NONE);
		introLabel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		introLabel.setText("个人说明: ");
		Text introText = new Text(comp,SWT.BORDER | SWT.WRAP);
		introText.setLayoutData(createGridData(GridData.HORIZONTAL_ALIGN_FILL|GridData.FILL_VERTICAL,5));
		
		return comp;
	}

	private Composite createImageComp(Composite parnet, Image image) {
		Composite c = new Composite(parnet, SWT.NONE);
		c.setBackgroundImage(image);
		
		ImageData imageData = image.getImageData();
		int width = imageData.width;
		int height = imageData.height;
		Layout parnetLayout = parnet.getLayout();
		if(parnetLayout instanceof GridLayout)
			c.setLayoutData(new GridData(width,height));
		else if(parnetLayout instanceof RowLayout)
			c.setLayoutData(new RowData(width, height));
		else if (parnetLayout instanceof FormLayout) 
			c.setLayoutData(new FormData(width, height));		
		return c;	
	}

	private GridData createGridData(int style, int horizontalSpan, int verticalSpan) {
		GridData gridData  = new GridData(style);
		gridData.horizontalSpan = horizontalSpan;
		gridData.verticalSpan = verticalSpan;
		return gridData;
	}

	private GridData createGridData(int style, int horizontalSpan) {
		GridData gridData  = new GridData(style);
		gridData.horizontalSpan = horizontalSpan;
		return gridData;
	}
	
	private class MySelectionListener extends SelectionAdapter{
		public void widgetSelected(SelectionEvent e) {
			if(selectList.getSelectionIndex() == 0)
				stackLayout.topControl = yourDataComp;
			else 
				stackLayout.topControl = otherComp;
			rightComp.layout();
		}
	}

}
