package com.koalaIT.common.controller;

import com.koalaIT.common.biz.HunterService;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Hunter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "Hunter")
public class HunterController <T extends BaseDO,E extends BaseExample> extends BaseController{
    @Autowired
    private Hunter hunter;

    @Autowired
    private HunterService<T,E> hunterService;

    @RequestMapping(value="/hunter_list.html")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("hunter_list");

        return mv;
    }

    private void setProperties(){
        hunterService.setEntityMapper(hunterService.getHunterByUser());
        hunterService.setEntity((T)hunter);

        this.setBizService(hunterService);
    }
}
