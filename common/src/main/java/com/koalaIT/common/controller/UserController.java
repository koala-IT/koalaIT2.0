package com.koalaIT.common.controller;

import com.koalaIT.common.biz.UserService;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "User")
public class UserController <T extends BaseDO, E extends BaseExample> extends BaseController {
    @Autowired
    private User user;

    @Autowired
    private UserService<T,E> userService;

    @RequestMapping(value="/user_list.html")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("user_list");

        return mv;
    }

    private void setProperties(){
        userService.setEntityMapper(userService.getUserMapper());
        userService.setEntity((T)user);

        this.setBizService(userService);
    }
}
