package com.example.mechanic_shop.admin.service.impl;

import com.example.mechanic_shop.admin.DTO.entity.User;
import com.example.mechanic_shop.admin.DTO.model.GetUserResponseModel;
import com.example.mechanic_shop.admin.DTO.model.requestbody.AddUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.AddUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.GetUserResponseBody;
import com.example.mechanic_shop.admin.repository.UserRepo;
import com.example.mechanic_shop.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public GetUserResponseBody getAllUser() {
        List<User> userList = userRepo.findAll();
        GetUserResponseBody responseBody = new GetUserResponseBody();
        List<GetUserResponseModel> userModelList = userList.stream().map(u->{
            GetUserResponseModel userModel = new GetUserResponseModel();
            userModel.setId(u.getId());
            userModel.setName(u.getName());
            userModel.setStatus(u.getStatus());
            userModel.setContactNumber(u.getContactNumber());
            userModel.setRole(u.getRole());
            userModel.setEmail(u.getEmail());
            userModel.setImageUrl(u.getImageUrl());
            userModel.setCreatedDate(u.getCreatedDate());
            userModel.setUpdatedDate(u.getUpdatedDate());
            return userModel;
        }).collect(Collectors.toList());
        responseBody.setUserModelList(userModelList);
        return responseBody;
    }

    @Override
    public AddUserResponseBody addNewUser(AddUserRequestBody requestBody) throws Exception {
        AddUserResponseBody responseBody =new AddUserResponseBody();

        List<User> userList = userRepo.findAll();
        boolean isUserExist = userList.stream().anyMatch(u->u.getEmail().equals(requestBody.getEmail()));
        if(isUserExist){
            throw new Exception("user is exist");
        }
        User user = new User();
        user.setName(requestBody.getName());
        user.setEmail(requestBody.getEmail());
        user.setRole(requestBody.getRole());
        user.setImageUrl(requestBody.getImageUrl());
        user.setStatus(requestBody.getStatus());
        Date present = new Date(System.currentTimeMillis());
        user.setCreatedDate(present);

        userRepo.save(user);
        responseBody.setStatus("SUCCESS");
        return responseBody;
    }


//    public User addNewUser(User user){
//        return userRepo.save(user);
//    }
//    public User updateUser(User user){
//        return userRepo.save(user);
//    }
//    public void deleteUser(Long id){
//        userRepo.deleteUserById(id);
//    }
//    public User findUserById(Long id){
//        return userRepo.findUserById(id)
//                .orElseThrow(()-> new UserNotFoundException("user by id "+id+"was not found"));
//    }
}
