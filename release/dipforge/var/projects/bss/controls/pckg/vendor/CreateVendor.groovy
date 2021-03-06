/*
 * bss: Description
 * Copyright (C) Tue Jul 10 21:15:24 SAST 2012 owner 
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
 * CreateVendor.groovy
 * @author admin
 */

package pckg.vendor



import com.dipforge.utils.PageManager;
import com.dipforge.semantic.RDF;
import org.apache.log4j.Logger;
import com.rift.coad.lib.common.RandomGuid;
import com.dipforge.request.RequestHandler;


def log = Logger.getLogger("com.dipforge.log.pckg.vendor.CreateVendor");

log.info("Parameters : " + params)

// perform a check for a duplicate
def result = RDF.query("SELECT ?s WHERE {" +
    "?s a <http://dipforge.sourceforge.net/schema/rdf/1.0/bss/Vendor#Vendor> . " +
    "?s <http://dipforge.sourceforge.net/schema/rdf/1.0/bss/Vendor#id> ?id . "+
    "FILTER (?id = \"${params.vendorId}\")}")
if (result.size() == 0) {
    def vendor = RDF.create("http://dipforge.sourceforge.net/schema/rdf/1.0/bss/Vendor#Vendor")
    
    vendor.setId(params.vendorId)
    vendor.setName(params.vendorName)
    vendor.setDescription(params.vendorDescription)
    vendor.setThumbnail(params.thumbnail)
    vendor.setIcon(params.icon)
    
    log.info("##### Init the request : " + vendor.toXML())
    RequestHandler.getInstance("bss", "CreateVendor", vendor).makeRequest()
    
    print "success"
} else {
    print "Fail: Attempting to add a duplicate vendor identified by ID."
}

