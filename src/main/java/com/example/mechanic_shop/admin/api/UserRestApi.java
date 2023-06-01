package com.example.mechanic_shop.admin.api;

import com.example.mechanic_shop.admin.DTO.model.requestbody.user.AddUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.requestbody.user.UpdateUserRequestBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.AddUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.DeleteUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.GetUserResponseBody;
import com.example.mechanic_shop.admin.DTO.model.responsebody.user.UpdateUserResponseBody;
import com.example.mechanic_shop.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/delete")
    public DeleteUserResponseBody deleteUser(@RequestParam(value = "id") Long id){
        return userService.deleteUserById(id);
    }
}
