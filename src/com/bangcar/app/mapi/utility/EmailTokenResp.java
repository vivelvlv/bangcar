/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.utility;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.EncodingUtils;

import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;

public class EmailTokenResp implements org.apache.thrift.TBase<EmailTokenResp, EmailTokenResp._Fields>, java.io.Serializable, Cloneable, Comparable<EmailTokenResp> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EmailTokenResp");

  private static final org.apache.thrift.protocol.TField HEAD_FIELD_DESC = new org.apache.thrift.protocol.TField("head", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField MSG_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("msgId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DELAY_FIELD_DESC = new org.apache.thrift.protocol.TField("delay", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new EmailTokenRespStandardSchemeFactory());
    schemes.put(TupleScheme.class, new EmailTokenRespTupleSchemeFactory());
  }

  public com.bangcar.app.mapi.base.MApiRespHead head; // required
  /**
   * 消息ID
   */
  public String msgId; // required
  /**
   * 重发等待时间
   */
  public int delay; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HEAD((short)1, "head"),
    /**
     * 消息ID
     */
    MSG_ID((short)2, "msgId"),
    /**
     * 重发等待时间
     */
    DELAY((short)3, "delay");

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
        case 2: // MSG_ID
          return MSG_ID;
        case 3: // DELAY
          return DELAY;
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
  private static final int __DELAY_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HEAD, new org.apache.thrift.meta_data.FieldMetaData("head", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.bangcar.app.mapi.base.MApiRespHead.class)));
    tmpMap.put(_Fields.MSG_ID, new org.apache.thrift.meta_data.FieldMetaData("msgId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DELAY, new org.apache.thrift.meta_data.FieldMetaData("delay", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EmailTokenResp.class, metaDataMap);
  }

  public EmailTokenResp() {
  }

  public EmailTokenResp(
    com.bangcar.app.mapi.base.MApiRespHead head,
    String msgId,
    int delay)
  {
    this();
    this.head = head;
    this.msgId = msgId;
    this.delay = delay;
    setDelayIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EmailTokenResp(EmailTokenResp other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetHead()) {
      this.head = new com.bangcar.app.mapi.base.MApiRespHead(other.head);
    }
    if (other.isSetMsgId()) {
      this.msgId = other.msgId;
    }
    this.delay = other.delay;
  }

  public EmailTokenResp deepCopy() {
    return new EmailTokenResp(this);
  }

  @Override
  public void clear() {
    this.head = null;
    this.msgId = null;
    setDelayIsSet(false);
    this.delay = 0;
  }

  public com.bangcar.app.mapi.base.MApiRespHead getHead() {
    return this.head;
  }

  public EmailTokenResp setHead(com.bangcar.app.mapi.base.MApiRespHead head) {
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
   * 消息ID
   */
  public String getMsgId() {
    return this.msgId;
  }

  /**
   * 消息ID
   */
  public EmailTokenResp setMsgId(String msgId) {
    this.msgId = msgId;
    return this;
  }

  public void unsetMsgId() {
    this.msgId = null;
  }

  /** Returns true if field msgId is set (has been assigned a value) and false otherwise */
  public boolean isSetMsgId() {
    return this.msgId != null;
  }

  public void setMsgIdIsSet(boolean value) {
    if (!value) {
      this.msgId = null;
    }
  }

  /**
   * 重发等待时间
   */
  public int getDelay() {
    return this.delay;
  }

  /**
   * 重发等待时间
   */
  public EmailTokenResp setDelay(int delay) {
    this.delay = delay;
    setDelayIsSet(true);
    return this;
  }

  public void unsetDelay() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DELAY_ISSET_ID);
  }

  /** Returns true if field delay is set (has been assigned a value) and false otherwise */
  public boolean isSetDelay() {
    return EncodingUtils.testBit(__isset_bitfield, __DELAY_ISSET_ID);
  }

  public void setDelayIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DELAY_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case HEAD:
      if (value == null) {
        unsetHead();
      } else {
        setHead((com.bangcar.app.mapi.base.MApiRespHead)value);
      }
      break;

    case MSG_ID:
      if (value == null) {
        unsetMsgId();
      } else {
        setMsgId((String)value);
      }
      break;

    case DELAY:
      if (value == null) {
        unsetDelay();
      } else {
        setDelay((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HEAD:
      return getHead();

    case MSG_ID:
      return getMsgId();

    case DELAY:
      return Integer.valueOf(getDelay());

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
    case MSG_ID:
      return isSetMsgId();
    case DELAY:
      return isSetDelay();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof EmailTokenResp)
      return this.equals((EmailTokenResp)that);
    return false;
  }

  public boolean equals(EmailTokenResp that) {
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

    boolean this_present_msgId = true && this.isSetMsgId();
    boolean that_present_msgId = true && that.isSetMsgId();
    if (this_present_msgId || that_present_msgId) {
      if (!(this_present_msgId && that_present_msgId))
        return false;
      if (!this.msgId.equals(that.msgId))
        return false;
    }

    boolean this_present_delay = true;
    boolean that_present_delay = true;
    if (this_present_delay || that_present_delay) {
      if (!(this_present_delay && that_present_delay))
        return false;
      if (this.delay != that.delay)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(EmailTokenResp other) {
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
    lastComparison = Boolean.valueOf(isSetMsgId()).compareTo(other.isSetMsgId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMsgId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.msgId, other.msgId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDelay()).compareTo(other.isSetDelay());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDelay()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.delay, other.delay);
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
    StringBuilder sb = new StringBuilder("EmailTokenResp(");
    boolean first = true;

    sb.append("head:");
    if (this.head == null) {
      sb.append("null");
    } else {
      sb.append(this.head);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("msgId:");
    if (this.msgId == null) {
      sb.append("null");
    } else {
      sb.append(this.msgId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("delay:");
    sb.append(this.delay);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class EmailTokenRespStandardSchemeFactory implements SchemeFactory {
    public EmailTokenRespStandardScheme getScheme() {
      return new EmailTokenRespStandardScheme();
    }
  }

  private static class EmailTokenRespStandardScheme extends StandardScheme<EmailTokenResp> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, EmailTokenResp struct) throws org.apache.thrift.TException {
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
              struct.head = new com.bangcar.app.mapi.base.MApiRespHead();
              struct.head.read(iprot);
              struct.setHeadIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MSG_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.msgId = iprot.readString();
              struct.setMsgIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DELAY
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.delay = iprot.readI32();
              struct.setDelayIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, EmailTokenResp struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.head != null) {
        oprot.writeFieldBegin(HEAD_FIELD_DESC);
        struct.head.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.msgId != null) {
        oprot.writeFieldBegin(MSG_ID_FIELD_DESC);
        oprot.writeString(struct.msgId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(DELAY_FIELD_DESC);
      oprot.writeI32(struct.delay);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class EmailTokenRespTupleSchemeFactory implements SchemeFactory {
    public EmailTokenRespTupleScheme getScheme() {
      return new EmailTokenRespTupleScheme();
    }
  }

  private static class EmailTokenRespTupleScheme extends TupleScheme<EmailTokenResp> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, EmailTokenResp struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHead()) {
        optionals.set(0);
      }
      if (struct.isSetMsgId()) {
        optionals.set(1);
      }
      if (struct.isSetDelay()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetHead()) {
        struct.head.write(oprot);
      }
      if (struct.isSetMsgId()) {
        oprot.writeString(struct.msgId);
      }
      if (struct.isSetDelay()) {
        oprot.writeI32(struct.delay);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, EmailTokenResp struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.head = new com.bangcar.app.mapi.base.MApiRespHead();
        struct.head.read(iprot);
        struct.setHeadIsSet(true);
      }
      if (incoming.get(1)) {
        struct.msgId = iprot.readString();
        struct.setMsgIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.delay = iprot.readI32();
        struct.setDelayIsSet(true);
      }
    }
  }

}

