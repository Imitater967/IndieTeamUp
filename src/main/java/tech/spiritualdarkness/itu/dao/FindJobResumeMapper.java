package tech.spiritualdarkness.itu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tech.spiritualdarkness.itu.bean.model.FindJobResume;

public interface FindJobResumeMapper extends BaseMapper<FindJobResume> {
    FindJobResume getById(int uuid);
    void delete(int uuid);
}
