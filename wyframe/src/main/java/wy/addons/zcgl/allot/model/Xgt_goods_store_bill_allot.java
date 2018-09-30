package wy.addons.zcgl.allot.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

public class Xgt_goods_store_bill_allot {
    private static final long serialVersionUID = 1L;

    @TableId(value = "bill_req_id", type = IdType.AUTO)
    private Integer bill_req_id;
    private String bill_no;
    private String bill_dsc;
    private Integer out_cpn_store_id;
    private Integer in_cpn_store_id;
    private Integer cpn_id;
    private Integer cpn_branch_id;
    private Date cre_dt;
    private Integer st_id;
    private String oper_user;
    private Integer req_bill_type;
    private Integer rel_bill_id;
    private Integer print_num;
    private Integer aud_st_id;
    private String aud_user;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBill_req_id() {
        return bill_req_id;
    }

    public void setBill_req_id(Integer bill_req_id) {
        this.bill_req_id = bill_req_id;
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

    public Integer getOut_cpn_store_id() {
        return out_cpn_store_id;
    }

    public void setOut_cpn_store_id(Integer out_cpn_store_id) {
        this.out_cpn_store_id = out_cpn_store_id;
    }

    public Integer getIn_cpn_store_id() {
        return in_cpn_store_id;
    }

    public void setIn_cpn_store_id(Integer in_cpn_store_id) {
        this.in_cpn_store_id = in_cpn_store_id;
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

    public Integer getReq_bill_type() {
        return req_bill_type;
    }

    public void setReq_bill_type(Integer req_bill_type) {
        this.req_bill_type = req_bill_type;
    }

    public Integer getRel_bill_id() {
        return rel_bill_id;
    }

    public void setRel_bill_id(Integer rel_bill_id) {
        this.rel_bill_id = rel_bill_id;
    }

    public Integer getPrint_num() {
        return print_num;
    }

    public void setPrint_num(Integer print_num) {
        this.print_num = print_num;
    }

    public Integer getAud_st_id() {
        return aud_st_id;
    }

    public void setAud_st_id(Integer aud_st_id) {
        this.aud_st_id = aud_st_id;
    }

    public String getAud_user() {
        return aud_user;
    }

    public void setAud_user(String aud_user) {
        this.aud_user = aud_user;
    }
}
