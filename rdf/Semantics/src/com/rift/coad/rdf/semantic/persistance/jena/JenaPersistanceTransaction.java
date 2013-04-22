/*
 * Semantics: The semantic library for coadunation os
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
 * PersistanceSession.java
 */

// package path
package com.rift.coad.rdf.semantic.persistance.jena;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.shared.Lock;
import com.rift.coad.rdf.semantic.SessionManager;
import com.rift.coad.rdf.semantic.persistance.PersistanceException;
import com.rift.coad.rdf.semantic.persistance.PersistanceTransaction;
import org.apache.log4j.Logger;

/**
 * This interface defines the methods to manage a transaction on behalf of a
 * persistance session.
 *
 * @author brett chaldecott
 */
public class JenaPersistanceTransaction implements PersistanceTransaction {

    // static member variables
    private static Logger log = Logger.getLogger(JenaPersistanceTransaction.class);
    
    // private member variables
    private Model jenaModel;
    private boolean inTransaction = false;
    private SessionManager.SessionLock lock;

    /**
     * The constructor responsible for creating the jena transaction.
     *
     * @param jenaModel The reference to the jena model.
     * @param type The type of store to utilize
     */
    protected JenaPersistanceTransaction(Model jenaModel, JenaStoreType type) {
        this.jenaModel = jenaModel;
        // sets up the default read lock
        if (type == JenaStoreType.XML) {
            this.lock = SessionManager.SessionLock.NO_LOCK;
        } else {
            this.lock = SessionManager.SessionLock.READ_LOCK;
        }
    }
    
    
    /**
     * The constructor responsible for creating the jena transaction.
     *
     * @param jenaModel The reference to the jena model.
     * @param lock The type of lock to utilize on this session.
     */
    protected JenaPersistanceTransaction(Model jenaModel, 
            SessionManager.SessionLock lock) {
        this.jenaModel = jenaModel;
        this.lock = lock;
    }

    /**
     * This method is called to being the transaction scope.
     *
     * @throws PersistanceException
     */
    public void begin() throws PersistanceException {
        if (inTransaction) {
            throw new PersistanceException(
                    "Transaction already started for this object.");
        }
        try {
            if (lock == SessionManager.SessionLock.READ_LOCK) {
                jenaModel.enterCriticalSection(Lock.READ);
            } else if (lock == SessionManager.SessionLock.WRITE_LOCK) {
                jenaModel.enterCriticalSection(Lock.WRITE);
            }
            jenaModel.begin();
            inTransaction = true;
        } catch (Exception ex) {
            log.error("Failed to begin the changes : " + ex.getMessage());
        }
    }



    /**
     * This method is responsible for commiting the transaction.
     *
     * @throws PersistanceException
     */
    public void commit() throws PersistanceException {
        try {
            jenaModel.commit();
        } catch (Exception ex) {
            log.error("Failed to commit the changes : " + ex.getMessage());
        } finally {
            if (lock == SessionManager.SessionLock.READ_LOCK || 
                    lock == SessionManager.SessionLock.WRITE_LOCK) {
                jenaModel.leaveCriticalSection();
            }
        }
    }


    /**
     * This method is responsible for rolling back the transactional changes.
     * 
     * @throws PersistanceException
     */
    public void rollback() throws PersistanceException {
        try {
            jenaModel.abort();
        } catch (Exception ex) {
            log.error("Failed to commit the changes : " + ex.getMessage());
        } finally {
            if (lock == SessionManager.SessionLock.READ_LOCK || 
                    lock == SessionManager.SessionLock.WRITE_LOCK) {
                jenaModel.leaveCriticalSection();
            }
        }
    }


    /**
     * TRUE if transaction has been started for this object, FALSE if not.
     *
     * @return TRUE if a transaction has been started.
     * @throws PersistanceException
     */
    public boolean isInTransaction() throws PersistanceException {
        return inTransaction;
    }
}
