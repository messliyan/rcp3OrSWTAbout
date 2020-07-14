package priogressDiaog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class ProgressMonitorDialog3 {

    public static void main(String[] args) {
        new ProgressMonitorDialog3().open();
    }

    public void open() {
        final Display display = Display.getDefault();
        final Shell shell = new Shell();
        shell.setSize(500, 375);

        shell.setLayout(new RowLayout());
        Button button = new Button(shell, SWT.NONE);
        button.setText("        GO          ");
        button.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                new LoopProgressDialog(shell).run(true, new IProgressDialogRunnable() {
                    public void run(BooleanFlag stopFlag) {
                       
                            try {
                                Thread.sleep(1000);
                            } catch (Throwable t) {}
                        
                        stopFlag.setFlag(true);
  
                    }
                });
            }
        });

        shell.layout();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

}