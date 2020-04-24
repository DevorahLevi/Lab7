package edu.ti.caih313.recursion.simple;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecursiveLinkedListTest {
    @Test
    public void testNewEmptyListIsEmpty() {
        RecursiveLinkedList<Integer> linkedList = new RecursiveLinkedList<>();
        assertTrue(linkedList.isEmpty());
        assertEquals(null, linkedList.endNode);
    }

    @Test
    public void testAppendToEmpty()
    {
        RecursiveLinkedList<Integer> linkedList = new RecursiveLinkedList<>();
        linkedList.append(new Integer(4));
        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
        assertEquals(linkedList.end(), linkedList.endNode);
    }

    @Test
    public void testNewEmptyListIsZeroSize() {
        RecursiveLinkedList<Integer> linkedList = new RecursiveLinkedList<>();
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testNewNotEmptyListIsNotEmpty() {
        Integer i14 = 14;
        RecursiveLinkedList<Integer> linkedList = new RecursiveLinkedList<>(i14);
        assertFalse(linkedList.isEmpty());
        assertEquals(linkedList.endNode, linkedList.end());
    }

    @Test
    public void testInsertTwoObjectsGivesCorrectSize() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        RecursiveLinkedList<Integer> linkedList = new RecursiveLinkedList<>(i12);
        linkedList.insert(j37);
        assertEquals(2, linkedList.size());
        assertEquals(linkedList.endNode, linkedList.end());
    }

    @Test
    public void testAppendTwoObjectsGivesCorrectSize() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        RecursiveLinkedList<Integer> linkedList = new RecursiveLinkedList<>(i12);
        linkedList.append(j37);
        assertEquals(2, linkedList.size());
        assertEquals(linkedList.endNode, linkedList.end());
    }

    @Test
    public void testGetTooBigReturnsNull() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        RecursiveLinkedList<Integer> linkedList = new RecursiveLinkedList<>(i12);
        linkedList.append(j37);
        assertNull(linkedList.get(2));
    }

    @Test
    public void testInsertTwoObjectsCorrectOrder() {
        Double i12 = new Double(12);
        Double j37 = new Double(37);
        RecursiveLinkedList<Double> linkedList = new RecursiveLinkedList<>(i12);
        assertEquals(linkedList.endNode, linkedList.end());
        linkedList.insert(j37);
        assertEquals(linkedList.endNode, linkedList.end());
        Double first = linkedList.get(0);
        assertEquals(j37, first);
        Double second = linkedList.get(1);
        assertEquals(i12, second);
    }

    @Test
    public void testAppendTwoObjectsCorrectOrder() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        RecursiveLinkedList<Integer> linkedList = new RecursiveLinkedList<>(i12);
        linkedList.append(j37);
        assertEquals(linkedList.endNode, linkedList.end());
        Integer first = linkedList.get(0);
        assertEquals(i12, first);
        Integer second = linkedList.get(1);
        assertEquals(j37, second);
    }

    @Test
    public void testDeleteCorrectElementByPositionFirst() {
        Person bob = new Person("Jones", "Bob");
        Person jimmy = new Person("Dean", "Jimmy");
        Person george = new Person("Jungle", "George");
        RecursiveLinkedList<Person> linkedList = new RecursiveLinkedList<>(bob);
        linkedList.insert(jimmy);
        linkedList.insert(george);
        assertEquals(linkedList.endNode, linkedList.end());
        Person actualPerson = linkedList.remove(0);
        assertEquals(linkedList.endNode, linkedList.end());
        assertEquals(george, actualPerson);
        assertEquals(2, linkedList.size());
        assertEquals(jimmy, linkedList.get(0));
        assertEquals(bob, linkedList.get(1));
    }

    @Test
    public void testDeleteCorrectElementByPositionSecond() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        Integer k34 = new Integer(34);
        RecursiveLinkedList<Integer> linkedList = new RecursiveLinkedList<>(i12);
        linkedList.insert(j37);
        linkedList.insert(k34);
        assertEquals(linkedList.endNode, linkedList.end());
        Integer actualInteger = linkedList.remove(1);
        assertEquals(linkedList.endNode, linkedList.end());
        assertEquals(j37, actualInteger);
        assertEquals(2, linkedList.size());
        assertEquals(k34, linkedList.get(0));
    }

    @Test
    public void testDeleteCorrectElementByPositionLast() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        Integer k34 = new Integer(34);
        RecursiveLinkedList<Integer> linkedList = new RecursiveLinkedList<>(i12);
        linkedList.insert(j37);
        linkedList.insert(k34);
        assertEquals(linkedList.endNode, linkedList.end());
        Integer actualInteger = linkedList.remove(2);
        assertEquals(linkedList.endNode, linkedList.end());
        assertEquals(i12, actualInteger);
        assertEquals(2, linkedList.size());
        assertEquals(k34, linkedList.get(0));
    }

    @Test
    public void testDeleteCorrectElementByObject() {
        Integer i12 = new Integer(12);
        Integer j37 = new Integer(37);
        RecursiveLinkedList<Integer> linkedList = new RecursiveLinkedList<>(i12);
        linkedList.insert(j37);
        assertEquals(linkedList.endNode, linkedList.end());
        Integer actualInteger = linkedList.remove(i12);
        assertEquals(linkedList.endNode, linkedList.end());
        assertEquals(i12, actualInteger);
        assertEquals(1, linkedList.size());
        assertEquals(j37, linkedList.get(0));
    }
}