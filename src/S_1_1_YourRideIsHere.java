/*
ID: mthai952
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.StringTokenizer;

class ride {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

    StringTokenizer st = new StringTokenizer(f.readLine());
    String comet = st.nextToken();
    st = new StringTokenizer(f.readLine());
    String group = st.nextToken();
    String output = getValue(comet) == getValue(group) ? "GO" : "STAY";
    out.println(output);
    out.close();
  }

  static int getValue(String s) {
    char[] sArray = s.toCharArray();
    int result = 1;

    for (char c : sArray) {
      result *= (c - 64);
    }

    return result % 47;
  }
}
