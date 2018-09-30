package wy.rest.addons.zsh.bs_bill.dao;

import org.apache.ibatis.annotations.Param;
import wy.rest.addons.zsh.bs_bill.model.Bs_bill;

import java.util.List;
import java.util.Map;
/**
 * 订单Dao
 *
 * @author wyFrame
 * @Date 2018-07-25 15:16:00
 */
public interface Bs_billDao {
	List<Map<String, Object>> list(@Param("condition") String condition, @Param("bill_st_id") Integer bill_st_id, @Param("send_st") Integer send_st, @Param("xyd_st_id") Integer xyd_st_id);
    List<Map<String, Object>> list1(@Param("condition") String condition, @Param("bill_st_id") Integer bill_st_id, @Param("send_st") Integer send_st, @Param("xyd_st_id") Integer xyd_st_id, @Param("userId") Integer userId);
	Bs_bill queryById(@Param("bs_billId") Integer bs_billId);
    List<Map<String, Object>> getMap8();
    List<Map<String, Object>> getMap9();
    List<Map<String, Object>> getMap10();
    List<Map<String, Object>> getMap13();
    List<Map<String, Object>> getMap15();
    List<Map<String, Object>> getMap19();

      void deleteByIds(@Param("list") List<Integer> list);
      List<Map<String,Object>> fuList();
      List<Map<String,Object>> paramList();
      List<Map<String,Object>> initParam(@Param("moren") Integer moren);

      	int insertTotal(@Param("map") Map<String, Object> map);
      	int deleteDetail(@Param("id") Integer id);

      	int insertDetail(@Param("list") List<Map<String, Object>> list);

    Map<String,String> selectArea(@Param("area_id") Integer area_id);

    List<Map<String,Object>> selectSendChannel(@Param("area_id") Integer area_id);

    void changeSendToIng(@Param("bs_billId") Integer bs_billId, @Param("send_st") Integer send_st, @Param("sendTime") String sendTime, @Param("send_remark") String send_remark, @Param("account") String account);

    Integer addBill(@Param("map") Map<String, Object> map);

    Map<String,Object> findByBillNo(@Param("map") Map<String, Object> map);

    void saveShopDt(@Param("map") Map<String, Object> map);
    void changeShopNoNUM(@Param("map") Map<String, Object> map);

    void delBill(@Param("map") Map<String, Object> map);

    List<Map<String,Object>> queryBill(@Param("map") Map<String, Object> map);

    List<Map<String,Object>> queryBillBoolean(@Param("map") Map<String, Object> map);
    Map<String,Object> querySend(@Param("map") Map<String, Object> map);
}
