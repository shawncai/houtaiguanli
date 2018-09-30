package wy.rest.addons.zcgl.inStore.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wy.core.base.controller.BaseController;
import wy.core.util.DateUtil;
import wy.rest.addons.zcgl.cpn_store.dao.Xyd_cpn_storeMapper;
import wy.rest.addons.zcgl.cpn_store.model.Xyd_cpn_store;
import wy.rest.addons.zcgl.inStore.dao.Xgt_goods_store_billDao;
import wy.rest.addons.zcgl.inStore.dao.Xgt_goods_store_billMapper;
import wy.rest.addons.zcgl.inStore.model.Xgt_goods_store_bill;
import wy.rest.addons.zcgl.inStore.warpper.Xgt_goods_store_billWarpper;
import wy.rest.addons.zcgl.products.dao.Xgt_goods_productDao;
import wy.rest.addons.zcgl.products.warpper.Xgt_goods_productWarpper;
import wy.rest.addons.zcgl.xgt_vendor.dao.Xgt_goods_prd_vendorMapper;
import wy.rest.addons.zcgl.xgt_vendor.model.Xgt_goods_prd_vendor;
import wy.rest.common.persistence.dao.UserMgrDao;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 入库单控制器
 *
 * @author wyframe
 * @Date 2017-11-21 16:29:33
 */
@Controller
@RequestMapping("/xgt_goods_store_bill")
public class Xgt_goods_store_billController extends BaseController {
    private String PREFIX = "/addons/zcgl/inStore/";
    @Resource
    Xgt_goods_store_billDao xgt_goods_store_billDao;
    @Resource
    Xgt_goods_productDao xgt_goods_productDao;
    @Resource
    Xgt_goods_store_billMapper xgt_goods_store_billMapper;

    @Resource
    Xgt_goods_prd_vendorMapper xgt_goods_prd_vendorMapper;

    @Resource
    Xyd_cpn_storeMapper xyd_cpn_storeMapper;
    @Resource
    private UserMgrDao managerDao;


    public static int vendorIdSta;

    public static int clsIdSta;

    public List<String> distinct;

    /**
     * 跳转到入库单首页
     */
    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("user", 1);
        model.addAttribute("timer", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        model.addAttribute("print",0);
        return PREFIX + "xgt_goods_store_bill_in.html";
    }

    /**
     * 跳转到供货商搜索
     */
    @RequestMapping("/inStoreVendorPage")
    public String inStoreVendorPage() {
        return PREFIX + "xgt_goods_store_bill_in_vendor.html";
    }

    /**
     * 跳转到供货商添加
     */
    @RequestMapping("/inStoreVendorAdd")
    public String inStoreVendorAdd() {
        return PREFIX + "xgt_goods_store_bill_in_vendor_add.html";
    }

    /**
     * 跳转到仓库搜索
     */
    @RequestMapping("/inStoreStorePage")
    public String inStoreStorePage() {
        return PREFIX + "xgt_goods_store_bill_in_store.html";
    }

    /**
     * 跳转到仓库添加
     */
    @RequestMapping("/inStoreStoreAdd")
    public String inStoreStoreAdd() {
        return PREFIX + "xgt_goods_store_bill_in_store_add.html";
    }

    /**
     * 跳转到用户搜索
     */
    @RequestMapping("/inStoreUserPage")
    public String inStoreUserPage() {
        return PREFIX + "xgt_goods_store_bill_in_user.html";
    }

    /**
     * 跳转到用户添加
     */
    @RequestMapping("/inStoreUserAdd")
    public String inStoreUserAdd() {
        return PREFIX + "xgt_goods_store_bill_in_user_add.html";
    }

    /**
     * 跳转到商品添加
     */
    @RequestMapping("/inStoreProductAdd")
    public String inStoreProductAdd() {
        return PREFIX + "xgt_goods_store_bill_add_param_add.html";
    }

    /**
     * 跳转到审核入库单首页
     */
    @RequestMapping("/indexCheck")
    public String indexCheck() {
        return PREFIX + "xgt_goods_store_bill2.html";
    }

