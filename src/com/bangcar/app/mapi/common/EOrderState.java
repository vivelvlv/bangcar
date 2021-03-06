/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.common;


/**
 * 订单状态[UserOrder::orderState]: 是否有效(有效即占用库存)
 */
public enum EOrderState implements org.apache.thrift.TEnum {
  /**
   * 有效: 初始状态
   */
  INITIAL(0),
  /**
   * 无效: 系统关闭订单
   */
  SYS_CLOSED(1),
  /**
   * 无效: 用户取消订单
   */
  USER_CLOSED(2);

  private final int value;

  private EOrderState(int value) {
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
  public static EOrderState findByValue(int value) { 
    switch (value) {
      case 0:
        return INITIAL;
      case 1:
        return SYS_CLOSED;
      case 2:
        return USER_CLOSED;
      default:
        return null;
    }
  }
}
