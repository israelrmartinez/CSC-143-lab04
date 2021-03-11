package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import utility.ArrayList;
import utility.List;

public class ArrayListUnitTest {

    List<String> list;				//global variable

    @Test
    void testArrayList() {

        assertNull(list);
        list = new ArrayList<String>();

        System.out.println("---------------- Test Default Constructor( ) ----------------");
        System.out.println("size before: " + list.size());
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"  ));
        assertTrue(list.add("Valerian"));

        assertEquals(4, list.size());
        System.out.println(list);
        System.out.println("size after: " + list.size());
        System.out.println();
    }


    @Test
    void testArrayListInt() {

        assertNull(list);
        list = new ArrayList<String>(5);

        System.out.println("---------------- Test Constructor( ) ----------------");
        System.out.println("size before: " + list.size());
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"  ));
        assertTrue(list.add("Valerian"));

        assertEquals(4, list.size());
        System.out.println(list);
        System.out.println("size after: " + list.size());
        System.out.println();
    }


    @Test
    void testAddE() {

        assertNull(list);
        list = new ArrayList<String>();

        System.out.println("---------------- Test Add(E e) ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Florianus"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        System.out.println(list);
        System.out.println("size: " + list.size());
        assertEquals(7, list.size());
        System.out.println();
    }


    @Test
    void testAddIntE() {

        assertNull(list);
        list = new ArrayList<String>();
        list.add(0,"Horus");
        list.add(1,"Isis");
        list.add("Marcus");

        System.out.println("---------------------- List AddIntE ---------------------");
        System.out.println(list);
        System.out.println();

        System.out.println("----------------- Test Add(index, value) ----------------");
        list.add(0, "Augustus");
        list.add(1, "Cresus");
        list.add(2, "Aquinas");
        System.out.println(list);
        System.out.println();

        assertEquals("Augustus", list.get(0));
        assertEquals("Cresus"  , list.get(1));
        assertEquals("Aquinas" , list.get(2));

        System.out.println("--------------------------- Add @ Location 3 -----------------------");
        list.add(3, "Commodus");
        assertEquals("Commodus", list.get(3));

        list.add(3, "Balbinus");
        assertEquals("Balbinus", list.get(3));

        list.add(3, "Eurius");
        assertEquals("Eurius"  , list.get(3));

        System.out.println(list);
        System.out.println("size: " + list.size());

        //Test if accessing index out of bounds.
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-2, "Hera"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(10, "Hera"));
        System.out.println();
    }


    @Test
    void testContains() {

        assertNull(list);
        list = new ArrayList<String>();

        System.out.println("---------------- Test Contains( ) ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Florianus"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        assertTrue(list.contains("Augustus"));
        assertTrue(list.contains("Commodus"));
        assertTrue(list.contains("Valerian"));
        assertFalse(list.contains("Tiberius"));

        System.out.println(list);
        System.out.println("has Commodus? " + list.contains("Commodus"));
        System.out.println("has Valerian? " + list.contains("Valerian"));
        System.out.println("has Tiberius? " + list.contains("Tiberius"));
        System.out.println();

        System.out.println();
    }


    @Test
    void testEnsureCapacity() {

        assertNull(list);
        list = new ArrayList<String>(5);

        System.out.println("---------------- Test EnsureCapacity( ) ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Florianus"));

        assertEquals(5, list.size());
        System.out.println("List Threshold @ Capacity");
        System.out.println("Should expand beyond this point or will CRASH");
        System.out.println("TEST VIA add method");

        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Julius"));
        assertTrue(list.add("Tiberius"));
        assertTrue(list.add("Valerian"));

        assertEquals(9, list.size());
        System.out.println(list);

        int size = list.size();

        for (int count = 1; count <= 100; count++) {
            assertTrue(list.add("Valerian"));
        }

        size = size + 100;
        assertEquals(size, list.size());
        System.out.printf("TEST 1: size: %d, list-size: %d \n", size, list.size());

        for (int count = 1; count < 100; count++) {
            assertTrue(list.remove("Valerian"));
        }

        size = size - 99;
        assertEquals(size, list.size());
        System.out.printf("TEST 2: size: %d, list-size: %d \n", size, list.size());

        //TEST: MIN CAPACITY
        list.ensureCapacity(140);
        for (int count = 1; count <= 140; count++) {
            assertTrue(list.add("Valerian"));
        }

        size = size + 140;
        assertEquals(size, list.size());
        System.out.printf("TEST 3: size: %d, list-size: %d \n", size, list.size());
        System.out.println();
    }


