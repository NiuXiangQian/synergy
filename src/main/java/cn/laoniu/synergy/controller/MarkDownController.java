package cn.laoniu.synergy.controller;

import cn.laoniu.synergy.common.webret.R;
import cn.laoniu.synergy.service.storage.DocStorage;
import cn.laoniu.synergy.service.storage.model.DocModel;
import cn.laoniu.synergy.service.storage.model.MarkDownModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/***
 * markdown控制器
 * @author niuxiangqian
 * @version 1.0
 * @since 2021/3/31 4:57 下午
 **/
@RestController
@RequestMapping("/markdown")
public class MarkDownController {

    @Autowired
    private DocStorage docStorage;

    /***
     * 创建一个makrdown文档
     * @author nxq
     * @param request:
     * @return cn.laoniu.synergy.common.webret.R<cn.laoniu.synergy.service.storage.model.MarkDownModel>
     */
    @PostMapping("/create")
    public R<MarkDownModel> create(HttpServletRequest request) {

        String gid = UUID.randomUUID().toString();
        request.setAttribute("gid", gid);
        MarkDownModel downModel = new MarkDownModel();
        downModel.setData("");
        downModel.setId(gid);
        docStorage.add(downModel);

        return R.ok(downModel);
    }

    /***
      * 获取markdown的内容
      * @author nxq
      * @param gid:
      * @return cn.laoniu.synergy.common.webret.R<cn.laoniu.synergy.service.storage.model.DocModel>
      */
    @GetMapping("/{gid}")
    public R<DocModel> get(@PathVariable String gid) {

        DocModel docModel = docStorage.get(gid);
        if (docModel == null) {
            return R.failed("该文档不不存在");
        }
        return R.ok(docModel);
    }

}
