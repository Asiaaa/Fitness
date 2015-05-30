/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inka
 */
public class Grafik_fitnessTest {
    
    public Grafik_fitnessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDataSource method, of class Grafik_fitness.
     */
    @Test
    public void testSetDataSource() {
        System.out.println("setDataSource");
        DataSource dataSource = null;
        Grafik_fitness instance = new Grafik_fitness();
        instance.setDataSource(dataSource);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdZajecia method, of class Grafik_fitness.
     */
    @Test
    public void testSetIdZajecia() {
        System.out.println("setIdZajecia");
        int id_zajecia = 0;
        Grafik_fitness instance = new Grafik_fitness();
        instance.setIdZajecia(id_zajecia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdZajecia method, of class Grafik_fitness.
     */
    @Test
    public void testGetIdZajecia() {
        System.out.println("getIdZajecia");
        Grafik_fitness instance = new Grafik_fitness();
        int expResult = 0;
        int result = instance.getIdZajecia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdSala method, of class Grafik_fitness.
     */
    @Test
    public void testSetIdSala() {
        System.out.println("setIdSala");
        int id_sala = 0;
        Grafik_fitness instance = new Grafik_fitness();
        instance.setIdSala(id_sala);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdSala method, of class Grafik_fitness.
     */
    @Test
    public void testGetIdSala() {
        System.out.println("getIdSala");
        Grafik_fitness instance = new Grafik_fitness();
        int expResult = 0;
        int result = instance.getIdSala();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxIloscMiejsc method, of class Grafik_fitness.
     */
    @Test
    public void testSetMaxIloscMiejsc() {
        System.out.println("setMaxIloscMiejsc");
        int max_ilosc_miejsc = 0;
        Grafik_fitness instance = new Grafik_fitness();
        instance.setMaxIloscMiejsc(max_ilosc_miejsc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxIloscMiejsc method, of class Grafik_fitness.
     */
    @Test
    public void testGetMaxIloscMiejsc() {
        System.out.println("getMaxIloscMiejsc");
        Grafik_fitness instance = new Grafik_fitness();
        int expResult = 0;
        int result = instance.getMaxIloscMiejsc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class Grafik_fitness.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        Grafik_fitness instance = new Grafik_fitness();
        List<Grafik_fitness> expResult = null;
        List<Grafik_fitness> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdInstruktor method, of class Grafik_fitness.
     */
    @Test
    public void testSetIdInstruktor() {
        System.out.println("setIdInstruktor");
        int aInt = 0;
        Grafik_fitness instance = new Grafik_fitness();
        instance.setIdInstruktor(aInt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGodzStart method, of class Grafik_fitness.
     */
    @Test
    public void testSetGodzStart() {
        System.out.println("setGodzStart");
        int aInt = 0;
        Grafik_fitness instance = new Grafik_fitness();
        instance.setGodzStart(aInt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGodzKoniec method, of class Grafik_fitness.
     */
    @Test
    public void testSetGodzKoniec() {
        System.out.println("setGodzKoniec");
        int aInt = 0;
        Grafik_fitness instance = new Grafik_fitness();
        instance.setGodzKoniec(aInt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdDzienTygodnia method, of class Grafik_fitness.
     */
    @Test
    public void testSetIdDzienTygodnia() {
        System.out.println("setIdDzienTygodnia");
        int aInt = 0;
        Grafik_fitness instance = new Grafik_fitness();
        instance.setIdDzienTygodnia(aInt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
