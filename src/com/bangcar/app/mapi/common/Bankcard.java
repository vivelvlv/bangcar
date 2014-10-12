/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.common;

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
 * 用户银行卡
 */
public class Bankcard implements org.apache.thrift.TBase<Bankcard, Bankcard._Fields>, java.io.Serializable, Cloneable, Comparable<Bankcard> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Bankcard");

  private static final org.apache.thrift.protocol.TField BANKCARD_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("bankcardId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField BANK_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("bankName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CARD_NO_SUFFIX_FIELD_DESC = new org.apache.thrift.protocol.TField("cardNoSuffix", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField IS_DEFAULT_FIELD_DESC = new org.apache.thrift.protocol.TField("isDefault", org.apache.thrift.protocol.TType.BOOL, (short)4);
  private static final org.apache.thrift.protocol.TField PAY_LIMIT_FIELD_DESC = new org.apache.thrift.protocol.TField("payLimit", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField LOGO_FIELD_DESC = new org.apache.thrift.protocol.TField("logo", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BankcardStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BankcardTupleSchemeFactory());
  }

  /**
   * 银行卡id
   */
  public int bankcardId; // required
  /**
   * 银行名称
   */
  public String bankName; // required
  /**
   * 银行卡后缀（4位)
   */
  public String cardNoSuffix; // required
  /**
   * 是否默认卡
   */
  public boolean isDefault; // required
  /**
   * 支付限额
   */
  public long payLimit; // required
  /**
   * 银行logo url
   */
  public String logo; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 银行卡id
     */
    BANKCARD_ID((short)1, "bankcardId"),
    /**
     * 银行名称
     */
    BANK_NAME((short)2, "bankName"),
    /**
     * 银行卡后缀（4位)
     */
    CARD_NO_SUFFIX((short)3, "cardNoSuffix"),
    /**
     * 是否默认卡
     */
    IS_DEFAULT((short)4, "isDefault"),
    /**
     * 支付限额
     */
    PAY_LIMIT((short)5, "payLimit"),
    /**
     * 银行logo url
     */
    LOGO((short)6, "logo");

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
        case 1: // BANKCARD_ID
          return BANKCARD_ID;
        case 2: // BANK_NAME
          return BANK_NAME;
        case 3: // CARD_NO_SUFFIX
          return CARD_NO_SUFFIX;
        case 4: // IS_DEFAULT
          return IS_DEFAULT;
        case 5: // PAY_LIMIT
          return PAY_LIMIT;
        case 6: // LOGO
          return LOGO;
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
  private static final int __BANKCARDID_ISSET_ID = 0;
  private static final int __ISDEFAULT_ISSET_ID = 1;
  private static final int __PAYLIMIT_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BANKCARD_ID, new org.apache.thrift.meta_data.FieldMetaData("bankcardId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.BANK_NAME, new org.apache.thrift.meta_data.FieldMetaData("bankName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CARD_NO_SUFFIX, new org.apache.thrift.meta_data.FieldMetaData("cardNoSuffix", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.IS_DEFAULT, new org.apache.thrift.meta_data.FieldMetaData("isDefault", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.PAY_LIMIT, new org.apache.thrift.meta_data.FieldMetaData("payLimit", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.LOGO, new org.apache.thrift.meta_data.FieldMetaData("logo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Bankcard.class, metaDataMap);
  }

  public Bankcard() {
  }

  public Bankcard(
    int bankcardId,
    String bankName,
    String cardNoSuffix,
    boolean isDefault,
    long payLimit,
    String logo)
  {
    this();
    this.bankcardId = bankcardId;
    setBankcardIdIsSet(true);
    this.bankName = bankName;
    this.cardNoSuffix = cardNoSuffix;
    this.isDefault = isDefault;
    setIsDefaultIsSet(true);
    this.payLimit = payLimit;
    setPayLimitIsSet(true);
    this.logo = logo;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Bankcard(Bankcard other) {
    __isset_bitfield = other.__isset_bitfield;
    this.bankcardId = other.bankcardId;
    if (other.isSetBankName()) {
      this.bankName = other.bankName;
    }
    if (other.isSetCardNoSuffix()) {
      this.cardNoSuffix = other.cardNoSuffix;
    }
    this.isDefault = other.isDefault;
    this.payLimit = other.payLimit;
    if (other.isSetLogo()) {
      this.logo = other.logo;
    }
  }

  public Bankcard deepCopy() {
    return new Bankcard(this);
  }

  @Override
  public void clear() {
    setBankcardIdIsSet(false);
    this.bankcardId = 0;
    this.bankName = null;
    this.cardNoSuffix = null;
    setIsDefaultIsSet(false);
    this.isDefault = false;
    setPayLimitIsSet(false);
    this.payLimit = 0;
    this.logo = null;
  }

  /**
   * 银行卡id
   */
  public int getBankcardId() {
    return this.bankcardId;
  }

  /**
   * 银行卡id
   */
  public Bankcard setBankcardId(int bankcardId) {
    this.bankcardId = bankcardId;
    setBankcardIdIsSet(true);
    return this;
  }

  public void unsetBankcardId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __BANKCARDID_ISSET_ID);
  }

  /** Returns true if field bankcardId is set (has been assigned a value) and false otherwise */
  public boolean isSetBankcardId() {
    return EncodingUtils.testBit(__isset_bitfield, __BANKCARDID_ISSET_ID);
  }

  public void setBankcardIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __BANKCARDID_ISSET_ID, value);
  }

  /**
   * 银行名称
   */
  public String getBankName() {
    return this.bankName;
  }

  /**
   * 银行名称
   */
  public Bankcard setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public void unsetBankName() {
    this.bankName = null;
  }

  /** Returns true if field bankName is set (has been assigned a value) and false otherwise */
  public boolean isSetBankName() {
    return this.bankName != null;
  }

  public void setBankNameIsSet(boolean value) {
    if (!value) {
      this.bankName = null;
    }
  }

  /**
   * 银行卡后缀（4位)
   */
  public String getCardNoSuffix() {
    return this.cardNoSuffix;
  }

  /**
   * 银行卡后缀（4位)
   */
  public Bankcard setCardNoSuffix(String cardNoSuffix) {
    this.cardNoSuffix = cardNoSuffix;
    return this;
  }

  public void unsetCardNoSuffix() {
    this.cardNoSuffix = null;
  }

  /** Returns true if field cardNoSuffix is set (has been assigned a value) and false otherwise */
  public boolean isSetCardNoSuffix() {
    return this.cardNoSuffix != null;
  }

  public void setCardNoSuffixIsSet(boolean value) {
    if (!value) {
      this.cardNoSuffix = null;
    }
  }

  /**
   * 是否默认卡
   */
  public boolean isIsDefault() {
    return this.isDefault;
  }

  /**
   * 是否默认卡
   */
  public Bankcard setIsDefault(boolean isDefault) {
    this.isDefault = isDefault;
    setIsDefaultIsSet(true);
    return this;
  }

  public void unsetIsDefault() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISDEFAULT_ISSET_ID);
  }

  /** Returns true if field isDefault is set (has been assigned a value) and false otherwise */
  public boolean isSetIsDefault() {
    return EncodingUtils.testBit(__isset_bitfield, __ISDEFAULT_ISSET_ID);
  }

  public void setIsDefaultIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISDEFAULT_ISSET_ID, value);
  }

  /**
   * 支付限额
   */
  public long getPayLimit() {
    return this.payLimit;
  }

  /**
   * 支付限额
   */
  public Bankcard setPayLimit(long payLimit) {
    this.payLimit = payLimit;
    setPayLimitIsSet(true);
    return this;
  }

  public void unsetPayLimit() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAYLIMIT_ISSET_ID);
  }

  /** Returns true if field payLimit is set (has been assigned a value) and false otherwise */
  public boolean isSetPayLimit() {
    return EncodingUtils.testBit(__isset_bitfield, __PAYLIMIT_ISSET_ID);
  }

  public void setPayLimitIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAYLIMIT_ISSET_ID, value);
  }

  /**
   * 银行logo url
   */
  public String getLogo() {
    return this.logo;
  }

  /**
   * 银行logo url
   */
  public Bankcard setLogo(String logo) {
    this.logo = logo;
    return this;
  }

  public void unsetLogo() {
    this.logo = null;
  }

  /** Returns true if field logo is set (has been assigned a value) and false otherwise */
  public boolean isSetLogo() {
    return this.logo != null;
  }

  public void setLogoIsSet(boolean value) {
    if (!value) {
      this.logo = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case BANKCARD_ID:
      if (value == null) {
        unsetBankcardId();
      } else {
        setBankcardId((Integer)value);
      }
      break;

    case BANK_NAME:
      if (value == null) {
        unsetBankName();
      } else {
        setBankName((String)value);
      }
      break;

    case CARD_NO_SUFFIX:
      if (value == null) {
        unsetCardNoSuffix();
      } else {
        setCardNoSuffix((String)value);
      }
      break;

    case IS_DEFAULT:
      if (value == null) {
        unsetIsDefault();
      } else {
        setIsDefault((Boolean)value);
      }
      break;

    case PAY_LIMIT:
      if (value == null) {
        unsetPayLimit();
      } else {
        setPayLimit((Long)value);
      }
      break;

    case LOGO:
      if (value == null) {
        unsetLogo();
      } else {
        setLogo((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case BANKCARD_ID:
      return Integer.valueOf(getBankcardId());

    case BANK_NAME:
      return getBankName();

    case CARD_NO_SUFFIX:
      return getCardNoSuffix();

    case IS_DEFAULT:
      return Boolean.valueOf(isIsDefault());

    case PAY_LIMIT:
      return Long.valueOf(getPayLimit());

    case LOGO:
      return getLogo();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case BANKCARD_ID:
      return isSetBankcardId();
    case BANK_NAME:
      return isSetBankName();
    case CARD_NO_SUFFIX:
      return isSetCardNoSuffix();
    case IS_DEFAULT:
      return isSetIsDefault();
    case PAY_LIMIT:
      return isSetPayLimit();
    case LOGO:
      return isSetLogo();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Bankcard)
      return this.equals((Bankcard)that);
    return false;
  }

  public boolean equals(Bankcard that) {
    if (that == null)
      return false;

    boolean this_present_bankcardId = true;
    boolean that_present_bankcardId = true;
    if (this_present_bankcardId || that_present_bankcardId) {
      if (!(this_present_bankcardId && that_present_bankcardId))
        return false;
      if (this.bankcardId != that.bankcardId)
        return false;
    }

    boolean this_present_bankName = true && this.isSetBankName();
    boolean that_present_bankName = true && that.isSetBankName();
    if (this_present_bankName || that_present_bankName) {
      if (!(this_present_bankName && that_present_bankName))
        return false;
      if (!this.bankName.equals(that.bankName))
        return false;
    }

    boolean this_present_cardNoSuffix = true && this.isSetCardNoSuffix();
    boolean that_present_cardNoSuffix = true && that.isSetCardNoSuffix();
    if (this_present_cardNoSuffix || that_present_cardNoSuffix) {
      if (!(this_present_cardNoSuffix && that_present_cardNoSuffix))
        return false;
      if (!this.cardNoSuffix.equals(that.cardNoSuffix))
        return false;
    }

    boolean this_present_isDefault = true;
    boolean that_present_isDefault = true;
    if (this_present_isDefault || that_present_isDefault) {
      if (!(this_present_isDefault && that_present_isDefault))
        return false;
      if (this.isDefault != that.isDefault)
        return false;
    }

    boolean this_present_payLimit = true;
    boolean that_present_payLimit = true;
    if (this_present_payLimit || that_present_payLimit) {
      if (!(this_present_payLimit && that_present_payLimit))
        return false;
      if (this.payLimit != that.payLimit)
        return false;
    }

    boolean this_present_logo = true && this.isSetLogo();
    boolean that_present_logo = true && that.isSetLogo();
    if (this_present_logo || that_present_logo) {
      if (!(this_present_logo && that_present_logo))
        return false;
      if (!this.logo.equals(that.logo))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Bankcard other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetBankcardId()).compareTo(other.isSetBankcardId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBankcardId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bankcardId, other.bankcardId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBankName()).compareTo(other.isSetBankName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBankName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bankName, other.bankName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCardNoSuffix()).compareTo(other.isSetCardNoSuffix());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCardNoSuffix()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cardNoSuffix, other.cardNoSuffix);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIsDefault()).compareTo(other.isSetIsDefault());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsDefault()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isDefault, other.isDefault);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPayLimit()).compareTo(other.isSetPayLimit());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPayLimit()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.payLimit, other.payLimit);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLogo()).compareTo(other.isSetLogo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLogo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.logo, other.logo);
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
    StringBuilder sb = new StringBuilder("Bankcard(");
    boolean first = true;

    sb.append("bankcardId:");
    sb.append(this.bankcardId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("bankName:");
    if (this.bankName == null) {
      sb.append("null");
    } else {
      sb.append(this.bankName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("cardNoSuffix:");
    if (this.cardNoSuffix == null) {
      sb.append("null");
    } else {
      sb.append(this.cardNoSuffix);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("isDefault:");
    sb.append(this.isDefault);
    first = false;
    if (!first) sb.append(", ");
    sb.append("payLimit:");
    sb.append(this.payLimit);
    first = false;
    if (!first) sb.append(", ");
    sb.append("logo:");
    if (this.logo == null) {
      sb.append("null");
    } else {
      sb.append(this.logo);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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

  private static class BankcardStandardSchemeFactory implements SchemeFactory {
    public BankcardStandardScheme getScheme() {
      return new BankcardStandardScheme();
    }
  }

  private static class BankcardStandardScheme extends StandardScheme<Bankcard> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Bankcard struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BANKCARD_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.bankcardId = iprot.readI32();
              struct.setBankcardIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BANK_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.bankName = iprot.readString();
              struct.setBankNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CARD_NO_SUFFIX
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.cardNoSuffix = iprot.readString();
              struct.setCardNoSuffixIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // IS_DEFAULT
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isDefault = iprot.readBool();
              struct.setIsDefaultIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PAY_LIMIT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.payLimit = iprot.readI64();
              struct.setPayLimitIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // LOGO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.logo = iprot.readString();
              struct.setLogoIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Bankcard struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(BANKCARD_ID_FIELD_DESC);
      oprot.writeI32(struct.bankcardId);
      oprot.writeFieldEnd();
      if (struct.bankName != null) {
        oprot.writeFieldBegin(BANK_NAME_FIELD_DESC);
        oprot.writeString(struct.bankName);
        oprot.writeFieldEnd();
      }
      if (struct.cardNoSuffix != null) {
        oprot.writeFieldBegin(CARD_NO_SUFFIX_FIELD_DESC);
        oprot.writeString(struct.cardNoSuffix);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(IS_DEFAULT_FIELD_DESC);
      oprot.writeBool(struct.isDefault);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(PAY_LIMIT_FIELD_DESC);
      oprot.writeI64(struct.payLimit);
      oprot.writeFieldEnd();
      if (struct.logo != null) {
        oprot.writeFieldBegin(LOGO_FIELD_DESC);
        oprot.writeString(struct.logo);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BankcardTupleSchemeFactory implements SchemeFactory {
    public BankcardTupleScheme getScheme() {
      return new BankcardTupleScheme();
    }
  }

  private static class BankcardTupleScheme extends TupleScheme<Bankcard> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Bankcard struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetBankcardId()) {
        optionals.set(0);
      }
      if (struct.isSetBankName()) {
        optionals.set(1);
      }
      if (struct.isSetCardNoSuffix()) {
        optionals.set(2);
      }
      if (struct.isSetIsDefault()) {
        optionals.set(3);
      }
      if (struct.isSetPayLimit()) {
        optionals.set(4);
      }
      if (struct.isSetLogo()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetBankcardId()) {
        oprot.writeI32(struct.bankcardId);
      }
      if (struct.isSetBankName()) {
        oprot.writeString(struct.bankName);
      }
      if (struct.isSetCardNoSuffix()) {
        oprot.writeString(struct.cardNoSuffix);
      }
      if (struct.isSetIsDefault()) {
        oprot.writeBool(struct.isDefault);
      }
      if (struct.isSetPayLimit()) {
        oprot.writeI64(struct.payLimit);
      }
      if (struct.isSetLogo()) {
        oprot.writeString(struct.logo);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Bankcard struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.bankcardId = iprot.readI32();
        struct.setBankcardIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.bankName = iprot.readString();
        struct.setBankNameIsSet(true);
      }
      if (incoming.get(2)) {
        struct.cardNoSuffix = iprot.readString();
        struct.setCardNoSuffixIsSet(true);
      }
      if (incoming.get(3)) {
        struct.isDefault = iprot.readBool();
        struct.setIsDefaultIsSet(true);
      }
      if (incoming.get(4)) {
        struct.payLimit = iprot.readI64();
        struct.setPayLimitIsSet(true);
      }
      if (incoming.get(5)) {
        struct.logo = iprot.readString();
        struct.setLogoIsSet(true);
      }
    }
  }

}

