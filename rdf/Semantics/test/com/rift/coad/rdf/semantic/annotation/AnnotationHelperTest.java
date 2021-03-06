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
 * AnnotationHelperTest.java
 */

package com.rift.coad.rdf.semantic.annotation;

import com.rift.coad.rdf.semantic.annotation.test.TestClass;
import java.lang.annotation.Annotation;
import junit.framework.TestCase;

/**
 * This class is responsible for testing the annotation helper class.
 *
 * @author brett chaldecott
 */
public class AnnotationHelperTest extends TestCase {
    
    public AnnotationHelperTest(String testName) {
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
     * Test of getAnnotation method, of class AnnotationHelper.
     */
    public void testGetAnnotation_Class_Class() {
        System.out.println("getAnnotation");
        Class source = TestClass.class;
        //Class type = thewebsemantic.Namespace.class;
        //Annotation result = AnnotationHelper.getAnnotation(source, type);
        //if (!result.annotationType().equals(thewebsemantic.Namespace.class)) {
        //    fail("Retrieved the incorrect annotation class.");
        //}
    }

    /**
     * Test of getAnnotation method, of class AnnotationHelper.
     */
    public void testGetAnnotation_AnnotationArr_Class() {
        System.out.println("getAnnotation");
        //Class type = thewebsemantic.Namespace.class;
        //Annotation result = AnnotationHelper.getAnnotation(
        //        AnnotationHelper.getAnnotationGroup(TestClass.class, thewebsemantic.RdfType.class), type);
        //if (!result.annotationType().equals(thewebsemantic.Namespace.class)) {
        //    fail("Retrieved the incorrect annotation class.");
        //}
    }

    /**
     * Test of getAnnotationGroup method, of class AnnotationHelper.
     */
    public void testGetAnnotationGroup() {
        System.out.println("getAnnotationGroup");
        //Class type = thewebsemantic.RdfType.class;
        //Annotation[] expResult = AnnotationHelper.getAnnotationGroup(TestClass.class, type);
        //Annotation[] result = AnnotationHelper.getAnnotationGroup(TestClass.class, type);
        //assertEquals(expResult.length, result.length);
    }

}
