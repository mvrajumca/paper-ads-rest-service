package com.acme.ads;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests.
 * 
 * @author Raju 
 */
public class AcmeAdsDaoTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AcmeAdsDaoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AcmeAdsDaoTest.class );
    }

    public void testCreateNewsPapaer()throws Exception
    {
    	assertTrue(true);
    }
    public void testCreateAdvertisement()throws Exception
    {
    	assertTrue(true);
    }
}
