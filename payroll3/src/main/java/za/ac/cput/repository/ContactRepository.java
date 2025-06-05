package za.ac.cput.repository;


import za.ac.cput.domain.Contact;

public class ContactRepository implements IRepository<Contact,String>{
    @Override
    public Contact create(Contact ts) {
        return null;
    }

    @Override
    public Contact read(String s) {
        return null;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