    /**
     * 跳转到添加入库单
     */
    @RequestMapping("/xgt_goods_store_bill_add")
    public String xgt_goods_store_billAdd() {
        return PREFIX + "xgt_goods_store_bill_add.html";
    }

    /**
     * 跳转到审核入库单审核修改
     */

    @RequestMapping("/xgt_goods_store_bill_change/{xgt_goods_store_bill_in_Id}")
    public String xgt_goods_store_bill_change(@PathVariable Integer xgt_goods_store_bill_in_Id, Model model) {
        wy.rest.addons.zcgl.inStore.model.Xgt_goods_store_bill xgt_goods_store_bill = this.xgt_goods_store_billDao.queryById(xgt_goods_store_bill_in_Id);
        model.addAttribute(xgt_goods_store_bill);
        return PREFIX + "xgt_goods_store_bill_add_change.html";

    }

    /**
     * 跳转到添加参数
     */
    @RequestMapping("/xgt_goods_store_bill_add_param/{str}")
    public String xgt_goods_store_bill_add_param(@PathVariable String str) {

        String[] split = str.split(",");
        distinct = Arrays.asList(split);
        return PREFIX + "xgt_goods_store_bill_add_param.html";
    }
    /**
     * 审核页面修改里的新增
     */
    /**
     * 跳转到添加参数
     */
    @RequestMapping("/xgt_goods_store_bill_add_change_add/{str}")
    public String xgt_goods_store_bill_add_change_add(@PathVariable String str) {

        String[] split = str.split(",");
        distinct = Arrays.asList(split);
        return PREFIX + "xgt_goods_store_bill_add_change_add.html";
    }

    /**
     * 获取产品列表
     */
    @RequestMapping(value = "/productList")
    @ResponseBody
    public Object productList() {
        Integer cpnId = managerDao.queryCpnId(1);
        List<Map<String, Object>> list = this.xgt_goods_productDao.list(cpnId);
        List<Map<String, Object>> list1 = new ArrayList<>();
        for (String s : distinct) {
            for (Map<String, Object> map : list) {
                map.put("amount",0);
                map.put("numb",0);
                if ((Integer) map.get("prd_id") == Integer.parseInt(s)) {
                    list1.add(map);
                }
            }
        }
        list.removeAll(list1);
        return super.warpObject(new Xgt_goods_productWarpper(list));
    }

    /**
     * 跳转到修改入库单
     */
    @RequestMapping("/xgt_goods_store_bill_update/{xgt_goods_store_billId}")
    public String xgt_goods_store_billUpdate(@PathVariable Integer xgt_goods_store_billId, Model model) {
        wy.rest.addons.zcgl.inStore.model.Xgt_goods_store_bill xgt_goods_store_bill = this.xgt_goods_store_billDao.queryById(xgt_goods_store_billId);
        model.addAttribute(xgt_goods_store_bill);
        return PREFIX + "xgt_goods_store_bill_edit.html";

    }

    /**
     * 跳转到审核入库单
     */
    @RequestMapping("/xgt_goods_store_bill_review/{xgt_goods_store_bill_in_Id}")
    public String xgt_goods_store_billreview(@PathVariable Integer xgt_goods_store_bill_in_Id, Model model) {
        wy.rest.addons.zcgl.inStore.model.Xgt_goods_store_bill xgt_goods_store_bill = this.xgt_goods_store_billDao.queryById(xgt_goods_store_bill_in_Id);
        model.addAttribute(xgt_goods_store_bill);
        return PREFIX + "xgt_goods_store_bill_review.html";

    }

    /**
     * 跳转到详情入库单
     */
    @RequestMapping("/xgt_goods_store_bill_detail/{xgt_goods_store_billId}")
    public String xgt_goods_store_billDetail(@PathVariable Integer xgt_goods_store_billId, Model model) {
        wy.rest.addons.zcgl.inStore.model.Xgt_goods_store_bill xgt_goods_store_bill = this.xgt_goods_store_billDao.queryById(xgt_goods_store_billId);
        model.addAttribute(xgt_goods_store_bill);
        return PREFIX + "xgt_goods_store_bill_detail.html";

    }

