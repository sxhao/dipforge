/*
 * CoadunationRDFResources: The rdf resource object mappings.
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
 * SHAPassword.java
 */

// package path
package com.rift.coad.rdf.objmapping.base.password;

import junit.framework.TestCase;

/**
 * This object is responsible for testing the sha password
 *
 * @author brett chaldecott
 */
public class SHAPasswordTest extends TestCase {
    
    public SHAPasswordTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getValue method, of class SHAPassword.
     */
    public void testGetValue() {
        System.out.println("getValue");
        SHAPassword instance = new SHAPassword();
        instance.setValue("test");
        String expResult = instance.getValue();
        instance.setValue(expResult);
        String result = instance.getValue();
        assertEquals(expResult, result);
        System.out.println(expResult);
    }

}
