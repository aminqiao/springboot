package com.boot;

import static org.hamcrest.Matchers.*;

import com.boot.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemobootApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void homePage() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("index1"))
				.andExpect(model().attributeExists("singlePerson"))
				.andExpect(model().attributeExists("people"))
				.andExpect(model().attribute("people", is(hasSize(3))));
	}

	@Test
	public void addPerson()throws Exception {
		mockMvc.perform(post("/aa")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("name", "aa")
				.param("age", "11"))
				.andExpect(status().is3xxRedirection())
				.andExpect(header().string("Location", "/aa"));

		Person p1 = new Person();
		p1.setId(1L);
		p1.setName("aa");
		p1.setAge(11);

		mockMvc.perform(get("/aa"))
				.andExpect(status().isOk())
				.andExpect(view().name("personList"))
				.andExpect(model().attributeExists("persons"))
				.andExpect(model().attribute("persons", is(hasSize(1))));
	}
}
