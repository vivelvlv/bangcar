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
import org.apache.thrift.EncodingUtils;

import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;

public class CaptchaResp implements org.apache.thrift.TBase<CaptchaResp, CaptchaResp._Fields>, java.io.Serializable, Cloneable, Comparable<CaptchaResp> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CaptchaResp");

  private static final org.apache.thrift.protocol.TField HEAD_FIELD_DESC = new org.apache.thrift.protocol.TField("head", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField IMG_FIELD_DESC = new org.apache.thrift.protocol.TField("img", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField HASH1_FIELD_DESC = new org.apache.thrift.protocol.TField("hash1", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField HASH2_FIELD_DESC = new org.apache.thrift.protocol.TField("hash2", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CaptchaRespStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CaptchaRespTupleSchemeFactory());
  }

  public com.bangcar.app.mapi.base.MApiRespHead head; // required
  /**
   * 图片验证码base64内容体，如果不需要验证码则为空
   */
  public String img; // required
  /**
   * 图片验证码离线校验哈希值（验证码大小写敏感）
   */
  public int hash1; // required
  /**
   * 图片验证码离线校验哈希值（验证码大小写不敏感）
   */
  public int hash2; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HEAD((short)1, "head"),
    /**
     * 图片验证码base64内容体，如果不需要验证码则为空
     */
    IMG((short)2, "img"),
    /**
     * 图片验证码离线校验哈希值（验证码大小写敏感）
     */
    HASH1((short)3, "hash1"),
    /**
     * 图片验证码离线校验哈希值（验证码大小写不敏感）
     */
    HASH2((short)4, "hash2");

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
        case 2: // IMG
          return IMG;
        case 3: // HASH1
          return HASH1;
        case 4: // HASH2
          return HASH2;
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
  private static final int __HASH1_ISSET_ID = 0;
  private static final int __HASH2_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HEAD, new org.apache.thrift.meta_data.FieldMetaData("head", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.bangcar.app.mapi.base.MApiRespHead.class)));
    tmpMap.put(_Fields.IMG, new org.apache.thrift.meta_data.FieldMetaData("img", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HASH1, new org.apache.thrift.meta_data.FieldMetaData("hash1", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.HASH2, new org.apache.thrift.meta_data.FieldMetaData("hash2", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CaptchaResp.class, metaDataMap);
  }

  public CaptchaResp() {
  }

  public CaptchaResp(
    com.bangcar.app.mapi.base.MApiRespHead head,
    String img,
    int hash1,
    int hash2)
  {
    this();
    this.head = head;
    this.img = img;
    this.hash1 = hash1;
    setHash1IsSet(true);
    this.hash2 = hash2;
    setHash2IsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CaptchaResp(CaptchaResp other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetHead()) {
      this.head = new com.bangcar.app.mapi.base.MApiRespHead(other.head);
    }
    if (other.isSetImg()) {
      this.img = other.img;
    }
    this.hash1 = other.hash1;
    this.hash2 = other.hash2;
  }

  public CaptchaResp deepCopy() {
    return new CaptchaResp(this);
  }

  @Override
  public void clear() {
    this.head = null;
    this.img = null;
    setHash1IsSet(false);
    this.hash1 = 0;
    setHash2IsSet(false);
    this.hash2 = 0;
  }

  public com.bangcar.app.mapi.base.MApiRespHead getHead() {
    return this.head;
  }

  public CaptchaResp setHead(com.bangcar.app.mapi.base.MApiRespHead head) {
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
   * 图片验证码base64内容体，如果不需要验证码则为空
   */
  public String getImg() {
    return this.img;
  }

  /**
   * 图片验证码base64内容体，如果不需要验证码则为空
   */
  public CaptchaResp setImg(String img) {
    this.img = img;
    return this;
  }

  public void unsetImg() {
    this.img = null;
  }

  /** Returns true if field img is set (has been assigned a value) and false otherwise */
  public boolean isSetImg() {
    return this.img != null;
  }

  public void setImgIsSet(boolean value) {
    if (!value) {
      this.img = null;
    }
  }

  /**
   * 图片验证码离线校验哈希值（验证码大小写敏感）
   */
  public int getHash1() {
    return this.hash1;
  }

  /**
   * 图片验证码离线校验哈希值（验证码大小写敏感）
   */
  public CaptchaResp setHash1(int hash1) {
    this.hash1 = hash1;
    setHash1IsSet(true);
    return this;
  }

  public void unsetHash1() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __HASH1_ISSET_ID);
  }

  /** Returns true if field hash1 is set (has been assigned a value) and false otherwise */
  public boolean isSetHash1() {
    return EncodingUtils.testBit(__isset_bitfield, __HASH1_ISSET_ID);
  }

  public void setHash1IsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __HASH1_ISSET_ID, value);
  }

  /**
   * 图片验证码离线校验哈希值（验证码大小写不敏感）
   */
  public int getHash2() {
    return this.hash2;
  }

  /**
   * 图片验证码离线校验哈希值（验证码大小写不敏感）
   */
  public CaptchaResp setHash2(int hash2) {
    this.hash2 = hash2;
    setHash2IsSet(true);
    return this;
  }

  public void unsetHash2() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __HASH2_ISSET_ID);
  }

  /** Returns true if field hash2 is set (has been assigned a value) and false otherwise */
  public boolean isSetHash2() {
    return EncodingUtils.testBit(__isset_bitfield, __HASH2_ISSET_ID);
  }

  public void setHash2IsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __HASH2_ISSET_ID, value);
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

    case IMG:
      if (value == null) {
        unsetImg();
      } else {
        setImg((String)value);
      }
      break;

    case HASH1:
      if (value == null) {
        unsetHash1();
      } else {
        setHash1((Integer)value);
      }
      break;

    case HASH2:
      if (value == null) {
        unsetHash2();
      } else {
        setHash2((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HEAD:
      return getHead();

    case IMG:
      return getImg();

    case HASH1:
      return Integer.valueOf(getHash1());

    case HASH2:
      return Integer.valueOf(getHash2());

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
    case IMG:
      return isSetImg();
    case HASH1:
      return isSetHash1();
    case HASH2:
      return isSetHash2();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CaptchaResp)
      return this.equals((CaptchaResp)that);
    return false;
  }

  public boolean equals(CaptchaResp that) {
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

    boolean this_present_img = true && this.isSetImg();
    boolean that_present_img = true && that.isSetImg();
    if (this_present_img || that_present_img) {
      if (!(this_present_img && that_present_img))
        return false;
      if (!this.img.equals(that.img))
        return false;
    }

    boolean this_present_hash1 = true;
    boolean that_present_hash1 = true;
    if (this_present_hash1 || that_present_hash1) {
      if (!(this_present_hash1 && that_present_hash1))
        return false;
      if (this.hash1 != that.hash1)
        return false;
    }

    boolean this_present_hash2 = true;
    boolean that_present_hash2 = true;
    if (this_present_hash2 || that_present_hash2) {
      if (!(this_present_hash2 && that_present_hash2))
        return false;
      if (this.hash2 != that.hash2)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(CaptchaResp other) {
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
    lastComparison = Boolean.valueOf(isSetImg()).compareTo(other.isSetImg());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetImg()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.img, other.img);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHash1()).compareTo(other.isSetHash1());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHash1()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hash1, other.hash1);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHash2()).compareTo(other.isSetHash2());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHash2()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hash2, other.hash2);
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
    StringBuilder sb = new StringBuilder("CaptchaResp(");
    boolean first = true;

    sb.append("head:");
    if (this.head == null) {
      sb.append("null");
    } else {
      sb.append(this.head);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("img:");
    if (this.img == null) {
      sb.append("null");
    } else {
      sb.append(this.img);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("hash1:");
    sb.append(this.hash1);
    first = false;
    if (!first) sb.append(", ");
    sb.append("hash2:");
    sb.append(this.hash2);
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

  private static class CaptchaRespStandardSchemeFactory implements SchemeFactory {
    public CaptchaRespStandardScheme getScheme() {
      return new CaptchaRespStandardScheme();
    }
  }

  private static class CaptchaRespStandardScheme extends StandardScheme<CaptchaResp> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CaptchaResp struct) throws org.apache.thrift.TException {
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
          case 2: // IMG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.img = iprot.readString();
              struct.setImgIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // HASH1
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.hash1 = iprot.readI32();
              struct.setHash1IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // HASH2
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.hash2 = iprot.readI32();
              struct.setHash2IsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, CaptchaResp struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.head != null) {
        oprot.writeFieldBegin(HEAD_FIELD_DESC);
        struct.head.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.img != null) {
        oprot.writeFieldBegin(IMG_FIELD_DESC);
        oprot.writeString(struct.img);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(HASH1_FIELD_DESC);
      oprot.writeI32(struct.hash1);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(HASH2_FIELD_DESC);
      oprot.writeI32(struct.hash2);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CaptchaRespTupleSchemeFactory implements SchemeFactory {
    public CaptchaRespTupleScheme getScheme() {
      return new CaptchaRespTupleScheme();
    }
  }

  private static class CaptchaRespTupleScheme extends TupleScheme<CaptchaResp> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CaptchaResp struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHead()) {
        optionals.set(0);
      }
      if (struct.isSetImg()) {
        optionals.set(1);
      }
      if (struct.isSetHash1()) {
        optionals.set(2);
      }
      if (struct.isSetHash2()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetHead()) {
        struct.head.write(oprot);
      }
      if (struct.isSetImg()) {
        oprot.writeString(struct.img);
      }
      if (struct.isSetHash1()) {
        oprot.writeI32(struct.hash1);
      }
      if (struct.isSetHash2()) {
        oprot.writeI32(struct.hash2);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CaptchaResp struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.head = new com.bangcar.app.mapi.base.MApiRespHead();
        struct.head.read(iprot);
        struct.setHeadIsSet(true);
      }
      if (incoming.get(1)) {
        struct.img = iprot.readString();
        struct.setImgIsSet(true);
      }
      if (incoming.get(2)) {
        struct.hash1 = iprot.readI32();
        struct.setHash1IsSet(true);
      }
      if (incoming.get(3)) {
        struct.hash2 = iprot.readI32();
        struct.setHash2IsSet(true);
      }
    }
  }

}

