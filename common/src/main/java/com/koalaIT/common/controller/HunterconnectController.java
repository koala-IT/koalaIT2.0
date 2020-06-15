package com.koalaIT.common.controller;

import com.koalaIT.common.biz.HunterconnectService;
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

    //新增hunter
    @RequestMapping(value="/addhunter.json")
    @ResponseBody
    public ResultMap addHunterInfo(Hunterconnect hunterconnect, HttpSession session) {
        ResultMap resultMap = new ResultMap();

        hunterconnect.setHunterId( Integer.parseInt(CommonUtils.getUUID()));



        hunterconnectService.setEntityMapper(hunterconnectService.getHunterconnectMapper());
        hunterconnectService.setEntity((T) hunterconnect);
        this.setBizService(hunterconnectService);

        this.insertSelective((T) hunterconnect);

        resultMap.setRet(1);
        resultMap.setSuccess("用户注册成功！");
        return resultMap;
    }

    //删除求职
    @RequestMapping(value="/delorder.json")
    @ResponseBody
    public ResultMap delHunterInfo(Integer hunter_id) {
        ResultMap resultMap = new ResultMap();




        hunterconnectService.setEntityMapper(hunterconnectService.getHunterconnectMapper());
        hunterconnectService.setEntity((T) hunterconnect);
        this.setBizService(hunterconnectService);

        this.deleteByPrimaryKey(hunter_id);

        resultMap.setRet(1);
        resultMap.setSuccess("删除求职信息成功！");
        return resultMap;
    }

    //我发布的
    //查询hunter的信息
    @RequestMapping(value="/getorder.json")
    @ResponseBody
    public ResultMap getResume(Integer user_id) {
        ResultMap resultMap = new ResultMap();
        HunterExample hunterExample = new HunterExample();


        try {
            this.setProperties();
            List list = hunterconnectService.findHunterByID(user_id);
            if (list != null) {
                resultMap.setRet(1);
                resultMap.setSuccess("查询详细信息成功！");
                resultMap.setData(list);
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

    //更改我的check
    @RequestMapping(value="/yescheck.json")
    @ResponseBody
    public ResultMap addCheck(Hunterconnect hunterconnect) {
        ResultMap resultMap = new ResultMap();
        HunterconnectExample hunterconnectExample = new HunterconnectExample();



        hunterconnectService.setEntityMapper(hunterconnectService.getHunterconnectMapper());
        hunterconnectService.setEntity((T) hunterconnect);
        this.setBizService(hunterconnectService);

        this.addCheck(hunterconnect);

        resultMap.setRet(1);
        resultMap.setSuccess("个人信息更新成功！");
        return resultMap;
    }


    private void setProperties(){
        hunterconnectService.setEntityMapper(hunterconnectService.getHunterconnectMapper());
        hunterconnectService.setEntity((T)hunterconnect);

        this.setBizService(hunterconnectService);
    }


}
