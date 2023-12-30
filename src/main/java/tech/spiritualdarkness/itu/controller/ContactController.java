package tech.spiritualdarkness.itu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.spiritualdarkness.itu.bean.po.UserContact;
import tech.spiritualdarkness.itu.bean.vo.response.ContactStatus;
import tech.spiritualdarkness.itu.bean.vo.response.Result;
import tech.spiritualdarkness.itu.service.IContactService;

@Slf4j
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    IContactService contactService;

    @GetMapping("/query")
    public Result<UserContact, ContactStatus> queryContact(@RequestHeader String uuid, @RequestParam String target_uuid) {
        Result<UserContact, ContactStatus> result = new Result<>();
        // 根据 uuid 查询 contact 信息
        UserContact contact = contactService.findByUuid(uuid, target_uuid);
        if (contact == null) {
            result.setStatus(ContactStatus.Fail);
            return result;
        }

        result.setStatus(ContactStatus.Success);
        result.setData(contact);
        return result;
    }
    @PostMapping("/update")
    public Result<UserContact, ContactStatus> updateContact(@RequestHeader Integer uuid, @RequestBody UserContact contact) {
        Result<UserContact, ContactStatus> result = new Result<>();

        contact.setUuid(uuid);
        contactService.updateByUuid(contact);

        result.setStatus(ContactStatus.Success);
        result.setData(contact);
        return result;
    }
}
