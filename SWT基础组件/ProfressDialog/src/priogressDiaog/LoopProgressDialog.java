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
            monitor.beginTask("����ִ����......", 30);
            int i = 0;
            while (true) {
                // �����Ƿ񵥻��˽��ȿ�ġ�ȡ������ť��stopFlag���Ǽ�����̨�����Ƿ�ֹͣ
                if (monitor.isCanceled() || stopFlag.getFlag()) {
                    stopFlag.setFlag(true);
                    break;// �жϴ���
                }
                // i��30�����㡣������������������
                if ((++i) == 30) {
                    i = 0;
                    monitor.beginTask("����ִ����......", 30);
                }
                // ������ÿǰ��һ����Ϣһ�ᣬ����̫����̫�̣�ʱ��������衣
                try {
                    Thread.sleep(99);
                } catch (Throwable t) {}
                monitor.worked(1);// ������ǰ��һ��
            }
            monitor.done();// ������ǰ�������
        }
    }

}