package com.koalaIT.common.controller;

import com.koalaIT.common.biz.BossService;
import com.koalaIT.common.model.*;
import com.koalaIT.common.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

@RequestMapping(value = "boss")
public class BossController <T extends BaseDO, E extends BaseExample> extends BaseController<T,E>{
    @Autowired
    private Boss boss;

    @Autowired
    private BossService <T,E> bossService;


/*    private Timer currentTimer = null;

    private List bossinfo = null;*/


    @RequestMapping(value="/boss_list.html")
    public ModelAndView selectAllInfo(){
        ModelAndView mv = new ModelAndView("boss_list");

        return mv;
    }

    //查询boss的信息

    @RequestMapping(value="/findboss.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap getBossInfo() {
        ResultMap resultMap = new ResultMap();
        BossExample bossExample = new BossExample();

        try {
/*            if (currentTimer == null) {
                this.addTestData(10000);
            }*/
            this.setProperties();
            List t = this.selectByExample((E) bossExample);
            if (t != null) {

                List<Boss> list =  t;
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
/*    //计时器
    private void addTestData(int timeInterval) {
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                ResultMap resultMap = new ResultMap();
                BossExample bossExample = new BossExample();
                setProperties();
                List t = selectByExample((E) bossExample);
            }
        }, time, timeInterval);

        currentTimer = timer;
        bossinfo = t;
    }*/
    //条件查询
    @RequestMapping(value="/searchboss.json", method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap findHunterByOrder(@RequestParam String bossTitle) {
        ResultMap resultMap = new ResultMap();
        BossExample bossExample = new BossExample();
        BossExample.Criteria criteria = bossExample.createCriteria();
        criteria.andBossTitleEqualTo(bossTitle);



        try {
            this.setProperties();
            List list = this.bossService.getBossInfo(bossTitle);
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



    //新增boss
/*    @RequestMapping(value="/addboss.html")
    public ModelAndView addHunterInfo(ModelAndView mv) {
        mv.setViewName("addhunter");
        return mv;
    }*/

    @RequestMapping(value="/addboss.json",method = { RequestMethod.POST })
    @ResponseBody
    public ResultMap addBossInfo(@RequestBody Boss bossinfo) {
        ResultMap resultMap = new ResultMap();

       /* boss.setBossId( Integer.parseInt(CommonUtils.getUUID()));*/



        this.setProperties();

        this.insertSelective((T) bossinfo);

        resultMap.setRet(1);
        resultMap.setSuccess("用户注册成功！");
        resultMap.put("success", 1);
        return resultMap;
    }
    //更改我的boss
    @RequestMapping(value="/getboss.json", method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap getBossInfoById(@RequestParam Integer bossId) {
        ResultMap resultMap = new ResultMap();

        //以后这里可以放置检验bossId是否为空的方法
/*        if (StringUtils.isBlank(rid)) {
            resultMap.setRet(0);
            resultMap.setError("rid不能为空！");
            return resultMap;
        }*/

        try {
            this.setProperties();
            T t =  this.selectByPrimaryKey(bossId);
            if (t != null) {
                resultMap.setRet(1);
                resultMap.setSuccess("查询详细信息成功！");
                resultMap.put("areaBossList",t);
            }
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.setRet(0);
            resultMap.setError("查询详细信息失败！");
            return resultMap;
        }




        return resultMap;
    }


    @RequestMapping(value="/updateboss.json",method = { RequestMethod.POST })
    @ResponseBody
    public ResultMap updateBossInfo( Boss boss) {
        ResultMap resultMap = new ResultMap();





        this.setProperties();

        this.updateByPrimaryKey((T) boss);

        resultMap.setRet(1);
        resultMap.setSuccess("个人信息更新成功！");
        resultMap.put("success", 1);
        return resultMap;
    }

    //删除信息
    @RequestMapping(value="/delboss.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap delBossInfo(@RequestParam Integer bossId) {
        ResultMap resultMap = new ResultMap();




        this.setProperties();

        this.deleteByPrimaryKey(bossId);

        resultMap.setRet(1);
        resultMap.setSuccess("删除求职信息成功！");
        resultMap.put("success", 1);
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
        resultMap.put("success", 1);
        return resultMap;
    }

    //查询boss的信息
    @RequestMapping(value="/publish.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap getBoss(@RequestParam Integer userId) {
        ResultMap resultMap = new ResultMap();

        try {
            this.setProperties();
            List list = bossService.getBossByUser(userId);
            if (list != null) {
                resultMap.setRet(1);
                resultMap.setSuccess("查询详细信息成功！");
                resultMap.put("areaBossList", list);
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
    public ResultMap findBossByOrder(@RequestParam Integer userId) {
        ResultMap resultMap = new ResultMap();

        try {
            this.setProperties();
            List list = bossService.findBossByOrder(userId);
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
    //预约我的
    @RequestMapping(value="/orderedhunter.json",method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap getBossByOrder(@RequestParam Integer userId) {
        ResultMap resultMap = new ResultMap();

        try {
            this.setProperties();
            List list = bossService.getBossByOrder(userId);
            if (list != null) {
                resultMap.setRet(1);
                resultMap.setSuccess("查询详细信息成功！");
                resultMap.put("areaBossList", list);
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
        bossService.setEntity((T) boss);

        this.setBizService(bossService);
    }

}
