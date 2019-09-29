package com.itheima.service.impl;

import com.itheima.dao.LogDao;
import com.itheima.domain.Log;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceimpl implements LogService {
    @Autowired
    LogDao logDao;
    @Override
    public void insert(Log log) {
        logDao.insert(log);
    }
}
