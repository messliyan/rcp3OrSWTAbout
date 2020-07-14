package priogressDiaog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;


public class LoopProgressDialog {
    private ProgressMonitorDialog dialog;
    public BooleanFlag stopFlag = new BooleanFlag();

    public LoopProgressDialog(Shell shell) {
        dialog = new ProgressMonitorDialog(shell);
    }

    public void run(boolean cancelable, final IProgressDialogRunnable runnable) {
        new Thread() {
            public void run() {
                runnable.run(stopFlag);
            }
        }.start();

        try {
            dialog.run(true, cancelable, new LoopRunnable());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class LoopRunnable implements IRunnableWithProgress {
        public void run(IProgressMonitor monitor) {
            monitor.beginTask("正在执行中......", 30);
            int i = 0;
            while (true) {
                // 监听是否单击了进度框的“取消”按钮，stopFlag则是监听后台任务是否停止
                if (monitor.isCanceled() || stopFlag.getFlag()) {
                    stopFlag.setFlag(true);
                    break;// 中断处理
                }
                // i到30后清零。并将进度条重新来过
                if ((++i) == 30) {
                    i = 0;
                    monitor.beginTask("正在执行中......", 30);
                }
                // 进度条每前进一步体息一会，不用太长或太短，时间可任意设。
                try {
                    Thread.sleep(99);
                } catch (Throwable t) {}
                monitor.worked(1);// 进度条前进一步
            }
            monitor.done();// 进度条前进到完成
        }
    }

}