package com.example.mechanic_shop.admin.service.impl;

import com.example.mechanic_shop.admin.DTO.entity.User;
import com.example.mechanic_shop.admin.DTO.model.GetUserResponseModel;
import com.example.mechanic_shop.admin.DTO.model.requestbody.user.AddUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.requestbody.user.UpdateUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.AddUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.DeleteUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.GetUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.UpdateUserResponseBody;
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

//    @Override
//    public AddUserResponseBody addNewUser(AddUserRequestBody requestBody) throws Exception {
//        AddUserResponseBody responseBody =new AddUserResponseBody();
//        List<User> userList = userRepo.findAll();
//        boolean isUserExist = userList.stream().anyMatch(u->u.getEmail().equals(requestBody.getEmail()));
//        if(isUserExist){
//            responseBody.setStatus("email is exits");
//            return responseBody;
//        }
//        User user = new User();
//        user.setName(requestBody.getName());
//        user.setEmail(requestBody.getEmail());
//        user.setRole(requestBody.getRole());
//        user.setImageUrl(requestBody.getImageUrl());
//        user.setStatus(requestBody.getStatus());
//        Date present = new Date(System.currentTimeMillis());
//        user.setContactNumber(requestBody.getContactNumber());
//        user.setCreatedDate(present);
//        userRepo.save(user);
//        responseBody.setStatus("SUCCESS");
//        return responseBody;
//    }

    @Override
    public UpdateUserResponseBody updateUser(UpdateUserRequestBody requestBody, Long id) {
        UpdateUserResponseBody responseBody = new UpdateUserResponseBody();
        User user = userRepo.findById(id).orElse(null);
        if(user==null){
            responseBody.setStatus("not found user");
            return responseBody;
        } else if (userRepo.existsByEmail(requestBody.getEmail()) && !user.getEmail().equals(requestBody.getEmail())) {
            responseBody.setStatus("email is exits");
            return responseBody;
        } else if (user!=null) {
            user.setName(requestBody.getName());
            user.setEmail(requestBody.getEmail());
            user.setRole(requestBody.getRole());
            user.setImageUrl(requestBody.getImageUrl());
            user.setStatus(requestBody.getStatus());
            Date present = new Date(System.currentTimeMillis());
            user.setUpdatedDate(present);
            user.setContactNumber(requestBody.getContactNumber());
            userRepo.save(user);
            responseBody.setStatus("success");
            return responseBody;
        }
        return responseBody;

    }

    @Override
    public DeleteUserResponseBody deleteUserById(Long id) {
        User user = userRepo.findById(id).orElse(null);
        DeleteUserResponseBody responseBody = new DeleteUserResponseBody();
        if(user == null){
            responseBody.setStatus("not found user");
        }else{
            userRepo.deleteById(id);
            responseBody.setStatus("Delete User Success");
            return responseBody;
        }
        return responseBody;
    }


}