    @Test
    void testGet() {

        assertNull(list);
        list = new ArrayList<String>();

        System.out.println("---------------- Test Get( ) ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Florianus"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        assertEquals("Augustus", list.get(0));
        assertEquals("Commodus", list.get(2));
        assertEquals("Valerian", list.get(6));

        System.out.println(list);
        System.out.println("who is at 0? " + list.get(0));
        System.out.println("who is at 2? " + list.get(2));
        System.out.println("who is at 6? " + list.get(6));

        //Test if accessing index out of bounds.
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(8));
        System.out.println();
    }


    @Test
    void testIndexOf() {

        assertNull(list);
        list = new ArrayList<String>();
        System.out.println("---------------- Test IndexOf( ) ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Florianus"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        assertEquals(0, list.indexOf("Augustus"));
        assertEquals(2, list.indexOf("Commodus"));
        assertEquals(6, list.indexOf("Valerian"));
        assertEquals(-1, list.indexOf("Tiberius"));

        System.out.println(list);
        System.out.println("location of Commodus " + list.indexOf("Commodus"));
        System.out.println("location of Valerian " + list.indexOf("Valerian"));
        System.out.println("location of Tiberius " + list.indexOf("Tiberius"));
        System.out.println();
    }

    @Test
    void testRemoveInt() {

        assertNull(list);
        list = new ArrayList<String>();

        System.out.println("---------------- Test RemoveInt() ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Florianus"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        System.out.println(list);
        System.out.println("size before: " + list.size());
        assertEquals(7, list.size());
        assertEquals("Decius", list.remove(3));
        assertEquals(6, list.size());

        list.add(0, "Aurelius");
        assertEquals(7, list.size());
        assertTrue(list.add("Gallienus"));
        assertEquals("Aurelius", list.remove(0));
        System.out.println(list);

        assertEquals("Gallienus", list.remove(list.size() - 1));
        System.out.println("size after: " + list.size());
        System.out.println(list);

        //Test if accessing index out of bounds.
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size() + 2));
        System.out.println();
    }


    @Test
    void testRemoveE() {

        assertNull(list);
        list = new ArrayList<String>();
        System.out.println("---------------- Test RemoveE() ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        System.out.println(list);
        System.out.println("size before: " + list.size());
        assertEquals(6, list.size());
        assertTrue(list.remove("Decius"));
        assertEquals(5, list.size());

        System.out.println(list);
        System.out.println("size after: " + list.size());
        assertFalse(list.remove("Florianus"));
        System.out.println("size after Flo: " + list.size());
        assertFalse(list.remove("Decius"));
        System.out.println();
    }


    @Test
    void testSet() {

        assertNull(list);
        list = new ArrayList<String>();

        System.out.println("------------------ Test Set( ) ------------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Decius"));
        assertTrue(list.add("Valerian"));

        System.out.println(list);
        assertEquals("Balbinus", list.set(1, "Julius"));
        System.out.println(list);
        assertEquals("Decius"  , list.set(3, "Tiberius"));
        System.out.println(list);
        System.out.println();

        //Test if accessing index out of bounds.
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-2, "Hera"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(8, "Hera"));
        System.out.println();
    }

    @Test
    void testSize() {

        assertNull(list);
        list = new ArrayList<String>();

        System.out.println("---------------- Test Size() ----------------");
        assertTrue(list.add("Augustus"));
        assertTrue(list.add("Balbinus"));
        assertTrue(list.add("Commodus"));
        assertTrue(list.add("Gallienus"));
        assertTrue(list.add("Valerian"));

        System.out.println(list);
        assertEquals(5, list.size());
        System.out.println("size end: " + list.size());

        System.out.println();
    }

}
