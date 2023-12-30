package tech.spiritualdarkness.itu.dao;

import tech.spiritualdarkness.itu.bean.po.UserSkill;

import java.util.List;

public interface WorkSkillMapper {
    List<UserSkill> getAllById(Integer uuid);
}
