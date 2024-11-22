
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProcessLargeFileParallelStream {

    public static void main(String[] args) throws Exception {
        // Path to the large 10GB transaction log file
        String filePath = "path/to/transaction_log.txt";

        // Process the file in parallel, filter and sum the transactions greater than 10000
        double total = Files.lines(Paths.get(filePath)) // Stream of lines from the file
                .parallel() // Convert to parallel stream
                .map(ProcessLargeFileParallelStream::parseTransactionAmount) // Parse the amount from each line
                .filter(amount -> amount > 10000) // Filter transactions greater than 10000
                .mapToDouble(Double::doubleValue) // Convert Stream<Double> to DoubleStream
                .sum(); // Sum the filtered amounts

        System.out.println("Total sum of transactions greater than 10,000: " + total);
    }

    // Helper method to parse transaction amount from a line (assuming a specific format)
    private static Double parseTransactionAmount(String line) {
        // Assuming the transaction log is in CSV format with the amount as the second column
        // For example: "txn_id,amount,timestamp"
        String[] fields = line.split(",");
        return Double.parseDouble(fields[1]); // Extract the amount
    }
}
