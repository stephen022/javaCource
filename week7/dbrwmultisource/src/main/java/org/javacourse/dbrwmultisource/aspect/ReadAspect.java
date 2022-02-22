package org.javacourse.dbrwmultisource.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.javacourse.dbrwmultisource.datasource.ManagementCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;



@Aspect
@Component
public class ReadAspect {

    @Autowired
    ManagementCenter managementCenter;

    @Pointcut("@annotation(org.javacourse.dbrwmultisource.annotation.ReadAnnotation)")
    public void read(){};

    @Around("read()")
    public List<Map<String, Object>> setDatabaseSource(ProceedingJoinPoint point) throws Throwable {
        System.out.println("data source change......");
        Object[] argv = point.getArgs();
        argv[0] = managementCenter.getReadDataSource();
        return (List<Map<String, Object>>) point.proceed(argv);
    }
}
