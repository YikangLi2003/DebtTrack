import org.json.JSONObject;

public class App {
    public static void main(String[] args) {
        String json = "{ \"name\": \"John\", \"age\": 30 }";

        JSONObject jsonObject = new JSONObject(json);

        String name = jsonObject.getString("name");
        int age = jsonObject.getInt("age");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

/*
Transaction Date: 2024-08-19
Transaction Description: Buying Food
Record Creation Timestamp: [To be determined dynamically]
Record Creator: [To be specified]
Payers:

Zijie Duan: $50
Xinglin Wang: $20
Beneficiaries:

Yikang Li: 30%
Xinglin Wang: 30%
Zijie Duan: 40%
Settlement Status (for Beneficiaries):

Yikang Li: false
Xinglin Wang: true
Zijie Duan: true
Transactions:
Payment: Contribution made by payers.
Benefit: Proportionate share of the transaction by each beneficiary.
Accounting:
Equalization on Date: Payment is evenly split based on each person's share of the benefit.
Each Pays for Their Share: Each participant pays an amount proportionate to the benefit they receive.
Record Contents:
Atomic Information: Essential data needed to record the transaction.
Derived Information: Information computed dynamically by the program (not stored).

 */