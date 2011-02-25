/*
 * CoaduntionSemantics: The semantic library for coadunation os
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
 * SemanticUtil.java
 */

// package path
package com.rift.coad.rdf.semantic.coadunation;

// java imports
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

// logging import
import org.apache.log4j.Logger;

// coadunation imports
import com.rift.coad.rdf.semantic.SessionManager;
import com.rift.coad.rdf.semantic.Session;

/**
 * This class sets up a hibernate SessionFactory.
 */
public class SemanticUtil implements XAResource {

    // class constants
    public final static String RDF_CONFIG_URL = "rdf_config_url";
    public final static String SDB_CONFIG_FILE = "sdb_config_file";
    public final static String TRANSACTION_TIMEOUT = "transaction_timeout";
    public final static int DEFAULT_TRANSACTION_TIMEOUT = 180000;

    // class singleton
    private static Map<Class, SemanticUtil> singletons = new HashMap<Class, SemanticUtil>();

    // the logger reference
    protected static Logger log =
            Logger.getLogger(SemanticUtil.class.getName());

    // class private member variables
    private int timeout = 0;
    private Context context = null;
    private SessionManager sessionManager = null;
    private Map<Xid,Session> sessions = new ConcurrentHashMap<Xid,Session>();
    private ThreadLocal<Session> currentSession = new ThreadLocal<Session>();


    /**
     * The constructor of the hibernate util object.
     *
     * @param configId The identifier of the configuration.
     * @exception MessageServiceException
     */
    private SemanticUtil(Class configId) throws SemanticUtilException {
        try {
            // retrieve the initial context
            context = new InitialContext();

            // Retrieve the configuration for the message service implementation
            com.rift.coad.lib.configuration.Configuration coadConfig =
                    com.rift.coad.lib.configuration.ConfigurationFactory.
                    getInstance()
                    .getConfig(configId);

            // retrieve the default transaction timeout
            timeout = (int)coadConfig.getLong(TRANSACTION_TIMEOUT,
                    DEFAULT_TRANSACTION_TIMEOUT);

            // instanciate the session manager
            this.sessionManager = com.rift.coad.rdf.semantic.config.SDB.
                    initSessionManager(coadConfig.getString(RDF_CONFIG_URL),
                    coadConfig.getString(SDB_CONFIG_FILE));
        } catch (Throwable ex) {
            log.error("Initial SessionManager " +
                    "creation failed: " + ex.getMessage(),ex);
            throw new SemanticUtilException("Initial SessionManager " +
                    "creation failed: " + ex.getMessage(),ex);
        }
    }


    /**
     * Configures up hibernate programmatically using Coadunations configuration
     * file.
     *
     * @return The reference to the hibernate util singleton.
     * @param configId The id of the configuration.
     * @excepiton MessageServiceException
     */
    public synchronized static SemanticUtil getInstance(Class configId) throws
            SemanticUtilException {
        SemanticUtil singleton = null;
        if (!singletons.containsKey(configId)) {
            singleton = new SemanticUtil(configId);
            singletons.put(configId,singleton);
        } else {
            singleton = (SemanticUtil)singletons.get(configId);
        }
        return singleton;
    }


    /**
     * Configures up hibernate programmatically using Coadunations configuration
     * file.
     *
     * @return The reference to the hibernate util singleton.
     * @param configId The id of the configuration.
     * @excepiton MessageServiceException
     */
    public synchronized static void closeInstance(Class configId) throws SemanticUtilException {
        try {
            if (singletons.containsKey(configId)) {
                SemanticUtil singleton = singletons.remove(configId);
                singleton.sessionManager.shutdown();
            }
        } catch (Exception ex) {
            log.error("Failed to close down this instance : " + ex.getMessage(),ex);
            throw new SemanticUtilException
                    ("Failed to close down this instance : " + ex.getMessage(),ex);
        }
    }


    /**
     * This method returns a reference to the session factory object.
     *
     * @return Returns the current session for this thread.
     * @exception
     */
    public Session getSession() throws SemanticUtilException {
        try {
            Transaction transaction = getTransaction();
            transaction.enlistResource(this);
            return (Session)currentSession.get();
        } catch (Exception ex) {
            log.error("Failed to retrieve the current session for this thread : "
                    + ex.getMessage(),ex);
            throw new SemanticUtilException(
                    "Failed to retrieve the current session for this thread : "
                    + ex.getMessage(),ex);
        }
    }




