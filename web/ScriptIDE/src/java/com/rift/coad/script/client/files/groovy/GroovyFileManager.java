/*
 * ScriptIDE: The coadunation ide for editing scripts in coadunation.
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
 * GroovyFileManager.java
 */

// package path
package com.rift.coad.script.client.files.groovy;

// imports
import com.google.gwt.user.client.rpc.RemoteService;
import java.util.List;

/**
 * The file manager responsible for providing access to the groovy file information.
 *
 * @author brett chaldecott
 */
public interface GroovyFileManager extends RemoteService{
    /**
     * The file manager.
     *
     * @return The list of scopes.
     * @throws com.rift.coad.script.client.files.groovy.GroovyFileManagerException
     */
    public List<String> listScopes() throws GroovyFileManagerException;


    /**
     * This method returns list of files.
     *
     * @param scope The scope to perform the search on.
     * @return The list of files.
     * @throws com.rift.coad.script.client.files.groovy.GroovyFileManagerException
     */
    public List<com.rift.coad.script.broker.client.rdf.RDFScriptInfo>
            listFiles(String scope) throws GroovyFileManagerException;


    /**
     * This method is called to create the file.
     *
     * @param type The type of file to create.
     * @param scope The scope of the file.
     * @param name The name of the file.
     * @throws com.rift.coad.script.client.files.groovy.GroovyFileManagerException
     */
    public void createFile(String type, String scope, String name)
            throws GroovyFileManagerException;


    /**
     * This method is called to delete a file.
     *
     * @param scope The name space of the file.
     * @param name The name of the file.
     * @throws com.rift.coad.script.client.files.groovy.GroovyFileManagerException
     */
    public void deleteFile(String scope, String name)
            throws GroovyFileManagerException;
}
