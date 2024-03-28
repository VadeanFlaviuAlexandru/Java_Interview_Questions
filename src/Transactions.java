import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transactions {
    //You are given a list of transactions, each representing a financial transaction made by a
    //user. Each transaction has a transaction ID, user ID, amount, and transaction type, either
    //spending or receiving. Your task is to process this list of transactions and return the
    //total balance. It means the sum of amounts for each user. For example, the function
    //transaction where the user ID is 101, the amount is 100, and the type is spending.
    //Another function transaction, user ID 102, amount 50, type receiving. In the end, we should
    //receive an array of an objects which have user ID and amount.
    public static List<Map<String, Object>> calculateTotalBalance(List<Map<String, Object>> transactions) {
        Map<Integer, Integer> balanceMap = new HashMap<>();

        for (Map<String, Object> transaction : transactions) {
            int userId = (int) transaction.get("userId");
            int amount = (int) transaction.get("amount");
            String type = (String) transaction.get("type");

            if (type.equals("spending")) {
                balanceMap.put(userId, balanceMap.getOrDefault(userId, 0) - amount);
            } else if (type.equals("receiving")) {
                balanceMap.put(userId, balanceMap.getOrDefault(userId, 0) + amount);
            }
        }

        List<Map<String, Object>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : balanceMap.entrySet()) {
            Map<String, Object> balance = new HashMap<>();
            balance.put("userId", entry.getKey());
            balance.put("amount", entry.getValue());
            result.add(balance);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example list of transactions
        List<Map<String, Object>> transactions = new ArrayList<>();
        Map<String, Object> transaction1 = new HashMap<>();
        transaction1.put("transactionId", 1);
        transaction1.put("userId", 101);
        transaction1.put("amount", 100);
        transaction1.put("type", "spending");
        transactions.add(transaction1);

        Map<String, Object> transaction2 = new HashMap<>();
        transaction2.put("transactionId", 2);
        transaction2.put("userId", 102);
        transaction2.put("amount", 50);
        transaction2.put("type", "receiving");
        transactions.add(transaction2);

        // Calculate total balance
        List<Map<String, Object>> totalBalance = calculateTotalBalance(transactions);
        System.out.println(totalBalance);
    }
}
