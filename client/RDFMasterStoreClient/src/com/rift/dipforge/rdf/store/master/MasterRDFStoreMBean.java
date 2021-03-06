/*
 * RDFMasterStoreClient: The rdf store daemon client.
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
 * RDFStoreDaemon.java
 */

package com.rift.dipforge.rdf.store.master;

import com.rift.coad.annotation.MethodInfo;
import com.rift.coad.annotation.ParamInfo;
import com.rift.coad.annotation.Result;
import com.rift.coad.annotation.Version;
import java.rmi.RemoteException;

/**
 *
 * @author brettc
 */
public interface MasterRDFStoreMBean {

    /**
     * This method returns the name of the tomcat daemon.
     */
    @MethodInfo(description="This method returns the name of the tomcat daemon.")
    @Version(number="1.0")
    @Result(description="The string containing the name.")
    public String getName() throws RemoteException;


    /**
     * This method returns the description of the tom cat daemon.
     */
    @MethodInfo(description="This method returns the description of the tom cat daemon.")
    @Version(number="1.0")
    @Result(description="The string containing the description")
    public String getDescription() throws RemoteException;


    /**
     * This method returns the version of this daemon.
     */
    @MethodInfo(description="This method returns the version of this daemon.")
    @Version(number="1.0")
    @Result(description="The string containing the version")
    public String getVersion() throws RemoteException;



    /**
     * This method returns the stats for the master store.
     *
     * @return This method returns the stats for the store master.
     * @throws RemoteException
     */
    @MethodInfo(description="This method returns the version of this daemon.")
    @Version(number="1.0")
    @Result(description="The string containing the version")
    public String getStats() throws RemoteException;
    
    
    /**
     * This method is called to persist the changes
     * @param action
     * @param rdfXML
     * @throws MasterRDFStoreException
     * @throws RemoteException 
     */
    @MethodInfo(description="Persist the XML RDF information in the store and propergate the change.")
    @Version(number="1.0")
    public void persist(
            @ParamInfo(name="action",
            description="The action being performed on the store.")String action,
            @ParamInfo(name="rdfXML",
            description="The information to persist.")String rdfXML) throws MasterRDFStoreException,
            RemoteException;
}
