package wy.rest.addons.zsh.bs_shop.dao;

import org.apache.ibatis.annotations.Param;
import wy.rest.addons.zsh.bs_shop.model.Bs_shop;

import java.util.List;
import java.util.Map;

/**
 * 商品Dao
 *
 * @author wyFrame
 * @Date 2018-07-25 14:33:23
 */
public interface Bs_shopDao {
	List<Map<String, Object>> list(@Param("condition") String condition, @Param("xyd_st_id") Integer xyd_st_id);

	Bs_shop queryById(@Param("bs_shopId") Integer bs_shopId);
    List<Map<String, Object>> getMap10();

      void deleteByIds(@Param("list") List<Integer> list);

    List<Map<String, Object>> listAllShop(@Param("pd") Map<String, Object> pd);
    List<Map<String, Object>> findByShopName(@Param("pd") Map<String, Object> pd);
}
