package com.example.mechanic_shop.admin.api;

import com.example.mechanic_shop.admin.DTO.entity.User;
import com.example.mechanic_shop.admin.DTO.model.requestbody.AddUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.requestbody.UpdateUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.AddUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.GetUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.UpdateUserResponseBody;
import com.example.mechanic_shop.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api/user")
public class UserRestApi {
    private final UserService userService;
    @Autowired
    public UserRestApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public GetUserResponseBody listUser(){
        return userService.getAllUser();
    }
    @PostMapping("/add")
    public AddUserResponseBody addNewUser(@RequestBody AddUserRequestBody requestBody) throws Exception {
        return userService.addNewUser(requestBody);
    }
    @PutMapping("/update")
    public UpdateUserResponseBody updateUser(@RequestParam(value = "id") Long id, @RequestBody UpdateUserRequestBody requestBody){
        return userService.updateUser(requestBody,id);
    }
}
