package com.koalaIT.common.controller;

import com.koalaIT.common.biz.SysLogService;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "SysLog")
public class SysLogController <T extends BaseDO, E extends BaseExample> extends BaseController{
    @Autowired
    private SysLog sysLog;

    @Autowired
    private SysLogService<T,E> sysLogService;

    @RequestMapping(value="/sysLog_list.html")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("sysLog_list");

        return mv;
    }

    private void setProperties(){
        sysLogService.setEntityMapper(sysLogService.getSysLogMapper());
        sysLogService.setEntity((T)sysLog);

        this.setBizService(sysLogService);
    }
}
