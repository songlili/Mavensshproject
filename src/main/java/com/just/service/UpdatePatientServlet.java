

package com.just.service;




import com.just.dao.PatientsDao;
import com.just.dao.UsersDao;
import com.just.entity.Patients;
import com.just.entity.Users;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Connection;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class UpdatePatientServlet extends HttpServlet 
{
    @Resource
    PatientsDao patientsDao ;
       public void init() throws ServletException
       {
           super.init();
                     //�����ݿ�����
         
       }
       public void destroy()
       {
        super.destroy();
              //�ر���ݿ����� 
       }
   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        doPost(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
    	request.setCharacterEncoding("utf-8");
    	  response.setCharacterEncoding("utf-8");
        //��ý������������
        String patientname=request.getParameter("patientname");
        String sex=request.getParameter("sex");
        String birthday=request.getParameter("birthday");
        String content=request.getParameter("content");
        String telephone=request.getParameter("telephone");
        String id=request.getParameter("id");
        Patients p=new Patients();
        p.setBirthday(birthday);
        p.setContent(content);
        p.setPatientname(patientname);
        p.setSex(sex);
        p.setId(Integer.parseInt(id));
        p.setTelephone(telephone);
       //check����  ������ݿ�Ƚ� �ж���û���û�
       patientsDao.updatePatients(p);
        
	 request.getRequestDispatcher("listpatient1.jsp").forward(request, response);    
    }

}
