package com.koalaIT.admin.controller;

import com.koalaIT.common.biz.ManagerService;
import com.koalaIT.common.controller.BaseController;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Manager;
import com.koalaIT.common.model.ManagerExample;
import com.koalaIT.common.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value="login")
public class LoginController<T extends BaseDO,E extends BaseExample> extends BaseController<T,E> {

    @Autowired
    private ManagerService<T,E> managerService;

    @Autowired
    private Manager manager;

    //登入
    @RequestMapping(value="/login.html")
    public ModelAndView gotoLogin(ModelAndView mv) {
        mv.setViewName("login");
        return mv;
    }



    @RequestMapping(value="/login.json")
    @ResponseBody
    public ResultMap login() {
        ResultMap resultMap = new ResultMap();

        Integer managerId = manager.getManagerId();
        String psd = manager.getPassword();

        ManagerExample managerExample = new ManagerExample();
        ManagerExample.Criteria userCriteria = managerExample.createCriteria();
        userCriteria.andManagerIdEqualTo(managerId);
        userCriteria.andPasswordEqualTo(psd);

        managerService.setEntityMapper(managerService.getManagerMapper());
        managerService.setEntity((T) new Manager());

        this.setProperties();
        List<? extends T> userList = this.selectByExample((E)managerExample);
        if (userList != null && userList.size() > 0) {
            Manager manager = (Manager) userList.get(0);
            resultMap.setRet(1);
            resultMap.setSuccess("用户注册成功！");
        } else {
            resultMap.setRet(0);
            resultMap.setError("用户名或密码错误！");
        }
        return resultMap;
    }

    @RequestMapping(value="/index.html")
    public ModelAndView gotoIndex(ModelAndView mv) {
        mv.setViewName("welcome");
        return mv;
    }

    private void setProperties(){
        managerService.setEntityMapper(managerService.getManagerMapper());
        managerService.setEntity((T) new Manager());
        this.setBizService(managerService);
    }
}
