package cn.laoniu.synergy.service.storage;

import cn.laoniu.synergy.service.storage.model.DocModel;

/**
 * @description: 文档存储
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 4:36 下午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 4:36 下午
 * @updateRemark:
 * @version: 1.0
 **/
public interface DocStorage {

    /***
     * 添加一个doc数据
     * @author nxq
     * @param docModel:
     * @return cn.laoniu.synergy.service.storage.model.DocModel
     */
    void add(DocModel docModel);

    /***
     * 根据id获取doc数据
     * @author nxq
     * @param id:
     * @return cn.laoniu.synergy.service.storage.model.DocModel
     */
    DocModel get(String id);


}
