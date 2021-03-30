package cn.laoniu.synergy.service.storage;

import cn.laoniu.synergy.service.storage.model.DocModel;

/***
 *
 * @author nxq email: niuxiangqian163@163.com
 * @version 1.0
 * @since 2021/3/30 4:47 下午
 **/
public interface DocStorage {

    /***
     * 添加一个doc数据
     * @author nxq
     * @param docModel:
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
