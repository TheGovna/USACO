/*
ID: mthai952
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class gift1 {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

    Map<String, Integer> map = new HashMap<>();
    int np = Integer.parseInt(f.readLine());
    String[] friends = new String[np];

    // Initialize map
    for (int i = 0; i < np; i++) {
      String friend = f.readLine();
      friends[i] = friend;
      map.put(friend, 0);
    }

    // Process each group of lines
    for (int i = 0; i < np; i++) {
      String current = f.readLine();
      StringTokenizer st = new StringTokenizer(f.readLine());
      int initialMoney = Integer.parseInt(st.nextToken());
      int numFriendsToDistribute = Integer.parseInt(st.nextToken());

      if (numFriendsToDistribute == 0) {
        continue;
      }

      int amountPerFriend = initialMoney / numFriendsToDistribute;
      int remaining = initialMoney % numFriendsToDistribute;

      map.put(current, map.get(current) - initialMoney + remaining);
      for (int j = 0; j < numFriendsToDistribute; j++) {
        String friend = f.readLine();
        map.put(friend, map.get(friend) + amountPerFriend);
      }
    }

    // Write output
    for (String friend : friends) {
      out.println(friend + ' ' + map.get(friend));
    }

    out.close();
  }
}
