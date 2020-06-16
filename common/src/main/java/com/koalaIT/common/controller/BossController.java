package com.koalaIT.common.controller;

import com.koalaIT.common.biz.BossService;
import com.koalaIT.common.model.*;
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
@RequestMapping(value = "boss")
public class BossController <T extends BaseDO, E extends BaseExample> extends BaseController<T,E>{
    @Autowired
    private Boss boss;

    @Autowired
    private BossService <T,E> bossService;

    @RequestMapping(value="/boss_list.html")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("boss_list");

        return mv;
    }

    //查询hunter的信息
    @RequestMapping(value="/findboss.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap getBossInfo() {
        ResultMap resultMap = new ResultMap();
        BossExample bossExample = new BossExample();


        try {
            this.setProperties();
            List t = this.selectByExample((E) bossExample);
            if (t != null) {
                List<Hunter> list =  t;
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

        bossExample = null;


        return resultMap;
    }
    //条件查询
    @RequestMapping(value="/searchboss.json", method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap findHunterByOrder(String bossTitle) {
        ResultMap resultMap = new ResultMap();



        try {
            this.setProperties();
            List list = bossService.getBossInfo(bossTitle);
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




        return resultMap;
    }



    //新增boss
/*    @RequestMapping(value="/addboss.html")
    public ModelAndView addHunterInfo(ModelAndView mv) {
        mv.setViewName("addhunter");
        return mv;
    }*/

    @RequestMapping(value="/addboss.json",method = { RequestMethod.POST })
    @ResponseBody
    public ResultMap addBossInfo(Boss boss) {
        ResultMap resultMap = new ResultMap();

        boss.setBossId( Integer.parseInt(CommonUtils.getUUID()));



        this.setProperties();

        this.insertSelective((T) boss);

        resultMap.setRet(1);
        resultMap.setSuccess("用户注册成功！");
        return resultMap;
    }
    //更改我的boss
    @RequestMapping(value="/updateboss.json",method = { RequestMethod.POST })
    @ResponseBody
    public ResultMap updateBossInfo(Boss boss) {
        ResultMap resultMap = new ResultMap();





        this.setProperties();

        this.updateByPrimaryKey((T) boss);

        resultMap.setRet(1);
        resultMap.setSuccess("个人信息更新成功！");
        return resultMap;
    }

    //删除信息
    @RequestMapping(value="/delboss.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap delBossInfo(Integer bossId) {
        ResultMap resultMap = new ResultMap();




        this.setProperties();

        this.deleteByPrimaryKey(bossId);

        resultMap.setRet(1);
        resultMap.setSuccess("删除求职信息成功！");
        return resultMap;
    }

    //
    //添加预约状态
    @RequestMapping(value="/order.json",method = { RequestMethod.POST })
    @ResponseBody
    public ResultMap orderBossInfo(Boss boss) {
        ResultMap resultMap = new ResultMap();
        HunterExample hunterExample = new HunterExample();



        this.setProperties();

        this.updateByPrimaryKeySelective((T) boss);

        resultMap.setRet(1);
        resultMap.setSuccess("添加预约状态成功！");
        return resultMap;
    }
    //我发布的
    //查询boss的信息
    @RequestMapping(value="/publish.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap getBoss(Integer userId) {
        ResultMap resultMap = new ResultMap();

        try {
            this.setProperties();
            List list = bossService.getBossByUser(userId);
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

        return resultMap;
    }
    //我预约的
    @RequestMapping(value="/orderhunter.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap findBossByOrder(Integer userId) {
        ResultMap resultMap = new ResultMap();

        try {
            this.setProperties();
            List list = bossService.findBossByOrder(userId);
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

        return resultMap;
    }
    //预约我的
    @RequestMapping(value="/orderedhunter.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap getBossByOrder(Integer userId) {
        ResultMap resultMap = new ResultMap();

        try {
            this.setProperties();
            List list = bossService.getBossByOrder(userId);
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

        return resultMap;
    }




    private void setProperties(){                 /*将模板service的方法实体化*/
        bossService.setEntityMapper(bossService.getBossMapper());
        bossService.setEntity((T)boss);

        this.setBizService(bossService);
    }

}
