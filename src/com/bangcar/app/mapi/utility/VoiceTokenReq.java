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

import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;

public class VoiceTokenReq implements org.apache.thrift.TBase<VoiceTokenReq, VoiceTokenReq._Fields>, java.io.Serializable, Cloneable, Comparable<VoiceTokenReq> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("VoiceTokenReq");

  private static final org.apache.thrift.protocol.TField HEAD_FIELD_DESC = new org.apache.thrift.protocol.TField("head", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField VOICE_MOBILE_FIELD_DESC = new org.apache.thrift.protocol.TField("voiceMobile", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField VOICE_TOKEN_FIELD_DESC = new org.apache.thrift.protocol.TField("voiceToken", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new VoiceTokenReqStandardSchemeFactory());
    schemes.put(TupleScheme.class, new VoiceTokenReqTupleSchemeFactory());
  }

  public com.bangcar.app.mapi.base.MApiReqHead head; // required
  /**
   * 语音验证接收手机号
   */
  public String voiceMobile; // required
  /**
   * 语音验证码请求TOKEN
   */
  public String voiceToken; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HEAD((short)1, "head"),
    /**
     * 语音验证接收手机号
     */
    VOICE_MOBILE((short)2, "voiceMobile"),
    /**
     * 语音验证码请求TOKEN
     */
    VOICE_TOKEN((short)3, "voiceToken");

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
        case 2: // VOICE_MOBILE
          return VOICE_MOBILE;
        case 3: // VOICE_TOKEN
          return VOICE_TOKEN;
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
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.bangcar.app.mapi.base.MApiReqHead.class)));
    tmpMap.put(_Fields.VOICE_MOBILE, new org.apache.thrift.meta_data.FieldMetaData("voiceMobile", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.VOICE_TOKEN, new org.apache.thrift.meta_data.FieldMetaData("voiceToken", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(VoiceTokenReq.class, metaDataMap);
  }

  public VoiceTokenReq() {
  }

  public VoiceTokenReq(
    com.bangcar.app.mapi.base.MApiReqHead head,
    String voiceMobile,
    String voiceToken)
  {
    this();
    this.head = head;
    this.voiceMobile = voiceMobile;
    this.voiceToken = voiceToken;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public VoiceTokenReq(VoiceTokenReq other) {
    if (other.isSetHead()) {
      this.head = new com.bangcar.app.mapi.base.MApiReqHead(other.head);
    }
    if (other.isSetVoiceMobile()) {
      this.voiceMobile = other.voiceMobile;
    }
    if (other.isSetVoiceToken()) {
      this.voiceToken = other.voiceToken;
    }
  }

  public VoiceTokenReq deepCopy() {
    return new VoiceTokenReq(this);
  }

  @Override
  public void clear() {
    this.head = null;
    this.voiceMobile = null;
    this.voiceToken = null;
  }

  public com.bangcar.app.mapi.base.MApiReqHead getHead() {
    return this.head;
  }

  public VoiceTokenReq setHead(com.bangcar.app.mapi.base.MApiReqHead head) {
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
   * 语音验证接收手机号
   */
  public String getVoiceMobile() {
    return this.voiceMobile;
  }

  /**
   * 语音验证接收手机号
   */
  public VoiceTokenReq setVoiceMobile(String voiceMobile) {
    this.voiceMobile = voiceMobile;
    return this;
  }

  public void unsetVoiceMobile() {
    this.voiceMobile = null;
  }

  /** Returns true if field voiceMobile is set (has been assigned a value) and false otherwise */
  public boolean isSetVoiceMobile() {
    return this.voiceMobile != null;
  }

  public void setVoiceMobileIsSet(boolean value) {
    if (!value) {
      this.voiceMobile = null;
    }
  }

  /**
   * 语音验证码请求TOKEN
   */
  public String getVoiceToken() {
    return this.voiceToken;
  }

  /**
   * 语音验证码请求TOKEN
   */
  public VoiceTokenReq setVoiceToken(String voiceToken) {
    this.voiceToken = voiceToken;
    return this;
  }

  public void unsetVoiceToken() {
    this.voiceToken = null;
  }

  /** Returns true if field voiceToken is set (has been assigned a value) and false otherwise */
  public boolean isSetVoiceToken() {
    return this.voiceToken != null;
  }

  public void setVoiceTokenIsSet(boolean value) {
    if (!value) {
      this.voiceToken = null;
    }
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

    case VOICE_MOBILE:
      if (value == null) {
        unsetVoiceMobile();
      } else {
        setVoiceMobile((String)value);
      }
      break;

    case VOICE_TOKEN:
      if (value == null) {
        unsetVoiceToken();
      } else {
        setVoiceToken((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HEAD:
      return getHead();

    case VOICE_MOBILE:
      return getVoiceMobile();

    case VOICE_TOKEN:
      return getVoiceToken();

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
    case VOICE_MOBILE:
      return isSetVoiceMobile();
    case VOICE_TOKEN:
      return isSetVoiceToken();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof VoiceTokenReq)
      return this.equals((VoiceTokenReq)that);
    return false;
  }

  public boolean equals(VoiceTokenReq that) {
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

    boolean this_present_voiceMobile = true && this.isSetVoiceMobile();
    boolean that_present_voiceMobile = true && that.isSetVoiceMobile();
    if (this_present_voiceMobile || that_present_voiceMobile) {
      if (!(this_present_voiceMobile && that_present_voiceMobile))
        return false;
      if (!this.voiceMobile.equals(that.voiceMobile))
        return false;
    }

    boolean this_present_voiceToken = true && this.isSetVoiceToken();
    boolean that_present_voiceToken = true && that.isSetVoiceToken();
    if (this_present_voiceToken || that_present_voiceToken) {
      if (!(this_present_voiceToken && that_present_voiceToken))
        return false;
      if (!this.voiceToken.equals(that.voiceToken))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(VoiceTokenReq other) {
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
    lastComparison = Boolean.valueOf(isSetVoiceMobile()).compareTo(other.isSetVoiceMobile());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVoiceMobile()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.voiceMobile, other.voiceMobile);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVoiceToken()).compareTo(other.isSetVoiceToken());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVoiceToken()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.voiceToken, other.voiceToken);
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
    StringBuilder sb = new StringBuilder("VoiceTokenReq(");
    boolean first = true;

    sb.append("head:");
    if (this.head == null) {
      sb.append("null");
    } else {
      sb.append(this.head);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("voiceMobile:");
    if (this.voiceMobile == null) {
      sb.append("null");
    } else {
      sb.append(this.voiceMobile);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("voiceToken:");
    if (this.voiceToken == null) {
      sb.append("null");
    } else {
      sb.append(this.voiceToken);
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

  private static class VoiceTokenReqStandardSchemeFactory implements SchemeFactory {
    public VoiceTokenReqStandardScheme getScheme() {
      return new VoiceTokenReqStandardScheme();
    }
  }

  private static class VoiceTokenReqStandardScheme extends StandardScheme<VoiceTokenReq> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, VoiceTokenReq struct) throws org.apache.thrift.TException {
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
          case 2: // VOICE_MOBILE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.voiceMobile = iprot.readString();
              struct.setVoiceMobileIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // VOICE_TOKEN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.voiceToken = iprot.readString();
              struct.setVoiceTokenIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, VoiceTokenReq struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.head != null) {
        oprot.writeFieldBegin(HEAD_FIELD_DESC);
        struct.head.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.voiceMobile != null) {
        oprot.writeFieldBegin(VOICE_MOBILE_FIELD_DESC);
        oprot.writeString(struct.voiceMobile);
        oprot.writeFieldEnd();
      }
      if (struct.voiceToken != null) {
        oprot.writeFieldBegin(VOICE_TOKEN_FIELD_DESC);
        oprot.writeString(struct.voiceToken);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class VoiceTokenReqTupleSchemeFactory implements SchemeFactory {
    public VoiceTokenReqTupleScheme getScheme() {
      return new VoiceTokenReqTupleScheme();
    }
  }

  private static class VoiceTokenReqTupleScheme extends TupleScheme<VoiceTokenReq> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, VoiceTokenReq struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetHead()) {
        optionals.set(0);
      }
      if (struct.isSetVoiceMobile()) {
        optionals.set(1);
      }
      if (struct.isSetVoiceToken()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetHead()) {
        struct.head.write(oprot);
      }
      if (struct.isSetVoiceMobile()) {
        oprot.writeString(struct.voiceMobile);
      }
      if (struct.isSetVoiceToken()) {
        oprot.writeString(struct.voiceToken);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, VoiceTokenReq struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.head = new com.bangcar.app.mapi.base.MApiReqHead();
        struct.head.read(iprot);
        struct.setHeadIsSet(true);
      }
      if (incoming.get(1)) {
        struct.voiceMobile = iprot.readString();
        struct.setVoiceMobileIsSet(true);
      }
      if (incoming.get(2)) {
        struct.voiceToken = iprot.readString();
        struct.setVoiceTokenIsSet(true);
      }
    }
  }

}

