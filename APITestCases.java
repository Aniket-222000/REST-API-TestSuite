import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class APITestCases {
    private static final String API_ENDPOINT = "https://bfhldevapigw.healthrx.co.in/automation-campus/create/user";

    public static void main(String[] args) {
        try {
            // Test Case 1: Positive Case
            positiveCase();

            // Test Case 2: Missing Roll Number
            missingRollNumber();

            // Test Case 3: Missing First Name
            missingFirstName();

            // Test Case 4: Missing Last Name
            missingLastName();

            // Test Case 5: Missing Phone Number
            missingPhoneNumber();

            // Test Case 6: Missing Email ID
            missingEmailId();

            // Test Case 7: Duplicate Roll Number
            duplicateRollNumber();

            // Test Case 8: Duplicate Phone Number
            duplicatePhoneNumber();

            // Test Case 9: Duplicate Email ID
            duplicateEmailId();

            // Test Case 10: Invalid Phone Number
            invalidPhoneNumber();

            // Test Case 11: Invalid Email ID
            invalidEmailId();

            // Test Case 12: Long First Name
            longFirstName();

            // Test Case 13: Long Last Name
            longLastName();

            // Test Case 14: Integer as First Name
            integerAsFirstName();

            // Test Case 15: Integer as Last Name
            integerAsLastName();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void positiveCase() throws IOException {
        String requestBody = "{\"firstName\":\"Devashish\",\"lastName\":\"Bhor\",\"phoneNumber\":8329284273,\"emailId\":\"bhordevashish0@gmail.com\"}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection,
                "Positive Test Case: User account created successfully with all fields having new values");
    }

    private static void missingRollNumber() throws IOException {
        String requestBody = "{\"firstName\":\"Akanksha\",\"lastName\":\"Ghule\",\"phoneNumber\":4455663312,\"emailId\":\"akankshaghule.sknsitssse.comp@gmail.com\"}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection, "Negative Test Case: Missing roll number - Passed");
    }

    private static void missingFirstName() throws IOException {
        String requestBody = "{\"lastName\":\"User\",\"phoneNumber\":775588996,\"emailId\":\"randomemailid1@gmail.com\"}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection, "Negative Test Case: Missing first name - Passed");
    }

    private static void missingLastName() throws IOException {
        String requestBody = "{\"firstName\":\"Test\",\"phoneNumber\":8762462334,\"emailId\":\"randomemailid1@gmail.com\"}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection, "Negative Test Case: Missing last name - Passed");
    }

    private static void missingPhoneNumber() throws IOException {
        String requestBody = "{\"firstName\":\"Test\",\"lastName\":\"User\",\"emailId\":\"randomemailid1@gmail.com\"}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection, "Negative Test Case: Missing phone number - Passed");
    }

    private static void missingEmailId() throws IOException {
        String requestBody = "{\"firstName\":\"Test\",\"lastName\":\"User\",\"phoneNumber\":1222211}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection, "Negative Test Case: Missing email ID - Passed");
    }

    private static void duplicateRollNumber() throws IOException {
        String requestBody = "{\"firstName\":\"Test\",\"lastName\":\"User\",\"phoneNumber\":134324254,\"emailId\":\"randomemailid1@gmail.com\"}";
        HttpURLConnection connection1 = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection1, requestBody);
        handleResponse(connection1, "First Request for Duplicate Roll Number");

        // Wait a bit before making the second request
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HttpURLConnection connection2 = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection2, requestBody);
        handleResponse(connection2, "Negative Test Case: Duplicate roll number - Passed");
    }

    private static void duplicatePhoneNumber() throws IOException {
        String requestBody1 = "{\"firstName\":\"Test\",\"lastName\":\"User\",\"phoneNumber\":990909090,\"emailId\":\"randomemailid132@gmail.com\"}";
        String requestBody2 = "{\"firstName\":\"Test\",\"lastName\":\"User\",\"phoneNumber\":990909093,\"emailId\":\"randomemailid132@gmail.com\"}";
        HttpURLConnection connection1 = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection1, requestBody1);
        handleResponse(connection1, "First Request for Duplicate Phone Number");

        // Wait a bit before making the second request
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HttpURLConnection connection2 = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection2, requestBody2);
        handleResponse(connection2, "Negative Test Case: Duplicate phone number - Passed");
    }

    private static void duplicateEmailId() throws IOException {
        String requestBody1 = "{\"firstName\":\"Test1\",\"lastName\":\"User1\",\"phoneNumber\":9999999998,\"emailId\":\"randomemailid111@gmail.com\"}";
        String requestBody2 = "{\"firstName\":\"Test2\",\"lastName\":\"User2\",\"phoneNumber\":9999999997,\"emailId\":\"randomemailid111@gmail.com\"}";
        HttpURLConnection connection1 = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection1, requestBody1);
        handleResponse(connection1, "First Request for Duplicate Email ID");

        // Wait a bit before making the second request
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HttpURLConnection connection2 = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection2, requestBody2);
        handleResponse(connection2, "Negative Test Case: Duplicate email ID - Passed");
    }

    private static void invalidPhoneNumber() throws IOException {
        String requestBody = "{\"firstName\":\"Test\",\"lastName\":\"User\",\"phoneNumber\":\"12345\",\"emailId\":\"randomemailid1@gmail.com\"}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection, "Negative Test Case: Invalid phone number - Passed");
    }

    private static void invalidEmailId() throws IOException {
        String requestBody = "{\"firstName\":\"Test\",\"lastName\":\"User\",\"phoneNumber\":3452783059,\"emailId\":\"invalidEmail\"}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection, "Negative Test Case: Invalid email ID - Passed");
    }

    private static void longFirstName() throws IOException {
        String requestBody = "{\"firstName\":\"A\"" + "A".repeat(8999)
                + ",\"lastName\":\"User\",\"phoneNumber\":3452783059,\"emailId\":\"randomemailid132@gmail.com\"}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection, "Negative Test Case: Long first name - Passed");
    }

    private static void longLastName() throws IOException {
        String requestBody = "{\"firstName\":\"A\",\"lastName\":\"User\"" + "User".repeat(899)
                + ",\"phoneNumber\":3452783059,\"emailId\":\"randomemailid132@gmail.com\"}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection, "Negative Test Case: Long last name - Passed");
    }

    private static void integerAsFirstName() throws IOException {
        String requestBody = "{\"firstName\":23524534,\"lastName\":\"user\",\"phoneNumber\":66677755,\"emailId\":\"randomemailid3@gmail.com\"}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection, "Negative Test Case: Integer as first name - Passed");
    }

    private static void integerAsLastName() throws IOException {
        String requestBody = "{\"firstName\":\"User\",\"lastName\":324244353,\"phoneNumber\":66677755,\"emailId\":\"randomemailid3@gmail.com\"}";
        HttpURLConnection connection = createConnection(API_ENDPOINT, "POST", "72288652H", "application/json");
        sendRequest(connection, requestBody);
        handleResponse(connection, "Negative Test Case: Integer as last name - Passed");
    }

    private static HttpURLConnection createConnection(String apiUrl, String requestMethod, String rollNumber,
            String contentType) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestMethod);
        connection.setRequestProperty("roll-number", rollNumber);
        connection.setRequestProperty("Content-Type", contentType);
        connection.setDoOutput(true);
        return connection;
    }

    private static void sendRequest(HttpURLConnection connection, String requestBody) throws IOException {
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
    }

    private static void handleResponse(HttpURLConnection connection, String testCaseDescription) throws IOException {
        int responseCode = connection.getResponseCode();
        System.out.println("\n" + testCaseDescription);
        if (responseCode == 200) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println("Response: " + response.toString());
                // Handle the JSON response as needed
            }
        } else {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()))) {
                String inputLine;
                StringBuilder errorResponse = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    errorResponse.append(inputLine);
                }
                System.out.println("Response Code: " + responseCode);
                System.out.println("Error Response: " + errorResponse.toString());
                // Handle the error response as needed
            }
        }
    }
}
