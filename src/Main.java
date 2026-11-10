import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    static ArrayList<Documentary> documentaries = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a whole number: ");
            }
        }
    }

    public static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number: ");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n===== WildScope =====");
        System.out.println("1. Add documentary");
        System.out.println("2. Show all documentaries");
        System.out.println("3. Search by title");
        System.out.println("4. Mark as watched");
        System.out.println("5. Remove documentary");
        System.out.println("6. Rate documentary");
        System.out.println("7. Sort by rating");
        System.out.println("8. Sort by duration");
        System.out.println("9. Filter by category");
        System.out.println("10. Remove watched");
        System.out.println("11. Statistics");
        System.out.println("12. Add ocean documentary");
        System.out.println("13. Add wildlife documentary");
        System.out.println("14. Show recommended");
        System.out.println("15. Quick add");
        System.out.println("16. Show educational");
        System.out.println("17. Show long documentaries");
        System.out.println("18. Mark long as watched");
        System.out.println("19. Show titles only");
        System.out.println("20. Show short list");
        System.out.println("21. Top 3 rated");
        System.out.println("22. Stream statistics");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        int choice;
        Supplier<String> banner = () -> "Welcome to WildScope! Documentaries loaded: " + documentaries.size();
        System.out.println(banner.get());
        do {
            printMenu();
            choice = readInt();
            switch (choice) {
                case 1:
                    addDocumentary();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    searchByTitle();
                    break;
                case 4:
                    markWatched();
                    break;
                case 5:
                    removeDocumentary();
                    break;
                case 6:
                    rateDocumentary();
                    break;
                case 7:
                    sortByRating();
                    break;
                case 8:
                    sortByDuration();
                    break;
                case 9:
                    filterByCategory();
                    break;
                case 10:
                    removeWatched();
                    break;
                case 11:
                    showStatistics();
                    break;
                case 12:
                    addOceanDocumentary();
                    break;
                case 13:
                    addWildlifeDocumentary();
                    break;
                case 14:
                    showRecommended();
                    break;
                case 15:
                    quickAdd();
                    break;
                case 16:
                    showEducational();
                    break;
                case 17:
                    showLong();
                    break;
                case 18:
                    markLongAsWatched();
                    break;
                case 19:
                    showTitles();
                    break;
                case 20:
                    showShortList();
                    break;
                case 21:
                    showTopRated();
                    break;
                case 22:
                    showStreamStats();
                    break;
                case 0:
                    System.out.println("Exiting WildScope. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void addDocumentary() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Duration: ");
        int duration = readInt();
        documentaries.add(new GeneralDocumentary(title, category, duration));
        System.out.println("Added: " + title);
    }

    public static void showAll() {
        if (documentaries.isEmpty()) {
            System.out.println("No documentaries yet.");
            return;
        }
        for (int i = 0; i < documentaries.size(); i++) {
            System.out.println((i + 1) + ". [" + documentaries.get(i).getType() + "] " + documentaries.get(i));
        }
    }

    public static void searchByTitle() {
        System.out.print("Enter title: ");
        String keyword = scanner.nextLine();
        boolean isFound = false;
        for (int i = 0; i < documentaries.size(); i++) {
            if (documentaries.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println((i + 1) + ". " + documentaries.get(i));
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Nothing found.");
        }
    }

    public static void markWatched() {
        if (documentaries.isEmpty()) {
            System.out.println("No documentaries yet.");
            return;
        }
        showAll();
        System.out.print("Enter number: ");
        int number = readInt();
        if (number < 1 || number > documentaries.size()) {
            System.out.println("Invalid number.");
            return;
        }
        documentaries.get(number - 1).markAsWatched();
        System.out.println("Marked as watched: " + documentaries.get(number - 1).getTitle());
    }

    public static void removeDocumentary() {
        if (documentaries.isEmpty()) {
            System.out.println("No documentaries yet.");
            return;
        }
        showAll();
        System.out.print("Enter number: ");
        int number = readInt();
        if (number < 1 || number > documentaries.size()) {
            System.out.println("Invalid number.");
            return;
        }
        documentaries.remove(number - 1);
        System.out.println("Removed.");
    }

    public static void rateDocumentary() {
        if (documentaries.isEmpty()) {
            System.out.println("No documentaries yet.");
            return;
        }
        showAll();
        System.out.print("Enter number: ");
        int number = readInt();
        if (number < 1 || number > documentaries.size()) {
            System.out.println("Invalid number.");
            return;
        }
        System.out.print("Enter rating (0-10): ");
        double rating = readDouble();

        try {
            documentaries.get(number - 1).setRating(rating);
            System.out.println("Rating saved: " + rating);
        } catch (InvalidRatingException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Rating operation finished.");
        }
    }

    public static void sortByRating() {
        if (documentaries.isEmpty()) {
            System.out.println("No documentaries yet.");
            return;
        }
        Collections.sort(documentaries);
        showAll();
    }

    public static void sortByDuration() {
        if (documentaries.isEmpty()) {
            System.out.println("No documentaries yet.");
            return;
        }
        documentaries.sort(Comparator.comparingInt(Documentary::getDuration));
        showAll();
    }

    public static void filterByCategory() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        printFiltered(d -> d.getCategory().equalsIgnoreCase(category));
    }

    public static void printFiltered(Predicate<Documentary> condition) {
        boolean found = false;
        for (int i = 0; i < documentaries.size(); i++) {
            if (condition.test(documentaries.get(i))) {
                System.out.println((i + 1) + ". " + documentaries.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nothing found.");
        }
    }

    public static int processFiltered(Predicate<Documentary> condition, Consumer<Documentary> action) {
        int processed = 0;
        for (Documentary d : documentaries) {
            if (condition.test(d)) {
                action.accept(d);
                processed++;
            }
        }
        return processed;
    }

    public static void showLong() {
        printFiltered(d -> d.getDuration() > 60);
    }

    public static void markLongAsWatched() {
        int n = processFiltered(d -> d.getDuration() > 60, d -> d.markAsWatched());
        System.out.println(n + " documentaries marked as watched.");
    }

    public static void printMapped(Function<Documentary, String> mapper) {
        if (documentaries.isEmpty()) {
            System.out.println("No documentaries yet.");
            return;
        }
        for (Documentary d : documentaries) {
            System.out.println(mapper.apply(d));
        }
    }

    public static void showTitles() {
        printMapped(Documentary::getTitle);
    }

    public static void showShortList() {
        printMapped(d -> d.getTitle() + " (" + d.getDuration() + " min)");
    }

    public static void showTopRated() {
        List<Documentary> top = documentaries.stream()
                .filter(d -> d.getRating() > 0)
                .sorted()
                .limit(3)
                .collect(Collectors.toList());

        if (top.isEmpty()) {
            System.out.println("No rated documentaries yet.");
            return;
        }
        top.forEach(System.out::println);
    }

    public static void showStreamStats() {
        if (documentaries.isEmpty()) {
            System.out.println("No documentaries yet.");
            return;
        }

        double avgRating = documentaries.stream()
                .filter(d -> d.getRating() > 0)
                .mapToDouble(Documentary::getRating)
                .average()
                .orElse(0.0);

        int totalMinutes = documentaries.stream()
                .map(Documentary::getDuration)
                .reduce(0, Integer::sum);

        long watchedCount = documentaries.stream()
                .filter(Documentary::isWatched)
                .count();

        List<String> watchedTitles = documentaries.stream()
                .filter(Documentary::isWatched)
                .map(Documentary::getTitle)
                .collect(Collectors.toList());

        System.out.println("Average rating (rated only): " + avgRating);
        System.out.println("Total duration: " + totalMinutes + " min");
        System.out.println("Watched: " + watchedCount + " " + watchedTitles);
    }

    public static void showStatistics() {
        if (documentaries.isEmpty()) {
            System.out.println("No documentaries yet.");
            return;
        }
        Map<String, Long> stats = documentaries.stream()
                .collect(Collectors.groupingBy(d -> d.getCategory().toLowerCase(), Collectors.counting()));
        stats.forEach((category, count) -> System.out.println(category + ": " + count));
    }

    public static void removeWatched() {
        if (documentaries.isEmpty()) {
            System.out.println("No documentaries yet.");
            return;
        }
        Iterator<Documentary> it = documentaries.iterator();
        int removed = 0;
        while (it.hasNext()) {
            Documentary d = it.next();
            if (d.isWatched()) {
                it.remove();
                removed++;
            }
        }
        System.out.println("Removed: " + removed + " watched.");
    }

    public static void addOceanDocumentary() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Duration: ");
        int duration = readInt();
        System.out.print("Max depth (m): ");
        int maxDepth = readInt();
        documentaries.add(new OceanDocumentary(title, duration, maxDepth));
        System.out.println("Added: " + title);
    }

    public static void addWildlifeDocumentary() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Duration: ");
        int duration = readInt();
        System.out.print("Main animal: ");
        String mainAnimal = scanner.nextLine();
        documentaries.add(new WildlifeDocumentary(title, duration, mainAnimal));
        System.out.println("Added: " + title);
    }

    public static void showRecommended() {
        boolean found = false;
        for (Documentary d : documentaries) {
            if (d instanceof Recommendable) {
                Recommendable r = (Recommendable) d;
                if (r.isRecommended()) {
                    System.out.println("[" + d.getType() + "] " + d);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No recommended documentaries.");
        }
    }

    public static void quickAdd() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Duration: ");
        int duration = readInt();
        documentaries.add(new GeneralDocumentary(title, duration));
        System.out.println("Added: " + title);
    }

    public static void showEducational() {
        boolean found = false;
        for (Documentary d : documentaries) {
            if (d instanceof Educational) {
                System.out.println("[" + d.getType() + "] " + d);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No educational documentaries.");
        }
    }
}
