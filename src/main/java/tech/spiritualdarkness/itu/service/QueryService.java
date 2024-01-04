package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.dto.EmployeeResumeQuery;
import tech.spiritualdarkness.itu.bean.dto.ProjectResumeQuery;
import tech.spiritualdarkness.itu.dao.FindEmployeeResumeMapper;
import tech.spiritualdarkness.itu.dao.FindJobResumeMapper;

import java.util.HashMap;
import java.util.Map;

@Service
public class QueryService {
    final
    FindJobResumeMapper findJob;

    final
    FindEmployeeResumeMapper findEmployee;

    public QueryService(FindJobResumeMapper findJob, FindEmployeeResumeMapper findEmployee) {
        this.findJob = findJob;
        this.findEmployee = findEmployee;
    }


    /**
     * 查询员工简历
     *
     * @param bean
     * @return
     */
    public IPage findJobResumes(EmployeeResumeQuery bean){
        QueryWrapper wrapper = new QueryWrapper();
        //1. 固定查询条件
        Map<String,Object> queryResult = new HashMap<>();
        if(bean.getJob()!=null){
            queryResult.put("job",bean.getJob());
        }


        //common query
        if(bean.getWorkMethod()!=null){
            queryResult.put("work_method",bean.getWorkMethod());
        }
        if(bean.getWorkType()!=null){
            queryResult.put("work_type",bean.getWorkType());
        }
        if(bean.getPayMethod()!=null){
            queryResult.put("pay_method",bean.getPayMethod());
        }
        // 大于查询条件
        wrapper.allEq(queryResult);

        if(bean.getLeastSalary()!=null){
            wrapper.le("salary",bean.getLeastSalary());
        }
        if(bean.getLeastSalaryStock()!=null){
            wrapper.le("salary_stock",bean.getLeastSalaryStock());
        }

        int page = bean.getPage();
        return findJob.selectPage(new Page<>(page,5),wrapper);
    }

    public IPage findProjectResumes(ProjectResumeQuery bean) {
        QueryWrapper wrapper = new QueryWrapper();
        //1. 固定查询条件
        Map<String,Object> queryResult = new HashMap<>();
        //common query
        if(bean.getWorkMethod()!=null){
            queryResult.put("work_method",bean.getWorkMethod());
        }
        if(bean.getWorkType()!=null){
            queryResult.put("work_type",bean.getWorkType());
        }
        if(bean.getPayMethod()!=null){
            queryResult.put("pay_method",bean.getPayMethod());
        }
        // 大于查询条件
        wrapper.allEq(queryResult);

        if(bean.getLeastSalary()!=null){
            wrapper.ge("salary",bean.getLeastSalary());
        }
        if(bean.getLeastSalaryStock()!=null){
            wrapper.ge("salary_stock",bean.getLeastSalaryStock());
        }
        if(bean.getMinQualify()!=null){
            wrapper.ge("qualify",bean.getMinQualify());
        }
        if(bean.getFinishStage()!=null){
            wrapper.ge("finish_stage",bean.getFinishStage());
        }


        int page = bean.getPage();
        return findEmployee.selectPage(new Page<>(page,5),wrapper);


    }
}
