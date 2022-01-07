package ru.vsu.cs.volobueva;

import ru.vsu.cs.util.ArrayUtils;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class ConsoleMain {

    public static class CmdParams {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();

        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            if (!args[0].equals("-i")) {
                params.error = true;
                params.help = true;
                return params;
            }

            if (args.length < 2) {
                params.help = true;
                params.error = true;
                return params;
            }

            params.inputFile = args[1];
            if (args.length > 2 && args[2].equals("-o")) {
                params.outputFile = args[3];
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }

    public static void main(String[] args) throws Exception {
        CmdParams params = parseArgs(args);

        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("    -i  // transform");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }
        if (params.window) {
            GuiMain.winMain();
        } else {
            List<String[]> list = ArrayUtils.readSplitListFromFile(params.inputFile);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the desired number of rooms in the apartment: ");
            int numberOfRoom = scanner.nextInt();

            System.out.print("Enter the desired minimum total square of the apartment: ");
            int totalSquare = scanner.nextInt();

            if (list == null) {
                System.err.printf("Can't read array from \"%s\"%n", params.inputFile);
                System.exit(2);
            } else{
                PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;

                List<ApartmentParameters> resultList = SearchFlat.searchFlat(ArrayUtils.makeListToApartmentParameters(list), numberOfRoom, totalSquare);
                ArrayUtils.writeArrayToFile(params.outputFile, ApartmentParameters.makeListToArr(resultList));
            }
            out.close();
        }
    }
}
