package com.koalaIT.front.controller;

import com.koalaIT.common.biz.UserService;
import com.koalaIT.common.controller.BaseController;
import com.koalaIT.common.dto.UserDTO;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.User;
import com.koalaIT.common.model.UserExample;
import com.koalaIT.common.util.ResultMap;
import com.koalaIT.common.util.VerifyCodeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "login")
public class LoginController <T extends BaseDO,E extends BaseExample> extends BaseController<T,E> {
    @Autowired
    UserService<T,E> userService;

    @Autowired
    User user;




    //登入
    @RequestMapping(value="/login.html")
    public ModelAndView gotoLogin(ModelAndView mv) {
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value="/login.json",method = { RequestMethod.POST })
    @ResponseBody
    public ResultMap login(@RequestBody UserDTO userDTO, HttpSession session) {
        ResultMap resultMap = new ResultMap();
/*        String cc = userDTO.getCc();
        if (StringUtils.isNotBlank(cc)) {
            if (!cc.equalsIgnoreCase((String) session.getAttribute("cc"))) {
                resultMap.setRet(0); //0表示失败
                resultMap.setError("验证码不正确！");
                return resultMap;
            }
        }*/

        String userName = userDTO.getUserName();
        String psd = userDTO.getPassword();

        UserExample userExample = new UserExample();    /* 我也不懂这是啥*/
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andPasswordEqualTo(psd);

        userService.setEntityMapper(userService.getUserMapper());
        userService.setEntity((T) new User());        /*将baseDO和baseExample实例化*/

        List list = userService.selectByExample((E) userExample);
        if (list != null && list.size() > 0) {
            User user = (User) list.get(0);
            session.setAttribute("userId",user.getUserId());
            session.setAttribute("userName",user.getUserName());

            resultMap.setRet(1);
            resultMap.setSuccess("登陆成功！");
            resultMap.put("success",user.getUserId());
        }
        userExample = null;



        return resultMap;
    }

    @RequestMapping(value="/index.html")
    public ModelAndView gotoIndex(ModelAndView mv) {
        mv.setViewName("welcome");
        return mv;
    }

    //注册
    @RequestMapping(value="/register.html")
    public ModelAndView gotoRegister(ModelAndView mv) {
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping(value="/register.json")
    @ResponseBody
    public ResultMap register(@RequestBody UserDTO userDTO,HttpSession session) {
        ResultMap resultMap = new ResultMap();
        String cc = userDTO.getCc();
        if (StringUtils.isNotBlank(cc)) {
            if (!cc.equalsIgnoreCase((String) session.getAttribute("cc"))) {
                resultMap.setRet(0);
                resultMap.setError("验证码不正确！");
                return resultMap;
            }
        }

        String userName = userDTO.getUserName();
        if (StringUtils.isBlank(userName)) {
            resultMap.setRet(0);
            resultMap.setError("用户名不能为空！");
        }
        String password = userDTO.getPassword();
        if (StringUtils.isBlank(password)) {
            resultMap.setRet(0);
            resultMap.setError("密码不能为空！");
        }

        userService.setEntityMapper(userService.getUserMapper());
        userService.setEntity((T) user);
        this.setBizService(userService);

        this.insertSelective((T) userDTO);

        resultMap.setRet(1);
        resultMap.setSuccess("用户注册成功！");
        return resultMap;
    }


    //验证码
    @RequestMapping(value="/ccImg")
    public void getCC(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //存入会话session
        HttpSession session = request.getSession();
        //删除以前的
        session.removeAttribute("cc");

        String code = VerifyCodeUtils.generateVerifyCode(4);
        try {
            VerifyCodeUtils.outputImage(80, 26, response.getOutputStream(), code);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        session.setAttribute("cc",code);
    }

/*    *//*
     * 加入测试数据
     *//*
    private void addTestData(int timeInterval) {
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                TabRoute tRoute = new TabRoute();
                tRoute.setRid(CommonUtils.getUUID());
                tRoute.setCid(5);
                tRoute.setCount((int) (Math.random() * (500-100) + 100));
                tRoute.setPrice(900.0);
                tRoute.setRdate(DateUtil.strByDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
                tRoute.setSid(1);
                tRoute.setRflag("1");
                tRoute.setIsthemetour("0");
                tRoute.setRname("【张家界高铁4天 深度纯玩高级团】天门山 玻璃栈道 大峡谷玻璃桥");
                tRoute.setRouteintroduce("游览天门山森林公园，挑战玻璃栈道+大峡谷玻璃桥 ，品张家界土家风味餐！");

                tabRouteService.setEntityMapper(tabRouteService.getTabRouteMapper());
                tabRouteService.setEntity((T) tRoute);
                tabRouteService.insertSelective((T) tRoute);//通过插入来查看刷新
                tRoute = null;
            }
        }, time, timeInterval);

        currentTimer = timer;
    }*/


}
