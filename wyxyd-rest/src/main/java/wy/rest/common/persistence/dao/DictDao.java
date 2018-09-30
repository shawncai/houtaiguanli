package wy.rest.common.persistence.dao;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import wy.rest.common.persistence.model.Dict;

import java.util.List;
import java.util.Map;

/**
 * 字典的dao
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午11:10:24
 */
public interface DictDao {
    List<Map<String, Object>> selectByName(@Param("name") String name);

    /**
     * 根据编码获取词典列表
     *
     * @param code
     * @return
     * @date 2017年2月13日 下午11:11:28
     */
    List<Dict> selectByCode(@Param("code") String code);

    /**
     * 查询字典列表
     *
     * @author fengshuonan
     * @Date 2017/4/26 13:04
     */
    List<Map<String,Object>> list(@Param("condition") String conditiion);

    List<Map<String,Object>> dictList();

    List<Map<String,Object>> selectById(@Param("dictId") Integer dictId);

    List<Map<String, Object>> selectCpnSts();

    List<Map<String, Object>> selectCpnSpSts();

    List<Map<String, Object>> selectCpnDeptSts();

    List<Map<String, Object>> selectCpnStoreSts();

    List<Map<String, Object>> cpnDeptStList();

    List<Map<String, Object>> cpnStoreStList();

    List<Map<String, Object>> selectItemStList();

    List<Map<String, Object>> wyItemStList();

    List<Map<String, Object>> selectItemSts();

    List<Map<String, Object>> selectItemCls();

    List<Map<String, Object>> cpnBranchStList();

    List<Map<String, Object>> selectCpnBranchSts();

    List<Map<String, Object>> vendorStList();

    List<Map<String, Object>> brandStList();

    List<Map<String, Object>> clsStList();

    List<Map<String, Object>> productStList();

    List<Map<String, Object>> vendorFlgList();

    List<Map<String,Object>> inStoreStList();

    List<Map<String,Object>> inTypeStList();

    List<Map<String,Object>> inList();


    List<Map<String, Object>> list4(@Param("condition") String condition, @Param("id") Integer id);

    int selectPageCount(@Param("page") Page page, @Param("id") Integer id);

    List<Map> selectPageList(@Param("page") Page page, @Param("start") Integer start, @Param("rows") Integer rows, @Param("condition") String condition, @Param("id") Integer id);

}
