package 其他组件;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

/*
 *Button.java2019年1月28日
 *
 */
/**
 * 动态的创建进度条，用完销毁 简单的状态栏
 * 
 * @author 李佳斌
 */
public class ProgressBar进度加状态栏中隐藏 {

	private Display display;
	private Shell shell;

	private Composite statusbar;
	private Label statusbarLabel;

	private ProgressBar progressBar;
	private Button hideProbarButton;

	public static void main(String[] args) {
		new ProgressBar进度加状态栏中隐藏().open();
	}

	public void open() {
		// TODO 自动生成的方法存根
		display = Display.getDefault();
		shell = new Shell();
		shell.setSize(500, 303);
		shell.setText("Hello Woeld");
//	创建窗口中其他界面组件
//	--------
		shell.setLayout(new GridLayout());
		createMainComp(shell);// 创建主界面
		createStatusbar(shell);// 创建工具栏

		shell.layout();
		shell.open();// 打开shell主窗口
		while (!shell.isDisposed()) {// 如果主窗口没有关闭
//			则一直循环
			if (!display.readAndDispatch()) {// 如果display不忙，
//				就让display处于休眠
				display.sleep();
			}
		}
		display.dispose();

	}

	private void createStatusbar(Shell parent) {
		// TODO 自动生成的方法存根
		statusbar = new Composite(parent, SWT.BORDER);

		// 设置工具栏在Shell中的形状为水平抢占充满，并高19像素

		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.heightHint = 19;
		statusbar.setLayoutData(gridData);

		// 设置为用行列式布局管理状态栏里的组件
		RowLayout layout = new RowLayout();

		layout.marginLeft = layout.marginTop = 0;// 无边距
		statusbar.setLayout(layout);// 创建一个用于显示文字的标签

		statusbarLabel = new Label(statusbar, SWT.BORDER);
		statusbarLabel.setLayoutData(new RowData(160, -1));
	}

	private void createMainComp(Composite parent) {
		// TODO 自动生成的方法存根
		Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite.setLayout(new RowLayout());
		createButton(composite);

	}

	private void createButton(Composite parent) {
		// TODO 自动生成的方法存根
		final Button b1 = new Button(parent, SWT.NONE);
		b1.setText("隐藏状态栏");
		b1.addSelectionListener(new SelectionAdapter() {
			private boolean flag = true;

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO 自动生成的方法存根
				// 用statusbar.setvisible(false)来隐藏状态栏是不够的，
				// 必须释放其占用的空间，应该使用Gridata.exclude

				GridData data = (GridData) statusbar.getLayoutData();

				data.exclude = flag;

				shell.layout();
				b1.setText((flag ? "显示" : "隐藏") + "状态栏");
				flag = !flag;
			}
		});

		hideProbarButton = new Button(parent, SWT.NONE);
		hideProbarButton.setText("隐藏进度条");
		hideProbarButton.setEnabled(false);
		hideProbarButton.addSelectionListener(new SelectionAdapter() {
			private boolean flag = false;

			public void widgetSelected(SelectionEvent e) {
				progressBar.setVisible(flag);
				hideProbarButton.setText((flag ? "隐藏" : "显示") + "进度条");
				flag = !flag;

			}
		});
		final Button b3 = new Button(parent, SWT.NONE);
		b3.setText("GO ");
		b3.addSelectionListener(new SelectionAdapter() {
			private boolean stopFlag = true;

			public void widgetSelected(SelectionEvent e) {
				stopFlag = !stopFlag;
				if (stopFlag) // 根据停止标志stopFlag来判断是停止还是运行
					stop();
				else
					go();

			};

			private void stop() {
				b3.setEnabled(false);
			}// 停止需要时间，在完全停止前要防止再次开始b3.setText("GO");

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
							} // 停一秒
						}
						disposeProgressBar();
					}

					private void moveProgressBar(final int i) {
						// TODO 自动生成的方法存根
						display.asyncExec(new Runnable() {

							@Override
							public void run() {
								// TODO 自动生成的方法存根
								if (!statusbarLabel.isDisposed()) {
									statusbarLabel.setText("前进到第" + i + "步");
								}

								if (!statusbar.isDisposed()) {
									progressBar.setSelection(i * 10);
								}
							}
						});
					}

					private void disposeProgressBar() {
						// TODO 自动生成的方法存根
						if (display.isDisposed())
							return;
						display.asyncExec(new Runnable() {

							@Override
							public void run() {
								// TODO 自动生成的方法存根
								hideProbarButton.setEnabled(false);
								// 这一句不要放在线程外，否则progress被创建
								// 后就立即被dispose了
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
		// TODO 自动生成的方法存根
		ProgressBar progressBar = new ProgressBar(statusbar, SWT.SMOOTH);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		return progressBar;
	}

}
