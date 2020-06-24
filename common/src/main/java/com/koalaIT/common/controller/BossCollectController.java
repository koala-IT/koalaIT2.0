package com.koalaIT.common.controller;

import com.koalaIT.common.biz.BossService;
import com.koalaIT.common.biz.BosscollectService;
import com.koalaIT.common.model.*;
import com.koalaIT.common.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "bosscollect")
public class BossCollectController <T extends BaseDO, E extends BaseExample> extends BaseController<T,E>{
    @Autowired
    private Bosscollect bosscollect;

    @Autowired
    private Boss boss;

    @Autowired
    private BosscollectService<T,E> bosscollectService;

    @Autowired
    private BossService<T,E> bossService;

    //添加收藏
    @RequestMapping(value = "/addbosscollect", method = {RequestMethod.POST})
    @ResponseBody
    public ResultMap addBosscollect(Bosscollect bosscollect) {
        ResultMap resultMap = new ResultMap();


        this.setProperties();
        this.insertSelective((T) bosscollect);

        resultMap.setRet(1);
        resultMap.setSuccess("用户注册成功！");
        resultMap.put("success", 1);
        return resultMap;
    }
    //取消收藏
    @RequestMapping(value="/delbosscollect.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap delBossconnect(@RequestBody Bosscollect bosscollect) {
        ResultMap resultMap = new ResultMap();
        BosscollectExample bosscollectExample = new BosscollectExample();
        BosscollectExample.Criteria criteria = bosscollectExample.createCriteria();
        criteria.andBossIdEqualTo(bosscollect.getBossId());
        criteria.andUserIdEqualTo(bosscollect.getUserId());

        this.setProperties();

        this.deleteByExample((E) bosscollectExample);

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
            List list = this.bossService.getMyBossCollect(userId);
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
        bosscollectService.setEntityMapper(bosscollectService.getBosscollectMapper());
        bosscollectService.setEntity((T)bosscollect);

        this.setBizService(bosscollectService);
    }
}
