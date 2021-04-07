package cn.laoniu.synergy.controller;

import cn.laoniu.synergy.service.storage.DocStorage;
import cn.laoniu.synergy.service.storage.model.DocModel;
import cn.laoniu.synergy.service.storage.model.MarkDownModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/***
 *
 * @author nxq email: niuxiangqian163@163.com
 * @version 1.0
 * @since 2021/3/30 4:47 下午
 **/
@Controller
public class IndexController {

    @Autowired
    private DocStorage docStorage;

    @GetMapping("/")
    public String index() {
        return "redirect:index.html";
    }

    @GetMapping("/create")
    public String create(HttpServletRequest request) {
        String gid = UUID.randomUUID().toString();
        request.setAttribute("gid", gid);
        MarkDownModel downModel = new MarkDownModel();
        downModel.setData("");
        downModel.setId(gid);
        docStorage.add(downModel);

        return "redirect:t/" + gid;
    }

    @GetMapping("t/{gid}")
    public String t(@PathVariable String gid, HttpServletRequest request) {
        request.setAttribute("gid", gid);
        DocModel docModel = docStorage.get(gid);
        if (docModel == null) {
            return "notfound";
        }
        request.setAttribute("data", docModel.getData());
        return "edit";
    }

}
