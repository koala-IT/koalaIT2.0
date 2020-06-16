package com.koalaIT.common.controller;

import com.koalaIT.common.biz.ResumeService;
import com.koalaIT.common.dto.ResumeDTO;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Resume;
import com.koalaIT.common.model.ResumeExample;
import com.koalaIT.common.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    //查询我的简历
    @RequestMapping(value="/getresume.json",method = { RequestMethod.GET})
    @ResponseBody
    public ResultMap getResume(Integer resumeId) {
        ResultMap resultMap = new ResultMap();
        if (resumeId == null) {
            resultMap.setRet(0);
            resultMap.setError("user_id不能为空！");
            return resultMap;
        }

        try {
            this.setProperties();
            T t = (T)this.selectByPrimaryKey(resumeId);
            if (t != null) {
                Resume resume = (Resume) t;
                resultMap.setRet(1);
                resultMap.setSuccess("查询详细信息成功！");
                resultMap.setData(resume);
            }
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.setRet(0);
            resultMap.setError("查询详细信息失败！");
            return resultMap;
        }

        return resultMap;
    }

    //更改我的简历
    @RequestMapping(value="/updresume.json",method = { RequestMethod.POST})
    @ResponseBody
    public ResultMap updateResume(ResumeDTO resumeDTO) {
        ResultMap resultMap = new ResultMap();
        ResumeExample resumeExample = new ResumeExample();



        this.setProperties();

        this.updateByExampleSelective(resumeDTO, resumeExample);

        resultMap.setRet(1);
        resultMap.setSuccess("个人信息更新成功！");
        return resultMap;
    }

    //添加简历
    @RequestMapping(value="/addresume.json",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMap addResume(ResumeDTO resumeDTO) {
        ResultMap resultMap = new ResultMap();


        this.setProperties();

        this.insertSelective((T) resumeDTO);

        resultMap.setRet(1);
        resultMap.setSuccess("用户注册成功！");
        return resultMap;
    }

    //
    @RequestMapping(value="/orderresume.json",method = { RequestMethod.GET})
    @ResponseBody
    public ResultMap orderResume(String userName) {
        ResultMap resultMap = new ResultMap();
        if (userName == null) {
            resultMap.setRet(0);
            resultMap.setError("user_name不能为空！");
            return resultMap;
        }

        try {
            this.setProperties();
            T t = (T)this.resumeService.findResumeByName(userName);
            if (t != null) {
                Resume resume = (Resume) t;
                resultMap.setRet(1);
                resultMap.setSuccess("查询详细信息成功！");
                resultMap.setData(resume);
            }
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.setRet(0);
            resultMap.setError("查询详细信息失败！");
            return resultMap;
        }

        return resultMap;
    }









    private void setProperties(){
        resumeService.setEntityMapper(resumeService.getResumeMapper());
        resumeService.setEntity((T)resume);

        this.setBizService(resumeService);
    }



}
