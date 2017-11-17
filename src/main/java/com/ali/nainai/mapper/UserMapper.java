package com.ali.nainai.mapper;

import com.ali.nainai.entity.User;
import org.apache.ibatis.annotations.Update;

/**
 * @author zhangxingrui
 * @version V1.0
 * @Title: UserMapper
 * @Package: com.ali.nainai.mapper
 * @Description: 用户Mapper
 * @Company: 都市放牛集团
 * @date 2017/11/14 11:06
 */
public interface UserMapper {

    /**
     * @Title: update
     * @Description: 修改用户
     * @author zhangxingrui
     * @param user
     * @return 
     * @date 2017/11/14 11:28
     */
    @Update("update t_user set avatar = #{avatar},create_at = #{createAt},description = #{description}," +
            "salt = #{salt},status = #{status},nick_name = #{nickName} where id = #{id}")
    int update(User user);
}
