package org.example;

import java.util.ArrayList;
import java.util.List;

public class LC706 {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        myHashMap.put(2, 2);

    }

    private static class MyHashMap {
        List<Entry> table;

        private static class Entry {
            private final int key;
            private int value;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public MyHashMap() {
            table = new ArrayList<Entry>();
        }

        public void put(int key, int value) {
            boolean exist = false;
            for (Entry entry : table) {
                if (key == entry.key) {
                    entry.value = value;
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                table.add(new Entry(key, value));
            }

        }

        public int get(int key) {
            for (Entry entry : table) {
                if (key == entry.key) {
                    return entry.value;
                }
            }
            return -1;
        }

        public void remove(int key) {
            int count = 0;
            for (Entry entry : table) {
                if (key == entry.key) {
                    table.remove(count);
                    break;
                }
                count++;
            }
        }

    }

}

