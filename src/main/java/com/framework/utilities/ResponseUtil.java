package com.framework.utilities;

public class ResponseUtil {

	public static String extractJsonFromHtml(String response) {

		return response.replace("<html>", "").replace("</html>", "").replace("<body>", "").replace("</body>", "")
				.trim();
	}
}
