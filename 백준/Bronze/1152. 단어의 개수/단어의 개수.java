import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();
        br.close();

        System.out.println(input.isEmpty() ? "0" : input.trim().split(" ").length);
    }
}