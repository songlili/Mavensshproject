package com.just.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Entity(name="t_patient")
public class Patients implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;	//Ա�����
    private String patientname;//Ա���û���//��¼����
    private String  sex;		//�Ա�
    private String birthday;
    private String content;	
	private  String telephone;//��Ա���//����//����ʱ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
   
   
}
