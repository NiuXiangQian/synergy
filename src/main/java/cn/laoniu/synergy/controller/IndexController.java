package cn.laoniu.synergy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @description:
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 9:19 上午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 9:19 上午
 * @updateRemark:
 * @version: 1.0
 **/
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "redirect:index.html";
    }

    @GetMapping("/create")
    public String create(HttpServletRequest request) {
        String gid = UUID.randomUUID().toString();
        request.setAttribute("gid", gid);

        return "redirect:t/" + gid;
    }

    @GetMapping("t/{gid}")
    public String t(@PathVariable String gid, HttpServletRequest request) {
        request.setAttribute("gid", gid);
        System.out.println("gid = " + gid);
        return "edit";
    }

}
