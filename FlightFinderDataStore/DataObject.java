/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightFinderDataStore;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Willie Holmes
 */
public abstract class DataObject extends DataFactory {

    protected final String dataTable = "";

    protected String uuid;
    protected String Name;
    protected String Code;
    protected int CarrierId;
    protected int PlaceId;
    protected String Type;
    protected String SkyscannerCode; 
    protected String code;
    protected String symbol;
    protected String thousandsSeparator;
    protected String decimalSeparator;
    protected boolean symbolOnLeft;
    protected boolean spaceBetweenAmountAndSymbol;
    protected int roundingCoefficient;
    protected int decimalDigits;

    public DataObject() {
        this.setUuid(DataObject.generateUuid());
    }

    public DataObject loadByName(String _Name) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Name", _Name);
        return this.loadByCondition(map);
    }

    public DataObject loadByUuid(String _uuid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uuid", _uuid);
        return this.loadByCondition(map);
    }
      public DataObject loadByCode(String _Code) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Code", _Code);
        return this.loadByCondition(map);
    }
  public DataObject loadByCarrierId(int _CarrierId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("CarrierId", Integer.toString(_CarrierId));
        return this.loadByCondition(map);
    }
    public DataObject loadByPlaceId(int _PlaceId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("PlaceId", Integer.toString(_PlaceId));
        return this.loadByCondition(map);
    }
      public DataObject loadByType(String _Type) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Type", _Type);
        return this.loadByCondition(map);
    }
        public DataObject loadBySkyscannerCode(String _SkyscannerCode) {
        HashMap<String, String> map = new HashMap<>();
        map.put("SkyscannerCode", _SkyscannerCode);
        return this.loadByCondition(map);
    }
     
        public DataObject loadBycode(String _code) {
        HashMap<String, String> map = new HashMap<>();
        map.put("code", _code);
        return this.loadByCondition(map);
    }
            public DataObject loadBysymbol(String _symbol) {
        HashMap<String, String> map = new HashMap<>();
        map.put("symbol", _symbol);
        return this.loadByCondition(map);
    }
        public DataObject loadBythousandsSeparator(String _thousandsSeparator) {
        HashMap<String, String> map = new HashMap<>();
        map.put("thousandsSeparator", _thousandsSeparator);
        return this.loadByCondition(map);
    }
        public DataObject loadBydecimalSeparator(String _decimalSeparator) {
        HashMap<String, String> map = new HashMap<>();
        map.put("decimalSeparator", _decimalSeparator);
        return this.loadByCondition(map);
    }
      /*   public DataObject loadBysymbolOnLeft(boolean _symbolOnLeft) {
        HashMap<String, String> map = new HashMap<>();
        map.put("symbolOnLeft", _symbolOnLeft);
        return this.loadByCondition(map);
    } 
        public DataObject loadBy spaceBetweenAmountAndSymbolboolean _ spaceBetweenAmountAndSymbol) {
        HashMap<String, String> map = new HashMap<>();
        map.put(" spaceBetweenAmountAndSymbol", _ spaceBetweenAmountAndSymbol);
        return this.loadByCondition(map);
    } 
        
        */
       public DataObject loadByroundingCoefficient(int _roundingCoefficient) {
        HashMap<String, String> map = new HashMap<>();
        map.put("roundingCoefficient", Integer.toString(_roundingCoefficient));
        return this.loadByCondition(map);
    }
        public DataObject loadBydecimalDigits(int _decimalDigits) {
        HashMap<String, String> map = new HashMap<>();
        map.put("decimalDigits", Integer.toString(_decimalDigits));
        return this.loadByCondition(map);
    }
        
    public DataObject loadByCondition(String _name, String _value) {
        HashMap<String, String> map = new HashMap<>();
        map.put(_name, _value);
        return this.loadByCondition(map);
    }
/**

    
    protected String uuid;
    protected String Name;
    protected String Code;
    protected int CarrierId;
    protected int PlaceId;
    protected String Type;
    protected String SkyscannerCode; 
    protected String code;
    protected String symbol;
    protected String thousandsSeparator;
    protected String decimalSeparator;
    protected boolean symbolOnLeft;
    protected boolean spaceBetweenAmountAndSymbol;
    protected int roundingCoefficient;
    protected int decimalDigits;
*/
    protected static String generateUuid() {
        return UUID.randomUUID().toString();
    }

// ================================ GETTERS ====================================
    public String getUuid() {
        return this.uuid;
    }
    public String getName() {
        return this.Name;
    }
    public String getCode() {
        return this.Code;
    }

    public int getCarrierId() {
        return this.CarrierId;
    }
    public int getPlaceId() {
        return this.PlaceId;
    }
    
      public String getType() {
        return this.Type;
    }
      
        public String getSkyscannerCode() {
        return this.SkyscannerCode;
    }
        
        public String getcode() {
        return this.code;
    }
        
        public String getsymbol() {
        return this.symbol;
    }
        public String getthousandsSeparator() {
        return this.thousandsSeparator;
    }
        public String getdecimalSeparator() {
        return this.decimalSeparator;
    }
        
        public boolean getsymbolOnLeft() {
        return this.symbolOnLeft;
    }
        public boolean getspaceBetweenAmountAndSymbol() {
        return this.spaceBetweenAmountAndSymbol;
    }
        public int getroundingCoefficient() {
        return this.roundingCoefficient;
    }
        public int getdecimalDigits() {
        return this.decimalDigits;
    }
// ================================ SETTERS ====================================

    public void setUuid(String _uuid) {
        this.uuid = _uuid;
    }

    public void setName(String _Name) {
         this.Name = _Name;
    }
    public void setCode (String _Code) {
        this.Code = _Code;
    }

    public void setCarrierId (int _CarrierId) {
       this.CarrierId = _CarrierId;
    }
    public void  setPlaceId(int _PlaceId) {
         this.PlaceId=_PlaceId;
    }
    
      public void setType (String _Type) {
        this.Type = _Type;
    }
      
        public void setSkyscannerCode (String _SkyscannerCode) {
        this.SkyscannerCode = _SkyscannerCode;
    }
        
        public void setcode (String _code) {
        this.code = _code;
    }
        
        public void setsymbol (String _symbol) {
        this.symbol = _symbol;
    }
        public void setthousandsSeperator (String _thousandsSeparator) {
        this.thousandsSeparator = _thousandsSeparator;
    }
        public void setdecimalSeparator  (String _decimalSeparator) {
        this.decimalSeparator = _decimalSeparator;
    }
        
        public void setsymbolOnLeft (boolean _symbolOnLeft) {
        this.symbolOnLeft = _symbolOnLeft;
    }
        public void setspaceBetweenAmountAndSymbol (boolean _spaceBetweenAmountAndSymbol) {
        this.spaceBetweenAmountAndSymbol = _spaceBetweenAmountAndSymbol;
    }
        public void setroundingCoefficient (int _roundingCoefficient) {
        this.roundingCoefficient = _roundingCoefficient;
    }
        public void setdecimalDigits (int _decimalDigits) {
        this.decimalDigits = _decimalDigits;
    }
}
    
    
    

