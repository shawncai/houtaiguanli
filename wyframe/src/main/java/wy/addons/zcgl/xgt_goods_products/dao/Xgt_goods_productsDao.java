package wy.addons.zcgl.xgt_goods_products.dao;
import java.util.List;
import java.util.Map;
import wy.addons.zcgl.xgt_goods_products.model.Xgt_goods_products;
import org.apache.ibatis.annotations.Param;
/**
 * 商品测试Dao
 *
 * @author wyFrame
 * @Date 2018-07-20 20:23:12
 */
public interface Xgt_goods_productsDao {
	List<Map<String, Object>> list(@Param("condition") String condition,@Param("xyd_st_id") Integer xyd_st_id);

	Xgt_goods_products queryById(@Param("xgt_goods_productsId") Integer xgt_goods_productsId);
    List<Map<String, Object>> getMap2();
    List<Map<String, Object>> getMap4();
    List<Map<String, Object>> getMap6();
    List<Map<String, Object>> getMap15();

      void deleteByIds(@Param("list")  List<Integer> list);
}