package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Contact;

public interface ContactService {
    Contact getContact();

    int updateContact(Contact contact);

    int addContact(Contact contact);
}
