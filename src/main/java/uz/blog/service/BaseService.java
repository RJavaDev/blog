package uz.blog.service;

public interface BaseService<R,T>{

    R add(T t);

    boolean delete(int id);


    boolean update(int id,T t);


}
