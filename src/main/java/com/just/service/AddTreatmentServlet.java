

package com.just.service;




import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.just.dao.PatientsDao;
import com.just.dao.TreatmentsDao;
import com.just.entity.Patients;
import com.just.entity.Treatments;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class AddTreatmentServlet extends HttpServlet 
{
    @Resource
    TreatmentsDao treatmentsDao ;
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
        //��ý������������
        String patientname=request.getParameter("patientname");
        String doctorname=request.getParameter("doctorname");
        String treatment=request.getParameter("treatment");
        Treatments t=new Treatments();
         t.setDoctorname(doctorname);
        t.setPatientname(patientname);
         t.setTreatment(treatment);

       //check����  ������ݿ�Ƚ� �ж���û���û�
       treatmentsDao.addTreatments(t);
        
	 request.getRequestDispatcher("listtreatment1.jsp").forward(request, response);    
    }

}
