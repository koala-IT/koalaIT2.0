package com.koalaIT.common.controller;

import com.koalaIT.common.biz.HunterconnectService;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Hunterconnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "Hunterconnect")
public class HunterconnectController <T extends BaseDO,E extends BaseExample> extends  BaseController<T,E>{
    @Autowired
    private Hunterconnect hunterconnect;

    @Autowired
    private HunterconnectService<T,E> hunterconnectService;

    @RequestMapping(value = "/hunterconnect_list.html")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("hunterconnect_list");

        return mv;
    }

    private void setProperties(){
        hunterconnectService.setEntityMapper(hunterconnectService.getHunterconnectMapper());
        hunterconnectService.setEntity((T)hunterconnect);

        this.setBizService(hunterconnectService);
    }
}
