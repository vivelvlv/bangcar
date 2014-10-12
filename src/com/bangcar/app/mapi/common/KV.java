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

import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;

public class KV implements org.apache.thrift.TBase<KV, KV._Fields>, java.io.Serializable, Cloneable, Comparable<KV> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("KV");

  private static final org.apache.thrift.protocol.TField K_FIELD_DESC = new org.apache.thrift.protocol.TField("k", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField V_FIELD_DESC = new org.apache.thrift.protocol.TField("v", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new KVStandardSchemeFactory());
    schemes.put(TupleScheme.class, new KVTupleSchemeFactory());
  }

  public String k; // required
  public String v; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    K((short)1, "k"),
    V((short)2, "v");

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
        case 1: // K
          return K;
        case 2: // V
          return V;
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
    tmpMap.put(_Fields.K, new org.apache.thrift.meta_data.FieldMetaData("k", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.V, new org.apache.thrift.meta_data.FieldMetaData("v", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(KV.class, metaDataMap);
  }

  public KV() {
  }

  public KV(
    String k,
    String v)
  {
    this();
    this.k = k;
    this.v = v;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public KV(KV other) {
    if (other.isSetK()) {
      this.k = other.k;
    }
    if (other.isSetV()) {
      this.v = other.v;
    }
  }

  public KV deepCopy() {
    return new KV(this);
  }

  @Override
  public void clear() {
    this.k = null;
    this.v = null;
  }

  public String getK() {
    return this.k;
  }

  public KV setK(String k) {
    this.k = k;
    return this;
  }

  public void unsetK() {
    this.k = null;
  }

  /** Returns true if field k is set (has been assigned a value) and false otherwise */
  public boolean isSetK() {
    return this.k != null;
  }

  public void setKIsSet(boolean value) {
    if (!value) {
      this.k = null;
    }
  }

  public String getV() {
    return this.v;
  }

  public KV setV(String v) {
    this.v = v;
    return this;
  }

  public void unsetV() {
    this.v = null;
  }

  /** Returns true if field v is set (has been assigned a value) and false otherwise */
  public boolean isSetV() {
    return this.v != null;
  }

  public void setVIsSet(boolean value) {
    if (!value) {
      this.v = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case K:
      if (value == null) {
        unsetK();
      } else {
        setK((String)value);
      }
      break;

    case V:
      if (value == null) {
        unsetV();
      } else {
        setV((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case K:
      return getK();

    case V:
      return getV();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case K:
      return isSetK();
    case V:
      return isSetV();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof KV)
      return this.equals((KV)that);
    return false;
  }

  public boolean equals(KV that) {
    if (that == null)
      return false;

    boolean this_present_k = true && this.isSetK();
    boolean that_present_k = true && that.isSetK();
    if (this_present_k || that_present_k) {
      if (!(this_present_k && that_present_k))
        return false;
      if (!this.k.equals(that.k))
        return false;
    }

    boolean this_present_v = true && this.isSetV();
    boolean that_present_v = true && that.isSetV();
    if (this_present_v || that_present_v) {
      if (!(this_present_v && that_present_v))
        return false;
      if (!this.v.equals(that.v))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(KV other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetK()).compareTo(other.isSetK());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetK()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.k, other.k);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetV()).compareTo(other.isSetV());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetV()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.v, other.v);
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
    StringBuilder sb = new StringBuilder("KV(");
    boolean first = true;

    sb.append("k:");
    if (this.k == null) {
      sb.append("null");
    } else {
      sb.append(this.k);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("v:");
    if (this.v == null) {
      sb.append("null");
    } else {
      sb.append(this.v);
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class KVStandardSchemeFactory implements SchemeFactory {
    public KVStandardScheme getScheme() {
      return new KVStandardScheme();
    }
  }

  private static class KVStandardScheme extends StandardScheme<KV> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, KV struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // K
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.k = iprot.readString();
              struct.setKIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // V
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.v = iprot.readString();
              struct.setVIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, KV struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.k != null) {
        oprot.writeFieldBegin(K_FIELD_DESC);
        oprot.writeString(struct.k);
        oprot.writeFieldEnd();
      }
      if (struct.v != null) {
        oprot.writeFieldBegin(V_FIELD_DESC);
        oprot.writeString(struct.v);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class KVTupleSchemeFactory implements SchemeFactory {
    public KVTupleScheme getScheme() {
      return new KVTupleScheme();
    }
  }

  private static class KVTupleScheme extends TupleScheme<KV> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, KV struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetK()) {
        optionals.set(0);
      }
      if (struct.isSetV()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetK()) {
        oprot.writeString(struct.k);
      }
      if (struct.isSetV()) {
        oprot.writeString(struct.v);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, KV struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.k = iprot.readString();
        struct.setKIsSet(true);
      }
      if (incoming.get(1)) {
        struct.v = iprot.readString();
        struct.setVIsSet(true);
      }
    }
  }

}

