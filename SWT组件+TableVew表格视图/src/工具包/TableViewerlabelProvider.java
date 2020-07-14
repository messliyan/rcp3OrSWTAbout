/*
 *TreeViewerLabelProvider.java2019年2月15日
 *
 */
package 工具包;

import java.security.KeyStore.Entry;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import dao.PeopleEntry;



/**
 *标签器。如果说内容器是对输入表格的数据集作处理，
	那么标签器则是对数据集中的单个实体对象进行处理和转化，
	由标签器来决定实体对象中的字段显示在表格的哪一-列中
 *@author 李佳斌
 */
public class TableViewerlabelProvider implements ITableLabelProvider {

	
	//创建几个图像
	/*private Image[] images = new Image[] {
			new Image(null, "icons/refresh.gif"),
			new Image(null, "icons/starjpg"),
			new Image(null, "icons/moon.jpg")};*/
	//由此方法决定数据记录在表格的每一列显示什么文字。
	//element 参数是一个实体类对象  col是当前要设置的列的列号，0是第一列
	public String getColumnText(Object element, int col) {
	PeopleEntry o = (PeopleEntry) element; //类型转换
	if (col== 0)//第1列要显示什么数据
	return o.getld().toString();
	if(col== 1)
	return o.getName();
	if(col== 2) 
	return o.isSex() ?"男":"女";
	
	if(col == 3)
	return String.valueOf(o.getAge()); //将int型转为String 型
	if(col== 4)
	return o.getCreateDate().toString();
	return null; //方法可以返回空值

	}
	//getColumnText方法用于显示文字，本方法用于显示图片
	/*public Image getColumnlmage(Object element, int col) {
		PeopleEntry o = (PeopleEntry) element;
		//只让“陈刚”这条记录显示图片
	if (o.getName().equals("陈刚")
	||o.getName().equals("周阅")) {
	if(col== 0)//1第一列要显示的图片
	return images[0];
	if (col == 2)//根据性别显示不同的图标
	return o.isSex() ? images[1] : images[2];

	}
	return null; //方法可以返回空值

	}
	//当TableViewer 对象被关闭时触发执行此方法
	public void dispose() {
	//别忘了SWT组件的原则:自己创建，自释放
		for (Image image : images) {
			image.dispose();
		}
	}*/
	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO 自动生成的方法存根
		
	}
	
	@Override
	public void dispose() {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO 自动生成的方法存根
		return null;
	}
	
}

