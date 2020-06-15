package com.koalaIT.common.controller;

import com.koalaIT.common.biz.HunterService;
import com.koalaIT.common.dto.HunterDTO;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Hunter;
import com.koalaIT.common.model.HunterExample;
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
public class HunterController <T extends BaseDO,E extends BaseExample> extends BaseController<T,E>{
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
            List t = this.selectByExample((E) hunterExample);
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



        hunterService.setEntityMapper(hunterService.getHunterMapper());
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



        hunterService.setEntityMapper(hunterService.getHunterMapper());
        hunterService.setEntity((T) hunter);
        this.setBizService(hunterService);

        this.updateByPrimaryKey((T) hunterDTO);

        resultMap.setRet(1);
        resultMap.setSuccess("个人信息更新成功！");
        return resultMap;
    }

    //删除求职
    @RequestMapping(value="/delhunter.json")
    @ResponseBody
    public ResultMap delBossInfo(Integer hunter_id) {
        ResultMap resultMap = new ResultMap();




        hunterService.setEntityMapper(hunterService.getHunterMapper());
        hunterService.setEntity((T) hunter);
        this.setBizService(hunterService);

        this.deleteByPrimaryKey(hunter_id);

        resultMap.setRet(1);
        resultMap.setSuccess("删除求职信息成功！");
        return resultMap;
    }

    //添加预约状态
    @RequestMapping(value="/order.json")
    @ResponseBody
    public ResultMap orderHunterInfo(HunterDTO hunterDTO) {
        ResultMap resultMap = new ResultMap();
        HunterExample hunterExample = new HunterExample();



        hunterService.setEntityMapper(hunterService.getHunterMapper());
        hunterService.setEntity((T) hunter);
        this.setBizService(hunterService);

        this.updateByPrimaryKeySelective((T) hunterDTO);

        resultMap.setRet(1);
        resultMap.setSuccess("添加预约状态成功！");
        return resultMap;
    }

    //我发布的
    //查询hunter的信息
    @RequestMapping(value="/publish.json")
    @ResponseBody
    public ResultMap getHunter(Integer user_id) {
        ResultMap resultMap = new ResultMap();
        HunterExample hunterExample = new HunterExample();


        try {
            this.setProperties();
            List list = hunterService.selectByUser_id(user_id);
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

    //我预约的
    //查询hunter的信息
    @RequestMapping(value="/orderboss.json")
    @ResponseBody
    public ResultMap findHunterByOrder(Integer user_id) {
        ResultMap resultMap = new ResultMap();
        HunterExample hunterExample = new HunterExample();


        try {
            this.setProperties();
            List list = hunterService.selectHunterInfoByOrder(user_id);
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

    //我预约的
    //查询hunter的信息
    @RequestMapping(value="/orderedboss.json")
    @ResponseBody
    public ResultMap getHunterByOrder(Integer user_id) {
        ResultMap resultMap = new ResultMap();
        HunterExample hunterExample = new HunterExample();


        try {
            this.setProperties();
            List list = hunterService.selectHunterInfoByOrdered(user_id);
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









    private void setProperties(){
        hunterService.setEntityMapper(hunterService.getHunterMapper());
        hunterService.setEntity((T)hunter);

        this.setBizService(hunterService);
    }
}
