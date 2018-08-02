package com.action;

import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojos.Student;
import com.pojos.Teacher;

import java.util.List;

public class Index extends ActionSupport {
    public String add() throws Exception
    {
        ActionContext actionContext=ActionContext.getContext();
        StudentDao studentDao=new StudentDao();
        Student student=new Student();
        student.setName((String) actionContext.get("name"));
        String id=(String) actionContext.get("id");
        student.setId(Integer.parseInt(id));
        Teacher teacher =new Teacher();
        teacher.setId((Integer) actionContext.get("teacherId"));
        teacher.setName((String) actionContext.get("teacherName"));
        student.setTeacher(teacher);
//        Student student=(Student) actionContext.get("student");
        studentDao.add(student);
        List list=studentDao.query();
        actionContext.getApplication().put("list",list);
        return "success";
    }

    public String query() throws Exception
    {
        ActionContext actionContext=ActionContext.getContext();
        StudentDao studentDao=new StudentDao();
        List list=studentDao.query();
        actionContext.getApplication().put("list",list);
        return "success";
    }
}
