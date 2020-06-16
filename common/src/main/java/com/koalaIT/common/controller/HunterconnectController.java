package com.koalaIT.common.controller;

import com.koalaIT.common.biz.HunterconnectService;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.HunterExample;
import com.koalaIT.common.model.Hunterconnect;
import com.koalaIT.common.util.CommonUtils;
import com.koalaIT.common.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping(value="/addhunter.json",method = { RequestMethod.POST})
    @ResponseBody
    public ResultMap addHunterInfo(Hunterconnect hunterconnect) {
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
    @RequestMapping(value="/delorder.json",method = { RequestMethod.GET})
    @ResponseBody
    public ResultMap delHunterInfo(Integer hunterId) {
        ResultMap resultMap = new ResultMap();



        this.setProperties();

        this.deleteByPrimaryKey(hunterId);

        resultMap.setRet(1);
        resultMap.setSuccess("删除求职信息成功！");
        return resultMap;
    }

    //我发布的
    //查询hunter的信息
    @RequestMapping(value="/getorder.json",method = { RequestMethod.GET})
    @ResponseBody
    public ResultMap getResume(Integer userId) {
        ResultMap resultMap = new ResultMap();
        HunterExample hunterExample = new HunterExample();


        try {
            this.setProperties();
            List list = hunterconnectService.findHunterByID(userId);
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
    @RequestMapping(value="/yescheck.json",method = { RequestMethod.POST})
    @ResponseBody
    public ResultMap addHunterCheck(Hunterconnect hunterconnect) {
        ResultMap resultMap = new ResultMap();




        this.setProperties();

        this.hunterconnectService.addCheck(hunterconnect);

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
