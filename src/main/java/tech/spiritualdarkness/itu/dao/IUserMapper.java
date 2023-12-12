package tech.spiritualdarkness.itu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tech.spiritualdarkness.itu.bean.model.User;

public interface IUserMapper extends BaseMapper<User> {

    /**
     * 新增用户
     *
     * @param user 用户对象
     * @return 新增成功记录条数
     */
    int add(User user);
    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @return 修改成功记录条数
     */
    int update(User user);

    /**
     * 根据id获取用户
     *
     * @param id 用户id
     * @return 用户对象
     */
    User getById(int id);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户对象
     */
    User getByUsername(String username);

}
