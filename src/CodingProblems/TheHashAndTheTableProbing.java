// some erros about 'undefined' popped up. because of lombok, i guess. i will fix this in the future.



//package CodingProblems;
//
//import lombok.Data;
//import lombok.NonNull;
//
//import java.lang.reflect.Array;
//
//public class TheHashAndTheTableProbing {
//    @Data
//    public class HashItem<Key, Value> {
//        private final Key key;
//        @NonNull
//        private Value value;
//    }
//
//    public class HashTable<Key, Value> {
//        public static final int max_map_size = 5; // this is only for chaining <=> LL size
//        private final HashItem<Key, Value>[] hashTable;
//        private int size;
//        private int capacity;
//
//        public HashTable() {
//            hashTable = (HashItem<Key, Value>[]) Array.newInstance(HashItem.class, max_map_size);
//            capacity = max_map_size;
//        }
//
//        private HashTable(int capacity) {
//            hashTable = (HashItem<Key, Value>[]) Array.newInstance(HashItem.class, capacity);
//            this.capacity = capacity;
//        }
//
//        private int hash(Key key) {
//            return key.hashCode() % capacity;
//        }
//
//        public void put(Key key, Value value) {
//            if (size >= capacity * 0.75) {
//                resize(2 * capacity);
//            }
//            int index = hash(key);
//            while (hashTable[index] != null) {
//                if (hashTable[index].getKey().equals(key)) {
//                    hashTable[index].setValue(value);
//                    return;
//                }
//                index = (index + 1) & capacity;
//
//            }
//            hashTable[index] = new HashItem<>(key, value);
//            size++;
//        }
//
//        public void resize(int newCap) {
//            HashTable<Key, Value> tempMap = new HashTable<>(newCap);
//            for (int i = 0; i < capacity; i++) {
//                if (hashTable[i] != null) {
//                    tempMap.put(hashTable[i].getKey(), hashTable[i].getValue());
//                }
//            }
//            hashTable = tempMap.getHashTable();
//            capacity = newCap;
//        }
//
//        public Value get(Key key) {
//            int index = hash(key);
//            while (hashTable[index] != null) {
//                if (hashTable[index].getKey().equals(key)) {
//                    return hashTable[index].getValue();
//                }
//                index = (index + 1) % capacity;
//            }
//            return null;
//        }
//
//        public Value remove(Key key) {
//            int index = hash(key);
//            while (!hashTable[index].getKey().equals(key)) {
//                index = (index + 1) % capacity;
//            }
//            Value toReturn = hashTable[index].getValue();
//            hashTable[index] = null;
//            size--;
//            while (hashTable[index = (index + 1) % capacity] != null) {
//                HashItem<Key, Value> nextItem = hashTable[index];
//                hashTable[index] = null;
//                size--;
//                put(nextItem.getKey(), nextItem.getValue());
//            }
//
//            return toReturn;
//        }
//
//    }
//
//
//}
