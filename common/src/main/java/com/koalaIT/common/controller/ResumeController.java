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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
    @RequestMapping(value="/getresume.json")
    @ResponseBody
    public ResultMap getResume(Integer resume_id) {
        ResultMap resultMap = new ResultMap();
        if (resume_id == null) {
            resultMap.setRet(0);
            resultMap.setError("user_id不能为空！");
            return resultMap;
        }

        try {
            this.setProperties();
            T t = (T)this.selectByPrimaryKey(resume_id);
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
    @RequestMapping(value="/updresume.json")
    @ResponseBody
    public ResultMap updateResume(ResumeDTO resumeDTO) {
        ResultMap resultMap = new ResultMap();
        ResumeExample resumeExample = new ResumeExample();



        resumeService.setEntityMapper(resumeService.getResumeMapper());
        resumeService.setEntity((T) resume);
        this.setBizService(resumeService);

        this.updateByExampleSelective(resumeDTO, resumeExample);

        resultMap.setRet(1);
        resultMap.setSuccess("个人信息更新成功！");
        return resultMap;
    }

    //添加简历
    @RequestMapping(value="/addresume.json")
    @ResponseBody
    public ResultMap addResume(ResumeDTO resumeDTO, HttpSession session) {
        ResultMap resultMap = new ResultMap();


        resumeService.setEntityMapper(resumeService.getResumeMapper());
        resumeService.setEntity((T) resume);
        this.setBizService(resumeService);

        this.insertSelective((T) resumeDTO);

        resultMap.setRet(1);
        resultMap.setSuccess("用户注册成功！");
        return resultMap;
    }









    private void setProperties(){
        resumeService.setEntityMapper(resumeService.getResumeMapper());
        resumeService.setEntity((T)resume);

        this.setBizService(resumeService);
    }

/*    //查询我的简历投递(多表关联)
    @RequestMapping(value="/orderresume.json")
    @ResponseBody
    public ResultMap orderResume(String user_name) {
        ResultMap resultMap = new ResultMap();
        if (user_name == null) {
            resultMap.setRet(0);
            resultMap.setError("user_id不能为空！");
            return resultMap;
        }

        try {
            this.setProperties();
            T t = (T)this.selectByPrimaryKey(user_name);
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
    }*/

}
