package �������;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019��1��28��
 *
 */
/**
 * ��̬�Ĵ������������������� �򵥵�״̬��
 * 
 * @author ��ѱ�
 */
public class ProgressBar���ȼ�״̬�������� {

	private Display display;
	private Shell shell;

	private Composite statusbar;
	private Label statusbarLabel;

	private ProgressBar progressBar;
	private Button hideProbarButton;

	public static void main(String[] args) {
		new ProgressBar���ȼ�״̬��������().open();
	}

	public void open() {
		// TODO �Զ����ɵķ������
		display = Display.getDefault();
		shell = new Shell();
		shell.setSize(500, 303);
		shell.setText("Hello Woeld");
//	���������������������
//	--------
		shell.setLayout(new GridLayout());
		createMainComp(shell);// ����������
		createStatusbar(shell);// ����������

		shell.layout();
		shell.open();// ��shell������
		while (!shell.isDisposed()) {// ���������û�йر�
//			��һֱѭ��
			if (!display.readAndDispatch()) {// ���display��æ��
//				����display��������
				display.sleep();
			}
		}
		display.dispose();

	}

	private void createStatusbar(Shell parent) {
		// TODO �Զ����ɵķ������
		statusbar = new Composite(parent, SWT.BORDER);

		// ���ù�������Shell�е���״Ϊˮƽ��ռ����������19����

		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.heightHint = 19;
		statusbar.setLayoutData(gridData);

		// ����Ϊ������ʽ���ֹ���״̬��������
		RowLayout layout = new RowLayout();

		layout.marginLeft = layout.marginTop = 0;// �ޱ߾�
		statusbar.setLayout(layout);// ����һ��������ʾ���ֵı�ǩ

		statusbarLabel = new Label(statusbar, SWT.BORDER);
		statusbarLabel.setLayoutData(new RowData(160, -1));
	}

	private void createMainComp(Composite parent) {
		// TODO �Զ����ɵķ������
		Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setLayout(new RowLayout());
		createButton(composite);

	}

	private void createButton(Composite parent) {
		// TODO �Զ����ɵķ������
		final Button b1 = new Button(parent, SWT.NONE);
		b1.setText("����״̬��");
		b1.addSelectionListener(new SelectionAdapter() {
			private boolean flag = true;

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO �Զ����ɵķ������
				// ��statusbar.setvisible(false)������״̬���ǲ����ģ�
				// �����ͷ���ռ�õĿռ䣬Ӧ��ʹ��Gridata.exclude

				GridData data = (GridData) statusbar.getLayoutData();

				data.exclude = flag;

				shell.layout();
				b1.setText((flag ? "��ʾ" : "����") + "״̬��");
				flag = !flag;
			}
		});

		hideProbarButton = new Button(parent, SWT.NONE);
		hideProbarButton.setText("���ؽ�����");
		hideProbarButton.setEnabled(false);
		hideProbarButton.addSelectionListener(new SelectionAdapter() {
			private boolean flag = false;

			public void widgetSelected(SelectionEvent e) {
				progressBar.setVisible(flag);
				hideProbarButton.setText((flag ? "����" : "��ʾ") + "������");
				flag = !flag;

			}
		});
		final Button b3 = new Button(parent, SWT.NONE);
		b3.setText("GO ");
		b3.addSelectionListener(new SelectionAdapter() {
			private boolean stopFlag = true;

			public void widgetSelected(SelectionEvent e) {
				stopFlag = !stopFlag;
				if (stopFlag) // ����ֹͣ��־stopFlag���ж���ֹͣ��������
					stop();
				else
					go();

			};

			private void stop() {
				b3.setEnabled(false);
			}// ֹͣ��Ҫʱ�䣬����ȫֹͣǰҪ��ֹ�ٴο�ʼb3.setText("GO");

			private void go() {
				b3.setText("STOP");
				progressBar = createProgressBar(statusbar);
				hideProbarButton.setEnabled(true);
				statusbar.layout();//
				new Thread() {
					public void run() {
						for (int i = 1; i < 11; i++) {
							if (display.isDisposed() || stopFlag) {
								disposeProgressBar();
								return;
							}
							moveProgressBar(i);
							try {
								Thread.sleep(1000);
							} catch (Throwable e2) {
							} // ͣһ��
						}
						disposeProgressBar();
					}

					private void moveProgressBar(final int i) {
						// TODO �Զ����ɵķ������
						display.asyncExec(new Runnable() {

							@Override
							public void run() {
								// TODO �Զ����ɵķ������
								if (!statusbarLabel.isDisposed()) {
									statusbarLabel.setText("ǰ������" + i + "��");
								}

								if (!statusbar.isDisposed()) {
									progressBar.setSelection(i * 10);
								}
							}
						});
					}

					private void disposeProgressBar() {
						// TODO �Զ����ɵķ������
						if (display.isDisposed())
							return;
						display.asyncExec(new Runnable() {

							@Override
							public void run() {
								// TODO �Զ����ɵķ������
								hideProbarButton.setEnabled(false);
								// ��һ�䲻Ҫ�����߳��⣬����progress������
								// ���������dispose��
								progressBar.dispose();
								b3.setEnabled(true);
							}
						});
					}
				}.start();
			}
		});

	}

	private ProgressBar createProgressBar(Composite statusbar) {
		// TODO �Զ����ɵķ������
		ProgressBar progressBar = new ProgressBar(statusbar, SWT.SMOOTH);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		return progressBar;
	}

}
