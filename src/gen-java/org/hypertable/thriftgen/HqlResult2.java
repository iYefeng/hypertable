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
 * Same as HqlResult except with cell as array
 */
public class HqlResult2 implements TBase<HqlResult2, HqlResult2._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("HqlResult2");

  private static final TField RESULTS_FIELD_DESC = new TField("results", TType.LIST, (short)1);
  private static final TField CELLS_FIELD_DESC = new TField("cells", TType.LIST, (short)2);
  private static final TField SCANNER_FIELD_DESC = new TField("scanner", TType.I64, (short)3);
  private static final TField MUTATOR_FIELD_DESC = new TField("mutator", TType.I64, (short)4);

  public List<String> results;
  public List<List<String>> cells;
  public long scanner;
  public long mutator;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    RESULTS((short)1, "results"),
    CELLS((short)2, "cells"),
    SCANNER((short)3, "scanner"),
    MUTATOR((short)4, "mutator");

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
        case 1: // RESULTS
          return RESULTS;
        case 2: // CELLS
          return CELLS;
        case 3: // SCANNER
          return SCANNER;
        case 4: // MUTATOR
          return MUTATOR;
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
  private static final int __SCANNER_ISSET_ID = 0;
  private static final int __MUTATOR_ISSET_ID = 1;
  private BitSet __isset_bit_vector = new BitSet(2);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULTS, new FieldMetaData("results", TFieldRequirementType.OPTIONAL, 
        new ListMetaData(TType.LIST, 
            new FieldValueMetaData(TType.STRING))));
    tmpMap.put(_Fields.CELLS, new FieldMetaData("cells", TFieldRequirementType.OPTIONAL, 
        new ListMetaData(TType.LIST, 
            new FieldValueMetaData(TType.LIST            , "CellAsArray"))));
    tmpMap.put(_Fields.SCANNER, new FieldMetaData("scanner", TFieldRequirementType.OPTIONAL, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.MUTATOR, new FieldMetaData("mutator", TFieldRequirementType.OPTIONAL, 
        new FieldValueMetaData(TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(HqlResult2.class, metaDataMap);
  }

  public HqlResult2() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public HqlResult2(HqlResult2 other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetResults()) {
      List<String> __this__results = new ArrayList<String>();
      for (String other_element : other.results) {
        __this__results.add(other_element);
      }
      this.results = __this__results;
    }
    if (other.isSetCells()) {
      List<List<String>> __this__cells = new ArrayList<List<String>>();
      for (List<String> other_element : other.cells) {
        __this__cells.add(other_element);
      }
      this.cells = __this__cells;
    }
    this.scanner = other.scanner;
    this.mutator = other.mutator;
  }

  public HqlResult2 deepCopy() {
    return new HqlResult2(this);
  }

  @Deprecated
  public HqlResult2 clone() {
    return new HqlResult2(this);
  }

  public int getResultsSize() {
    return (this.results == null) ? 0 : this.results.size();
  }

  public java.util.Iterator<String> getResultsIterator() {
    return (this.results == null) ? null : this.results.iterator();
  }

  public void addToResults(String elem) {
    if (this.results == null) {
      this.results = new ArrayList<String>();
    }
    this.results.add(elem);
  }

  public List<String> getResults() {
    return this.results;
  }

  public HqlResult2 setResults(List<String> results) {
    this.results = results;
    return this;
  }

  public void unsetResults() {
    this.results = null;
  }

  /** Returns true if field results is set (has been asigned a value) and false otherwise */
  public boolean isSetResults() {
    return this.results != null;
  }

  public void setResultsIsSet(boolean value) {
    if (!value) {
      this.results = null;
    }
  }

  public int getCellsSize() {
    return (this.cells == null) ? 0 : this.cells.size();
  }

  public java.util.Iterator<List<String>> getCellsIterator() {
    return (this.cells == null) ? null : this.cells.iterator();
  }

  public void addToCells(List<String> elem) {
    if (this.cells == null) {
      this.cells = new ArrayList<List<String>>();
    }
    this.cells.add(elem);
  }

  public List<List<String>> getCells() {
    return this.cells;
  }

  public HqlResult2 setCells(List<List<String>> cells) {
    this.cells = cells;
    return this;
  }

  public void unsetCells() {
    this.cells = null;
  }

  /** Returns true if field cells is set (has been asigned a value) and false otherwise */
  public boolean isSetCells() {
    return this.cells != null;
  }

  public void setCellsIsSet(boolean value) {
    if (!value) {
      this.cells = null;
    }
  }

  public long getScanner() {
    return this.scanner;
  }

  public HqlResult2 setScanner(long scanner) {
    this.scanner = scanner;
    setScannerIsSet(true);
    return this;
  }

  public void unsetScanner() {
    __isset_bit_vector.clear(__SCANNER_ISSET_ID);
  }

  /** Returns true if field scanner is set (has been asigned a value) and false otherwise */
  public boolean isSetScanner() {
    return __isset_bit_vector.get(__SCANNER_ISSET_ID);
  }

  public void setScannerIsSet(boolean value) {
    __isset_bit_vector.set(__SCANNER_ISSET_ID, value);
  }

  public long getMutator() {
    return this.mutator;
  }

  public HqlResult2 setMutator(long mutator) {
    this.mutator = mutator;
    setMutatorIsSet(true);
    return this;
  }

  public void unsetMutator() {
    __isset_bit_vector.clear(__MUTATOR_ISSET_ID);
  }

  /** Returns true if field mutator is set (has been asigned a value) and false otherwise */
  public boolean isSetMutator() {
    return __isset_bit_vector.get(__MUTATOR_ISSET_ID);
  }

  public void setMutatorIsSet(boolean value) {
    __isset_bit_vector.set(__MUTATOR_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RESULTS:
      if (value == null) {
        unsetResults();
      } else {
        setResults((List<String>)value);
      }
      break;

    case CELLS:
      if (value == null) {
        unsetCells();
      } else {
        setCells((List<List<String>>)value);
      }
      break;

    case SCANNER:
      if (value == null) {
        unsetScanner();
      } else {
        setScanner((Long)value);
      }
      break;

    case MUTATOR:
      if (value == null) {
        unsetMutator();
      } else {
        setMutator((Long)value);
      }
      break;

    }
  }

  public void setFieldValue(int fieldID, Object value) {
    setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESULTS:
      return getResults();

    case CELLS:
      return getCells();

    case SCANNER:
      return new Long(getScanner());

    case MUTATOR:
      return new Long(getMutator());

    }
    throw new IllegalStateException();
  }

  public Object getFieldValue(int fieldId) {
    return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    switch (field) {
    case RESULTS:
      return isSetResults();
    case CELLS:
      return isSetCells();
    case SCANNER:
      return isSetScanner();
    case MUTATOR:
      return isSetMutator();
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
    if (that instanceof HqlResult2)
      return this.equals((HqlResult2)that);
    return false;
  }

  public boolean equals(HqlResult2 that) {
    if (that == null)
      return false;

    boolean this_present_results = true && this.isSetResults();
    boolean that_present_results = true && that.isSetResults();
    if (this_present_results || that_present_results) {
      if (!(this_present_results && that_present_results))
        return false;
      if (!this.results.equals(that.results))
        return false;
    }

    boolean this_present_cells = true && this.isSetCells();
    boolean that_present_cells = true && that.isSetCells();
    if (this_present_cells || that_present_cells) {
      if (!(this_present_cells && that_present_cells))
        return false;
      if (!this.cells.equals(that.cells))
        return false;
    }

    boolean this_present_scanner = true && this.isSetScanner();
    boolean that_present_scanner = true && that.isSetScanner();
    if (this_present_scanner || that_present_scanner) {
      if (!(this_present_scanner && that_present_scanner))
        return false;
      if (this.scanner != that.scanner)
        return false;
    }

    boolean this_present_mutator = true && this.isSetMutator();
    boolean that_present_mutator = true && that.isSetMutator();
    if (this_present_mutator || that_present_mutator) {
      if (!(this_present_mutator && that_present_mutator))
        return false;
      if (this.mutator != that.mutator)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(HqlResult2 other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    HqlResult2 typedOther = (HqlResult2)other;

    lastComparison = Boolean.valueOf(isSetResults()).compareTo(typedOther.isSetResults());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResults()) {      lastComparison = TBaseHelper.compareTo(this.results, typedOther.results);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCells()).compareTo(typedOther.isSetCells());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCells()) {      lastComparison = TBaseHelper.compareTo(this.cells, typedOther.cells);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetScanner()).compareTo(typedOther.isSetScanner());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetScanner()) {      lastComparison = TBaseHelper.compareTo(this.scanner, typedOther.scanner);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMutator()).compareTo(typedOther.isSetMutator());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMutator()) {      lastComparison = TBaseHelper.compareTo(this.mutator, typedOther.mutator);
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
        case 1: // RESULTS
          if (field.type == TType.LIST) {
            {
              TList _list8 = iprot.readListBegin();
              this.results = new ArrayList<String>(_list8.size);
              for (int _i9 = 0; _i9 < _list8.size; ++_i9)
              {
                String _elem10;
                _elem10 = iprot.readString();
                this.results.add(_elem10);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // CELLS
          if (field.type == TType.LIST) {
            {
              TList _list11 = iprot.readListBegin();
              this.cells = new ArrayList<List<String>>(_list11.size);
              for (int _i12 = 0; _i12 < _list11.size; ++_i12)
              {
                List<String> _elem13;
                {
                  TList _list14 = iprot.readListBegin();
                  _elem13 = new ArrayList<String>(_list14.size);
                  for (int _i15 = 0; _i15 < _list14.size; ++_i15)
                  {
                    String _elem16;
                    _elem16 = iprot.readString();
                    _elem13.add(_elem16);
                  }
                  iprot.readListEnd();
                }
                this.cells.add(_elem13);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // SCANNER
          if (field.type == TType.I64) {
            this.scanner = iprot.readI64();
            setScannerIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // MUTATOR
          if (field.type == TType.I64) {
            this.mutator = iprot.readI64();
            setMutatorIsSet(true);
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
    if (this.results != null) {
      if (isSetResults()) {
        oprot.writeFieldBegin(RESULTS_FIELD_DESC);
        {
          oprot.writeListBegin(new TList(TType.STRING, this.results.size()));
          for (String _iter17 : this.results)
          {
            oprot.writeString(_iter17);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (this.cells != null) {
      if (isSetCells()) {
        oprot.writeFieldBegin(CELLS_FIELD_DESC);
        {
          oprot.writeListBegin(new TList(TType.LIST, this.cells.size()));
          for (List<String> _iter18 : this.cells)
          {
            {
              oprot.writeListBegin(new TList(TType.STRING, _iter18.size()));
              for (String _iter19 : _iter18)
              {
                oprot.writeString(_iter19);
              }
              oprot.writeListEnd();
            }
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
    }
    if (isSetScanner()) {
      oprot.writeFieldBegin(SCANNER_FIELD_DESC);
      oprot.writeI64(this.scanner);
      oprot.writeFieldEnd();
    }
    if (isSetMutator()) {
      oprot.writeFieldBegin(MUTATOR_FIELD_DESC);
      oprot.writeI64(this.mutator);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("HqlResult2(");
    boolean first = true;

    if (isSetResults()) {
      sb.append("results:");
      if (this.results == null) {
        sb.append("null");
      } else {
        sb.append(this.results);
      }
      first = false;
    }
    if (isSetCells()) {
      if (!first) sb.append(", ");
      sb.append("cells:");
      if (this.cells == null) {
        sb.append("null");
      } else {
        sb.append(this.cells);
      }
      first = false;
    }
    if (isSetScanner()) {
      if (!first) sb.append(", ");
      sb.append("scanner:");
      sb.append(this.scanner);
      first = false;
    }
    if (isSetMutator()) {
      if (!first) sb.append(", ");
      sb.append("mutator:");
      sb.append(this.mutator);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

