package com.just.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.just.entity.Patients;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
@Repository

public class PatientsDao {
	@Resource
	SessionFactory sessionFactory;
	public void addPatients(Patients p){	
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    session.save(p);
	    tx.commit();
		session.close();
	}
	public void deletePatients(Patients users){//ɾ����Ա��Ϣ
		Session session =  sessionFactory.getCurrentSession();//���Seesion����
		Transaction tx = session.beginTransaction();//��������
		session.delete(users);
		tx.commit();
		session.close();
	}
	public void updatePatients(Patients p){
		Patients u = loadPatients(p.getId());//���ظ�ID��Ӧ����Ա��Ϣ
		if (p.getBirthday() != null){
			u.setBirthday(p.getBirthday());//���ó�������
		}
	    if(p.getSex()!=null){
	    	u.setSex(p.getSex());//�����Ա�
	    }
		if (p.getContent() != null) {
			u.setContent(p.getContent());//������Ա���
	    }
		if (p.getPatientname() != null) {
			u.setPatientname(p.getPatientname());//�����Ƿ�Ϊ����Ա
	    }
		if (p.getContent() != null) {
			u.setContent(p.getContent());//���õ�¼����
		}
		Session session =  sessionFactory.getCurrentSession();//���Session����
		Transaction tx = session.beginTransaction();//��������
		session.update(u);//���¶���
		tx.commit();//�ύ����
		session.close();//�ر�Session����
	}
	public Patients loadPatients(int id){//������Ա��Ϣ
		Session session =  sessionFactory.getCurrentSession();//���Session����
		Patients u = (Patients)session.get(Patients.class, id);//����ָ��ID��Users����
		return u;
	}
   
	public  List<Patients> listPatient(){//��ʾ��Ա�б�
	    Session session =  sessionFactory.getCurrentSession();//���Session����
	    Query query = session.createQuery
	    	("select u from Patients as u");//ִ�в�ѯ
	    List<Patients> list = query.list();//��ò�ѯ�б�
		session.close();//�ر�Session����
	    return list;		//������Ա�б�
	}
}
