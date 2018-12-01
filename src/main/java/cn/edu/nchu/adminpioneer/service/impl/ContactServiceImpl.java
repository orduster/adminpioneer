package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Contact;
import cn.edu.nchu.adminpioneer.mapper.ContactMapper;
import cn.edu.nchu.adminpioneer.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public Contact getContact() {
        return contactMapper.getContact();
    }

    @Override
    public int updateContact(Contact contact) {
        return contactMapper.updateContact(contact);
    }

    @Override
    public int addContact(Contact contact) {
        return contactMapper.addContact(contact);
    }
}
