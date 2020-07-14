/*
 *People.java2019年2月15日
 *
 */
package dao;

import java.util.Date;
import java.util.List;

/**
 *
 * @author 李佳斌
 */
public class PeopleEntry  {
	private String name; 
	private Long id; //唯-识别码，在数据库里常为自动递增的ID列private String name; 11姓名

	private boolean sex; //性别true 男，flase 女
	private int age; //年龄

	private Date createDate;//记录的建立日期。Date 类型是java.util.Date,而不是java.sql.Date

	//以下代码为字段各自的Setter/Getter方法。参考第3.5.2节，这些方法在Eclipse可自动生成public Long getld() { return id;}

	public void setld(Long long1) {id = long1;}
	public String getName() {return name;}

	public void setName(String string) {name = string;}
	public boolean isSex() { return sex;}

	public void setSex(boolean sex) { this.sex= sex; }
	public int getAge() {return age;}
	public void setAge(int i) {age = i;}

	public Date getCreateDate() {return createDate;}

	public void setCreateDate(Date date) {createDate = date;}
	public Object getld() {
		// TODO 自动生成的方法存根
		return id;
	}
	public Long getId() {
		// TODO 自动生成的方法存根
		return id;
	}

}
