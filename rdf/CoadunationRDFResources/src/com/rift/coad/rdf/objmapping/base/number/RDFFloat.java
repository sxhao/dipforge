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
 * RDFLong.java
 */

// package path
package com.rift.coad.rdf.objmapping.base.number;

// semantic imports
import com.rift.coad.rdf.objmapping.base.ComparisonOperators;
import com.rift.coad.rdf.objmapping.base.DataType;
import com.rift.coad.rdf.objmapping.exception.ObjException;
import thewebsemantic.Identifier;
import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;
import thewebsemantic.RdfType;


// coadunation imports
import com.rift.coad.rdf.objmapping.base.RDFNumber;

/**
 * This object represents a float in the database
 *
 * @author brett chaldecott
 */
@Namespace("http://www.coadunation.net/schema/rdf/1.0/base#")
@RdfType("RDFFloat")
public class RDFFloat extends RDFNumber implements ComparisonOperators {

    // private member variables
    private Float value = (float)0.0;

    /**
     * The default constructor.
     */
    public RDFFloat() {
    }

    /**
     * This constructor sets the value.
     *
     * @param value The new value.
     */
    public RDFFloat(float value) {
        this.value = value;
    }


    /**
     * This method returns the unique identifier for this object.
     *
     * @return This method returns the id of the object.
     */
    @Override
    public String getObjId() {
        if (value == null) {
            return "";
        }
        return value.toString();
    }


    /**
     * This method returns the float value.
     *
     * @return The long value.
     */
    @RdfProperty("http://www.coadunation.net/schema/rdf/1.0/base#RDFFloatValue")
    @Identifier()
    public float getValue() {
        if (value == null) {
            return 0;
        }
        return value;
    }


    /**
     * This method sets the float value.
     *
     * @param value The float value to set.
     */
    @RdfProperty("http://www.coadunation.net/schema/rdf/1.0/base#RDFFloatValue")
    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        // make the parent call
        if (!super.equals(obj)) {
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RDFFloat other = (RDFFloat) obj;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        if (value == null) {
            return "";
        }
        return this.value.toString();
    }


    /**
     * This method checks to see if the values are less than.
     * 
     * @param value The value to perform the comparison against.
     * @return TRUE if less than, FALSE if not.
     * @throws com.rift.coad.rdf.objmapping.exception.ObjException
     */
    public boolean lessThan(DataType value) throws ObjException {
        if (value == null) {
            throw new java.lang.NullPointerException("Null value");
        }
        if (value instanceof RDFLong) {
            RDFLong other = (RDFLong)value;
            return this.value < other.getValue();
        } else if (value instanceof RDFDouble) {
            RDFDouble other = (RDFDouble)value;
            return this.value < other.getValue();
        } else if (value instanceof RDFFloat) {
            RDFFloat other = (RDFFloat)value;
            return this.value < other.getValue();
        } else if (value instanceof RDFInteger) {
            RDFInteger other = (RDFInteger)value;
            return this.value < other.getValue();
        }
        throw new java.lang.UnsupportedOperationException(
                "Cannot perform the less than operation on these two types");
    }


    /**
     * This method returns true if the greater than comparison succeeds.
     *
     * @param value The value to perform the comparison on.
     * @return TRUE if greater than, FALSE if not.
     * @throws com.rift.coad.rdf.objmapping.exception.ObjException
     */
    public boolean greaterThan(DataType value) throws ObjException {
        if (value == null) {
            throw new java.lang.NullPointerException("Null value");
        }
        if (value instanceof RDFLong) {
            RDFLong other = (RDFLong)value;
            return this.value > other.getValue();
        } else if (value instanceof RDFDouble) {
            RDFDouble other = (RDFDouble)value;
            return this.value > other.getValue();
        } else if (value instanceof RDFFloat) {
            RDFFloat other = (RDFFloat)value;
            return this.value > other.getValue();
        } else if (value instanceof RDFInteger) {
            RDFInteger other = (RDFInteger)value;
            return this.value > other.getValue();
        }
        throw new java.lang.UnsupportedOperationException(
                "Cannot perform the greater than operation on these two types");
    }

    
    /**
     * This method returns true if the VALUES within are equal.
     *
     * @param value The value to perform the comparison on.
     * @return TRUE if the values
     * @throws com.rift.coad.rdf.objmapping.exception.ObjException
     */
    public boolean equalValue(DataType value) throws ObjException {
        if (value == null) {
            throw new java.lang.NullPointerException("Null value");
        }
        if (value instanceof RDFLong) {
            RDFLong other = (RDFLong)value;
            return this.value == other.getValue();
        } else if (value instanceof RDFDouble) {
            RDFDouble other = (RDFDouble)value;
            return this.value == other.getValue();
        } else if (value instanceof RDFFloat) {
            RDFFloat other = (RDFFloat)value;
            return this.value == other.getValue();
        } else if (value instanceof RDFInteger) {
            RDFInteger other = (RDFInteger)value;
            return this.value == other.getValue();
        }
        throw new java.lang.UnsupportedOperationException(
                "Cannot perform the equal value operation on these two types");
    }
}
