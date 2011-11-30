/*
 * GroovyDaemonClient: The client libraries for the groovy data mapper.
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
 * GroovyManager.java
 */

package com.rift.coad.groovy;

// java imports
import com.rift.coad.rdf.semantic.RDFFormats;
import com.rift.coad.rdf.semantic.SPARQLResultRow;
import com.rift.coad.rdf.semantic.Session;
import java.rmi.RemoteException;
import java.util.List;

// log 4j imports
import org.apache.log4j.Logger;

// coadunation import
import com.rift.coad.util.connection.ConnectionManager;
import java.util.ArrayList;


/**
 * This object is responsible for managing the groovy environment.
 *
 * @author brett chaldecott
 */
public class GroovyManager implements GroovyManagerMBean {


    // private member variables
    private static Logger log = Logger.getLogger(GroovyManager.class);

    /**
     * The default constructor
     */
    public GroovyManager() {
    }


    /**
     * This method returns the version information.
     *
     * @return The string containing the version information.
     * @throws java.rmi.RemoteException
     */
    public String getVersion() {
        return "1.0";
    }


    /**
     * This method returns the name of the groovy manager.
     *
     * @return The string containing the name of the groovy manager.
     */
    public String getName() {
        return this.getClass().getName();
    }


    /**
     * This method returns the description of the groovy manager.
     *
     * @return The string containing the description of the groovy manager.
     */
    public String getDescription() {
        return "The groovy manager.";
    }


    /**
     * This method executes the script path and xml.
     *
     * @param scriptPath The path to the script.
     * @param xmlParameters The xml parameters.
     * @return The result of the execution.
     * @throws com.rift.coad.groovy.GroovyDaemonException
     */
    public String execute(String project, String path) throws GroovyDaemonException {
        return null;
    }
    
    
    /**
     * This method is called to execute an exposed groovy method.
     * 
     * @param methodId The id of the method to execute.
     * @param xmlInput The xml input to use.
     * @return The results of the execution.
     * @throws GroovyDaemonException
     * @throws RemoteException 
     */
    public String executeMethod(String methodId, String xmlInput) throws GroovyDaemonException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
