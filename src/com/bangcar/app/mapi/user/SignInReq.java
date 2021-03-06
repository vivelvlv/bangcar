/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.user;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;

import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;

public class SignInReq implements org.apache.thrift.TBase<SignInReq, SignInReq._Fields>, java.io.Serializable, Cloneable, Comparable<SignInReq> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SignInReq");

  private static final org.apache.thrift.protocol.TField HEAD_FIELD_DESC = new org.apache.thrift.protocol.TField("head", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField ACCOUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("account", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField CAPTCHA_FIELD_DESC = new org.apache.thrift.protocol.TField("captcha", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SignInReqStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SignInReqTupleSchemeFactory());
  }

  public com.bangcar.app.mapi.base.MApiReqHead head; // required
  /**
   * 登录名，目前仅开放手机号登录
   */
  public String account; // required
  /**
   * 登录密码
   */
  public String password; // required
  /**
   * 图形验证码，可选，当用户尝试登录时密码错误后才必须
   */
  public String captcha; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HEAD((short)1, "head"),
    /**
     * 登录名，目前仅开放手机号登录
     */
    ACCOUNT((short)2, "account"),
    /**
     * 登录密码
     */
    PASSWORD((short)3, "password"),
    /**
     * 图形验证码，可选，当用户尝试登录时密码错误后才必须
     */
    CAPTCHA((short)4, "captcha");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // HEAD
          return HEAD;
        case 2: // ACCOUNT
          return ACCOUNT;
        case 3: // PASSWORD
          return PASSWORD;
        case 4: // CAPTCHA
          return CAPTCHA;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private _Fields optionals[] = {_Fields.CAPTCHA};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HEAD, new org.apache.thrift.meta_data.FieldMetaData("head", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.bangcar.app.mapi.base.MApiReqHead.class)));
    tmpMap.put(_Fields.ACCOUNT, new org.apache.thrift.meta_data.FieldMetaData("account", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CAPTCHA, new org.apache.thrift.meta_data.FieldMetaData("captcha", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SignInReq.class, metaDataMap);
  }

  public SignInReq() {
  }

  public SignInReq(
    com.bangcar.app.mapi.base.MApiReqHead head,
    String account,
    String password)
  {
    this();
    this.head = head;
    this.account = account;
    this.password = password;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SignInReq(SignInReq other) {
    if (other.isSetHead()) {
      this.head = new com.bangcar.app.mapi.base.MApiReqHead(other.head);
    }
    if (other.isSetAccount()) {
      this.account = other.account;
    }
    if (other.isSetPassword()) {
      this.password = other.password;
    }
    if (other.isSetCaptcha()) {
      this.captcha = other.captcha;
    }
  }

  public SignInReq deepCopy() {
    return new SignInReq(this);
  }

  @Override
  public void clear() {
    this.head = null;
    this.account = null;
    this.password = null;
    this.captcha = null;
  }

  public com.bangcar.app.mapi.base.MApiReqHead getHead() {
    return this.head;
  }

  public SignInReq setHead(com.bangcar.app.mapi.base.MApiReqHead head) {
    this.head = head;
    return this;
  }

  public void unsetHead() {
    this.head = null;
  }

  /** Returns true if field head is set (has been assigned a value) and false otherwise */
  public boolean isSetHead() {
    return this.head != null;
  }

  public void setHeadIsSet(boolean value) {
    if (!value) {
      this.head = null;
    }
  }

  /**
   * 登录名，目前仅开放手机号登录
   */
  public String getAccount() {
    return this.account;
  }

  /**
   * 登录名，目前仅开放手机号登录
   */
  public SignInReq setAccount(String account) {
    this.account = account;
    return this;
  }

  public void unsetAccount() {
    this.account = null;
  }

  /** Returns true if field account is set (has been assigned a value) and false otherwise */
  public boolean isSetAccount() {
    return this.account != null;
  }

  public void setAccountIsSet(boolean value) {
    if (!value) {
      this.account = null;
    }
  }

  /**
   * 登录密码
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * 登录密码
   */
  public SignInReq setPassword(String password) {
    this.password = password;
    return this;
  }

  public void unsetPassword() {
    this.password = null;
  }

  /** Returns true if field password is set (has been assigned a value) and false otherwise */
  public boolean isSetPassword() {
    return this.password != null;
  }

  public void setPasswordIsSet(boolean value) {
    if (!value) {
      this.password = null;
    }
  }

  /**
   * 图形验证码，可选，当用户尝试登录时密码错误后才必须
   */
  public String getCaptcha() {
    return this.captcha;
  }

  /**
   * 图形验证码，可选，当用户尝试登录时密码错误后才必须
   */
  public SignInReq setCaptcha(String captcha) {
    this.captcha = captcha;
    return this;
  }

  public void unsetCaptcha() {
    this.captcha = null;
  }

  /** Returns true if field captcha is set (has been assigned a value) and false otherwise */
  public boolean isSetCaptcha() {
    return this.captcha != null;
  }

  public void setCaptchaIsSet(boolean value) {
    if (!value) {
      this.captcha = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case HEAD:
      if (value == null) {
        unsetHead();
      } else {
        setHead((com.bangcar.app.mapi.base.MApiReqHead)value);
      }
      break;

    case ACCOUNT:
      if (value == null) {
        unsetAccount();
      } else {
        setAccount((String)value);
      }
      break;

    case PASSWORD:
      if (value == null) {
        unsetPassword();
      } else {
        setPassword((String)value);
      }
      break;

    case CAPTCHA:
      if (value == null) {
        unsetCaptcha();
      } else {
        setCaptcha((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HEAD:
      return getHead();

    case ACCOUNT:
      return getAccount();

    case PASSWORD:
      return getPassword();

    case CAPTCHA:
      return getCaptcha();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case HEAD:
      return isSetHead();
    case ACCOUNT:
      return isSetAccount();
    case PASSWORD:
      return isSetPassword();
    case CAPTCHA:
      return isSetCaptcha();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SignInReq)
      return this.equals((SignInReq)that);
    return false;
  }

  public boolean equals(SignInReq that) {
    if (that == null)
      return false;

    boolean this_present_head = true && this.isSetHead();
    boolean that_present_head = true && that.isSetHead();
    if (this_present_head || that_present_head) {
      if (!(this_present_head && that_present_head))
        return false;
      if (!this.head.equals(that.head))
        return false;
    }

    boolean this_present_account = true && this.isSetAccount();
    boolean that_present_account = true && that.isSetAccount();
    if (this_present_account || that_present_account) {
      if (!(this_present_account && that_present_account))
        return false;
      if (!this.account.equals(that.account))
        return false;
    }

    boolean this_present_password = true && this.isSetPassword();
    boolean that_present_password = true && that.isSetPassword();
    if (this_present_password || that_present_password) {
      if (!(this_present_password && that_present_password))
        return false;
      if (!this.password.equals(that.password))
        return false;
    }

    boolean this_present_captcha = true && this.isSetCaptcha();
    boolean that_present_captcha = true && that.isSetCaptcha();
    if (this_present_captcha || that_present_captcha) {
      if (!(this_present_captcha && that_present_captcha))
        return false;
      if (!this.captcha.equals(that.captcha))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(SignInReq other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetHead()).compareTo(other.isSetHead());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHead()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.head, other.head);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAccount()).compareTo(other.isSetAccount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAccount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.account, other.account);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPassword()).compareTo(other.isSetPassword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPassword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, other.password);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCaptcha()).compareTo(other.isSetCaptcha());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCaptcha()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.captcha, other.captcha);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("SignInReq(");
    boolean first = true;

    sb.append("head:");
    if (this.head == null) {
      sb.append("null");
    } else {
      sb.append(this.head);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("account:");
    if (this.account == null) {
      sb.append("null");
    } else {
      sb.append(this.account);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("password:");
    if (this.password == null) {
      sb.append("null");
    } else {
      sb.append(this.password);
    }
    first = false;
    if (isSetCaptcha()) {
      if (!first) sb.append(", ");
      sb.append("captcha:");
      if (this.captcha == null) {
        sb.append("null");
      } else {
        sb.append(this.captcha);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (head != null) {
      head.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SignInReqStandardSchemeFactory implements SchemeFactory {
    public SignInReqStandardScheme getScheme() {
      return new SignInReqStandardScheme();
    }
  }

  private static class SignInReqStandardScheme extends StandardScheme<SignInReq> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SignInReq struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // HEAD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.head = new com.bangcar.app.mapi.base.MApiReqHead();
              struct.head.read(iprot);
              struct.setHeadIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ACCOUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.account = iprot.readString();
              struct.setAccountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PASSWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.password = iprot.readString();
              struct.setPasswordIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CAPTCHA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.captcha = iprot.readString();
              struct.setCaptchaIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, SignInReq struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.head != null) {
        oprot.writeFieldBegin(HEAD_FIELD_DESC);
        struct.head.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.account != null) {
        oprot.writeFieldBegin(ACCOUNT_FIELD_DESC);
        oprot.writeString(struct.account);
        oprot.writeFieldEnd();
      }
      if (struct.password != null) {
        oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
        oprot.writeString(struct.password);
        oprot.writeFieldEnd();
      }
      if (struct.captcha != null) {
        if (struct.isSetCaptcha()) {
          oprot.writeFieldBegin(CAPTCHA_FIELD_DESC);
          oprot.writeString(struct.captcha);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SignInReqTupleSchemeFactory implements SchemeFactory {
    public SignInReqTupleScheme getScheme() {
      return new SignInReqTupleScheme();
    }
  }

  private static class SignInReqTupleScheme extends TupleScheme<SignInReq> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SignInReq struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHead()) {
        optionals.set(0);
      }
      if (struct.isSetAccount()) {
        optionals.set(1);
      }
      if (struct.isSetPassword()) {
        optionals.set(2);
      }
      if (struct.isSetCaptcha()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetHead()) {
        struct.head.write(oprot);
      }
      if (struct.isSetAccount()) {
        oprot.writeString(struct.account);
      }
      if (struct.isSetPassword()) {
        oprot.writeString(struct.password);
      }
      if (struct.isSetCaptcha()) {
        oprot.writeString(struct.captcha);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SignInReq struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.head = new com.bangcar.app.mapi.base.MApiReqHead();
        struct.head.read(iprot);
        struct.setHeadIsSet(true);
      }
      if (incoming.get(1)) {
        struct.account = iprot.readString();
        struct.setAccountIsSet(true);
      }
      if (incoming.get(2)) {
        struct.password = iprot.readString();
        struct.setPasswordIsSet(true);
      }
      if (incoming.get(3)) {
        struct.captcha = iprot.readString();
        struct.setCaptchaIsSet(true);
      }
    }
  }

}

