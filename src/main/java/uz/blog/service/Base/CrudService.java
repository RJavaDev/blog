package uz.blog.service.Base;

public interface CrudService<T>{

    boolean add(T t);

    void delete(Integer id);
}
