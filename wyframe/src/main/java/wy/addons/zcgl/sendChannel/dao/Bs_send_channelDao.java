package wy.addons.zcgl.sendChannel.dao;


import wy.addons.zcgl.sendChannel.model.Bs_send_channel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 配送商Dao
 *
 * @author wyframe
 * @Date 2017-07-17 16:44:18
 */
public interface Bs_send_channelDao {

	List<Map<String, Object>> list(@Param("condition") String condition);

	Bs_send_channel queryById(@Param("bs_send_channelId") Integer bs_send_channelId);
}
