/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.hypertable.thriftgen;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.protocol.*;

/**
 * Defines a cell key
 * 
 * <dl>
 *   <dt>row</dt>
 *   <dd>Specifies the row key. Note, it cannot contain null characters.
 *   If a row key is not specified in a return cell, it's assumed to
 *   be the same as the previous cell</dd>
 * 
 *   <dt>column_family</dt>
 *   <dd>Specifies the column family</dd>
 * 
 *   <dt>column_qualifier</dt>
 *   <dd>Specifies the column qualifier. A column family must be specified.</dd>
 * 
 *   <dt>timestamp</dt>
 *   <dd>Nanoseconds since epoch for the cell<dd>
 * 
 *   <dt>revision</dt>
 *   <dd>A 64-bit revision number for the cell</dd>
 * 
 *   <dt>flag</dt>
 *   <dd>A 16-bit integer indicating the state of the cell</dd>
 * </dl>
 */
public class Key implements TBase<Key, Key._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("Key");

  private static final TField ROW_FIELD_DESC = new TField("row", TType.STRING, (short)1);
  private static final TField COLUMN_FAMILY_FIELD_DESC = new TField("column_family", TType.STRING, (short)2);
  private static final TField COLUMN_QUALIFIER_FIELD_DESC = new TField("column_qualifier", TType.STRING, (short)3);
  private static final TField TIMESTAMP_FIELD_DESC = new TField("timestamp", TType.I64, (short)4);
  private static final TField REVISION_FIELD_DESC = new TField("revision", TType.I64, (short)5);
  private static final TField FLAG_FIELD_DESC = new TField("flag", TType.I16, (short)6);

  public String row;
  public String column_family;
  public String column_qualifier;
  public long timestamp;
  public long revision;
  public short flag;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    ROW((short)1, "row"),
    COLUMN_FAMILY((short)2, "column_family"),
    COLUMN_QUALIFIER((short)3, "column_qualifier"),
    TIMESTAMP((short)4, "timestamp"),
    REVISION((short)5, "revision"),
    FLAG((short)6, "flag");

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
        case 1: // ROW
          return ROW;
        case 2: // COLUMN_FAMILY
          return COLUMN_FAMILY;
        case 3: // COLUMN_QUALIFIER
          return COLUMN_QUALIFIER;
        case 4: // TIMESTAMP
          return TIMESTAMP;
        case 5: // REVISION
          return REVISION;
        case 6: // FLAG
          return FLAG;
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
  private static final int __TIMESTAMP_ISSET_ID = 0;
  private static final int __REVISION_ISSET_ID = 1;
  private static final int __FLAG_ISSET_ID = 2;
  private BitSet __isset_bit_vector = new BitSet(3);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ROW, new FieldMetaData("row", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.COLUMN_FAMILY, new FieldMetaData("column_family", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.COLUMN_QUALIFIER, new FieldMetaData("column_qualifier", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.TIMESTAMP, new FieldMetaData("timestamp", TFieldRequirementType.OPTIONAL, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.REVISION, new FieldMetaData("revision", TFieldRequirementType.OPTIONAL, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.FLAG, new FieldMetaData("flag", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I16)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(Key.class, metaDataMap);
  }

  public Key() {
    this.flag = (short)255;

  }

  public Key(
    String row,
    String column_family,
    String column_qualifier,
    short flag)
  {
    this();
    this.row = row;
    this.column_family = column_family;
    this.column_qualifier = column_qualifier;
    this.flag = flag;
    setFlagIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Key(Key other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetRow()) {
      this.row = other.row;
    }
    if (other.isSetColumn_family()) {
      this.column_family = other.column_family;
    }
    if (other.isSetColumn_qualifier()) {
      this.column_qualifier = other.column_qualifier;
    }
    this.timestamp = other.timestamp;
    this.revision = other.revision;
    this.flag = other.flag;
  }

  public Key deepCopy() {
    return new Key(this);
  }

  @Deprecated
  public Key clone() {
    return new Key(this);
  }

  public String getRow() {
    return this.row;
  }

  public Key setRow(String row) {
    this.row = row;
    return this;
  }

  public void unsetRow() {
    this.row = null;
  }

  /** Returns true if field row is set (has been asigned a value) and false otherwise */
  public boolean isSetRow() {
    return this.row != null;
  }

  public void setRowIsSet(boolean value) {
    if (!value) {
      this.row = null;
    }
  }

  public String getColumn_family() {
    return this.column_family;
  }

  public Key setColumn_family(String column_family) {
    this.column_family = column_family;
    return this;
  }

  public void unsetColumn_family() {
    this.column_family = null;
  }

  /** Returns true if field column_family is set (has been asigned a value) and false otherwise */
  public boolean isSetColumn_family() {
    return this.column_family != null;
  }

  public void setColumn_familyIsSet(boolean value) {
    if (!value) {
      this.column_family = null;
    }
  }

  public String getColumn_qualifier() {
    return this.column_qualifier;
  }

  public Key setColumn_qualifier(String column_qualifier) {
    this.column_qualifier = column_qualifier;
    return this;
  }

  public void unsetColumn_qualifier() {
    this.column_qualifier = null;
  }

  /** Returns true if field column_qualifier is set (has been asigned a value) and false otherwise */
  public boolean isSetColumn_qualifier() {
    return this.column_qualifier != null;
  }

  public void setColumn_qualifierIsSet(boolean value) {
    if (!value) {
      this.column_qualifier = null;
    }
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public Key setTimestamp(long timestamp) {
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    return this;
  }

  public void unsetTimestamp() {
    __isset_bit_vector.clear(__TIMESTAMP_ISSET_ID);
  }

  /** Returns true if field timestamp is set (has been asigned a value) and false otherwise */
  public boolean isSetTimestamp() {
    return __isset_bit_vector.get(__TIMESTAMP_ISSET_ID);
  }

  public void setTimestampIsSet(boolean value) {
    __isset_bit_vector.set(__TIMESTAMP_ISSET_ID, value);
  }

  public long getRevision() {
    return this.revision;
  }

  public Key setRevision(long revision) {
    this.revision = revision;
    setRevisionIsSet(true);
    return this;
  }

  public void unsetRevision() {
    __isset_bit_vector.clear(__REVISION_ISSET_ID);
  }

  /** Returns true if field revision is set (has been asigned a value) and false otherwise */
  public boolean isSetRevision() {
    return __isset_bit_vector.get(__REVISION_ISSET_ID);
  }

  public void setRevisionIsSet(boolean value) {
    __isset_bit_vector.set(__REVISION_ISSET_ID, value);
  }

  public short getFlag() {
    return this.flag;
  }

  public Key setFlag(short flag) {
    this.flag = flag;
    setFlagIsSet(true);
    return this;
  }

  public void unsetFlag() {
    __isset_bit_vector.clear(__FLAG_ISSET_ID);
  }

  /** Returns true if field flag is set (has been asigned a value) and false otherwise */
  public boolean isSetFlag() {
    return __isset_bit_vector.get(__FLAG_ISSET_ID);
  }

  public void setFlagIsSet(boolean value) {
    __isset_bit_vector.set(__FLAG_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ROW:
      if (value == null) {
        unsetRow();
      } else {
        setRow((String)value);
      }
      break;

    case COLUMN_FAMILY:
      if (value == null) {
        unsetColumn_family();
      } else {
        setColumn_family((String)value);
      }
      break;

    case COLUMN_QUALIFIER:
      if (value == null) {
        unsetColumn_qualifier();
      } else {
        setColumn_qualifier((String)value);
      }
      break;

    case TIMESTAMP:
      if (value == null) {
        unsetTimestamp();
      } else {
        setTimestamp((Long)value);
      }
      break;

    case REVISION:
      if (value == null) {
        unsetRevision();
      } else {
        setRevision((Long)value);
      }
      break;

    case FLAG:
      if (value == null) {
        unsetFlag();
      } else {
        setFlag((Short)value);
      }
      break;

    }
  }

  public void setFieldValue(int fieldID, Object value) {
    setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ROW:
      return getRow();

    case COLUMN_FAMILY:
      return getColumn_family();

    case COLUMN_QUALIFIER:
      return getColumn_qualifier();

    case TIMESTAMP:
      return new Long(getTimestamp());

    case REVISION:
      return new Long(getRevision());

    case FLAG:
      return new Short(getFlag());

    }
    throw new IllegalStateException();
  }

  public Object getFieldValue(int fieldId) {
    return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    switch (field) {
    case ROW:
      return isSetRow();
    case COLUMN_FAMILY:
      return isSetColumn_family();
    case COLUMN_QUALIFIER:
      return isSetColumn_qualifier();
    case TIMESTAMP:
      return isSetTimestamp();
    case REVISION:
      return isSetRevision();
    case FLAG:
      return isSetFlag();
    }
    throw new IllegalStateException();
  }

  public boolean isSet(int fieldID) {
    return isSet(_Fields.findByThriftIdOrThrow(fieldID));
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Key)
      return this.equals((Key)that);
    return false;
  }

  public boolean equals(Key that) {
    if (that == null)
      return false;

    boolean this_present_row = true && this.isSetRow();
    boolean that_present_row = true && that.isSetRow();
    if (this_present_row || that_present_row) {
      if (!(this_present_row && that_present_row))
        return false;
      if (!this.row.equals(that.row))
        return false;
    }

    boolean this_present_column_family = true && this.isSetColumn_family();
    boolean that_present_column_family = true && that.isSetColumn_family();
    if (this_present_column_family || that_present_column_family) {
      if (!(this_present_column_family && that_present_column_family))
        return false;
      if (!this.column_family.equals(that.column_family))
        return false;
    }

    boolean this_present_column_qualifier = true && this.isSetColumn_qualifier();
    boolean that_present_column_qualifier = true && that.isSetColumn_qualifier();
    if (this_present_column_qualifier || that_present_column_qualifier) {
      if (!(this_present_column_qualifier && that_present_column_qualifier))
        return false;
      if (!this.column_qualifier.equals(that.column_qualifier))
        return false;
    }

    boolean this_present_timestamp = true && this.isSetTimestamp();
    boolean that_present_timestamp = true && that.isSetTimestamp();
    if (this_present_timestamp || that_present_timestamp) {
      if (!(this_present_timestamp && that_present_timestamp))
        return false;
      if (this.timestamp != that.timestamp)
        return false;
    }

    boolean this_present_revision = true && this.isSetRevision();
    boolean that_present_revision = true && that.isSetRevision();
    if (this_present_revision || that_present_revision) {
      if (!(this_present_revision && that_present_revision))
        return false;
      if (this.revision != that.revision)
        return false;
    }

    boolean this_present_flag = true;
    boolean that_present_flag = true;
    if (this_present_flag || that_present_flag) {
      if (!(this_present_flag && that_present_flag))
        return false;
      if (this.flag != that.flag)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Key other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Key typedOther = (Key)other;

    lastComparison = Boolean.valueOf(isSetRow()).compareTo(typedOther.isSetRow());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRow()) {      lastComparison = TBaseHelper.compareTo(this.row, typedOther.row);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetColumn_family()).compareTo(typedOther.isSetColumn_family());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumn_family()) {      lastComparison = TBaseHelper.compareTo(this.column_family, typedOther.column_family);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetColumn_qualifier()).compareTo(typedOther.isSetColumn_qualifier());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumn_qualifier()) {      lastComparison = TBaseHelper.compareTo(this.column_qualifier, typedOther.column_qualifier);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTimestamp()).compareTo(typedOther.isSetTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestamp()) {      lastComparison = TBaseHelper.compareTo(this.timestamp, typedOther.timestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRevision()).compareTo(typedOther.isSetRevision());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRevision()) {      lastComparison = TBaseHelper.compareTo(this.revision, typedOther.revision);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFlag()).compareTo(typedOther.isSetFlag());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFlag()) {      lastComparison = TBaseHelper.compareTo(this.flag, typedOther.flag);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // ROW
          if (field.type == TType.STRING) {
            this.row = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // COLUMN_FAMILY
          if (field.type == TType.STRING) {
            this.column_family = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // COLUMN_QUALIFIER
          if (field.type == TType.STRING) {
            this.column_qualifier = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // TIMESTAMP
          if (field.type == TType.I64) {
            this.timestamp = iprot.readI64();
            setTimestampIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // REVISION
          if (field.type == TType.I64) {
            this.revision = iprot.readI64();
            setRevisionIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // FLAG
          if (field.type == TType.I16) {
            this.flag = iprot.readI16();
            setFlagIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.row != null) {
      oprot.writeFieldBegin(ROW_FIELD_DESC);
      oprot.writeString(this.row);
      oprot.writeFieldEnd();
    }
    if (this.column_family != null) {
      oprot.writeFieldBegin(COLUMN_FAMILY_FIELD_DESC);
      oprot.writeString(this.column_family);
      oprot.writeFieldEnd();
    }
    if (this.column_qualifier != null) {
      oprot.writeFieldBegin(COLUMN_QUALIFIER_FIELD_DESC);
      oprot.writeString(this.column_qualifier);
      oprot.writeFieldEnd();
    }
    if (isSetTimestamp()) {
      oprot.writeFieldBegin(TIMESTAMP_FIELD_DESC);
      oprot.writeI64(this.timestamp);
      oprot.writeFieldEnd();
    }
    if (isSetRevision()) {
      oprot.writeFieldBegin(REVISION_FIELD_DESC);
      oprot.writeI64(this.revision);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(FLAG_FIELD_DESC);
    oprot.writeI16(this.flag);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Key(");
    boolean first = true;

    sb.append("row:");
    if (this.row == null) {
      sb.append("null");
    } else {
      sb.append(this.row);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("column_family:");
    if (this.column_family == null) {
      sb.append("null");
    } else {
      sb.append(this.column_family);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("column_qualifier:");
    if (this.column_qualifier == null) {
      sb.append("null");
    } else {
      sb.append(this.column_qualifier);
    }
    first = false;
    if (isSetTimestamp()) {
      if (!first) sb.append(", ");
      sb.append("timestamp:");
      sb.append(this.timestamp);
      first = false;
    }
    if (isSetRevision()) {
      if (!first) sb.append(", ");
      sb.append("revision:");
      sb.append(this.revision);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("flag:");
    sb.append(this.flag);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

