package ru.anarchyghost.javalabs.testlist;

public class ListNode {
        public ListNode next;
        public ListNode prev;
        public Integer value;

        public ListNode(ListNode next, ListNode prev, Integer value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode getPrev() {
            return prev;
        }

        public void setPrev(ListNode prev) {
            this.prev = prev;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
}
