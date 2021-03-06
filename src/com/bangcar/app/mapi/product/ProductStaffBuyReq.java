/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.product;

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

/**
 * 同事购买记录请求
 */
public class ProductStaffBuyReq implements org.apache.thrift.TBase<ProductStaffBuyReq, ProductStaffBuyReq._Fields>, java.io.Serializable, Cloneable, Comparable<ProductStaffBuyReq> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ProductStaffBuyReq");

  private static final org.apache.thrift.protocol.TField HEAD_FIELD_DESC = new org.apache.thrift.protocol.TField("head", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField PID_FIELD_DESC = new org.apache.thrift.protocol.TField("pid", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField CHART_FIELD_DESC = new org.apache.thrift.protocol.TField("chart", org.apache.thrift.protocol.TType.BOOL, (short)3);
  private static final org.apache.thrift.protocol.TField PAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("page", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ProductStaffBuyReqStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ProductStaffBuyReqTupleSchemeFactory());
  }

  public com.bangcar.app.mapi.base.MApiReqHead head; // required
  /**
   * 产品ID
   */
  public int pid; // required
  /**
   * 是否返回画图信息
   */
  public boolean chart; // required
  /**
   * 请求页码
   */
  public int page; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HEAD((short)1, "head"),
    /**
     * 产品ID
     */
    PID((short)2, "pid"),
    /**
     * 是否返回画图信息
     */
    CHART((short)3, "chart"),
    /**
     * 请求页码
     */
    PAGE((short)4, "page");

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
        case 2: // PID
          return PID;
        case 3: // CHART
          return CHART;
        case 4: // PAGE
          return PAGE;
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
  private static final int __PID_ISSET_ID = 0;
  private static final int __CHART_ISSET_ID = 1;
  private static final int __PAGE_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HEAD, new org.apache.thrift.meta_data.FieldMetaData("head", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.bangcar.app.mapi.base.MApiReqHead.class)));
    tmpMap.put(_Fields.PID, new org.apache.thrift.meta_data.FieldMetaData("pid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CHART, new org.apache.thrift.meta_data.FieldMetaData("chart", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.PAGE, new org.apache.thrift.meta_data.FieldMetaData("page", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ProductStaffBuyReq.class, metaDataMap);
  }

  public ProductStaffBuyReq() {
  }

  public ProductStaffBuyReq(
    com.bangcar.app.mapi.base.MApiReqHead head,
    int pid,
    boolean chart,
    int page)
  {
    this();
    this.head = head;
    this.pid = pid;
    setPidIsSet(true);
    this.chart = chart;
    setChartIsSet(true);
    this.page = page;
    setPageIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ProductStaffBuyReq(ProductStaffBuyReq other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetHead()) {
      this.head = new com.bangcar.app.mapi.base.MApiReqHead(other.head);
    }
    this.pid = other.pid;
    this.chart = other.chart;
    this.page = other.page;
  }

  public ProductStaffBuyReq deepCopy() {
    return new ProductStaffBuyReq(this);
  }

  @Override
  public void clear() {
    this.head = null;
    setPidIsSet(false);
    this.pid = 0;
    setChartIsSet(false);
    this.chart = false;
    setPageIsSet(false);
    this.page = 0;
  }

  public com.bangcar.app.mapi.base.MApiReqHead getHead() {
    return this.head;
  }

  public ProductStaffBuyReq setHead(com.bangcar.app.mapi.base.MApiReqHead head) {
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
   * 产品ID
   */
  public int getPid() {
    return this.pid;
  }

  /**
   * 产品ID
   */
  public ProductStaffBuyReq setPid(int pid) {
    this.pid = pid;
    setPidIsSet(true);
    return this;
  }

  public void unsetPid() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PID_ISSET_ID);
  }

  /** Returns true if field pid is set (has been assigned a value) and false otherwise */
  public boolean isSetPid() {
    return EncodingUtils.testBit(__isset_bitfield, __PID_ISSET_ID);
  }

  public void setPidIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PID_ISSET_ID, value);
  }

  /**
   * 是否返回画图信息
   */
  public boolean isChart() {
    return this.chart;
  }

  /**
   * 是否返回画图信息
   */
  public ProductStaffBuyReq setChart(boolean chart) {
    this.chart = chart;
    setChartIsSet(true);
    return this;
  }

  public void unsetChart() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CHART_ISSET_ID);
  }

  /** Returns true if field chart is set (has been assigned a value) and false otherwise */
  public boolean isSetChart() {
    return EncodingUtils.testBit(__isset_bitfield, __CHART_ISSET_ID);
  }

  public void setChartIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CHART_ISSET_ID, value);
  }

  /**
   * 请求页码
   */
  public int getPage() {
    return this.page;
  }

  /**
   * 请求页码
   */
  public ProductStaffBuyReq setPage(int page) {
    this.page = page;
    setPageIsSet(true);
    return this;
  }

  public void unsetPage() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAGE_ISSET_ID);
  }

  /** Returns true if field page is set (has been assigned a value) and false otherwise */
  public boolean isSetPage() {
    return EncodingUtils.testBit(__isset_bitfield, __PAGE_ISSET_ID);
  }

  public void setPageIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAGE_ISSET_ID, value);
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

    case PID:
      if (value == null) {
        unsetPid();
      } else {
        setPid((Integer)value);
      }
      break;

    case CHART:
      if (value == null) {
        unsetChart();
      } else {
        setChart((Boolean)value);
      }
      break;

    case PAGE:
      if (value == null) {
        unsetPage();
      } else {
        setPage((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HEAD:
      return getHead();

    case PID:
      return Integer.valueOf(getPid());

    case CHART:
      return Boolean.valueOf(isChart());

    case PAGE:
      return Integer.valueOf(getPage());

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
    case PID:
      return isSetPid();
    case CHART:
      return isSetChart();
    case PAGE:
      return isSetPage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ProductStaffBuyReq)
      return this.equals((ProductStaffBuyReq)that);
    return false;
  }

  public boolean equals(ProductStaffBuyReq that) {
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

    boolean this_present_pid = true;
    boolean that_present_pid = true;
    if (this_present_pid || that_present_pid) {
      if (!(this_present_pid && that_present_pid))
        return false;
      if (this.pid != that.pid)
        return false;
    }

    boolean this_present_chart = true;
    boolean that_present_chart = true;
    if (this_present_chart || that_present_chart) {
      if (!(this_present_chart && that_present_chart))
        return false;
      if (this.chart != that.chart)
        return false;
    }

    boolean this_present_page = true;
    boolean that_present_page = true;
    if (this_present_page || that_present_page) {
      if (!(this_present_page && that_present_page))
        return false;
      if (this.page != that.page)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(ProductStaffBuyReq other) {
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
    lastComparison = Boolean.valueOf(isSetPid()).compareTo(other.isSetPid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pid, other.pid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChart()).compareTo(other.isSetChart());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChart()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.chart, other.chart);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPage()).compareTo(other.isSetPage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.page, other.page);
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
    StringBuilder sb = new StringBuilder("ProductStaffBuyReq(");
    boolean first = true;

    sb.append("head:");
    if (this.head == null) {
      sb.append("null");
    } else {
      sb.append(this.head);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pid:");
    sb.append(this.pid);
    first = false;
    if (!first) sb.append(", ");
    sb.append("chart:");
    sb.append(this.chart);
    first = false;
    if (!first) sb.append(", ");
    sb.append("page:");
    sb.append(this.page);
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

  private static class ProductStaffBuyReqStandardSchemeFactory implements SchemeFactory {
    public ProductStaffBuyReqStandardScheme getScheme() {
      return new ProductStaffBuyReqStandardScheme();
    }
  }

  private static class ProductStaffBuyReqStandardScheme extends StandardScheme<ProductStaffBuyReq> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ProductStaffBuyReq struct) throws org.apache.thrift.TException {
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
          case 2: // PID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pid = iprot.readI32();
              struct.setPidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CHART
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.chart = iprot.readBool();
              struct.setChartIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.page = iprot.readI32();
              struct.setPageIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ProductStaffBuyReq struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.head != null) {
        oprot.writeFieldBegin(HEAD_FIELD_DESC);
        struct.head.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PID_FIELD_DESC);
      oprot.writeI32(struct.pid);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CHART_FIELD_DESC);
      oprot.writeBool(struct.chart);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PAGE_FIELD_DESC);
      oprot.writeI32(struct.page);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ProductStaffBuyReqTupleSchemeFactory implements SchemeFactory {
    public ProductStaffBuyReqTupleScheme getScheme() {
      return new ProductStaffBuyReqTupleScheme();
    }
  }

  private static class ProductStaffBuyReqTupleScheme extends TupleScheme<ProductStaffBuyReq> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ProductStaffBuyReq struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHead()) {
        optionals.set(0);
      }
      if (struct.isSetPid()) {
        optionals.set(1);
      }
      if (struct.isSetChart()) {
        optionals.set(2);
      }
      if (struct.isSetPage()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetHead()) {
        struct.head.write(oprot);
      }
      if (struct.isSetPid()) {
        oprot.writeI32(struct.pid);
      }
      if (struct.isSetChart()) {
        oprot.writeBool(struct.chart);
      }
      if (struct.isSetPage()) {
        oprot.writeI32(struct.page);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ProductStaffBuyReq struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.head = new com.bangcar.app.mapi.base.MApiReqHead();
        struct.head.read(iprot);
        struct.setHeadIsSet(true);
      }
      if (incoming.get(1)) {
        struct.pid = iprot.readI32();
        struct.setPidIsSet(true);
      }
      if (incoming.get(2)) {
        struct.chart = iprot.readBool();
        struct.setChartIsSet(true);
      }
      if (incoming.get(3)) {
        struct.page = iprot.readI32();
        struct.setPageIsSet(true);
      }
    }
  }

}

