/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.profile;

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

public class ChangePwdReq implements org.apache.thrift.TBase<ChangePwdReq, ChangePwdReq._Fields>, java.io.Serializable, Cloneable, Comparable<ChangePwdReq> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ChangePwdReq");

  private static final org.apache.thrift.protocol.TField HEAD_FIELD_DESC = new org.apache.thrift.protocol.TField("head", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField OLD_PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("oldPassword", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField NEW_PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("newPassword", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ChangePwdReqStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ChangePwdReqTupleSchemeFactory());
  }

  public com.bangcar.app.mapi.base.MApiReqHead head; // required
  /**
   * 密码类型
   * 
   * @see EPwdType
   */
  public EPwdType type; // required
  /**
   * 原密码
   */
  public String oldPassword; // required
  /**
   * 新密码
   */
  public String newPassword; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HEAD((short)1, "head"),
    /**
     * 密码类型
     * 
     * @see EPwdType
     */
    TYPE((short)2, "type"),
    /**
     * 原密码
     */
    OLD_PASSWORD((short)3, "oldPassword"),
    /**
     * 新密码
     */
    NEW_PASSWORD((short)4, "newPassword");

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
        case 2: // TYPE
          return TYPE;
        case 3: // OLD_PASSWORD
          return OLD_PASSWORD;
        case 4: // NEW_PASSWORD
          return NEW_PASSWORD;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HEAD, new org.apache.thrift.meta_data.FieldMetaData("head", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.bangcar.app.mapi.base.MApiReqHead.class)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, EPwdType.class)));
    tmpMap.put(_Fields.OLD_PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("oldPassword", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NEW_PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("newPassword", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ChangePwdReq.class, metaDataMap);
  }

  public ChangePwdReq() {
  }

  public ChangePwdReq(
    com.bangcar.app.mapi.base.MApiReqHead head,
    EPwdType type,
    String oldPassword,
    String newPassword)
  {
    this();
    this.head = head;
    this.type = type;
    this.oldPassword = oldPassword;
    this.newPassword = newPassword;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ChangePwdReq(ChangePwdReq other) {
    if (other.isSetHead()) {
      this.head = new com.bangcar.app.mapi.base.MApiReqHead(other.head);
    }
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetOldPassword()) {
      this.oldPassword = other.oldPassword;
    }
    if (other.isSetNewPassword()) {
      this.newPassword = other.newPassword;
    }
  }

  public ChangePwdReq deepCopy() {
    return new ChangePwdReq(this);
  }

  @Override
  public void clear() {
    this.head = null;
    this.type = null;
    this.oldPassword = null;
    this.newPassword = null;
  }

  public com.bangcar.app.mapi.base.MApiReqHead getHead() {
    return this.head;
  }

  public ChangePwdReq setHead(com.bangcar.app.mapi.base.MApiReqHead head) {
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
   * 密码类型
   * 
   * @see EPwdType
   */
  public EPwdType getType() {
    return this.type;
  }

  /**
   * 密码类型
   * 
   * @see EPwdType
   */
  public ChangePwdReq setType(EPwdType type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  /**
   * 原密码
   */
  public String getOldPassword() {
    return this.oldPassword;
  }

  /**
   * 原密码
   */
  public ChangePwdReq setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
    return this;
  }

  public void unsetOldPassword() {
    this.oldPassword = null;
  }

  /** Returns true if field oldPassword is set (has been assigned a value) and false otherwise */
  public boolean isSetOldPassword() {
    return this.oldPassword != null;
  }

  public void setOldPasswordIsSet(boolean value) {
    if (!value) {
      this.oldPassword = null;
    }
  }

  /**
   * 新密码
   */
  public String getNewPassword() {
    return this.newPassword;
  }

  /**
   * 新密码
   */
  public ChangePwdReq setNewPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

  public void unsetNewPassword() {
    this.newPassword = null;
  }

  /** Returns true if field newPassword is set (has been assigned a value) and false otherwise */
  public boolean isSetNewPassword() {
    return this.newPassword != null;
  }

  public void setNewPasswordIsSet(boolean value) {
    if (!value) {
      this.newPassword = null;
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

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((EPwdType)value);
      }
      break;

    case OLD_PASSWORD:
      if (value == null) {
        unsetOldPassword();
      } else {
        setOldPassword((String)value);
      }
      break;

    case NEW_PASSWORD:
      if (value == null) {
        unsetNewPassword();
      } else {
        setNewPassword((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HEAD:
      return getHead();

    case TYPE:
      return getType();

    case OLD_PASSWORD:
      return getOldPassword();

    case NEW_PASSWORD:
      return getNewPassword();

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
    case TYPE:
      return isSetType();
    case OLD_PASSWORD:
      return isSetOldPassword();
    case NEW_PASSWORD:
      return isSetNewPassword();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ChangePwdReq)
      return this.equals((ChangePwdReq)that);
    return false;
  }

  public boolean equals(ChangePwdReq that) {
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

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_oldPassword = true && this.isSetOldPassword();
    boolean that_present_oldPassword = true && that.isSetOldPassword();
    if (this_present_oldPassword || that_present_oldPassword) {
      if (!(this_present_oldPassword && that_present_oldPassword))
        return false;
      if (!this.oldPassword.equals(that.oldPassword))
        return false;
    }

    boolean this_present_newPassword = true && this.isSetNewPassword();
    boolean that_present_newPassword = true && that.isSetNewPassword();
    if (this_present_newPassword || that_present_newPassword) {
      if (!(this_present_newPassword && that_present_newPassword))
        return false;
      if (!this.newPassword.equals(that.newPassword))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ChangePwdReq other) {
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
    lastComparison = Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOldPassword()).compareTo(other.isSetOldPassword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOldPassword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.oldPassword, other.oldPassword);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNewPassword()).compareTo(other.isSetNewPassword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNewPassword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.newPassword, other.newPassword);
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
    StringBuilder sb = new StringBuilder("ChangePwdReq(");
    boolean first = true;

    sb.append("head:");
    if (this.head == null) {
      sb.append("null");
    } else {
      sb.append(this.head);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("oldPassword:");
    if (this.oldPassword == null) {
      sb.append("null");
    } else {
      sb.append(this.oldPassword);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("newPassword:");
    if (this.newPassword == null) {
      sb.append("null");
    } else {
      sb.append(this.newPassword);
    }
    first = false;
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

  private static class ChangePwdReqStandardSchemeFactory implements SchemeFactory {
    public ChangePwdReqStandardScheme getScheme() {
      return new ChangePwdReqStandardScheme();
    }
  }

  private static class ChangePwdReqStandardScheme extends StandardScheme<ChangePwdReq> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ChangePwdReq struct) throws org.apache.thrift.TException {
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
          case 2: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = EPwdType.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // OLD_PASSWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.oldPassword = iprot.readString();
              struct.setOldPasswordIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // NEW_PASSWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.newPassword = iprot.readString();
              struct.setNewPasswordIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ChangePwdReq struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.head != null) {
        oprot.writeFieldBegin(HEAD_FIELD_DESC);
        struct.head.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeI32(struct.type.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.oldPassword != null) {
        oprot.writeFieldBegin(OLD_PASSWORD_FIELD_DESC);
        oprot.writeString(struct.oldPassword);
        oprot.writeFieldEnd();
      }
      if (struct.newPassword != null) {
        oprot.writeFieldBegin(NEW_PASSWORD_FIELD_DESC);
        oprot.writeString(struct.newPassword);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ChangePwdReqTupleSchemeFactory implements SchemeFactory {
    public ChangePwdReqTupleScheme getScheme() {
      return new ChangePwdReqTupleScheme();
    }
  }

  private static class ChangePwdReqTupleScheme extends TupleScheme<ChangePwdReq> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ChangePwdReq struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHead()) {
        optionals.set(0);
      }
      if (struct.isSetType()) {
        optionals.set(1);
      }
      if (struct.isSetOldPassword()) {
        optionals.set(2);
      }
      if (struct.isSetNewPassword()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetHead()) {
        struct.head.write(oprot);
      }
      if (struct.isSetType()) {
        oprot.writeI32(struct.type.getValue());
      }
      if (struct.isSetOldPassword()) {
        oprot.writeString(struct.oldPassword);
      }
      if (struct.isSetNewPassword()) {
        oprot.writeString(struct.newPassword);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ChangePwdReq struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.head = new com.bangcar.app.mapi.base.MApiReqHead();
        struct.head.read(iprot);
        struct.setHeadIsSet(true);
      }
      if (incoming.get(1)) {
        struct.type = EPwdType.findByValue(iprot.readI32());
        struct.setTypeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.oldPassword = iprot.readString();
        struct.setOldPasswordIsSet(true);
      }
      if (incoming.get(3)) {
        struct.newPassword = iprot.readString();
        struct.setNewPasswordIsSet(true);
      }
    }
  }

}
