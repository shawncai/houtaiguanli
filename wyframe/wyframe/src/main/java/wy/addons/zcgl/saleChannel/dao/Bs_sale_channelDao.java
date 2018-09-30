package wy.addons.zcgl.saleChannel.dao;


import wy.addons.zcgl.saleChannel.model.Bs_sale_channel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 销售渠道Dao
 *
 * @author wyframe
 * @Date 2017-07-17 16:53:20
 */
public interface Bs_sale_channelDao {

	List<Map<String, Object>> list(@Param("condition") String condition);

	Bs_sale_channel queryById(@Param("bs_sale_channelId") Integer bs_sale_channelId);
}
