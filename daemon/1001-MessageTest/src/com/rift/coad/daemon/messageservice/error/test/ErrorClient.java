/*
 * MessageQueueClient: The message queue client library
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
 * ErrorClient.java
 */

// package path
package com.rift.coad.daemon.messageservice.error.test;

// java imports
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The definition of the error client interface interface.
 *
 * @author Brett Chaldecott
 */
public interface ErrorClient extends Remote {
    
    /**
     * The jndi url of the error client
     */
    public final static String JNDI_URL = "messagetest/ErrorClient";
    
    /**
     * This method is called to test the error routing.
     *
     * @param number The number of error messages.
     * @exception ErrorTestException
     * @exception RemoteException
     */
    public void testErrorRouting(int number) throws ErrorTestException,
            RemoteException;
}