    /**
     * 获取入库单列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String name, @RequestParam(required = false)Integer st_id, @RequestParam(required = false)Integer aud_st_id) {
            List<Map<String, Object>> list = this.xgt_goods_store_billDao.selectOrders(name,st_id,aud_st_id);
            return new Xgt_goods_store_billWarpper(list);

    }

    /**
     * 入库单修改详情列表
     */
    @RequestMapping(value = "/showDetail/{id}")
    @ResponseBody
    public Object showDetail(@PathVariable Integer id) {
        List<Map<String, Object>> list = this.xgt_goods_store_billDao.showDetail(id);
        return list;
    }

    /**
     * 获取详情列表
     */
    @RequestMapping(value = "/detail/{id}")
    @ResponseBody
    public Object detail(@PathVariable Integer id) {
        List<Map<String, Object>> list = this.xgt_goods_store_billDao.selectDetail(id);
        return super.warpObject(new Xgt_goods_store_billWarpper(list));
    }

    /**
     * 获取入库单单号
     */
    @RequestMapping(value = "/getInStoreNo")
    @ResponseBody
    public Object getInStoreNo() {
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyyMMdd");
        String dateTime = dateFm.format(new Date());
        String value = "QTRKD-" + dateTime + "-";//这部分产生前面字符串("如QRTRKD-20180424")
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = dateFormat2.format(new Date());
        int a = Integer.parseInt(xgt_goods_store_billDao.getCreateTimeCount(startTime)) + 1;
        return value + "286L";
    }


    /**
     * 新增入库单
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@RequestParam String iData, @RequestParam String tData) {
        System.err.println("tData" + iData);
        String[] split = tData.split(",");//[1]供货商ID，[2]仓库ID，[3]经手人Id，[4]时间,[5]备注
        System.err.println("split:" + split);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = (List<Map<String, Object>>) JSON.parse(iData);
        int cpnId = managerDao.queryCpnId(1);
        int cpnBrandId = managerDao.queryCpnBrandId(1);
        map.put("in_bill_type", 11);//'单据类型  10：采购入库单；11：其它入库单；12：调拨入库单；',
        map.put("cpn_store_id", split[2]);
        map.put("cpn_id", cpnId);
        map.put("cpn_branch_id", cpnBrandId);
        map.put("cre_dt", DateUtil.format(new Date()));
        map.put("prd_vendor_id", split[1]);
        map.put("st_id", 2);//'状态 -1：废除 1：编辑；2：提交；3:修改',
        map.put("brok_user", split[3]);
        map.put("bill_no", split[6]);
        map.put("bill_dsc", split[5]);
        map.put("oper_user",null);
        map.put("aud_st_id", 1);//'审核状态：1：待审核；2：通过；-1：退单',
        int shop_num = 0;
        for (Map<String, Object> m : list) {
            shop_num = shop_num + Integer.parseInt(m.get("numb") + "");
        }
        map.put("shop_num", shop_num);
        map.put("be_total_amounts", split[7]);
        this.xgt_goods_store_billDao.insertTotal(map);
        for (Map<String, Object> m : list) {
            m.put("bill_id", map.get("bill_in_id"));
            m.put("cre_dt", DateUtil.format(new Date()));
            m.put("cpn_id", cpnId);
            m.put("cpn_branch_id", cpnBrandId);
            m.put("in_num", m.get("numb"));
            m.put("amounts",m.get("amount"));
        }
        this.xgt_goods_store_billDao.insertDetail(list);
        return SUCCESS_TIP;
    }

    /**
     * 修改入库单
     */
    @RequestMapping(value = "/keep")
    @ResponseBody
    public Object keep(@RequestParam String iData, @RequestParam Integer bill_in_id) {
        System.err.println(iData);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = (List<Map<String, Object>>) JSON.parse(iData);
        int cpnId = managerDao.queryCpnId(1);
        int cpnBrandId = managerDao.queryCpnBrandId(1);
        int shop_num = 0;
        for (Map<String, Object> m : list) {
            m.put("bill_id", bill_in_id);
            m.put("cre_dt", DateUtil.format(new Date()));
            m.put("cpn_id", cpnId);
            m.put("cpn_branch_id", cpnBrandId);
            shop_num = shop_num + Integer.parseInt(m.get("in_num") + "");
        }
        map.put("shop_num", shop_num);
        this.xgt_goods_store_billDao.updateTotal(shop_num, bill_in_id);
        this.xgt_goods_store_billDao.deleteDetail(bill_in_id);
        this.xgt_goods_store_billDao.insertDetail(list);
        return SUCCESS_TIP;
    }
    /**
     * 修改入库单
     */
    @RequestMapping(value = "/submit")
    @ResponseBody
    public Object submit(@RequestParam String iData, @RequestParam Integer bill_in_id) {
        System.err.println(iData);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = (List<Map<String, Object>>) JSON.parse(iData);
        int cpnId = managerDao.queryCpnId(1);
        int cpnBrandId = managerDao.queryCpnBrandId(1);
        int shop_num = 0;
        for (Map<String, Object> m : list) {
            m.put("bill_id", bill_in_id);
            m.put("cre_dt", DateUtil.format(new Date()));
            m.put("cpn_id", cpnId);
            m.put("cpn_branch_id", cpnBrandId);
            shop_num = shop_num + Integer.parseInt(m.get("in_num") + "");
        }
        map.put("shop_num", shop_num);
        this.xgt_goods_store_billDao.updateTotal(shop_num, bill_in_id);
        this.xgt_goods_store_billDao.deleteDetail(bill_in_id);
        this.xgt_goods_store_billDao.insertDetail(list);
        this.xgt_goods_store_billDao.updateSubmit(bill_in_id);
        return SUCCESS_TIP;
    }

