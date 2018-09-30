package wy.rest.addons.zsh.bs_send_channel.dao;

import org.apache.ibatis.annotations.Param;
import wy.core.node.ZTreeNode;
import wy.rest.addons.zsh.bs_send_channel.model.Bs_send_channel;

import java.util.List;
import java.util.Map;

/**
 * 配送商Dao
 *
 * @author wyFrame
 * @Date 2018-07-25 14:28:36
 */
public interface Bs_send_channelDao {
	List<Map<String, Object>> list(@Param("condition") String condition, @Param("xyd_st_id") Integer xyd_st_id);

	Bs_send_channel queryById(@Param("bs_send_channelId") Integer bs_send_channelId);
    List<Map<String, Object>> getMap10();

    List<Map<String, Object>> findAreaId(@Param("map") Map<String, Object> map);


      void deleteByIds(@Param("list") List<Integer> list);

    void deleteAreaSC(@Param("channelId") Integer channelId);

    void insertAreaIdSC(@Param("list") List<Map<String, Object>> list);

    List<Integer> selectAreaIdById(@Param("channelId") Integer channelId);

    List<ZTreeNode> areaTreeListById(@Param("array") String[] strArray, @Param("channelId") Integer channelId);
}
