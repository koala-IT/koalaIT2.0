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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping(value="/findhunter.json",method = {RequestMethod.GET})
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

    @RequestMapping(value="/addhunter.json",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMap addHunterInfo(HunterDTO hunterDTO) {
        ResultMap resultMap = new ResultMap();

        hunterDTO.setHunterId( Integer.parseInt(CommonUtils.getUUID()));

        this.setProperties();

        this.insertSelective((T) hunterDTO);

        resultMap.setRet(1);
        resultMap.setSuccess("用户注册成功！");
        return resultMap;
    }

    //更改我的hunter
    @RequestMapping(value="/updmyinfo.json",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMap updateUserInfo(HunterDTO hunterDTO) {
        ResultMap resultMap = new ResultMap();

        this.setProperties();

        this.updateByPrimaryKey((T) hunterDTO);

        resultMap.setRet(1);
        resultMap.setSuccess("个人信息更新成功！");
        return resultMap;
    }

    //删除求职
    @RequestMapping(value="/delhunter.json",method = {RequestMethod.GET})
    @ResponseBody
    public ResultMap delHunterInfo(Integer hunterId) {
        ResultMap resultMap = new ResultMap();

        this.setProperties();

        this.deleteByPrimaryKey(hunterId);

        resultMap.setRet(1);
        resultMap.setSuccess("删除求职信息成功！");
        return resultMap;
    }

    //添加预约状态
    @RequestMapping(value="/order.json",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMap orderHunterInfo(HunterDTO hunterDTO) {
        ResultMap resultMap = new ResultMap();

        this.setProperties();

        this.updateByPrimaryKeySelective((T) hunterDTO);

        resultMap.setRet(1);
        resultMap.setSuccess("添加预约状态成功！");
        return resultMap;
    }

    //我发布的
    //查询hunter的信息
    @RequestMapping(value="/publish.json",method = {RequestMethod.GET})
    @ResponseBody
    public ResultMap getHunter(Integer userId) {
        ResultMap resultMap = new ResultMap();

        try {
            this.setProperties();
            List list = hunterService.selectByUser_id(userId);
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
    //查询hunter的信息
    @RequestMapping(value="/orderboss.json",method = {RequestMethod.GET})
    @ResponseBody
    public ResultMap findHunterByOrder(Integer userId) {
        ResultMap resultMap = new ResultMap();

        try {
            this.setProperties();
            List list = hunterService.selectHunterInfoByOrder(userId);
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
    //查询hunter的信息
    @RequestMapping(value="/orderedboss.json",method = {RequestMethod.GET})
    @ResponseBody
    public ResultMap getHunterByOrder(Integer userId) {
        ResultMap resultMap = new ResultMap();

        try {
            this.setProperties();
            List list = hunterService.selectHunterInfoByOrdered(userId);
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









    private void setProperties(){
        hunterService.setEntityMapper(hunterService.getHunterMapper());
        hunterService.setEntity((T)hunter);

        this.setBizService(hunterService);
    }
}
