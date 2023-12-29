package tech.spiritualdarkness.itu.service;

import tech.spiritualdarkness.itu.bean.vo.relation.Relationship;
import tech.spiritualdarkness.itu.bean.vo.response.RelationStatus;

public interface IRelationService {
    Relationship queryRelationShip(int uuid,boolean asCompany);
    RelationStatus friendCompany(int uuid, int targetId,boolean friend);
    RelationStatus friendEmployee(int uuid, int targetId,boolean friend);


}
