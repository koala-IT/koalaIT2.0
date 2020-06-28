package com.koalaIT.front.controller;

import com.koalaIT.common.biz.HunterService;
import com.koalaIT.common.controller.BaseController;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Hunter;
import com.koalaIT.common.model.HunterExample;
import com.koalaIT.common.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "test")
public class TestController <T extends BaseDO, E extends BaseExample> extends BaseController<T,E> {

    @Autowired
    private Hunter hunter;

    @Autowired
    private HunterService<T,E> hunterService;

   @RequestMapping(value="/test_list.json" ,method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap hcount( ) {
        ResultMap resultMap = new ResultMap();

        HunterExample hunterExample = new HunterExample();
//        tabRouteExample.setOrderByClause("rdate desc");
        HunterExample hunterExample1 = new HunterExample();
        HunterExample.Criteria criteria1 = hunterExample1.createCriteria();
        HunterExample.Criteria criteria = hunterExample.createCriteria();
        Integer hunterCount = 0;

        hunterService.setEntityMapper(hunterService.getHunterMapper());
        hunterService.setEntity((T) new Hunter());

        hunterCount = this.countByExample((E) hunterExample1);

        hunterExample = null;
        hunterExample1 = null;

        resultMap.setRet(1);
        resultMap.setSuccess("分页查询成功！");
        resultMap.put("hunterCount",hunterCount);
        return resultMap;
    }

    @RequestMapping(value="/counthunter.json" ,method = { RequestMethod.GET })
    @ResponseBody
    public ResultMap counthunter( ) {
        ResultMap resultMap = new ResultMap();

        HunterExample hunterExample = new HunterExample();
//        tabRouteExample.setOrderByClause("rdate desc");
        HunterExample hunterExample1 = new HunterExample();
        HunterExample.Criteria criteria1 = hunterExample1.createCriteria();
        HunterExample.Criteria criteria = hunterExample.createCriteria();
        criteria.andHunterTitleLike("java");
        criteria1.andHunterTitleLike("web");
        Integer hunterCount = 0;
        Integer hunterCount1 = 0;

        hunterService.setEntityMapper(hunterService.getHunterMapper());
        hunterService.setEntity((T) new Hunter());

        hunterCount = this.countByExample((E) hunterExample);
        hunterCount1 = this.countByExample((E) hunterExample1);

        hunterExample = null;
        hunterExample1 = null;

        resultMap.setRet(1);
        resultMap.setSuccess("分页查询成功！");
        resultMap.put("hunterCount",hunterCount);
        resultMap.put("hunterCount1",hunterCount1);
        return resultMap;
    }

/*        //判断价格区间
        String priceStr = hunterDTO.getPriceStr();
        if (priceStr != null) {
            String[] priceStrs = priceStr.split("~");
            if (priceStrs != null && priceStrs.length == 1) {
                String priceStr1 = priceStrs[0];
                priceStr1 = priceStr1.substring(0,priceStr1.length() - 1);
                criteria.andPriceGreaterThan(Double.parseDouble(priceStr1));
                criteria1.andPriceGreaterThan(Double.parseDouble(priceStr1));
            } else {
                if (priceStrs != null && priceStrs.length == 2) {
                    criteria.andPriceBetween(Double.parseDouble(priceStrs[0].trim()),Double.parseDouble(priceStrs[1].trim()));
                    criteria1.andPriceBetween(Double.parseDouble(priceStrs[0].trim()),Double.parseDouble(priceStrs[1].trim()));
                }
            }
        }

        //出行日期
        String rdateStr = routeQueryDTO.getRdateStr();
        if (rdateStr != null) {
            String[] rdateStrs = rdateStr.split("~");
            if (rdateStrs != null && rdateStrs.length == 2) {
                criteria.andRdateBetween(rdateStrs[0].trim(),rdateStrs[1].trim());
                criteria1.andRdateBetween(rdateStrs[0].trim(),rdateStrs[1].trim());
            }
        }*/



/*        List<TabRouteVO>  tabRouteVOList = null;
        Integer tabRouteCount = 0;
        try {
            tabRouteCount = this.countByExample((E) tabRouteExample1);
            tabRouteVOList = (List<TabRouteVO>) this.selectByExamplePage((E) tabRouteExample,routeQueryDTO.getPageNum() - 1,routeQueryDTO.getPageSize());
            for (TabRouteVO tabRouteVO : tabRouteVOList) {
                String rFlag = tabRouteVO.getRflag();
                if (rFlag.equals("1")) {
                    tabRouteVO.setRflagStr("有效");
                } else if (rFlag.equals("0")){
                    tabRouteVO.setRflagStr("无效");
                }

                tabRouteVO.setRdateStr(tabRouteVO.getRdate());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.setRet(0);
            resultMap.setError("分页查询失败！");
            return resultMap;
        }

        resultMap.setData(tabRouteVOList);
        resultMap.put("pageAmount",tabRouteCount);
*/


  /*   @RequestMapping(value="/detail.json")
    @ResponseBody
    public ResultMap getDetail(String rid) {
        ResultMap resultMap = new ResultMap();
        if (StringUtils.isBlank(rid)) {
            resultMap.setRet(0);
            resultMap.setError("rid不能为空！");
            return resultMap;
        }

        try {
            this.setProperties();
            T t = this.selectByPrimaryKey(rid);
            if (t != null) {
                TabRoute tabRoute = (TabRoute) t;
                resultMap.setRet(1);
                resultMap.setSuccess("查询详细信息成功！");
                resultMap.setData(tabRoute);
            }
        } catch(Exception e) {
            e.printStackTrace();
            resultMap.setRet(0);
            resultMap.setError("查询详细信息失败！");
            return resultMap;
        }


        return resultMap;
    }*/



}
