/*
 * CoadunationRDFResources: The rdf resource object mappings.
 * Copyright (C) 2009  Rift IT Contracting
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * Email.java
 */

package com.rift.coad.rdf.objmapping.client.base;

/**
 * This object represents an ip address
 * 
 * @author brett chaldecott
 */
public class Email extends DataType {
    private String value;

    
    /**
     * Default contructor
     */
    public Email() {
    }
    
    
    /**
     * The constructor that sets the email address.
     * 
     * @param address The email address.
     */
    public Email(String value) {
        this.value = value;
    }

    
    /**
     * This method returns the address.
     * 
     * @return The string containing the address.
     */
    public String getValue() {
        return value;
    }
    
    
    /**
     * The setter that returns the address.
     * 
     * @param address The new address value.
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    
    /**
     * This method checks to see if the object passed in is the same as this one.
     * 
     * @param obj The object to perform the check on.
     * @return TRUE if equal FALSE if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Email other = (Email) obj;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }
    
    
    /**
     * This method returns the hash code for the object.
     * 
     * @return This method returns the current hash code for this object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }

    
    /**
     * This method returns the string value of this object.
     * 
     * @return The string containing the address.
     */
    @Override
    public String toString() {
        return this.value;
    }
    
    
    
    
    
}
