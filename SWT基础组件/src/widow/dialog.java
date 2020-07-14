package widow;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import java.util.ResourceBundle;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.wb.swt.ResourceManager;

public class dialog extends Dialog {
	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("widow.messages"); //$NON-NLS-1$
	Button btnCheckButton_4;
	Button btnCheckButton_5;

	Spinner spinner;
	private Button btnGood;
	private Button btnCheckButton;
	private CCombo combo;
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public dialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		btnGood = new Button(container, SWT.NONE);
		btnGood.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnGood.setText("baba");
		Group group2 = new Group(container, SWT.NONE);

		
		group2.setLayoutData(new GridData(GridData.FILL_BOTH));
		group2.setLayout(new GridLayout(2, false));

		group2.setText(BUNDLE.getString("good")); //$NON-NLS-1$

			btnCheckButton = new Button(group2, SWT.BORDER | SWT.FLAT | SWT.TOGGLE);
			
					btnCheckButton.setText("增量迁移");
					btnCheckButton.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							if(btnCheckButton.getSelection()){
								btnCheckButton_5.setEnabled(true);
							}else{
								btnCheckButton_5.setSelection(false);
								btnCheckButton_5.setEnabled(false);
								
							}
						}
					});
		
		combo = new CCombo(group2, SWT.BORDER);
		combo.setForeground(SWTResourceManager.getColor(0, 0, 102));
		combo.setItems(new String[] {"a", "b", "c"});


		btnCheckButton_5 = new Button(group2, SWT.NONE);
		btnCheckButton_5.setImage(SWTResourceManager.getImage(dialog.class, "/javax/swing/plaf/metal/icons/ocean/error.png"));
		btnCheckButton_5.setSelection(true);
		btnCheckButton_5.setGrayed(true);
		btnCheckButton_5.setVisible(true);
		btnCheckButton_5.setTouchEnabled(true);
		btnCheckButton_5.setAlignment(SWT.CENTER);
		btnCheckButton_5.setCapture(true);

		btnCheckButton_5.setText("覆盖迁移");
		btnCheckButton_5.setEnabled(false);
		
		Button btnNewButton_4 = new Button(group2, SWT.NONE);
		btnNewButton_4.setText("New Button");
		new Label(group2, SWT.NONE);
		new Label(group2, SWT.NONE);

		
		spinner = new Spinner (group2, SWT.BORDER);
		spinner.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1));
		spinner.setMinimum(0);
		spinner.setMaximum(1000);
		spinner.setSelection(0);
		spinner.setIncrement(1);
		spinner.setPageIncrement(100);
	
		Label NewLabel = new Label(group2, SWT.NONE);
		NewLabel.setText(BUNDLE.getString("dialog.NewLabel.text")); //$NON-NLS-1$
		NewLabel.setImage(SWTResourceManager.getImage(dialog.class, "/com/sun/java/swing/plaf/motif/icons/Error.gif"));
		NewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1));
		container.setTabList(new Control[]{btnGood, group2});
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	
	public Button getBtnGood() {
		return btnGood;
	}
	public Button getBtnCheckButton_5() {
		return btnCheckButton_5;
	}
}
