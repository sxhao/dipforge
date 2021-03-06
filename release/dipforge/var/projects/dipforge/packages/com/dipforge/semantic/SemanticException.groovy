/*
 * dipforge: Description
 * Copyright (C) Tue Apr 24 13:15:37 SAST 2012 owner 
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
 * SemanticException.groovy
 */

package com.dipforge.semantic


/**
 * This exception is thrown when there is an exception with the semantic libraries.
 * 
 * @author brett chaldecott
 */
class SemanticException extends Exception {
    
    /**
     * The default constructor
     */
    public SemanticException() {
        super("Semantic exception");
    }
    
    
    /**
     * This constructor sets up the semantic exception
     * 
     * @param msg The message to throw
     */
    public SemanticException(String msg) {
        super(msg)
    }
}
