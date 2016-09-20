

package com.just.service;




import com.just.dao.DoctorsDao;
import com.just.dao.PatientsDao;
import com.just.dao.UsersDao;
import com.just.entity.Doctors;
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
public class UpdateDoctorServlet extends HttpServlet 
{
    @Resource
    DoctorsDao doctorsDao ;
       public void init() throws ServletException
       {
           super.init();
                     //�����ݿ�����
         
       }
       public void destroy()
       {
        super.destroy();
              
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
        //��ý������������
        String doctorname=request.getParameter("doctorname");
        String sex=request.getParameter("sex");
        String content=request.getParameter("content");
        String telephone=request.getParameter("telephone");
        String id=request.getParameter("id");
        Doctors p=new Doctors();
        p.setContent(content);
         p.setDoctorname(doctorname);
        p.setSex(sex);
        p.setId(Integer.parseInt(id));
        p.setTelephone(telephone);
       //check����  ������ݿ�Ƚ� �ж���û���û�
       doctorsDao.updateDoctors(p);
        
	 request.getRequestDispatcher("listdoctor1.jsp").forward(request, response);    
    }

}
