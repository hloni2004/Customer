package za.ac.cput.service;


import za.ac.cput.domain.Contact;

public interface IContactService extends IService<Contact,String>{

    boolean delete(Contact id);


}
