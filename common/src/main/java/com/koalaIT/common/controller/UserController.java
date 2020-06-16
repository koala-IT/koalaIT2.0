package com.koalaIT.common.controller;

import com.koalaIT.common.biz.UserService;
import com.koalaIT.common.dto.UserDTO;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.User;
import com.koalaIT.common.model.UserExample;
import com.koalaIT.common.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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


    //查询我的信息
    @RequestMapping(value="/myinfo.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap getUserInfo(Integer userId) {
        ResultMap resultMap = new ResultMap();
        if (userId == null) {
            resultMap.setRet(0);
            resultMap.setError("user_id不能为空！");
            return resultMap;
        }

        try {
            this.setProperties();
            T t = (T)this.selectByPrimaryKey(userId);
            if (t != null) {
                User user = (User) t;
                resultMap.setRet(1);
                resultMap.setSuccess("查询详细信息成功！");
                resultMap.setData(user);
            }
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.setRet(0);
            resultMap.setError("查询详细信息失败！");
            return resultMap;
        }


        return resultMap;
    }
    //更改我的信息
    @RequestMapping(value="/updmyinfo.json",method = { RequestMethod.POST })
    @ResponseBody
    public ResultMap updateUserInfo(UserDTO userDTO) {
        ResultMap resultMap = new ResultMap();
        UserExample userExample = new UserExample();



        userService.setEntityMapper(userService.getUserMapper());
        userService.setEntity((T) user);
        this.setBizService(userService);

        this.updateByExampleSelective(userDTO, userExample);

        resultMap.setRet(1);
        resultMap.setSuccess("个人信息更新成功！");
        return resultMap;
    }




    private void setProperties() {
        userService.setEntityMapper(userService.getUserMapper());
        userService.setEntity((T) user);
        this.setBizService(userService);
    }


}
