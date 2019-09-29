package com.itheima.service.impl;

import com.itheima.dao.StudentDao;
import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class StudentServiceimpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public Student findOne(Integer id) {

        return studentDao.findOne(id);
    }

    @Override
    public void update(Student student) {
        studentDao.updata(student);
    }

    @Override
    public void del(Integer[] ids) {
        studentDao.del(Arrays.asList(ids));
    }
}
