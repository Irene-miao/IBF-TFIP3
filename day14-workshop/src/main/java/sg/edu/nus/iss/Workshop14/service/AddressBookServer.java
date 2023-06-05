package sg.edu.nus.iss.Workshop14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.Workshop14.model.Contact;
import sg.edu.nus.iss.Workshop14.repository.AddressBookRepository;

@Service
public class AddressBookServer {
    @Autowired
    private AddressBookRepository adrbkRepo;

    public void save(final Contact ctc) {
        adrbkRepo.save(ctc);
    }

    public Contact findById(final String contactId) {
        return adrbkRepo.findById(contactId);
    }

    public List<Contact> findAll(int startIndex) {
        return adrbkRepo.findAll(startIndex);
    }
}
