/*
 * CoadunationLib: The coaduntion implementation library.
 * Copyright (C) 2006  Rift IT Contracting
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
 * LoginException.java
 *
 * The login exception generated by the login related classes and interfaces.
 */

// package path
package com.rift.coad.lib.security.login;

// imports
import com.rift.coad.lib.security.SecurityException;

/**
 * The login exception generated by the login related classes and interfaces.
 *
 * @author Brett Chaldecott
 */
public class LoginException extends SecurityException {
    
    /**
     * Creates a new instance of <code>LoginException</code> without detail message.
     *
     * @param msg the detail message.
     */
    public LoginException(String msg) {
        super(msg);
    }
    
    
    /**
     * Constructs an instance of <code>LoginException</code> with the specified detail message.
     *
     * @param msg the detail message.
     * @param ex The exception stack.
     */
    public LoginException(String msg, Throwable ex) {
        super(msg,ex);
    }
}