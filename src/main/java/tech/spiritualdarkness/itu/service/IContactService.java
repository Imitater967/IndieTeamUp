package tech.spiritualdarkness.itu.service;

import tech.spiritualdarkness.itu.bean.po.UserContact;

public interface IContactService {

    UserContact findByUuid(String self,String uuid);

    void updateByUuid(UserContact contact);
}