    /**
     * This method is responsible for handling the committing of a transaction
     * identified by the xid.
     *
     * @param xid The id of the transaction to commit.
     * @param onePhase If true a one phase commit should be used.
     * @exception XAException
     */
    public void commit(Xid xid, boolean b) throws XAException {
        if (this.sessions.containsKey(xid)) {
            Session session = (Session)sessions.get(xid);
            sessions.remove(xid);
        }
    }


    /**
     * The resource manager has dissociated this object from the transaction.
     *
     * @param xid The id of the transaction that is getting ended.
     * @param flags The flags associated with this operation.
     * @exception XAException
     */
    public void end(Xid xid, int flags) throws XAException {
    }


    /**
     * The transaction has been completed and must be forgotten.
     *
     * @param xid The id of the transaction to forget.
     * @exception XAException
     */
    public void forget(Xid xid) throws XAException {
        if (this.sessions.containsKey(xid)) {
            Session session = (Session)sessions.get(xid);
            sessions.remove(xid);
        }
    }


    /**
     * This method returns the transaction timeout for this object.
     *
     * @return The int containing the transaction timeout.
     * @exception XAException
     */
    public int getTransactionTimeout() throws XAException {
        return timeout;
    }


    /**
     * This method returns true if this object is the resource manager getting
     * queried.
     *
     * @return TRUE if this is the resource manager, FALSE if not.
     * @param xaResource The resource to perform the check against.
     * @exception XAException
     */
    public boolean isSameRM(XAResource xAResource) throws XAException {
        return this == xAResource;
    }


    /**
     * This is called before a transaction is committed.
     *
     * @return The results of the transaction.
     * @param xid The id of the transaction to check against.
     * @exception XAException
     */
    public int prepare(Xid xid) throws XAException {
        return XAResource.XA_OK;
    }


    /**
     * This method returns the list of transaction branches for this resource
     * manager.
     *
     * @return The list of resource branches.
     * @param flags The flags
     * @exception XAException
     */
    public Xid[] recover(int flags) throws XAException {
        return null;
    }


    /**
     * This method is called to roll back the specified transaction.
     *
     * @param xid The id of the transaction to roll back.
     * @exception XAException
     */
    public void rollback(Xid xid) throws XAException {
        if (this.sessions.containsKey(xid)) {
            Session session = (Session)sessions.get(xid);
            sessions.remove(xid);
        }
    }


    /**
     * This method sets the transaction timeout for this resource manager.
     *
     * @return TRUE if the transaction timeout can be set successfully.
     * @param transactionTimeout The new transaction timeout value.
     * @exception XAException
     */
    public boolean setTransactionTimeout(int transactionTimeout) throws
            XAException {
        timeout = transactionTimeout;
        return true;
    }


    /**
     * This method is called to start a transaction on a resource manager.
     *
     * @param xid The id of the new transaction.
     * @param flags The flags associated with the transaction.
     * @exception XAException
     */
    public void start(Xid xid, int i) throws XAException {
        Session session = null;
        if (this.sessions.containsKey(xid)) {
            session = sessions.get(xid);
        } else {
            try {
                session = sessionManager.getSession();
                sessions.put(xid,session);
            } catch (Exception ex) {
                log.error("Failed to start the transaction : "
                        + ex.getMessage(),ex);
                throw new XAException(
                        "Failed to start the transaction : " + ex.getMessage());
            }
        }
        this.currentSession.set(session);
    }


    /**
     * This method returns the transaction for this thread.
     *
     * @return The transaction for this thread.
     * @exception HibernateUtilException
     */
    private Transaction getTransaction() throws SemanticUtilException {
        try {
            TransactionManager transactionManager = (TransactionManager)
                    context.lookup("java:comp/TransactionManager");
            return transactionManager.getTransaction();
        } catch (Exception ex) {
            log.error("Failed to retrieve the current transaction because : "
                    + ex.getMessage(),ex);
            // Make sure you log the exception, as it might be swallowed
            throw new SemanticUtilException(
                    "Failed to retrieve the current transaction because : "
                    + ex.getMessage(),ex);
        }
    }
}