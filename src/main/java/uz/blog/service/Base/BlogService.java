package uz.blog.service.Base;


import uz.blog.entity.BlogEntity;

import java.util.List;

public interface BlogService extends CrudService<BlogEntity>{

    BlogEntity getObject(Integer id);

    List<BlogEntity> getAllBlog();

    void checkedBlog(Integer id);

}
