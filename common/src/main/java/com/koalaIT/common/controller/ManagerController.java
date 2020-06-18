package com.koalaIT.common.controller;

import com.koalaIT.common.biz.ManagerService;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "Manager")
public class ManagerController <T extends BaseDO, E extends BaseExample> extends BaseController<T,E>{
    @Autowired
    private Manager manager;

    @Autowired
    private ManagerService<T,E> managerService;

    @RequestMapping(value="/manager_list.html")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("manager_list");
        return mv;
    }

    private void setProperties(){
        managerService.setEntityMapper(managerService.getManagerMapper());
        managerService.setEntity((T)manager);

        this.setBizService(managerService);
    }
}
