package com.itheima.service;

import com.itheima.dao.LogDao;
import com.itheima.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface LogService {

    public void insert(Log log);
}
