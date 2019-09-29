package com.itheima.dao;

import com.itheima.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao {
public List<Student>findAll();
public void add(Student student);

@Select("select * from t_student where id =#{suiyixie}")
    public Student findOne(Integer id);
@Select("update t_student set name=#{name},sex=#{sex},age=#{age},address=#{address} where id =#{id}")
    public void updata(Student student);

public void del(List list);
}
