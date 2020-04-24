package edu.ti.caih313.recursion.simple;

public class RecursiveLinkedList<T> {
    private class Node {
        T payload;
        Node next = null;

        public Node(T payload) {
            this.payload = payload;
        }

        public T getPayload() {
            return payload;
        }

        public void setPayload(T payload) {
            this.payload = payload;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;
    Node endNode = null;

    public RecursiveLinkedList() {
        // nothing
    }

    public RecursiveLinkedList(T payload) {
        head = new Node(payload);
        endNode = head;
    }

    public boolean isEmpty() {
        return (head == null);
    }


    //entry condition is that head is not null
    Node end() {
        return lastNode(head);

        /*
        Node endNode = head;
        while (endNode.getNext() != null) {
            endNode = endNode.getNext();
        }
        return endNode;
    */
    }

    private Node lastNode(Node node) //**Create helper method because you have to use recursion with what you pass into it, but end x have params
    {
        //Node lastNode = (node == null)?null:(node.next == null)?node:lastNode(node.next);
        Node lastNode = null;
        if (node == null)
        {
            lastNode = null;
        }
        else if (node.next == null)
        {
            lastNode = node;
        }
        else //if node.next is not null, we are not at the end of the list
        {
            lastNode = lastNode(node.next); //call this function again for the next node on the linked list
        }
        return lastNode;
    }

    public int size() {
        return sizeHelper(head);

        /*
        int size = 0;
        for (Node start = head; start != null; start = start.next) {
            size += 1;
        }
        return size;
        */
    }

    int sizeHelper(Node node)
    {
        int size = (node == null) ? 0 : 1 + sizeHelper(node.next);
        return size;
    }

    public void insert(T object) {
        Node newNode = new Node(object);
        newNode.setNext(head);
        if (head == null)
        {
            endNode = newNode;
        }
        head = newNode;
    }

    public void append(T object) {
        Node newNode = new Node(object);
        if (head == null) {
            head = newNode;
            endNode = newNode;
        } else {
            endNode.setNext(newNode);
            endNode = newNode;
        }
    }

    public T get(int n) {
        T requestedObject = null;
        if (n < size()) {
            requestedObject = getRequestObject(n, head).getPayload();

            /*
            Node requestedNode = head;
            while (n-- > 0) {
                requestedNode = requestedNode.getNext();
            }
            requestedObject = requestedNode.getPayload();
             */
        }
        return requestedObject;
    }

    private Node getRequestObject(int n, Node node)
    {
        Node requestedNode = (n == 0) ? node : getRequestObject(n-1, node.next);
        return requestedNode;
    }

    public T remove(int n) {
        T requestedObject = null;
        if (n < size()) {
            Node beforeRequestedNode = null;
            Node requestedNode = head;
            while (n-- > 0) {
                beforeRequestedNode = requestedNode;
                requestedNode = requestedNode.getNext();
            }
            if (beforeRequestedNode != null) {
                beforeRequestedNode.setNext(requestedNode.getNext());
            } else {
                head  = requestedNode.getNext();
            }
            requestedObject = requestedNode.getPayload();
            if (requestedNode.getNext() == null)
            {
                endNode = beforeRequestedNode;
            }
        }
        return requestedObject;
    }

    public T remove(T object) {
        T requestedObject = null;
        if (head != null) {
            Node beforeRequestedNode = null;
            Node requestedNode = head;
            boolean foundNode = false;
            do {
                if (requestedNode.getPayload().equals(object)) {
                    foundNode = true;
                } else {
                    beforeRequestedNode = requestedNode;
                    requestedNode = requestedNode.getNext();
                }
            } while (!foundNode && requestedNode.getNext() != null);

            if (beforeRequestedNode != null) {
                beforeRequestedNode.setNext(requestedNode.getNext());
            } else {
                head  = requestedNode.getNext();
            }
            requestedObject = requestedNode.getPayload();
            if (requestedNode.getNext() == null)
            {
                endNode = beforeRequestedNode;
            }
        }
        return requestedObject;
    }
}