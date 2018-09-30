package wy.addons.zcgl.inStore.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * 入库单Model
 *
 * @author wyframe
 * @Date 2017-11-21 16:29:33
 */
public class Xgt_goods_store_bill {


    private static final long serialVersionUID = 1L;

    @TableId(value = "bill_in_id", type = IdType.AUTO)
    private Integer bill_in_id;
    private Integer in_bill_type;
    private String bill_no;
    private String bill_dsc;
    private Integer cpn_store_id;
    private Integer cpn_id;
    private Integer cpn_branch_id;
    private Date cre_dt;
    private Integer st_id;
    private String oper_user;

    public Integer getBill_in_id() {
        return bill_in_id;
    }

    public void setBill_in_id(Integer bill_in_id) {
        this.bill_in_id = bill_in_id;
    }

    public Integer getIn_bill_type() {
        return in_bill_type;
    }

    public void setIn_bill_type(Integer in_bill_type) {
        this.in_bill_type = in_bill_type;
    }

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public String getBill_dsc() {
        return bill_dsc;
    }

    public void setBill_dsc(String bill_dsc) {
        this.bill_dsc = bill_dsc;
    }

    public Integer getCpn_store_id() {
        return cpn_store_id;
    }

    public void setCpn_store_id(Integer cpn_store_id) {
        this.cpn_store_id = cpn_store_id;
    }

    public Integer getCpn_id() {
        return cpn_id;
    }

    public void setCpn_id(Integer cpn_id) {
        this.cpn_id = cpn_id;
    }

    public Integer getCpn_branch_id() {
        return cpn_branch_id;
    }

    public void setCpn_branch_id(Integer cpn_branch_id) {
        this.cpn_branch_id = cpn_branch_id;
    }

    public Date getCre_dt() {
        return cre_dt;
    }

    public void setCre_dt(Date cre_dt) {
        this.cre_dt = cre_dt;
    }

    public Integer getSt_id() {
        return st_id;
    }

    public void setSt_id(Integer st_id) {
        this.st_id = st_id;
    }

    public String getOper_user() {
        return oper_user;
    }

    public void setOper_user(String oper_user) {
        this.oper_user = oper_user;
    }


}