    /**
     * 保存入库单
     */
    @RequestMapping(value = "/save_in")
    @ResponseBody
    public Object save_in(@RequestParam String iData, @RequestParam String tData) {
        System.err.println("tData" + iData);
        String[] split = tData.split(",");//[1]供货商ID，[2]仓库ID，[3]经手人Id，[4]时间,[5]备注
        System.err.println("split:" + split);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = (List<Map<String, Object>>) JSON.parse(iData);
        int cpnId = managerDao.queryCpnId(1);
        int cpnBrandId = managerDao.queryCpnBrandId(1);
        map.put("in_bill_type", 11);//'单据类型  10：采购入库单；11：其它入库单；12：调拨入库单；',
        map.put("cpn_store_id", split[2]);
        map.put("cpn_id", cpnId);
        map.put("cpn_branch_id", cpnBrandId);
        map.put("cre_dt", DateUtil.format(new Date()));
        map.put("prd_vendor_id", split[1]);
        map.put("st_id", 1);//'状态 -1：废除 1：编辑；2：提交；3:修改',
        map.put("brok_user", split[3]);
        map.put("bill_no", split[6]);
        map.put("bill_dsc", split[5]);
        map.put("oper_user", null);
        map.put("aud_st_id", null);//'审核状态：1：待审核；2：通过；-1：退单',
        int shop_num = 0;
        for (Map<String, Object> m : list) {
            shop_num = shop_num + Integer.parseInt(m.get("numb") + "");
        }
        map.put("shop_num", shop_num);
        map.put("be_total_amounts", split[7]);
        this.xgt_goods_store_billDao.insertTotal(map);
        for (Map<String, Object> m : list) {
            m.put("bill_id", map.get("bill_in_id"));
            m.put("cre_dt", DateUtil.format(new Date()));
            m.put("cpn_id", cpnId);
            m.put("cpn_branch_id", cpnBrandId);
            m.put("in_num", m.get("numb"));
        }
        this.xgt_goods_store_billDao.insertDetail(list);
        return SUCCESS_TIP;
    }

