package shall����;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;


/*
 *Button.java2019��1��28��
 *
 */
/**
 *
 *@author ��ѱ�
 */
public	class  SWTUtils��Ļ���� {
		private SWTUtils��Ļ����(Shell shell) {
			//ȡ����Ļ�Ŀ�Ⱥ͸߶ȣ���λ�����أ�
			Rectangle rtg=shell.getMonitor().getClientArea();
			int width=rtg.width;
			int height=rtg.height;
			//ȡ��shell�Ŀ�Ⱥ͸߶ȣ���λ�����أ�
			int x=-shell.getSize().x;
			int y=-shell.getSize().y;
			//���shell����ʱ�����Ͻǵ������
			Point p=new Point((width-x)/2,( height-y)/2);
			shell.setLocation(p);
			//��λ����
		}

}
