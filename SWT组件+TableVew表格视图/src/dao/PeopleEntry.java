/*
 *People.java2019��2��15��
 *
 */
package dao;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ��ѱ�
 */
public class PeopleEntry  {
	private String name; 
	private Long id; //Ψ-ʶ���룬�����ݿ��ﳣΪ�Զ�������ID��private String name; 11����

	private boolean sex; //�Ա�true �У�flase Ů
	private int age; //����

	private Date createDate;//��¼�Ľ������ڡ�Date ������java.util.Date,������java.sql.Date

	//���´���Ϊ�ֶθ��Ե�Setter/Getter�������ο���3.5.2�ڣ���Щ������Eclipse���Զ�����public Long getld() { return id;}

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
		// TODO �Զ����ɵķ������
		return id;
	}
	public Long getId() {
		// TODO �Զ����ɵķ������
		return id;
	}

}
