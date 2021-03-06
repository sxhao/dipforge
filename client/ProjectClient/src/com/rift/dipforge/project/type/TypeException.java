/*
 * ProjectClient: The project client interface.
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
 * TypeException.java
 */

package com.rift.dipforge.project.type;

/**
 * The type exception object.
 *
 * @author brett chaldecott
 */
public class TypeException extends Exception {

    /**
     * Creates a new instance of <code>TypeException</code> without detail message.
     */
    public TypeException() {
    }


    /**
     * Constructs an instance of <code>TypeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public TypeException(String msg) {
        super(msg);
    }


    /**
     * Constructs an instance of <code>TypeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public TypeException(String msg, Exception ex) {
        super(msg,ex);
    }
}
