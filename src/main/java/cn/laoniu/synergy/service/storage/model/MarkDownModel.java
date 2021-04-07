package cn.laoniu.synergy.service.storage.model;

/***
 *
 * @author nxq email: niuxiangqian163@163.com
 * @version 1.0
 * @since 2021/3/30 4:46 下午
 **/
public class MarkDownModel implements DocModel {
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
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data.toString();
    }
}
