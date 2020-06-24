package com.koalaIT.common.controller;

import com.koalaIT.common.biz.CheckconnectService;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Checkconnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "Checkconnect")
public class CheckconnectController <T extends BaseDO,E extends BaseExample> extends  BaseController<T,E>{
    @Autowired
    private Checkconnect checkconnect;

    @Autowired
    private CheckconnectService<T,E> checkconnectService;

    @RequestMapping(value = "/checkconnect_list.html")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("checkconnect_list");

        return mv;
    }

    private void setProperties(){
        checkconnectService.setEntityMapper(checkconnectService.getCheckconnectMapper());
        checkconnectService.setEntity((T) checkconnect);

        this.setBizService(checkconnectService);
    }
}
