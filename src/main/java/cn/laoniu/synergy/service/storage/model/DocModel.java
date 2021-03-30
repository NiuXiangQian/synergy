package cn.laoniu.synergy.service.storage.model;

/**
 * @description: doc文档的数据模型
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 4:44 下午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 4:44 下午
 * @updateRemark:
 * @version: 1.0
 **/
public class DocModel {
    private String id;
    private Object data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
