

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
public class AddPatientServlet extends HttpServlet 
{
    @Resource
    PatientsDao patientsDao ;
       public void init() throws ServletException
       {
           super.init();
                     //锟斤拷锟斤拷锟捷匡拷锟斤拷锟斤拷
         
       }
       public void destroy()
       {
        super.destroy();
              //锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
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
        //锟斤拷媒锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
        String patientname=request.getParameter("patientname");
        String sex=request.getParameter("sex");
        String birthday=request.getParameter("birthday");
        String content=request.getParameter("content");
        String telephone=request.getParameter("telephone");
        Patients p=new Patients();
        p.setBirthday(birthday);
        p.setContent(content);
        p.setPatientname(patientname);
        p.setSex(sex);
        p.setTelephone(telephone);

       //check锟斤拷锟斤拷  锟斤拷锟斤拷锟斤拷菘锟饺斤拷 锟叫讹拷锟斤拷没锟斤拷锟矫伙拷
       patientsDao.addPatients(p);
        
	 request.getRequestDispatcher("listpatient1.jsp").forward(request, response);    
    }

}
