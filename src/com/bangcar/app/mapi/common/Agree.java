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

public class Agree implements org.apache.thrift.TBase<Agree, Agree._Fields>, java.io.Serializable, Cloneable, Comparable<Agree> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Agree");

  private static final org.apache.thrift.protocol.TField AGREE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("agreeId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField SUBJECT_FIELD_DESC = new org.apache.thrift.protocol.TField("subject", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AgreeStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AgreeTupleSchemeFactory());
  }

  /**
   * 协议ID
   */
  public int agreeId; // required
  /**
   * 协议标题
   */
  public String subject; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 协议ID
     */
    AGREE_ID((short)1, "agreeId"),
    /**
     * 协议标题
     */
    SUBJECT((short)2, "subject");

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
        case 1: // AGREE_ID
          return AGREE_ID;
        case 2: // SUBJECT
          return SUBJECT;
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
  private static final int __AGREEID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.AGREE_ID, new org.apache.thrift.meta_data.FieldMetaData("agreeId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.SUBJECT, new org.apache.thrift.meta_data.FieldMetaData("subject", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Agree.class, metaDataMap);
  }

  public Agree() {
  }

  public Agree(
    int agreeId,
    String subject)
  {
    this();
    this.agreeId = agreeId;
    setAgreeIdIsSet(true);
    this.subject = subject;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Agree(Agree other) {
    __isset_bitfield = other.__isset_bitfield;
    this.agreeId = other.agreeId;
    if (other.isSetSubject()) {
      this.subject = other.subject;
    }
  }

  public Agree deepCopy() {
    return new Agree(this);
  }

  @Override
  public void clear() {
    setAgreeIdIsSet(false);
    this.agreeId = 0;
    this.subject = null;
  }

  /**
   * 协议ID
   */
  public int getAgreeId() {
    return this.agreeId;
  }

  /**
   * 协议ID
   */
  public Agree setAgreeId(int agreeId) {
    this.agreeId = agreeId;
    setAgreeIdIsSet(true);
    return this;
  }

  public void unsetAgreeId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __AGREEID_ISSET_ID);
  }

  /** Returns true if field agreeId is set (has been assigned a value) and false otherwise */
  public boolean isSetAgreeId() {
    return EncodingUtils.testBit(__isset_bitfield, __AGREEID_ISSET_ID);
  }

  public void setAgreeIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __AGREEID_ISSET_ID, value);
  }

  /**
   * 协议标题
   */
  public String getSubject() {
    return this.subject;
  }

  /**
   * 协议标题
   */
  public Agree setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public void unsetSubject() {
    this.subject = null;
  }

  /** Returns true if field subject is set (has been assigned a value) and false otherwise */
  public boolean isSetSubject() {
    return this.subject != null;
  }

  public void setSubjectIsSet(boolean value) {
    if (!value) {
      this.subject = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case AGREE_ID:
      if (value == null) {
        unsetAgreeId();
      } else {
        setAgreeId((Integer)value);
      }
      break;

    case SUBJECT:
      if (value == null) {
        unsetSubject();
      } else {
        setSubject((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case AGREE_ID:
      return Integer.valueOf(getAgreeId());

    case SUBJECT:
      return getSubject();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case AGREE_ID:
      return isSetAgreeId();
    case SUBJECT:
      return isSetSubject();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Agree)
      return this.equals((Agree)that);
    return false;
  }

  public boolean equals(Agree that) {
    if (that == null)
      return false;

    boolean this_present_agreeId = true;
    boolean that_present_agreeId = true;
    if (this_present_agreeId || that_present_agreeId) {
      if (!(this_present_agreeId && that_present_agreeId))
        return false;
      if (this.agreeId != that.agreeId)
        return false;
    }

    boolean this_present_subject = true && this.isSetSubject();
    boolean that_present_subject = true && that.isSetSubject();
    if (this_present_subject || that_present_subject) {
      if (!(this_present_subject && that_present_subject))
        return false;
      if (!this.subject.equals(that.subject))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Agree other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAgreeId()).compareTo(other.isSetAgreeId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAgreeId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.agreeId, other.agreeId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSubject()).compareTo(other.isSetSubject());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSubject()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.subject, other.subject);
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
    StringBuilder sb = new StringBuilder("Agree(");
    boolean first = true;

    sb.append("agreeId:");
    sb.append(this.agreeId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("subject:");
    if (this.subject == null) {
      sb.append("null");
    } else {
      sb.append(this.subject);
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

  private static class AgreeStandardSchemeFactory implements SchemeFactory {
    public AgreeStandardScheme getScheme() {
      return new AgreeStandardScheme();
    }
  }

  private static class AgreeStandardScheme extends StandardScheme<Agree> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Agree struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // AGREE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.agreeId = iprot.readI32();
              struct.setAgreeIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SUBJECT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.subject = iprot.readString();
              struct.setSubjectIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Agree struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(AGREE_ID_FIELD_DESC);
      oprot.writeI32(struct.agreeId);
      oprot.writeFieldEnd();
      if (struct.subject != null) {
        oprot.writeFieldBegin(SUBJECT_FIELD_DESC);
        oprot.writeString(struct.subject);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AgreeTupleSchemeFactory implements SchemeFactory {
    public AgreeTupleScheme getScheme() {
      return new AgreeTupleScheme();
    }
  }

  private static class AgreeTupleScheme extends TupleScheme<Agree> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Agree struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetAgreeId()) {
        optionals.set(0);
      }
      if (struct.isSetSubject()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetAgreeId()) {
        oprot.writeI32(struct.agreeId);
      }
      if (struct.isSetSubject()) {
        oprot.writeString(struct.subject);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Agree struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.agreeId = iprot.readI32();
        struct.setAgreeIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.subject = iprot.readString();
        struct.setSubjectIsSet(true);
      }
    }
  }

}
