/*
 * oss: Description
 * Copyright (C) Tue Jan 08 04:54:13 SAST 2013 owner 
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
 * CreateMail.groovy
 * @author brett chaldecott
 */

package com.dipforge.mail


// imports
import com.rift.coad.util.connection.ConnectionManager
import com.rift.coad.daemon.rdbusermanager.RDBUserManagementMBean
import java.util.Date
import org.apache.log4j.Logger;
import com.rift.coad.daemon.email.EMailServerMBean;

/**
 * This object is responsible for creating a new mail domain
 */
class CreateMail {
    
    static Logger log = Logger.getLogger("com.dipforge.log.pckg.com.dipforge.mail.CreateMail");
    
    
    /**
     * This is a test call.
     */
    def createMail(def Mail) {
        log.info("#######  This is a mail test for id " + Mail.getId())
        log.info("#######  This is a mail test for domain " + Mail.getDomain().getName())
        
        def fqdn = "${Mail.getDomain().getName()}.${Mail.getDomain().getTld()}"
        try {
            EMailServerMBean manageDaemon = (EMailServerMBean)ConnectionManager.getInstance().
                    getConnection(EMailServerMBean.class,"email/MBeanManager");
            manageDaemon.addDomain(fqdn)
        } catch (Exception ex) {
            log.error("Failed to add the mail domain : " + ex.getMessage());
        }
    }

}
