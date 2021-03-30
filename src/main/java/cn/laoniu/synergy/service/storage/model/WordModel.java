package cn.laoniu.synergy.service.storage.model;

/**
 * @description:
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 4:47 下午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 4:47 下午
 * @updateRemark:
 * @version: 1.0
 **/
public class WordModel implements DocModel {
    private String id;
    private String data;
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getData() {
        System.out.println("this"+data);
        return data;
    }

    public void setData(Object data) {
        this.data = data.toString();
    }
}
