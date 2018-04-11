package zhan666.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhan666.annotation.Clever;
import zhan666.annotation.stupid;
import zhan666.service.User;

/**
 * Created by Administrator on 2018/2/27.
 */
@Controller
@RequestMapping("/controller")
public class controller1 {

    @Autowired
    ApplicationContext ac;

    @RequestMapping("getName")
    @ResponseBody
    @stupid(howStupid="low")
    public String getName(){
            User user=(User)ac.getBean("user");
        System.out.println("yeyeyeye~");
        return user.name;
    }

    @RequestMapping("getNothing")
    @ResponseBody
    @stupid
    public String getNothing(){
        User user=(User)ac.getBean("user");
        System.out.println("Nothing~");
        return user.name;
    }

    @RequestMapping("clever")
    @ResponseBody
    @Clever
    public String soClever(){
        System.out.println("so hot ~");
        return "hot!";
    }
}
