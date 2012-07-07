/*
 * bss: remove category
 * Copyright (C) Fri Jul 06 06:33:56 SAST 2012 owner 
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
 * RemoveCategory.groovy
 * @author brett chaldecott
 */

package pckg.category

import com.dipforge.utils.PageManager;
import com.dipforge.semantic.RDF;
import org.apache.log4j.Logger;
import com.rift.coad.lib.common.RandomGuid;
import com.dipforge.request.RequestHandler;


def log = Logger.getLogger("pckg.category.RemoveCategory");

log.info("Parameters : " + params)

// perform a check for a duplicate
def result = RDF.query("SELECT ?s WHERE {" +
    "?s a <http://dipforge.sourceforge.net/schema/rdf/1.0/bss/Category#Category> . " +
    "?s <http://dipforge.sourceforge.net/schema/rdf/1.0/bss/Category#id> ?id . "+
    "FILTER (?id = \"${params.categoryId}\")}")
if (result.size() >= 1) {
    log.info("Before callign get from store")
    def category = RDF.getFromStore("http://dipforge.sourceforge.net/schema/rdf/1.0/bss/Category#Category/${params.categoryId}")
    
    
    log.info("##### Init the request : " + category.toXML())
    
    RequestHandler.getInstance("bss", "RemoveCategory", category).makeRequest()
    
    print "success"
} else {
    print "Fail: No category [${params.categoryId}] found"
}

