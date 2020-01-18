package net.orphidian11.projects.cars.product;

import net.orphidian11.projects.cars.product.domain.Product;
import net.orphidian11.projects.cars.product.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApplicationTests {

	@Autowired
	private ProductMapper productMapper;

	@Test
	public void testProductMapper() {
		System.out.println("LOREM IPSUM DOLOR");
		// test findAll
		List<Product> products = productMapper.findAll();
		assertTrue(products != null && products.size() > 0);

		// test add
		Date today = new Date();
		Product newProduct = new Product();
		newProduct.setName("City");
		newProduct.setDescription("Budget sedan");
		newProduct.setCreatedById(1);
		newProduct.setCreatedByDate(today);
		newProduct.setLastUpdateById(1);
		newProduct.setLastUpdateByDate(today);
		newProduct.setId(productMapper.add("City","Budget sedan",1,today));
		assertTrue(newProduct.getId() != null && newProduct.getId() > 0);

		// test findById
		Product targetProduct = productMapper.findById(newProduct.getId());
		assertTrue(targetProduct != null && targetProduct.getId() == newProduct.getId());

		// test edit
		targetProduct.setName("City 2019");
		productMapper.edit(targetProduct);
		Product editedProduct = productMapper.findById(targetProduct.getId());
		assertTrue(editedProduct != null && editedProduct.getName() == targetProduct.getName());

		// test delete
//		productMapper.delete(targetProduct);
//		Product deletedProduct = productMapper.findById(targetProduct.getId());
//		assertTrue(deletedProduct == null);
	}

}
