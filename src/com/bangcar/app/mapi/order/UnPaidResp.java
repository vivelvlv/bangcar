/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.order;

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

public class UnPaidResp implements org.apache.thrift.TBase<UnPaidResp, UnPaidResp._Fields>, java.io.Serializable, Cloneable, Comparable<UnPaidResp> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UnPaidResp");

  private static final org.apache.thrift.protocol.TField HEAD_FIELD_DESC = new org.apache.thrift.protocol.TField("head", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField ORDER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("orderId", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PRODUCT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("productName", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UnPaidRespStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UnPaidRespTupleSchemeFactory());
  }

  public com.bangcar.app.mapi.base.MApiRespHead head; // required
  /**
   * 订单id
   */
  public String orderId; // required
  /**
   * 产品名
   */
  public String productName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HEAD((short)1, "head"),
    /**
     * 订单id
     */
    ORDER_ID((short)2, "orderId"),
    /**
     * 产品名
     */
    PRODUCT_NAME((short)3, "productName");

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
        case 2: // ORDER_ID
          return ORDER_ID;
        case 3: // PRODUCT_NAME
          return PRODUCT_NAME;
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
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.bangcar.app.mapi.base.MApiRespHead.class)));
    tmpMap.put(_Fields.ORDER_ID, new org.apache.thrift.meta_data.FieldMetaData("orderId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PRODUCT_NAME, new org.apache.thrift.meta_data.FieldMetaData("productName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UnPaidResp.class, metaDataMap);
  }

  public UnPaidResp() {
  }

  public UnPaidResp(
    com.bangcar.app.mapi.base.MApiRespHead head,
    String orderId,
    String productName)
  {
    this();
    this.head = head;
    this.orderId = orderId;
    this.productName = productName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UnPaidResp(UnPaidResp other) {
    if (other.isSetHead()) {
      this.head = new com.bangcar.app.mapi.base.MApiRespHead(other.head);
    }
    if (other.isSetOrderId()) {
      this.orderId = other.orderId;
    }
    if (other.isSetProductName()) {
      this.productName = other.productName;
    }
  }

  public UnPaidResp deepCopy() {
    return new UnPaidResp(this);
  }

  @Override
  public void clear() {
    this.head = null;
    this.orderId = null;
    this.productName = null;
  }

  public com.bangcar.app.mapi.base.MApiRespHead getHead() {
    return this.head;
  }

  public UnPaidResp setHead(com.bangcar.app.mapi.base.MApiRespHead head) {
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
   * 订单id
   */
  public String getOrderId() {
    return this.orderId;
  }

  /**
   * 订单id
   */
  public UnPaidResp setOrderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  public void unsetOrderId() {
    this.orderId = null;
  }

  /** Returns true if field orderId is set (has been assigned a value) and false otherwise */
  public boolean isSetOrderId() {
    return this.orderId != null;
  }

  public void setOrderIdIsSet(boolean value) {
    if (!value) {
      this.orderId = null;
    }
  }

  /**
   * 产品名
   */
  public String getProductName() {
    return this.productName;
  }

  /**
   * 产品名
   */
  public UnPaidResp setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public void unsetProductName() {
    this.productName = null;
  }

  /** Returns true if field productName is set (has been assigned a value) and false otherwise */
  public boolean isSetProductName() {
    return this.productName != null;
  }

  public void setProductNameIsSet(boolean value) {
    if (!value) {
      this.productName = null;
    }
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

    case ORDER_ID:
      if (value == null) {
        unsetOrderId();
      } else {
        setOrderId((String)value);
      }
      break;

    case PRODUCT_NAME:
      if (value == null) {
        unsetProductName();
      } else {
        setProductName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HEAD:
      return getHead();

    case ORDER_ID:
      return getOrderId();

    case PRODUCT_NAME:
      return getProductName();

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
    case ORDER_ID:
      return isSetOrderId();
    case PRODUCT_NAME:
      return isSetProductName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UnPaidResp)
      return this.equals((UnPaidResp)that);
    return false;
  }

  public boolean equals(UnPaidResp that) {
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

    boolean this_present_orderId = true && this.isSetOrderId();
    boolean that_present_orderId = true && that.isSetOrderId();
    if (this_present_orderId || that_present_orderId) {
      if (!(this_present_orderId && that_present_orderId))
        return false;
      if (!this.orderId.equals(that.orderId))
        return false;
    }

    boolean this_present_productName = true && this.isSetProductName();
    boolean that_present_productName = true && that.isSetProductName();
    if (this_present_productName || that_present_productName) {
      if (!(this_present_productName && that_present_productName))
        return false;
      if (!this.productName.equals(that.productName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(UnPaidResp other) {
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
    lastComparison = Boolean.valueOf(isSetOrderId()).compareTo(other.isSetOrderId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOrderId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.orderId, other.orderId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetProductName()).compareTo(other.isSetProductName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProductName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.productName, other.productName);
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
    StringBuilder sb = new StringBuilder("UnPaidResp(");
    boolean first = true;

    sb.append("head:");
    if (this.head == null) {
      sb.append("null");
    } else {
      sb.append(this.head);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("orderId:");
    if (this.orderId == null) {
      sb.append("null");
    } else {
      sb.append(this.orderId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("productName:");
    if (this.productName == null) {
      sb.append("null");
    } else {
      sb.append(this.productName);
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

  private static class UnPaidRespStandardSchemeFactory implements SchemeFactory {
    public UnPaidRespStandardScheme getScheme() {
      return new UnPaidRespStandardScheme();
    }
  }

  private static class UnPaidRespStandardScheme extends StandardScheme<UnPaidResp> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UnPaidResp struct) throws org.apache.thrift.TException {
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
          case 2: // ORDER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.orderId = iprot.readString();
              struct.setOrderIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PRODUCT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.productName = iprot.readString();
              struct.setProductNameIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, UnPaidResp struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.head != null) {
        oprot.writeFieldBegin(HEAD_FIELD_DESC);
        struct.head.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.orderId != null) {
        oprot.writeFieldBegin(ORDER_ID_FIELD_DESC);
        oprot.writeString(struct.orderId);
        oprot.writeFieldEnd();
      }
      if (struct.productName != null) {
        oprot.writeFieldBegin(PRODUCT_NAME_FIELD_DESC);
        oprot.writeString(struct.productName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UnPaidRespTupleSchemeFactory implements SchemeFactory {
    public UnPaidRespTupleScheme getScheme() {
      return new UnPaidRespTupleScheme();
    }
  }

  private static class UnPaidRespTupleScheme extends TupleScheme<UnPaidResp> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UnPaidResp struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHead()) {
        optionals.set(0);
      }
      if (struct.isSetOrderId()) {
        optionals.set(1);
      }
      if (struct.isSetProductName()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetHead()) {
        struct.head.write(oprot);
      }
      if (struct.isSetOrderId()) {
        oprot.writeString(struct.orderId);
      }
      if (struct.isSetProductName()) {
        oprot.writeString(struct.productName);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UnPaidResp struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.head = new com.bangcar.app.mapi.base.MApiRespHead();
        struct.head.read(iprot);
        struct.setHeadIsSet(true);
      }
      if (incoming.get(1)) {
        struct.orderId = iprot.readString();
        struct.setOrderIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.productName = iprot.readString();
        struct.setProductNameIsSet(true);
      }
    }
  }

}
