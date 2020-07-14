/*
 *treeviewercontentProvider.java2019年2月15日
 *
 */
package 工具包;

import java.util.List;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * 内容器。由此类对输入到表格的数据进行筛选和转化。此类要实现接口的3种方法， 其中getElements是主要方法，另外两个方法很少用到，空实现就行了
 * 
 * @author 李佳斌
 */
public class TableViewerContentProvider implements IStructuredContentProvider {

	// 对输入到表格的数据集合进行筛选和转化。输入的数据集全部要转化成数组，每一个数组元素
	// 就是一个实体类对象，也就是表格中的一条记录
	public Object[] getElements(Object element) {
		// 参数element就是通过setinput(Object input)输入的对象input
		// 本例中输入给setInput是List集合
		if (element instanceof List)// 加一个List类型判断
			return ((List) element).toArray(); // 将数据集List转化为数组

		else
			return new Object[0]; // 如非List类型则返回一个空数组
	}

	// 当TableViewer对象被关闭时触发执行此方法
	public void dispose() {
	}

	// 当TableViewer 再次调用setInput()时触发执行此方法

}
