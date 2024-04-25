// some erros about 'undefined' popped up. because of lombok, i guess. i will fix this in the future.



//package CodingProblems;
//
//import lombok.Data;
//import lombok.NonNull;
//
//import java.lang.reflect.Array;
//
//public class TheHashAndTheTableChaining {
//
//    @Data
//    public class HashItem<Key, Value> {
//        private final Key key;
//        @NonNull
//        private Value value;
//        private HashItem<Key, Value> nextHashItem;
//    }
//
//    public class HashTable<Key, Value> {
//        public static final int max_map_size = 5; // this is only for chaining <=> LL size
//        private final HashItem<Key, Value>[] hashTable;
//        private int size;
//
//        public HashTable() {
//            hashTable = (HashItem<Key, Value>[]) Array.newInstance(HashItem.class, max_map_size);
//        }
//
//        private int hash(Key key) {
//            return key.hashCode() % max_map_size;
//        }
//
//        public void put(Key key, Value value) {
//            int index = hash(key);
//            HashItem<Key, Value> item = hashTable[index];
//            while (item != null) {
//                if (item.getKey().equals(key)) {
//                    item.setValue(value);//update
//                    return;
//                }
//                item = item.getNextHashItem();
//            }
//            HashItem<Key, Value> hashItem = new HashItem<>(key, value);
//            hashItem.setNextHashItem(hashTable[index]);
//            hashTable[index] = hashItem;
//            size++;
//        }
//
//        public Value get(Key key) {
//            int index = hash(key);
//            HashItem<Key, Value> item = hashTable[index];
//            while (item != null) {
//                if (item.getKey().equals(key)) {
//                    return item.getValue();
//                }
//                item = item.getNextHashItem();
//            }
//            return null;
//        }
//
//        public Value remove(Key key) {
//            int index = hash(key);
//            HashItem<Key, Value> item = hashTable[index];
//            HashItem<Key, Value> prev = null;
//
//            while (item != null) {
//                if (item.getKey().equals(key)) {
//                    break;
//                }
//                prev = item;
//                item = item.getNextHashItem();
//            }
//            if (item == null) {
//                return null;
//            }
//            if (prev == null) {
//                hashTable[index] = item.getNextHashItem();
//            } else {
//                prev.setNextHashItem(item.getNextHashItem());
//            }
//            size--;
//            return item.getValue();
//        }
//    }
//
//    public static void main(String[] args) {
//    }
//}