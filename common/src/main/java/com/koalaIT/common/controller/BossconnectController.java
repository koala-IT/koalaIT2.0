package com.koalaIT.common.controller;

import com.koalaIT.common.biz.BossconnectService;
import com.koalaIT.common.model.*;
import com.koalaIT.common.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "bossConnect")
public class BossconnectController <T extends BaseDO,E extends BaseExample>extends BaseController<T,E>{
    @Autowired
    private Bossconnect bossconnect;

    @Autowired
    private BossconnectService<T,E> bossconnectService;

    //网页展示区域，因为微信小程序而不用
/*    @RequestMapping(value="/")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("bossconnect_list");

        return mv;
    }*/
    //增加预约关联
    @RequestMapping(value="/orderboss.json", method = { RequestMethod.POST })
    @ResponseBody
    public ResultMap addHunterInfo(Bossconnect bossconnect) {
        ResultMap resultMap = new ResultMap();
        if(bossconnect.getUserId() == null){
            resultMap.setRet(0);
            resultMap.setError("没有收到用户ID");
        }else if (bossconnect.getBossId() == null){
            resultMap.setRet(0);
            resultMap.setError("没有收到BossID");
        }else {
            this.setProperties();
            this.insertSelective((T) bossconnect);

            resultMap.setRet(1);
            resultMap.setSuccess("用户注册成功！");

        }
        return resultMap;

    }
    //取消预约
    @RequestMapping(value="/delorder.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap delBossconnect(@RequestBody Bossconnect bossconnect) {
        ResultMap resultMap = new ResultMap();
        BossconnectExample bossconnectExample = new BossconnectExample();
        BossconnectExample.Criteria criteria = bossconnectExample.createCriteria();
        if(bossconnect.getUserId() == null){
            resultMap.setRet(0);
            resultMap.setError("没有收到用户ID");
        }else if (bossconnect.getBossId() == null){
            resultMap.setRet(0);
            resultMap.setError("没有收到BossID");
        }else {
            criteria.andBossIdEqualTo(bossconnect.getBossId());
            criteria.andUserIdEqualTo(bossconnect.getUserId());

            this.setProperties();
            this.deleteByExample((E) bossconnectExample);


            resultMap.setRet(1);
            resultMap.setSuccess("删除求职信息成功！");
            /*     resultMap.put("success",1);*/
        }
        return resultMap;

    }

    //
    @RequestMapping(value="/getorder.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap getResume(@RequestParam Integer userId) {
        ResultMap resultMap = new ResultMap();

        try {
            this.setProperties();
            List list = bossconnectService.findBossByID(userId);
            if (list != null) {
                resultMap.setRet(1);
                resultMap.setSuccess("查询详细信息成功！");
                resultMap.put("infoList",list);
            }
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.setRet(0);
            resultMap.setError("查询详细信息失败！");
            return resultMap;
        }



        return resultMap;
    }
    //更改我的check
    @RequestMapping(value="/yescheck.json",method = { RequestMethod.POST })
    @ResponseBody
    public ResultMap addBossCheck(Bossconnect bossconnect) {
        ResultMap resultMap = new ResultMap();




        this.setProperties();

        this.bossconnectService.addCheck(bossconnect);

        resultMap.setRet(1);
        resultMap.setSuccess("个人信息更新成功！");
        resultMap.put("success",1);
        return resultMap;
    }


    private void setProperties(){     /*将模板service的方法实体化*/
        bossconnectService.setEntityMapper(bossconnectService.getBossconnectMapper());
        bossconnectService.setEntity((T)bossconnect);

        this.setBizService(bossconnectService);
    }
}
