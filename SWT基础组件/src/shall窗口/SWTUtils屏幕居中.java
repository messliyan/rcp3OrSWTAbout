package shall窗口;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;


/*
 *Button.java2019年1月28日
 *
 */
/**
 *
 *@author 李佳斌
 */
public	class  SWTUtils屏幕居中 {
		private SWTUtils屏幕居中(Shell shell) {
			//取得屏幕的宽度和高度（单位：像素）
			Rectangle rtg=shell.getMonitor().getClientArea();
			int width=rtg.width;
			int height=rtg.height;
			//取得shell的宽度和高度（单位：像素）
			int x=-shell.getSize().x;
			int y=-shell.getSize().y;
			//算出shell居中时，左上角的坐标点
			Point p=new Point((width-x)/2,( height-y)/2);
			shell.setLocation(p);
			//定位居中
		}

}
