package HomeWorks;

import java.io.*;

public class main {
    final static String File_Name = "lesson6.csv";

    public static void main(String[] args) {
        String[] header = {"Value1", "Value2", "Value3"};
        int[][] data = {{100, 200, 123}, {300, 400, 500}};

        AppData appData = new AppData(header, data);

        save(appData);
        load();
    }

    public static void save(AppData appData) {
        try (BufferedWriter csvFile = new BufferedWriter(new FileWriter(File_Name))) {

            csvFile.write(String.join(";", appData.header) + "\n");
            for (int[] app : appData.data) {
                String[] strArray = new String[app.length];
                for (int i = 0; i < app.length; i++) {
                    strArray[i] = String.valueOf(app[i]);
                }
                csvFile.write(String.join(";", strArray) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        try (BufferedReader csvFile = new BufferedReader(new FileReader(File_Name))) {
            String str;
            while ((str = csvFile.readLine()) != null)
                System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
