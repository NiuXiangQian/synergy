package cn.laoniu.synergy.service.storage;

import cn.laoniu.synergy.service.storage.model.DocModel;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 在内存中的doc
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2021/3/30 4:51 下午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2021/3/30 4:51 下午
 * @updateRemark:
 * @version: 1.0
 **/
@Service
public class DocStorageInMemory implements DocStorage {

    /**
     * 存储
     */
    private static final Map<String, DocModel> DOC_MODEL_MAP = new ConcurrentHashMap<>();

    @Override
    public void add(DocModel docModel) throws Exception {
        DOC_MODEL_MAP.put(docModel.getId(), docModel);
    }

    @Override
    public DocModel get(String id) {
        return DOC_MODEL_MAP.get(id);
    }
}
