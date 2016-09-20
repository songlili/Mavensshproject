package com.just.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.*;


import com.just.entity.Users;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UsersDao {
	@Resource
	SessionFactory sessionFactory;
	public void addUsers(Users users){	
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();
	    session.save(users);
	    tx.commit();
		session.close();
	}
	public void deleteUsers(Users users){//ɾ����Ա��Ϣ
		Session session =sessionFactory.getCurrentSession();//���Seesion����
		Transaction tx = session.beginTransaction();//��������
		session.delete(users);
		tx.commit();
		session.close();
	}
	public void updateUsers(Users users){
		Users u = loadUsers(users.getId());//���ظ�ID��Ӧ����Ա��Ϣ
		if (users.getBirthday() != null){
			u.setBirthday(users.getBirthday());//���ó�������
		}
	    if(users.getSex()!=null){
	    	u.setSex(users.getSex());//�����Ա�
	    }
		if (users.getContent() != null) {
			u.setContent(users.getContent());//������Ա���
	    }
		if (users.getIsadmin() != null) {
			u.setIsadmin(users.getIsadmin());//�����Ƿ�Ϊ����Ա
	    }
		if (users.getPassword() != null) {
			u.setPassword(users.getPassword());//���õ�¼����
		}
		if(users.getUsername()!=null)
		{
			u.setUsername(users.getUsername());
		}
		Session session = sessionFactory.getCurrentSession();//���Session����
		Transaction tx = session.beginTransaction();//��������
		session.update(u);//���¶���
		tx.commit();//�ύ����
		session.close();//�ر�Session����
	}
	public Users loadUsers(int id){//������Ա��Ϣ
		Session session =sessionFactory.getCurrentSession();//���Session����
		Users u = (Users)session.get(Users.class, id);//����ָ��ID��Users����
		return u;
	}
    public boolean loginUsers(Users users){//��Ա��¼
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Users where username = :name and password =:password");
        query.setString("name", users.getUsername());
        query.setString("password", users.getPassword());
        List<Users> list = null;
        list = query.list();
        tx.commit();
		session.close();
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                
                    return true;    
            }
        }
        return false;
    }
	public  List listUser(){//��ʾ��Ա�б�
	    Session session = sessionFactory.getCurrentSession();//���Session����
	    Query query = session.createQuery
	    	("select u from Users as u");//ִ�в�ѯ
	    List list = query.list();//��ò�ѯ�б�
		session.close();//�ر�Session����
	    return list;		//������Ա�б�
	}
}
