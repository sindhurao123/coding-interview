import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPasswordGenerator {

    private static final String DICTIONARY_API =
            "https://api.dictionaryapi.dev/api/v2/entries/en/";

    private static final Pattern LETTER_SEQUENCE =
            Pattern.compile("[A-Za-z]{4,}");

    private static final String DEFAULT_CHARACTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "abcdefghijklmnopqrstuvwxyz"
                    + "0123456789"
                    + "!@#$%^&*";

    private final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();
        scanner.nextLine();

        if (length <= 4) {
            System.out.println("Error: Password length should be greater than 4.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        StrongPasswordGenerator generator =
                new StrongPasswordGenerator();

        try {

            if (generator.isValidPassword(password)) {

                System.out.println( "Password is valid: " + password );

            } else {

                System.out.println("Entered password contains a dictionary word.");

                String newPassword = generator.generatePassword( length, DEFAULT_CHARACTERS );

                System.out.println( "New generated password: " + newPassword );
            }

        } catch (IOException e) {

            System.out.println(
                    "Unable to connect to Dictionary API."
            );

            System.out.println(
                    "Please check your internet/proxy/firewall settings."
            );

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "Dictionary API request was interrupted."
            );
        }
    }

    private boolean isValidPassword(
            String password)
            throws IOException, InterruptedException {

        Matcher matcher =
                LETTER_SEQUENCE.matcher(password);

        while (matcher.find()) {

            String letters = matcher.group();

            System.out.println(
                    "Checking: " + letters
            );

            if (isDictionaryWord(letters)) {
                return false;
            }
        }

        return true;
    }

    private boolean isDictionaryWord(
            String word)
            throws IOException, InterruptedException {

        HttpClient client =
                HttpClient.newBuilder()
                        .connectTimeout(
                                Duration.ofSeconds(5)
                        )
                        .build();

        String url = DICTIONARY_API + word;

        System.out.println(
                "Calling API: " + url
        );

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .timeout(
                                Duration.ofSeconds(5)
                        )
                        .GET()
                        .build();

        HttpResponse<String> response =
                client.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        System.out.println(
                "API response: "
                        + response.statusCode()
        );

        return response.statusCode() == 200;
    }

    private String generatePassword(
            int length,
            String characters)
            throws IOException, InterruptedException {

        while (true) {

            StringBuilder password =
                    new StringBuilder();

            for (int i = 0; i < length; i++) {

                int index =
                        random.nextInt(
                                characters.length()
                        );

                password.append(
                        characters.charAt(index)
                );
            }

            String candidate =
                    password.toString();

            System.out.println(
                    "Generated candidate: "
                            + candidate
            );

            if (isValidPassword(candidate)) {
                return candidate;
            }
        }
    }
}