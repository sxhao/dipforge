/*
 * CoaduntionSemantics: The semantic library for coadunation os
 * Copyright (C) 2012  Rift IT Contracting
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
 * BasicJenaEscaper.java
 */

// package path
package com.rift.coad.rdf.semantic.persistance.jena;

/**
 * This object is responsible for managing the escaping tools for various
 * @author brett chaldecott
 */
public class BasicJenaEscaper implements JenaEscaper {

    public BasicJenaEscaper() {
    }

    
    /**
     * This method is used to escape the string.
     * 
     * @param value The string containing the value to escape
     * @return The result
     */
    public String escape(String value) {
        return value;
    }
    
    
}
