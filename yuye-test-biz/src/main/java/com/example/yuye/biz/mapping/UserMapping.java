package com.example.yuye.biz.mapping;

import com.example.yuye.dal.dto.User;
import com.example.yuye.dal.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author zhouliang
 * @date 2022/7/21 3:52 PM
 */
@Mapper
public interface UserMapping {
    UserMapping INSTANCE = Mappers.getMapper(UserMapping.class);

    @Mapping(source = "user.name",target = "userName")
    UserDTO toDto(User user);
}
