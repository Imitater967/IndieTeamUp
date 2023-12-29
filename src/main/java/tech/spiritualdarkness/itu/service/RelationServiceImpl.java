package tech.spiritualdarkness.itu.service;

import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.vo.relation.Relationship;
import tech.spiritualdarkness.itu.bean.vo.response.RelationStatus;


@Service
public class RelationServiceImpl implements IRelationService{
    @Override
    public Relationship queryRelationShip(int uuid) {
        return null;
    }

    @Override
    public RelationStatus friendCompany(int uuid, int targetId, boolean friend) {
        return null;
    }

    @Override
    public RelationStatus friendEmployee(int uuid, int targetId, boolean friend) {
        return null;
    }
}
