/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.bangcar.app.mapi.base;

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

public class MApiReqHead implements org.apache.thrift.TBase<MApiReqHead, MApiReqHead._Fields>, java.io.Serializable, Cloneable, Comparable<MApiReqHead> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MApiReqHead");

  private static final org.apache.thrift.protocol.TField SKEY_FIELD_DESC = new org.apache.thrift.protocol.TField("skey", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ACCESS_TOKEN_FIELD_DESC = new org.apache.thrift.protocol.TField("accessToken", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new MApiReqHeadStandardSchemeFactory());
    schemes.put(TupleScheme.class, new MApiReqHeadTupleSchemeFactory());
  }

  /**
   * 会话标识，可选
   */
  public String skey; // optional
  /**
   * 请求授权码，可选
   */
  public String accessToken; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 会话标识，可选
     */
    SKEY((short)1, "skey"),
    /**
     * 请求授权码，可选
     */
    ACCESS_TOKEN((short)2, "accessToken");

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
        case 1: // SKEY
          return SKEY;
        case 2: // ACCESS_TOKEN
          return ACCESS_TOKEN;
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
  private _Fields optionals[] = {_Fields.SKEY,_Fields.ACCESS_TOKEN};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SKEY, new org.apache.thrift.meta_data.FieldMetaData("skey", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ACCESS_TOKEN, new org.apache.thrift.meta_data.FieldMetaData("accessToken", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MApiReqHead.class, metaDataMap);
  }

  public MApiReqHead() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MApiReqHead(MApiReqHead other) {
    if (other.isSetSkey()) {
      this.skey = other.skey;
    }
    if (other.isSetAccessToken()) {
      this.accessToken = other.accessToken;
    }
  }

  public MApiReqHead deepCopy() {
    return new MApiReqHead(this);
  }

  @Override
  public void clear() {
    this.skey = null;
    this.accessToken = null;
  }

  /**
   * 会话标识，可选
   */
  public String getSkey() {
    return this.skey;
  }

  /**
   * 会话标识，可选
   */
  public MApiReqHead setSkey(String skey) {
    this.skey = skey;
    return this;
  }

  public void unsetSkey() {
    this.skey = null;
  }

  /** Returns true if field skey is set (has been assigned a value) and false otherwise */
  public boolean isSetSkey() {
    return this.skey != null;
  }

  public void setSkeyIsSet(boolean value) {
    if (!value) {
      this.skey = null;
    }
  }

  /**
   * 请求授权码，可选
   */
  public String getAccessToken() {
    return this.accessToken;
  }

  /**
   * 请求授权码，可选
   */
  public MApiReqHead setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  public void unsetAccessToken() {
    this.accessToken = null;
  }

  /** Returns true if field accessToken is set (has been assigned a value) and false otherwise */
  public boolean isSetAccessToken() {
    return this.accessToken != null;
  }

  public void setAccessTokenIsSet(boolean value) {
    if (!value) {
      this.accessToken = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SKEY:
      if (value == null) {
        unsetSkey();
      } else {
        setSkey((String)value);
      }
      break;

    case ACCESS_TOKEN:
      if (value == null) {
        unsetAccessToken();
      } else {
        setAccessToken((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SKEY:
      return getSkey();

    case ACCESS_TOKEN:
      return getAccessToken();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SKEY:
      return isSetSkey();
    case ACCESS_TOKEN:
      return isSetAccessToken();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MApiReqHead)
      return this.equals((MApiReqHead)that);
    return false;
  }

  public boolean equals(MApiReqHead that) {
    if (that == null)
      return false;

    boolean this_present_skey = true && this.isSetSkey();
    boolean that_present_skey = true && that.isSetSkey();
    if (this_present_skey || that_present_skey) {
      if (!(this_present_skey && that_present_skey))
        return false;
      if (!this.skey.equals(that.skey))
        return false;
    }

    boolean this_present_accessToken = true && this.isSetAccessToken();
    boolean that_present_accessToken = true && that.isSetAccessToken();
    if (this_present_accessToken || that_present_accessToken) {
      if (!(this_present_accessToken && that_present_accessToken))
        return false;
      if (!this.accessToken.equals(that.accessToken))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(MApiReqHead other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSkey()).compareTo(other.isSetSkey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSkey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.skey, other.skey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAccessToken()).compareTo(other.isSetAccessToken());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAccessToken()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.accessToken, other.accessToken);
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
    StringBuilder sb = new StringBuilder("MApiReqHead(");
    boolean first = true;

    if (isSetSkey()) {
      sb.append("skey:");
      if (this.skey == null) {
        sb.append("null");
      } else {
        sb.append(this.skey);
      }
      first = false;
    }
    if (isSetAccessToken()) {
      if (!first) sb.append(", ");
      sb.append("accessToken:");
      if (this.accessToken == null) {
        sb.append("null");
      } else {
        sb.append(this.accessToken);
      }
      first = false;
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MApiReqHeadStandardSchemeFactory implements SchemeFactory {
    public MApiReqHeadStandardScheme getScheme() {
      return new MApiReqHeadStandardScheme();
    }
  }

  private static class MApiReqHeadStandardScheme extends StandardScheme<MApiReqHead> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MApiReqHead struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SKEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.skey = iprot.readString();
              struct.setSkeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ACCESS_TOKEN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.accessToken = iprot.readString();
              struct.setAccessTokenIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, MApiReqHead struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.skey != null) {
        if (struct.isSetSkey()) {
          oprot.writeFieldBegin(SKEY_FIELD_DESC);
          oprot.writeString(struct.skey);
          oprot.writeFieldEnd();
        }
      }
      if (struct.accessToken != null) {
        if (struct.isSetAccessToken()) {
          oprot.writeFieldBegin(ACCESS_TOKEN_FIELD_DESC);
          oprot.writeString(struct.accessToken);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MApiReqHeadTupleSchemeFactory implements SchemeFactory {
    public MApiReqHeadTupleScheme getScheme() {
      return new MApiReqHeadTupleScheme();
    }
  }

  private static class MApiReqHeadTupleScheme extends TupleScheme<MApiReqHead> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MApiReqHead struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetSkey()) {
        optionals.set(0);
      }
      if (struct.isSetAccessToken()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetSkey()) {
        oprot.writeString(struct.skey);
      }
      if (struct.isSetAccessToken()) {
        oprot.writeString(struct.accessToken);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MApiReqHead struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.skey = iprot.readString();
        struct.setSkeyIsSet(true);
      }
      if (incoming.get(1)) {
        struct.accessToken = iprot.readString();
        struct.setAccessTokenIsSet(true);
      }
    }
  }

}

