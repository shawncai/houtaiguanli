package wy.rest.modular.auth.validator.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import wy.rest.common.persistence.dao.UserMapper;
import wy.rest.common.persistence.model.User;
import wy.rest.modular.auth.util.ShiroKit;
import wy.rest.modular.auth.validator.IReqValidator;
import wy.rest.modular.auth.validator.dto.Credence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号密码验证
 *
 * @author fengshuonan
 * @date 2017-08-23 12:34
 */
@Service
public class DbValidator implements IReqValidator {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean validate(Credence credence) {
        List<User> users = userMapper.selectList(new EntityWrapper<User>().eq("account", credence.getCredenceName()));
        if (users != null && validatePassword(users,credence) ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validatePassword(List<User> users,Credence credence){
       if (users.get(0).getPassword().equals(ShiroKit.md5(credence.getCredenceCode(),users.get(0).getSalt()))){
            return true;
       }else{
           return false;
       }
    }
}
