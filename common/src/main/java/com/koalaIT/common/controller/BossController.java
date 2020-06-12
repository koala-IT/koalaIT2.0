package com.koalaIT.common.controller;

import com.koalaIT.common.biz.BossService;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Boss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "boss")
public class BossController <T extends BaseDO, E extends BaseExample> extends BaseController<T,E>{
    @Autowired
    private Boss boss;

    @Autowired
    private BossService <T,E> bossService;

    @RequestMapping(value="/boss_list.html")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("boss_list");

        return mv;
    }

    private void setProperties(){                 /*将模板service的方法实体化*/
        bossService.setEntityMapper(bossService.getBossMapper());
        bossService.setEntity((T)boss);

        this.setBizService(bossService);
    }

}
