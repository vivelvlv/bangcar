/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.notify;

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

public class BindDeviceTokenReq implements org.apache.thrift.TBase<BindDeviceTokenReq, BindDeviceTokenReq._Fields>, java.io.Serializable, Cloneable, Comparable<BindDeviceTokenReq> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BindDeviceTokenReq");

  private static final org.apache.thrift.protocol.TField HEAD_FIELD_DESC = new org.apache.thrift.protocol.TField("head", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField DEVICE_TOKEN_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceToken", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BindDeviceTokenReqStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BindDeviceTokenReqTupleSchemeFactory());
  }

  public com.bangcar.app.mapi.base.MApiReqHead head; // required
  public String deviceToken; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HEAD((short)1, "head"),
    DEVICE_TOKEN((short)2, "deviceToken");

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
        case 2: // DEVICE_TOKEN
          return DEVICE_TOKEN;
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
    tmpMap.put(_Fields.DEVICE_TOKEN, new org.apache.thrift.meta_data.FieldMetaData("deviceToken", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BindDeviceTokenReq.class, metaDataMap);
  }

  public BindDeviceTokenReq() {
  }

  public BindDeviceTokenReq(
    com.bangcar.app.mapi.base.MApiReqHead head,
    String deviceToken)
  {
    this();
    this.head = head;
    this.deviceToken = deviceToken;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BindDeviceTokenReq(BindDeviceTokenReq other) {
    if (other.isSetHead()) {
      this.head = new com.bangcar.app.mapi.base.MApiReqHead(other.head);
    }
    if (other.isSetDeviceToken()) {
      this.deviceToken = other.deviceToken;
    }
  }

  public BindDeviceTokenReq deepCopy() {
    return new BindDeviceTokenReq(this);
  }

  @Override
  public void clear() {
    this.head = null;
    this.deviceToken = null;
  }

  public com.bangcar.app.mapi.base.MApiReqHead getHead() {
    return this.head;
  }

  public BindDeviceTokenReq setHead(com.bangcar.app.mapi.base.MApiReqHead head) {
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

  public String getDeviceToken() {
    return this.deviceToken;
  }

  public BindDeviceTokenReq setDeviceToken(String deviceToken) {
    this.deviceToken = deviceToken;
    return this;
  }

  public void unsetDeviceToken() {
    this.deviceToken = null;
  }

  /** Returns true if field deviceToken is set (has been assigned a value) and false otherwise */
  public boolean isSetDeviceToken() {
    return this.deviceToken != null;
  }

  public void setDeviceTokenIsSet(boolean value) {
    if (!value) {
      this.deviceToken = null;
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

    case DEVICE_TOKEN:
      if (value == null) {
        unsetDeviceToken();
      } else {
        setDeviceToken((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HEAD:
      return getHead();

    case DEVICE_TOKEN:
      return getDeviceToken();

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
    case DEVICE_TOKEN:
      return isSetDeviceToken();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BindDeviceTokenReq)
      return this.equals((BindDeviceTokenReq)that);
    return false;
  }

  public boolean equals(BindDeviceTokenReq that) {
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

    boolean this_present_deviceToken = true && this.isSetDeviceToken();
    boolean that_present_deviceToken = true && that.isSetDeviceToken();
    if (this_present_deviceToken || that_present_deviceToken) {
      if (!(this_present_deviceToken && that_present_deviceToken))
        return false;
      if (!this.deviceToken.equals(that.deviceToken))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(BindDeviceTokenReq other) {
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
    lastComparison = Boolean.valueOf(isSetDeviceToken()).compareTo(other.isSetDeviceToken());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeviceToken()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deviceToken, other.deviceToken);
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
    StringBuilder sb = new StringBuilder("BindDeviceTokenReq(");
    boolean first = true;

    sb.append("head:");
    if (this.head == null) {
      sb.append("null");
    } else {
      sb.append(this.head);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("deviceToken:");
    if (this.deviceToken == null) {
      sb.append("null");
    } else {
      sb.append(this.deviceToken);
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

  private static class BindDeviceTokenReqStandardSchemeFactory implements SchemeFactory {
    public BindDeviceTokenReqStandardScheme getScheme() {
      return new BindDeviceTokenReqStandardScheme();
    }
  }

  private static class BindDeviceTokenReqStandardScheme extends StandardScheme<BindDeviceTokenReq> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BindDeviceTokenReq struct) throws org.apache.thrift.TException {
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
          case 2: // DEVICE_TOKEN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.deviceToken = iprot.readString();
              struct.setDeviceTokenIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, BindDeviceTokenReq struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.head != null) {
        oprot.writeFieldBegin(HEAD_FIELD_DESC);
        struct.head.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.deviceToken != null) {
        oprot.writeFieldBegin(DEVICE_TOKEN_FIELD_DESC);
        oprot.writeString(struct.deviceToken);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BindDeviceTokenReqTupleSchemeFactory implements SchemeFactory {
    public BindDeviceTokenReqTupleScheme getScheme() {
      return new BindDeviceTokenReqTupleScheme();
    }
  }

  private static class BindDeviceTokenReqTupleScheme extends TupleScheme<BindDeviceTokenReq> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BindDeviceTokenReq struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHead()) {
        optionals.set(0);
      }
      if (struct.isSetDeviceToken()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetHead()) {
        struct.head.write(oprot);
      }
      if (struct.isSetDeviceToken()) {
        oprot.writeString(struct.deviceToken);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BindDeviceTokenReq struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.head = new com.bangcar.app.mapi.base.MApiReqHead();
        struct.head.read(iprot);
        struct.setHeadIsSet(true);
      }
      if (incoming.get(1)) {
        struct.deviceToken = iprot.readString();
        struct.setDeviceTokenIsSet(true);
      }
    }
  }

}

