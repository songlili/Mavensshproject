package com.just.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.just.entity.Treatments;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TreatmentsDao {
	@Resource
	SessionFactory sessionFactory;
	public void addTreatments(Treatments p){	
	    Session session = sessionFactory.getCurrentSession();
		   Transaction tx = session.beginTransaction();
		Serializable save = session.save(p);
		tx.commit();
		session.close();
	}
	public void deleteTreatments(Treatments users){//ɾ����Ա��Ϣ
		Session session = sessionFactory.getCurrentSession();//���Seesion����
		Transaction tx = session.beginTransaction();//��������
		session.delete(users);
		tx.commit();
		session.close();
	}
	public void updateTreatments(Treatments p){
		Treatments u = loadTreatments(p.getId());//���ظ�ID��Ӧ����Ա��Ϣ
		if (p.getDoctorname() != null){
			u.setDoctorname(p.getDoctorname());//���ó�������
		}
		if (p.getTreatment() != null) {
			u.setTreatment(p.getTreatment());//������Ա���
	    }
		if (p.getPatientname() != null) {
			u.setPatientname(p.getPatientname());//�����Ƿ�Ϊ����Ա
	    }
		Session session = sessionFactory.getCurrentSession();//���Session����
		Transaction tx = session.beginTransaction();//��������
		session.update(u);//���¶���
		tx.commit();//�ύ����
		session.close();//�ر�Session����
	}
	public Treatments loadTreatments(int id){//������Ա��Ϣ
		Session session = sessionFactory.getCurrentSession();//���Session����
		Treatments u = (Treatments)session.get(Treatments.class, id);//����ָ��ID��Users����
		return u;
	}
   
	public   List<Treatments> listTreatments(){//��ʾ��Ա�б�
	    Session session = sessionFactory.getCurrentSession();//���Session����
	    Query query = session.createQuery
	    	("select u from Treatments as u");//ִ�в�ѯ
	    List<Treatments> list = query.list();//��ò�ѯ�б�
		session.close();//�ر�Session����
	    return list;		//������Ա�б�
	}
}
