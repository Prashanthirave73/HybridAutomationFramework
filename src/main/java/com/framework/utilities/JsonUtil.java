package com.framework.utilities;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.models.User;

public class JsonUtil {

	public static User[] getUsers() {

		try {

			ObjectMapper mapper = new ObjectMapper();

			return mapper.readValue(new File("src/test/resources/testdata/users.json"), User[].class);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public static void printPrettyJson(String jsonString) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			Object json = mapper.readValue(jsonString, Object.class);

			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));

		} catch (Exception e) {

			System.out.println(jsonString);
		}
	}

}
