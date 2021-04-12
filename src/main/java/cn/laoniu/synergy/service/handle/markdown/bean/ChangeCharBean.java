package cn.laoniu.synergy.service.handle.markdown.bean;

import java.util.Map;

/***
 * 改变的内容
 * @author niuxiangqian
 * @version 1.0
 * @since 2021/4/8 6:00 下午
 **/
public class ChangeCharBean {

    /**
     * formatString 格式串
     * <main>X:c=m>n+@s</main>
     * <ul>
     *    <ol>`X:`  固定格式</ol>
     *    <ol>`c=`  c是数字，在此处代表了修改了几个字符，例如:
     *                               <i>此次修改了1个字符就是`1=`</i>
     *                               <i>例如修改了两个字符就是`2=`</i>
     *    </ol>
     *    <ol>`m>n` m、n都是数字，在此处代表字符串变更的位置长度是从m到n; 关于m与n的中间的符号若是新增字符则为`>`，若为删除则为`<`</ol>
     *    <ol>`+@s` +@是固定格式，s为更改的字符串</ol>
     * </ul>
     * 例如： 字符串 abcdef 变成了 abcdefg   则此格式串为：X:1=5>6+@f
     *       字符串 abc哈哈efg 变成了 abcdefg   则此格式串为：X:1=5>6+@f
     *
     */
    private String fmtStr;

    /**
     * 扩展元数据
     */
    private Map<Object, Object> meta;
    /**
     * timestamp 扩展时间戳
     */
    private long tsp;

    public String getFmtStr() {
        return fmtStr;
    }

    public void setFmtStr(String fmtStr) {
        this.fmtStr = fmtStr;
    }

    public Map<Object, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<Object, Object> meta) {
        this.meta = meta;
    }

    public long getTsp() {
        return tsp;
    }

    public void setTsp(long tsp) {
        this.tsp = tsp;
    }
}
