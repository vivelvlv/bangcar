/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.utility;


public enum EEmailTokenType implements org.apache.thrift.TEnum {
  /**
   * 注册激活邮件
   */
  REGISTER(1);

  private final int value;

  private EEmailTokenType(int value) {
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
  public static EEmailTokenType findByValue(int value) { 
    switch (value) {
      case 1:
        return REGISTER;
      default:
        return null;
    }
  }
}
