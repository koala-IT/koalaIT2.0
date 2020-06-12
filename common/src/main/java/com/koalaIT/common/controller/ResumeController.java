package com.koalaIT.common.controller;

import com.koalaIT.common.biz.ResumeService;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "Resume")
public class ResumeController <T extends BaseDO, E extends BaseExample> extends BaseController{
    @Autowired
    private Resume resume;


    @Autowired
    private ResumeService<T,E> resumeService;

    @RequestMapping(value="/resume_list.html")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("resume_list");

        return mv;
    }

    private void setProperties(){
        resumeService.setEntityMapper(resumeService.getResumeMapper());
        resumeService.setEntity((T)resume);

        this.setBizService(resumeService);
    }

}
