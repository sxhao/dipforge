/*
 * CoadunationTypeManage: The resource type manager.
 * Copyright (C) 2011  Rift IT Contracting
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
 * RDFDataType.java
 */

package com.rift.coad.type.manager.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * This class contains type information
 *
 * @author brett chaldecott
 */
public class RDFDataType implements IsSerializable {

    private String namespace;
    private String localName;


    /**
     * The default constructor.
     */
    public RDFDataType() {
    }


    /**
     * The RDF data type information.
     *
     * @param namespace The name space information.
     * @param localName The local name.
     */
    public RDFDataType(String namespace, String localName) {
        this.namespace = namespace;
        this.localName = localName;
    }



    /**
     * This method returns the local name of this object.
     *
     * @return The local name of this object.
     */
    public String getLocalName() {
        return localName;
    }


    /**
     * This method sets the local name.
     *
     * @param localName The local name.
     */
    public void setLocalName(String localName) {
        this.localName = localName;
    }


    /**
     * This method retrieve the name space for this type.
     *
     * @return The string containing the namespace.
     */
    public String getNamespace() {
        return namespace;
    }


    /**
     * This method sets the name space for the object.
     *
     * @param namespace The namespace for the object.
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }


    /**
     * This method performs an equals operation.
     *
     * @param obj The object to perform the comparison on.
     * @return TRUE if equals, FALSE if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RDFDataType other = (RDFDataType) obj;
        if ((this.namespace == null) ? (other.namespace != null) : !this.namespace.equals(other.namespace)) {
            return false;
        }
        if ((this.localName == null) ? (other.localName != null) : !this.localName.equals(other.localName)) {
            return false;
        }
        return true;
    }


    /**
     * The hash code value.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.namespace != null ? this.namespace.hashCode() : 0);
        hash = 53 * hash + (this.localName != null ? this.localName.hashCode() : 0);
        return hash;
    }


    /**
     * The string representation of this object.
     *
     * @return The string.
     */
    @Override
    public String toString() {
        return "RDFDataType{" + "namespace=" + namespace + "localName=" + localName + '}';
    }

    


}
