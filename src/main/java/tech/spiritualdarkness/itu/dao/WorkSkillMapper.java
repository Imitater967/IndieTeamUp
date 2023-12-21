package tech.spiritualdarkness.itu.dao;

import tech.spiritualdarkness.itu.bean.model.UserSkill;

import java.util.List;

public interface WorkSkillMapper {
    List<UserSkill> getAllById(Integer uuid);
}
