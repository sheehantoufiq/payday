package payday;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.text.ParseException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class CategoryController {

  CategoryService categoryService = new CategoryService();
  int counter = 2;

	// Get all categories
	@RequestMapping( value = "/api/businesses/1/categories", method = RequestMethod.GET )
	public List<Category> getAll() {

		List<Category> categories = CategoryService.getAllCategories(1);
		return categories;
	}

	// Create new category	
	@RequestMapping( value = "/api/businesses/1/categories", method = RequestMethod.POST )
	public Category create(@RequestParam(value="name") String name) throws ParseException {

		Category category = new Category(counter, name);
		counter++;
		CategoryService.createCategory(category);

		return category;

	}

	// Get category	
	@RequestMapping( value = "/api/businesses/1/categories/{categoryID}", method = RequestMethod.GET )
	public Category get(@PathVariable int categoryID) {
		return CategoryService.getCategory(categoryID);
	}

	// Update category
	@RequestMapping( value = "/api/businesses/1/categories/{categoryID}", method = RequestMethod.PUT )
	public Category update(@PathVariable int categoryID, @RequestParam(value="name") String name) throws ParseException
	{
		Category category = new Category();

		category.setId(categoryID);
		category.setName(name);

		CategoryService.updateCategory(category);

		return category;
	}

	// Delete category
	@RequestMapping( value = "/api/businesses/1/categories/{categoryID}", method = RequestMethod.DELETE )
	public String delete(@PathVariable int categoryID) {

		CategoryService.deleteCategory(categoryID);
		return "HTTP 200 OK: Category deleted from database.";
	}
}