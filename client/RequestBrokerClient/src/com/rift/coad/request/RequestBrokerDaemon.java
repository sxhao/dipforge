/*
 * RequestBrokerClient: The client libraries for the request broker.
 * Copyright (C) 2010  Rift IT Contracting
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
 * RequestBrokerDaemon.java
 */


// package path
package com.rift.coad.request;

// java imports
import com.rift.coad.change.request.Request;
import java.rmi.Remote;
import java.rmi.RemoteException;

// coadunation imports
import java.util.List;

/**
 * This daemon is responsible for manager the request broker.
 *
 * @author brett chaldecott
 */
public interface RequestBrokerDaemon extends Remote{


    /**
     * This method creates a new request.
     *
     * @param request The request to create.
     * @throws com.rift.coad.request.RequestBrokerException
     * @throws java.rmi.RemoteException
     * @throws RequestBrokerAccessDenied
     */
    public void createRequest(Request request) throws RequestBrokerException,
            RequestBrokerAccessDenied, RemoteException;


    /**
     * This method returns a list of all the requests.
     *
     * @return The string containing the list of requests.
     * @throws com.rift.coad.request.RequestBrokerException
     * @throws java.rmi.RemoteException
     */
    public List<String> listRequests() throws RequestBrokerException, RemoteException;


    /**
     * This method returns the request id.
     *
     * @param id The id of the request to retrieve the request for.
     * @return The request.
     * @throws com.rift.coad.request.RequestBrokerException
     * @throws java.rmi.RemoteException
     */
    public Request getRequest(String id) throws RequestBrokerException, RemoteException;


    /**
     * This method returns the request information.
     *
     * @param id The id of the request.
     * @return The reference to the request.
     * @throws com.rift.coad.request.RequestBrokerException
     * @throws java.rmi.RemoteException
     */
    public RequestInfo getRequestInfo(String id) throws RequestBrokerException, RemoteException;


    /**
     * This method is used to remove the request from the system.
     *
     * @param id The id of the request to remove.
     * @throws com.rift.coad.request.RequestBrokerException
     * @throws java.rmi.RemoteException
     */
    public void removeRequest(String id) throws RequestBrokerException, RemoteException;


    /**
     * This method is called to remove the request information and not the complete request.
     *
     * @param id The id of the request to remove.
     * @throws com.rift.coad.request.RequestBrokerException
     * @throws java.rmi.RemoteException
     */
    public void removeRequestInfo(String id) throws RequestBrokerException, RemoteException;
    
    
    
    /**
     * This method returns the list of requests for the given target uri.
     * 
     * @param targetUri The target uri.
     * @return The target uri
     * @throws RequestBrokerException
     * @throws RemoteException 
     */
    public List<String> listRequestsForTarget(String targetUri) throws RequestBrokerException, RemoteException;
    
    
    /**
     * This method returns true if the given target uri has a request on it.
     * 
     * @param targetUri The uri to perform the request on.
     * @return TRUE if there is a request for this uri.
     * @throws RequestBrokerException
     * @throws RemoteException 
     */
    public boolean hasRequestForTarget(String targetUri) throws RequestBrokerException, RemoteException;
}
