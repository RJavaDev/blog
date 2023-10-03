package uz.blog.service.Base;

public interface BaseService<R,T>{

    boolean add(T t);

    R getObject(Integer id);

    boolean delete(int id);

    boolean update(int id,T t);


}
