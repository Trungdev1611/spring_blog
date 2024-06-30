package com.example.Blog_model.mapper;

import com.example.Blog_model.user.dto.UserRegisterDTO;
import com.example.Blog_model.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper  //@Mapper: Annotation để đánh dấu interface này là một mapper của MapStruct.
public interface UserMapper {

    //UserMapper INSTANCE: Khởi tạo một instance của mapper sử dụng Mappers.getMapper(UserMapper.class).
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "role", ignore = true) // Bỏ qua thuộc tính role vì bạn sẽ xử lý nó riêng
    @Mapping(target = "password", ignore = true) // Bỏ qua thuộc tính password để mã hóa sau
    User userRegisterDtoToUser(UserRegisterDTO userRegisterDTO);
}
