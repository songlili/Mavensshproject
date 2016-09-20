package com.just.dao;

import java.util.List;

import org.apache.maven.plugins.annotations.Component;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.just.entity.Doctors;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class DoctorsDao {
	@Resource
	public SessionFactory sessionFactory;
	public void addDoctors(Doctors p){
		Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    session.save(p);
	    tx.commit();
		session.close();
	}
	public void deleteDoctors(Doctors users){//ɾ����Ա��Ϣ
		Session session =  sessionFactory.getCurrentSession();//���Seesion����
		Transaction tx = session.beginTransaction();//��������
		session.delete(users);
		tx.commit();
		session.close();
	}
	public void updateDoctors(Doctors p){
		Doctors u = loadDoctors(p.getId());//���ظ�ID��Ӧ����Ա��Ϣ
	    if(p.getSex()!=null){
	    	u.setSex(p.getSex());//�����Ա�
	    }
		if (p.getTelephone() != null) {
			u.setTelephone(p.getTelephone());//������Ա���
	    }
		if (p.getDoctorname() != null) {
			u.setDoctorname(p.getDoctorname());//�����Ƿ�Ϊ����Ա
	    }
		if (p.getContent() != null) {
			u.setContent(p.getContent());//���õ�¼����
		}
		Session session = sessionFactory.getCurrentSession();//���Session����
		Transaction tx = session.beginTransaction();//��������
		session.update(u);//���¶���
		tx.commit();//�ύ����
		session.close();//�ر�Session����
	}
	public Doctors loadDoctors(int id){//������Ա��Ϣ
		Session session =  sessionFactory.getCurrentSession();//���Session����
		Doctors u = (Doctors)session.get(Doctors.class, id);//����ָ��ID��Users����
		return u;
	}
   
	public  List<Doctors> listDoctor(){//��ʾ��Ա�б�
	    Session session =  sessionFactory.getCurrentSession();//���Session����
	    Query query = session.createQuery
	    	("select u from Doctors　as u");//ִ�в�ѯ
	    List<Doctors> list = query.list();//��ò�ѯ�б�
		session.close();//�ر�Session����
	    return list;		//������Ա�б�
	}
}
