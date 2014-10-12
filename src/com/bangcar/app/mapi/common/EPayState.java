/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.common;


/**
 * 订单付款状态[UserOrder::payState]: 描述订单关联的资金状态
 */
public enum EPayState implements org.apache.thrift.TEnum {
  /**
   * 未发起支付: 初始状态
   */
  UNPAID(0),
  /**
   * 支付处理中: 已发起,还无结果
   */
  PROCESSING(1),
  /**
   * 支付成功: 已回调或已查询到成功
   */
  PAID(2),
  /**
   * 支付失败: 已回调或已查询到失败(余额不足/超过限额)
   */
  FAIL(3),
  /**
   * 已赎回: 已结息完成(pay back)
   */
  REPAID(4),
  /**
   * 已退款: 未成团
   */
  REFUNDED(5);

  private final int value;

  private EPayState(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static EPayState findByValue(int value) { 
    switch (value) {
      case 0:
        return UNPAID;
      case 1:
        return PROCESSING;
      case 2:
        return PAID;
      case 3:
        return FAIL;
      case 4:
        return REPAID;
      case 5:
        return REFUNDED;
      default:
        return null;
    }
  }
}