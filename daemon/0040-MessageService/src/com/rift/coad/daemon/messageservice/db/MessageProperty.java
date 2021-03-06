package com.rift.coad.daemon.messageservice.db;
// Generated Feb 19, 2007 7:55:38 AM by Hibernate Tools 3.2.0.beta6a



/**
 * MessageProperty generated by hbm2java
 */
public class MessageProperty  implements java.io.Serializable {

    // Fields    

     /**
      * 		       auto_increment
 * 		    
     */
     private Integer id;
     private String name;
     private Integer boolValue;
     private Integer byteValue;
     private Double doubleValue;
     private Float floatValue;
     private Integer intValue;
     private Long longValue;
     private String stringValue;
     private byte[] objectValue;
     private Message message;

     // Constructors

    /** default constructor */
    public MessageProperty() {
    }

	/** minimal constructor */
    public MessageProperty(String name) {
        this.name = name;
    }
    /** full constructor */
    public MessageProperty(String name, Integer boolValue, Integer byteValue, Double doubleValue, Float floatValue, Integer intValue, Long longValue, String stringValue, byte[] objectValue, Message message) {
       this.name = name;
       this.boolValue = boolValue;
       this.byteValue = byteValue;
       this.doubleValue = doubleValue;
       this.floatValue = floatValue;
       this.intValue = intValue;
       this.longValue = longValue;
       this.stringValue = stringValue;
       this.objectValue = objectValue;
       this.message = message;
    }
    
   
    // Property accessors
    /**       
     *      * 		       auto_increment
     * 		    
     */
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Integer getBoolValue() {
        return this.boolValue;
    }
    
    public void setBoolValue(Integer boolValue) {
        this.boolValue = boolValue;
    }
    public Integer getByteValue() {
        return this.byteValue;
    }
    
    public void setByteValue(Integer byteValue) {
        this.byteValue = byteValue;
    }
    public Double getDoubleValue() {
        return this.doubleValue;
    }
    
    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }
    public Float getFloatValue() {
        return this.floatValue;
    }
    
    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
    }
    public Integer getIntValue() {
        return this.intValue;
    }
    
    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }
    public Long getLongValue() {
        return this.longValue;
    }
    
    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }
    public String getStringValue() {
        return this.stringValue;
    }
    
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
    public byte[] getObjectValue() {
        return this.objectValue;
    }
    
    public void setObjectValue(byte[] objectValue) {
        this.objectValue = objectValue;
    }
    public Message getMessage() {
        return this.message;
    }
    
    public void setMessage(Message message) {
        this.message = message;
    }




}


