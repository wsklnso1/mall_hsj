package com.hsj.mall.dto;

import org.mall_hsj_mbg.model.OmsOrder;
import org.mall_hsj_mbg.model.OmsOrderItem;
import org.mall_hsj_mbg.model.OmsOrderOperateHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * Created by macro on 2018/10/11.
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    private List<OmsOrderOperateHistory> historyList;
}