    /**
     * 提交入库单
     */
    @RequestMapping(value = "/submit_in")
    @ResponseBody
    public Object submit_in(@RequestParam String data) {
        Map<String, Object> map = (Map<String, Object>) JSON.parse(data);
//        map.put("in_bill_type",11);// '入库单据类型: 10：采购入库单；11：其它入库单；12：调拨入库单；'
        map.put("cpn_id", 1);
        map.put("cpn_branch_id", 1);
        map.put("cre_dt", DateUtil.format(new Date()));
        map.put("st_id", 2);  //'状态 -1：废除 1：编辑；2：提交；3:修改',
        return SUCCESS_TIP;
    }


    /**
     * 修改入库单
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Xgt_goods_store_bill xgt_goods_store_bill, @RequestParam String str) {
        this.xgt_goods_store_billMapper.updateById(xgt_goods_store_bill);
        String[] strs = str.split("\\.");
        List<Integer> list = new ArrayList<Integer>();
        for (String string : strs) {
            list.add(Integer.parseInt(string));
        }

        Integer id = xgt_goods_store_bill.getBill_in_id();
        this.xgt_goods_store_billDao.deleteDetl(id);
        List<Map<String, Object>> map2 = new ArrayList<Map<String, Object>>();
        for (Integer i : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("bill_id", id);
            map.put("prd_id", i);
            map2.add(map);
        }
        xgt_goods_store_billDao.insertDetail(map2);
        return super.SUCCESS_TIP;
    }

    /**
     * 审核入库单
     */
    @RequestMapping(value = "/review")
    @ResponseBody
    public Object review(@RequestParam Integer id, @RequestParam String idata, @RequestParam String tdata) {
        xgt_goods_store_billDao.updateState(id, 1);
        Map<String, Object> inputMap = (Map<String, Object>) JSON.parse(idata);//input数据
        List<Map<String, Object>> list = (List<Map<String, Object>>) JSON.parse(tdata);
        System.err.println("tadata:"+tdata);
        int cpnId = managerDao.queryCpnId(1);
        int cpnBrandId = managerDao.queryCpnBrandId(1);
        for (Map map : list) {
            map.putAll(inputMap);
            map.put("cpn_id",cpnId);
            map.put("cpn_branch_id",cpnBrandId);
        }
        xgt_goods_store_billDao.insertStore(list);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除入库单
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer id) {
        xgt_goods_store_billDao.deleteState(id,1);
        return SUCCESS_TIP;
    }



    @RequestMapping(value = "/changeCls/{clsId}")
    public void changeCls(@PathVariable String clsId) {
        clsIdSta = Integer.parseInt(clsId);
    }

    @RequestMapping(value = "/changeVendor/{vendorId}")
    public void changeVendor(@PathVariable String vendorId) {
        vendorIdSta = Integer.parseInt(vendorId);
    }

    /**
     * 新增合作伙伴
     */
    @RequestMapping(value = "/vendorAdd")
    @ResponseBody
    public Object vendorAdd(Xgt_goods_prd_vendor xgt_goods_prd_vendor) {
        Integer cpnId = managerDao.queryCpnId(1);
        Integer cpnBranchId = managerDao.queryCpnBrandId(1);
        xgt_goods_prd_vendor.setCpn_id(cpnId);
        xgt_goods_prd_vendor.setCpn_branch_id(cpnBranchId);
        xgt_goods_prd_vendor.setOper_user(null);
        xgt_goods_prd_vendor.setSt_id(1);
        xgt_goods_prd_vendor.setCre_dt(new Date());
        return this.xgt_goods_prd_vendorMapper.insert(xgt_goods_prd_vendor);
    }

    /**
     * 新增入仓仓库
     */
    @RequestMapping(value = "/xgt_goods_store_bill/storeAdd")
    @ResponseBody
    public Object storeAdd(Xyd_cpn_store xyd_cpn_store) {
        xyd_cpn_store.setCre_dt(new Date());
        xyd_cpn_store.setCpn_branch_id(1);
        xyd_cpn_store.setCpn_id(1);
        xyd_cpn_store.setSt_id(1);
        return this.xyd_cpn_storeMapper.insert(xyd_cpn_store);
    }



}
