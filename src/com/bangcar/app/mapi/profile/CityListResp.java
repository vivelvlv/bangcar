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

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;

public class CityListResp implements org.apache.thrift.TBase<CityListResp, CityListResp._Fields>, java.io.Serializable, Cloneable, Comparable<CityListResp> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CityListResp");

  private static final org.apache.thrift.protocol.TField HEAD_FIELD_DESC = new org.apache.thrift.protocol.TField("head", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField CITY_KVS_FIELD_DESC = new org.apache.thrift.protocol.TField("cityKVs", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CityListRespStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CityListRespTupleSchemeFactory());
  }

  public com.bangcar.app.mapi.base.MApiRespHead head; // required
  /**
   * 城市列表
   */
  public List<com.bangcar.app.mapi.common.KV> cityKVs; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HEAD((short)1, "head"),
    /**
     * 城市列表
     */
    CITY_KVS((short)2, "cityKVs");

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
        case 2: // CITY_KVS
          return CITY_KVS;
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
    tmpMap.put(_Fields.CITY_KVS, new org.apache.thrift.meta_data.FieldMetaData("cityKVs", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.bangcar.app.mapi.common.KV.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CityListResp.class, metaDataMap);
  }

  public CityListResp() {
  }

  public CityListResp(
    com.bangcar.app.mapi.base.MApiRespHead head,
    List<com.bangcar.app.mapi.common.KV> cityKVs)
  {
    this();
    this.head = head;
    this.cityKVs = cityKVs;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CityListResp(CityListResp other) {
    if (other.isSetHead()) {
      this.head = new com.bangcar.app.mapi.base.MApiRespHead(other.head);
    }
    if (other.isSetCityKVs()) {
      List<com.bangcar.app.mapi.common.KV> __this__cityKVs = new ArrayList<com.bangcar.app.mapi.common.KV>(other.cityKVs.size());
      for (com.bangcar.app.mapi.common.KV other_element : other.cityKVs) {
        __this__cityKVs.add(new com.bangcar.app.mapi.common.KV(other_element));
      }
      this.cityKVs = __this__cityKVs;
    }
  }

  public CityListResp deepCopy() {
    return new CityListResp(this);
  }

  @Override
  public void clear() {
    this.head = null;
    this.cityKVs = null;
  }

  public com.bangcar.app.mapi.base.MApiRespHead getHead() {
    return this.head;
  }

  public CityListResp setHead(com.bangcar.app.mapi.base.MApiRespHead head) {
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

  public int getCityKVsSize() {
    return (this.cityKVs == null) ? 0 : this.cityKVs.size();
  }

  public java.util.Iterator<com.bangcar.app.mapi.common.KV> getCityKVsIterator() {
    return (this.cityKVs == null) ? null : this.cityKVs.iterator();
  }

  public void addToCityKVs(com.bangcar.app.mapi.common.KV elem) {
    if (this.cityKVs == null) {
      this.cityKVs = new ArrayList<com.bangcar.app.mapi.common.KV>();
    }
    this.cityKVs.add(elem);
  }

  /**
   * 城市列表
   */
  public List<com.bangcar.app.mapi.common.KV> getCityKVs() {
    return this.cityKVs;
  }

  /**
   * 城市列表
   */
  public CityListResp setCityKVs(List<com.bangcar.app.mapi.common.KV> cityKVs) {
    this.cityKVs = cityKVs;
    return this;
  }

  public void unsetCityKVs() {
    this.cityKVs = null;
  }

  /** Returns true if field cityKVs is set (has been assigned a value) and false otherwise */
  public boolean isSetCityKVs() {
    return this.cityKVs != null;
  }

  public void setCityKVsIsSet(boolean value) {
    if (!value) {
      this.cityKVs = null;
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

    case CITY_KVS:
      if (value == null) {
        unsetCityKVs();
      } else {
        setCityKVs((List<com.bangcar.app.mapi.common.KV>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HEAD:
      return getHead();

    case CITY_KVS:
      return getCityKVs();

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
    case CITY_KVS:
      return isSetCityKVs();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CityListResp)
      return this.equals((CityListResp)that);
    return false;
  }

  public boolean equals(CityListResp that) {
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

    boolean this_present_cityKVs = true && this.isSetCityKVs();
    boolean that_present_cityKVs = true && that.isSetCityKVs();
    if (this_present_cityKVs || that_present_cityKVs) {
      if (!(this_present_cityKVs && that_present_cityKVs))
        return false;
      if (!this.cityKVs.equals(that.cityKVs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(CityListResp other) {
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
    lastComparison = Boolean.valueOf(isSetCityKVs()).compareTo(other.isSetCityKVs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCityKVs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cityKVs, other.cityKVs);
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
    StringBuilder sb = new StringBuilder("CityListResp(");
    boolean first = true;

    sb.append("head:");
    if (this.head == null) {
      sb.append("null");
    } else {
      sb.append(this.head);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("cityKVs:");
    if (this.cityKVs == null) {
      sb.append("null");
    } else {
      sb.append(this.cityKVs);
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

  private static class CityListRespStandardSchemeFactory implements SchemeFactory {
    public CityListRespStandardScheme getScheme() {
      return new CityListRespStandardScheme();
    }
  }

  private static class CityListRespStandardScheme extends StandardScheme<CityListResp> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CityListResp struct) throws org.apache.thrift.TException {
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
          case 2: // CITY_KVS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
                struct.cityKVs = new ArrayList<com.bangcar.app.mapi.common.KV>(_list16.size);
                for (int _i17 = 0; _i17 < _list16.size; ++_i17)
                {
                  com.bangcar.app.mapi.common.KV _elem18;
                  _elem18 = new com.bangcar.app.mapi.common.KV();
                  _elem18.read(iprot);
                  struct.cityKVs.add(_elem18);
                }
                iprot.readListEnd();
              }
              struct.setCityKVsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, CityListResp struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.head != null) {
        oprot.writeFieldBegin(HEAD_FIELD_DESC);
        struct.head.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.cityKVs != null) {
        oprot.writeFieldBegin(CITY_KVS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.cityKVs.size()));
          for (com.bangcar.app.mapi.common.KV _iter19 : struct.cityKVs)
          {
            _iter19.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CityListRespTupleSchemeFactory implements SchemeFactory {
    public CityListRespTupleScheme getScheme() {
      return new CityListRespTupleScheme();
    }
  }

  private static class CityListRespTupleScheme extends TupleScheme<CityListResp> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CityListResp struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHead()) {
        optionals.set(0);
      }
      if (struct.isSetCityKVs()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetHead()) {
        struct.head.write(oprot);
      }
      if (struct.isSetCityKVs()) {
        {
          oprot.writeI32(struct.cityKVs.size());
          for (com.bangcar.app.mapi.common.KV _iter20 : struct.cityKVs)
          {
            _iter20.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CityListResp struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.head = new com.bangcar.app.mapi.base.MApiRespHead();
        struct.head.read(iprot);
        struct.setHeadIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.cityKVs = new ArrayList<com.bangcar.app.mapi.common.KV>(_list21.size);
          for (int _i22 = 0; _i22 < _list21.size; ++_i22)
          {
            com.bangcar.app.mapi.common.KV _elem23;
            _elem23 = new com.bangcar.app.mapi.common.KV();
            _elem23.read(iprot);
            struct.cityKVs.add(_elem23);
          }
        }
        struct.setCityKVsIsSet(true);
      }
    }
  }

}

