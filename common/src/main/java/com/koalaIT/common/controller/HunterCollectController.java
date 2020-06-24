package com.koalaIT.common.controller;

import com.koalaIT.common.biz.HunterService;
import com.koalaIT.common.biz.HuntercollectService;
import com.koalaIT.common.model.*;
import com.koalaIT.common.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "huntercollect")
public class HunterCollectController <T extends BaseDO, E extends BaseExample> extends BaseController<T,E>{
    @Autowired
    private Huntercollect huntercollect;

    @Autowired
    private Hunter hunter;

    @Autowired
    private HuntercollectService<T,E> huntercollectService;

    @Autowired
    private HunterService<T,E> hunterService;

    //添加收藏
    @RequestMapping(value = "/addhuntercollect", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMap addHuntercollect(Huntercollect huntercollect) {
        ResultMap resultMap = new ResultMap();


        this.setProperties();
        this.insertSelective((T) huntercollect);

        resultMap.setRet(1);
        resultMap.setSuccess("用户注册成功！");
        resultMap.put("success", 1);
        return resultMap;
    }
    //取消收藏
    @RequestMapping(value="/delhuntercollect.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap delHunterconnect(@RequestBody Huntercollect huntercollect) {
        ResultMap resultMap = new ResultMap();
        HuntercollectExample huntercollectExample = new HuntercollectExample();
        HuntercollectExample.Criteria criteria = huntercollectExample.createCriteria();
        criteria.andHunterIdEqualTo(huntercollect.getHunterId());
        criteria.andUserIdEqualTo(huntercollect.getUserId());

        this.setProperties();

        this.deleteByExample((E) huntercollectExample);

        resultMap.setRet(1);
        resultMap.setSuccess("删除求职信息成功！");
        /*     resultMap.put("success",1);*/
        return resultMap;
    }
    //查询收藏
    @RequestMapping(value="/searchbosscollect.json", method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap findHunterByOrder(@RequestParam Integer userId) {
        ResultMap resultMap = new ResultMap();

        try {
            this.setProperties();
            List list = this.hunterService.getMyHunterCollect(userId);
            if (list != null) {
                resultMap.setRet(1);
                resultMap.setSuccess("查询详细信息成功！");
                resultMap.put("areaBossList",list);
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
        huntercollectService.setEntityMapper(huntercollectService.getHuntercollectMapper());
        huntercollectService.setEntity((T)huntercollect);

        this.setBizService(huntercollectService);
    }
}
