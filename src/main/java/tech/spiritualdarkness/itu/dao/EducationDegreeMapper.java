package tech.spiritualdarkness.itu.dao;

import tech.spiritualdarkness.itu.bean.model.UserEducation;

public interface EducationDegreeMapper {
    UserEducation getById(Integer uuid);
}
