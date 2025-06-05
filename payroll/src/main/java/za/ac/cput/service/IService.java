package za.ac.cput.service;

public interface IService <T,ID>{

    T create(T ts);
    T read(ID id);
    T update(T t);
}
