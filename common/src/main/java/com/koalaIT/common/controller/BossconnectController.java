package com.koalaIT.common.controller;

import com.koalaIT.common.biz.BossconnectService;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Bossconnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "bossConnect")
public class BossconnectController <T extends BaseDO,E extends BaseExample>extends BaseController<T,E>{
    @Autowired
    private Bossconnect bossconnect;

    @Autowired
    private BossconnectService<T,E> bossconnectService;


    @RequestMapping(value="/")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("bossconnect_list");

        return mv;
    }

    private void setProperties(){
        bossconnectService.setEntityMapper(bossconnectService.getBossconnectMapper());
        bossconnectService.setEntity((T)bossconnect);

        this.setBizService(bossconnectService);
    }
}
