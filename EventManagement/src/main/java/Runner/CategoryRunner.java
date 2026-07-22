package Runner;

import Dto.CategoryDto;
import controller.CategoryController;

import java.util.Scanner;

public class CategoryRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CategoryDto category = new CategoryDto();

        System.out.print("Enter Category Name:");
        category.setCategoryName(scanner.nextLine());

        System.out.print("Enter Description:");
        category.setDescription(scanner.nextLine());

        CategoryController controller = new CategoryController();

        boolean result = controller.addCategory(category);

        if (result) {
            System.out.println("Category Added Successfully.");
        } else {
            System.out.println("Failed to Add Category.");
        }

        scanner.close();
    }
}
