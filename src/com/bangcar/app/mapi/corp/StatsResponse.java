/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.corp;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.EncodingUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;

public class StatsResponse implements org.apache.thrift.TBase<StatsResponse, StatsResponse._Fields>, java.io.Serializable, Cloneable, Comparable<StatsResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("StatsResponse");

  private static final org.apache.thrift.protocol.TField HEAD_FIELD_DESC = new org.apache.thrift.protocol.TField("head", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField TOTAL_PRICE_E6_FIELD_DESC = new org.apache.thrift.protocol.TField("totalPriceE6", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField INCOME_PRICE_E6_FIELD_DESC = new org.apache.thrift.protocol.TField("incomePriceE6", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField USER_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("userCount", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField USER_BUY_RANK_FIELD_DESC = new org.apache.thrift.protocol.TField("userBuyRank", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField RANGE_FIELD_DESC = new org.apache.thrift.protocol.TField("range", org.apache.thrift.protocol.TType.LIST, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new StatsResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new StatsResponseTupleSchemeFactory());
  }

  public com.bangcar.app.mapi.base.MApiRespHead head; // required
  public long totalPriceE6; // required
  public long incomePriceE6; // required
  public int userCount; // required
  public int userBuyRank; // required
  public List<range> range; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HEAD((short)1, "head"),
    TOTAL_PRICE_E6((short)2, "totalPriceE6"),
    INCOME_PRICE_E6((short)3, "incomePriceE6"),
    USER_COUNT((short)4, "userCount"),
    USER_BUY_RANK((short)5, "userBuyRank"),
    RANGE((short)6, "range");

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
        case 2: // TOTAL_PRICE_E6
          return TOTAL_PRICE_E6;
        case 3: // INCOME_PRICE_E6
          return INCOME_PRICE_E6;
        case 4: // USER_COUNT
          return USER_COUNT;
        case 5: // USER_BUY_RANK
          return USER_BUY_RANK;
        case 6: // RANGE
          return RANGE;
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
  private static final int __TOTALPRICEE6_ISSET_ID = 0;
  private static final int __INCOMEPRICEE6_ISSET_ID = 1;
  private static final int __USERCOUNT_ISSET_ID = 2;
  private static final int __USERBUYRANK_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HEAD, new org.apache.thrift.meta_data.FieldMetaData("head", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.bangcar.app.mapi.base.MApiRespHead.class)));
    tmpMap.put(_Fields.TOTAL_PRICE_E6, new org.apache.thrift.meta_data.FieldMetaData("totalPriceE6", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.INCOME_PRICE_E6, new org.apache.thrift.meta_data.FieldMetaData("incomePriceE6", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.USER_COUNT, new org.apache.thrift.meta_data.FieldMetaData("userCount", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USER_BUY_RANK, new org.apache.thrift.meta_data.FieldMetaData("userBuyRank", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.RANGE, new org.apache.thrift.meta_data.FieldMetaData("range", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, range.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(StatsResponse.class, metaDataMap);
  }

  public StatsResponse() {
  }

  public StatsResponse(
    com.bangcar.app.mapi.base.MApiRespHead head,
    long totalPriceE6,
    long incomePriceE6,
    int userCount,
    int userBuyRank,
    List<range> range)
  {
    this();
    this.head = head;
    this.totalPriceE6 = totalPriceE6;
    setTotalPriceE6IsSet(true);
    this.incomePriceE6 = incomePriceE6;
    setIncomePriceE6IsSet(true);
    this.userCount = userCount;
    setUserCountIsSet(true);
    this.userBuyRank = userBuyRank;
    setUserBuyRankIsSet(true);
    this.range = range;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public StatsResponse(StatsResponse other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetHead()) {
      this.head = new com.bangcar.app.mapi.base.MApiRespHead(other.head);
    }
    this.totalPriceE6 = other.totalPriceE6;
    this.incomePriceE6 = other.incomePriceE6;
    this.userCount = other.userCount;
    this.userBuyRank = other.userBuyRank;
    if (other.isSetRange()) {
      List<range> __this__range = new ArrayList<range>(other.range.size());
      for (range other_element : other.range) {
        __this__range.add(new range(other_element));
      }
      this.range = __this__range;
    }
  }

  public StatsResponse deepCopy() {
    return new StatsResponse(this);
  }

  @Override
  public void clear() {
    this.head = null;
    setTotalPriceE6IsSet(false);
    this.totalPriceE6 = 0;
    setIncomePriceE6IsSet(false);
    this.incomePriceE6 = 0;
    setUserCountIsSet(false);
    this.userCount = 0;
    setUserBuyRankIsSet(false);
    this.userBuyRank = 0;
    this.range = null;
  }

  public com.bangcar.app.mapi.base.MApiRespHead getHead() {
    return this.head;
  }

  public StatsResponse setHead(com.bangcar.app.mapi.base.MApiRespHead head) {
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

  public long getTotalPriceE6() {
    return this.totalPriceE6;
  }

  public StatsResponse setTotalPriceE6(long totalPriceE6) {
    this.totalPriceE6 = totalPriceE6;
    setTotalPriceE6IsSet(true);
    return this;
  }

  public void unsetTotalPriceE6() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TOTALPRICEE6_ISSET_ID);
  }

  /** Returns true if field totalPriceE6 is set (has been assigned a value) and false otherwise */
  public boolean isSetTotalPriceE6() {
    return EncodingUtils.testBit(__isset_bitfield, __TOTALPRICEE6_ISSET_ID);
  }

  public void setTotalPriceE6IsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TOTALPRICEE6_ISSET_ID, value);
  }

  public long getIncomePriceE6() {
    return this.incomePriceE6;
  }

  public StatsResponse setIncomePriceE6(long incomePriceE6) {
    this.incomePriceE6 = incomePriceE6;
    setIncomePriceE6IsSet(true);
    return this;
  }

  public void unsetIncomePriceE6() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __INCOMEPRICEE6_ISSET_ID);
  }

  /** Returns true if field incomePriceE6 is set (has been assigned a value) and false otherwise */
  public boolean isSetIncomePriceE6() {
    return EncodingUtils.testBit(__isset_bitfield, __INCOMEPRICEE6_ISSET_ID);
  }

  public void setIncomePriceE6IsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __INCOMEPRICEE6_ISSET_ID, value);
  }

  public int getUserCount() {
    return this.userCount;
  }

  public StatsResponse setUserCount(int userCount) {
    this.userCount = userCount;
    setUserCountIsSet(true);
    return this;
  }

  public void unsetUserCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USERCOUNT_ISSET_ID);
  }

  /** Returns true if field userCount is set (has been assigned a value) and false otherwise */
  public boolean isSetUserCount() {
    return EncodingUtils.testBit(__isset_bitfield, __USERCOUNT_ISSET_ID);
  }

  public void setUserCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USERCOUNT_ISSET_ID, value);
  }

  public int getUserBuyRank() {
    return this.userBuyRank;
  }

  public StatsResponse setUserBuyRank(int userBuyRank) {
    this.userBuyRank = userBuyRank;
    setUserBuyRankIsSet(true);
    return this;
  }

  public void unsetUserBuyRank() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USERBUYRANK_ISSET_ID);
  }

  /** Returns true if field userBuyRank is set (has been assigned a value) and false otherwise */
  public boolean isSetUserBuyRank() {
    return EncodingUtils.testBit(__isset_bitfield, __USERBUYRANK_ISSET_ID);
  }

  public void setUserBuyRankIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USERBUYRANK_ISSET_ID, value);
  }

  public int getRangeSize() {
    return (this.range == null) ? 0 : this.range.size();
  }

  public java.util.Iterator<range> getRangeIterator() {
    return (this.range == null) ? null : this.range.iterator();
  }

  public void addToRange(range elem) {
    if (this.range == null) {
      this.range = new ArrayList<range>();
    }
    this.range.add(elem);
  }

  public List<range> getRange() {
    return this.range;
  }

  public StatsResponse setRange(List<range> range) {
    this.range = range;
    return this;
  }

  public void unsetRange() {
    this.range = null;
  }

  /** Returns true if field range is set (has been assigned a value) and false otherwise */
  public boolean isSetRange() {
    return this.range != null;
  }

  public void setRangeIsSet(boolean value) {
    if (!value) {
      this.range = null;
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

    case TOTAL_PRICE_E6:
      if (value == null) {
        unsetTotalPriceE6();
      } else {
        setTotalPriceE6((Long)value);
      }
      break;

    case INCOME_PRICE_E6:
      if (value == null) {
        unsetIncomePriceE6();
      } else {
        setIncomePriceE6((Long)value);
      }
      break;

    case USER_COUNT:
      if (value == null) {
        unsetUserCount();
      } else {
        setUserCount((Integer)value);
      }
      break;

    case USER_BUY_RANK:
      if (value == null) {
        unsetUserBuyRank();
      } else {
        setUserBuyRank((Integer)value);
      }
      break;

    case RANGE:
      if (value == null) {
        unsetRange();
      } else {
        setRange((List<range>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HEAD:
      return getHead();

    case TOTAL_PRICE_E6:
      return Long.valueOf(getTotalPriceE6());

    case INCOME_PRICE_E6:
      return Long.valueOf(getIncomePriceE6());

    case USER_COUNT:
      return Integer.valueOf(getUserCount());

    case USER_BUY_RANK:
      return Integer.valueOf(getUserBuyRank());

    case RANGE:
      return getRange();

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
    case TOTAL_PRICE_E6:
      return isSetTotalPriceE6();
    case INCOME_PRICE_E6:
      return isSetIncomePriceE6();
    case USER_COUNT:
      return isSetUserCount();
    case USER_BUY_RANK:
      return isSetUserBuyRank();
    case RANGE:
      return isSetRange();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof StatsResponse)
      return this.equals((StatsResponse)that);
    return false;
  }

  public boolean equals(StatsResponse that) {
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

    boolean this_present_totalPriceE6 = true;
    boolean that_present_totalPriceE6 = true;
    if (this_present_totalPriceE6 || that_present_totalPriceE6) {
      if (!(this_present_totalPriceE6 && that_present_totalPriceE6))
        return false;
      if (this.totalPriceE6 != that.totalPriceE6)
        return false;
    }

    boolean this_present_incomePriceE6 = true;
    boolean that_present_incomePriceE6 = true;
    if (this_present_incomePriceE6 || that_present_incomePriceE6) {
      if (!(this_present_incomePriceE6 && that_present_incomePriceE6))
        return false;
      if (this.incomePriceE6 != that.incomePriceE6)
        return false;
    }

    boolean this_present_userCount = true;
    boolean that_present_userCount = true;
    if (this_present_userCount || that_present_userCount) {
      if (!(this_present_userCount && that_present_userCount))
        return false;
      if (this.userCount != that.userCount)
        return false;
    }

    boolean this_present_userBuyRank = true;
    boolean that_present_userBuyRank = true;
    if (this_present_userBuyRank || that_present_userBuyRank) {
      if (!(this_present_userBuyRank && that_present_userBuyRank))
        return false;
      if (this.userBuyRank != that.userBuyRank)
        return false;
    }

    boolean this_present_range = true && this.isSetRange();
    boolean that_present_range = true && that.isSetRange();
    if (this_present_range || that_present_range) {
      if (!(this_present_range && that_present_range))
        return false;
      if (!this.range.equals(that.range))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(StatsResponse other) {
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
    lastComparison = Boolean.valueOf(isSetTotalPriceE6()).compareTo(other.isSetTotalPriceE6());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotalPriceE6()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.totalPriceE6, other.totalPriceE6);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIncomePriceE6()).compareTo(other.isSetIncomePriceE6());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIncomePriceE6()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.incomePriceE6, other.incomePriceE6);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserCount()).compareTo(other.isSetUserCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userCount, other.userCount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserBuyRank()).compareTo(other.isSetUserBuyRank());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserBuyRank()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userBuyRank, other.userBuyRank);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRange()).compareTo(other.isSetRange());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRange()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.range, other.range);
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
    StringBuilder sb = new StringBuilder("StatsResponse(");
    boolean first = true;

    sb.append("head:");
    if (this.head == null) {
      sb.append("null");
    } else {
      sb.append(this.head);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("totalPriceE6:");
    sb.append(this.totalPriceE6);
    first = false;
    if (!first) sb.append(", ");
    sb.append("incomePriceE6:");
    sb.append(this.incomePriceE6);
    first = false;
    if (!first) sb.append(", ");
    sb.append("userCount:");
    sb.append(this.userCount);
    first = false;
    if (!first) sb.append(", ");
    sb.append("userBuyRank:");
    sb.append(this.userBuyRank);
    first = false;
    if (!first) sb.append(", ");
    sb.append("range:");
    if (this.range == null) {
      sb.append("null");
    } else {
      sb.append(this.range);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class StatsResponseStandardSchemeFactory implements SchemeFactory {
    public StatsResponseStandardScheme getScheme() {
      return new StatsResponseStandardScheme();
    }
  }

  private static class StatsResponseStandardScheme extends StandardScheme<StatsResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, StatsResponse struct) throws org.apache.thrift.TException {
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
          case 2: // TOTAL_PRICE_E6
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.totalPriceE6 = iprot.readI64();
              struct.setTotalPriceE6IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // INCOME_PRICE_E6
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.incomePriceE6 = iprot.readI64();
              struct.setIncomePriceE6IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // USER_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userCount = iprot.readI32();
              struct.setUserCountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // USER_BUY_RANK
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.userBuyRank = iprot.readI32();
              struct.setUserBuyRankIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // RANGE
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.range = new ArrayList<range>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  range _elem2;
                  _elem2 = new range();
                  _elem2.read(iprot);
                  struct.range.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setRangeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, StatsResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.head != null) {
        oprot.writeFieldBegin(HEAD_FIELD_DESC);
        struct.head.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(TOTAL_PRICE_E6_FIELD_DESC);
      oprot.writeI64(struct.totalPriceE6);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(INCOME_PRICE_E6_FIELD_DESC);
      oprot.writeI64(struct.incomePriceE6);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USER_COUNT_FIELD_DESC);
      oprot.writeI32(struct.userCount);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USER_BUY_RANK_FIELD_DESC);
      oprot.writeI32(struct.userBuyRank);
      oprot.writeFieldEnd();
      if (struct.range != null) {
        oprot.writeFieldBegin(RANGE_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.range.size()));
          for (range _iter3 : struct.range)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class StatsResponseTupleSchemeFactory implements SchemeFactory {
    public StatsResponseTupleScheme getScheme() {
      return new StatsResponseTupleScheme();
    }
  }

  private static class StatsResponseTupleScheme extends TupleScheme<StatsResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, StatsResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHead()) {
        optionals.set(0);
      }
      if (struct.isSetTotalPriceE6()) {
        optionals.set(1);
      }
      if (struct.isSetIncomePriceE6()) {
        optionals.set(2);
      }
      if (struct.isSetUserCount()) {
        optionals.set(3);
      }
      if (struct.isSetUserBuyRank()) {
        optionals.set(4);
      }
      if (struct.isSetRange()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetHead()) {
        struct.head.write(oprot);
      }
      if (struct.isSetTotalPriceE6()) {
        oprot.writeI64(struct.totalPriceE6);
      }
      if (struct.isSetIncomePriceE6()) {
        oprot.writeI64(struct.incomePriceE6);
      }
      if (struct.isSetUserCount()) {
        oprot.writeI32(struct.userCount);
      }
      if (struct.isSetUserBuyRank()) {
        oprot.writeI32(struct.userBuyRank);
      }
      if (struct.isSetRange()) {
        {
          oprot.writeI32(struct.range.size());
          for (range _iter4 : struct.range)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, StatsResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.head = new com.bangcar.app.mapi.base.MApiRespHead();
        struct.head.read(iprot);
        struct.setHeadIsSet(true);
      }
      if (incoming.get(1)) {
        struct.totalPriceE6 = iprot.readI64();
        struct.setTotalPriceE6IsSet(true);
      }
      if (incoming.get(2)) {
        struct.incomePriceE6 = iprot.readI64();
        struct.setIncomePriceE6IsSet(true);
      }
      if (incoming.get(3)) {
        struct.userCount = iprot.readI32();
        struct.setUserCountIsSet(true);
      }
      if (incoming.get(4)) {
        struct.userBuyRank = iprot.readI32();
        struct.setUserBuyRankIsSet(true);
      }
      if (incoming.get(5)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.range = new ArrayList<range>(_list5.size);
          for (int _i6 = 0; _i6 < _list5.size; ++_i6)
          {
            range _elem7;
            _elem7 = new range();
            _elem7.read(iprot);
            struct.range.add(_elem7);
          }
        }
        struct.setRangeIsSet(true);
      }
    }
  }

}
