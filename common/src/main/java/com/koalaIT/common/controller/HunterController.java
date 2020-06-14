package com.koalaIT.common.controller;

import com.koalaIT.common.biz.HunterService;
import com.koalaIT.common.dto.HunterDTO;
import com.koalaIT.common.model.*;
import com.koalaIT.common.util.CommonUtils;
import com.koalaIT.common.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    //查询hunter的信息
    @RequestMapping(value="/findhunter.json")
    @ResponseBody
    public ResultMap getHunterInfo() {
        ResultMap resultMap = new ResultMap();
        HunterExample hunterExample = new HunterExample();


        try {
            this.setProperties();
            List<Hunter> t = this.selectByExample((E) hunterExample);
            if (t != null) {

                resultMap.setRet(1);
                resultMap.setSuccess("查询详细信息成功！");
                resultMap.setData(t);
            }
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.setRet(0);
            resultMap.setError("查询详细信息失败！");
            return resultMap;
        }

        hunterExample = null;


        return resultMap;
    }

    //新增hunter
    @RequestMapping(value="/addhunter.html")
    public ModelAndView addHunterInfo(ModelAndView mv) {
        mv.setViewName("addhunter");
        return mv;
    }

    @RequestMapping(value="/addhunter.json")
    @ResponseBody
    public ResultMap addHunterInfo(HunterDTO hunterDTO, HttpSession session) {
        ResultMap resultMap = new ResultMap();

        hunterDTO.setHunterId( Integer.parseInt(CommonUtils.getUUID()));



        hunterService.setEntityMapper(hunterService.getHunterByUser());
        hunterService.setEntity((T) hunter);
        this.setBizService(hunterService);

        this.insertSelective((T) hunterDTO);

        resultMap.setRet(1);
        resultMap.setSuccess("用户注册成功！");
        return resultMap;
    }

    //更改我的hunter
    @RequestMapping(value="/updmyinfo.json")
    @ResponseBody
    public ResultMap updateUserInfo(HunterDTO hunterDTO) {
        ResultMap resultMap = new ResultMap();
        HunterExample hunterExample = new HunterExample();



        hunterService.setEntityMapper(hunterService.getHunterByUser());
        hunterService.setEntity((T) hunter);
        this.setBizService(hunterService);

        this.updateByPrimaryKey((T) hunterDTO);

        resultMap.setRet(1);
        resultMap.setSuccess("个人信息更新成功！");
        return resultMap;
    }







    private void setProperties(){
        hunterService.setEntityMapper(hunterService.getHunterByUser());
        hunterService.setEntity((T)hunter);

        this.setBizService(hunterService);
    }
}
