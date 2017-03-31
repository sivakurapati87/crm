package com.cgi.crm.util;

import java.io.UnsupportedEncodingException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Ex {
	public static void main(String[] args) {
		new Ex().getMessagesFromOffice("skurapati@charterglobal.com", "pa55w0rd@");
	}
	public String getMessagesFromOffice(String user, String password) {

		JsonNode jsonObject = null;

		HttpResponse<JsonNode> response;

		String returnString = "";

		try {

			// It send request to get list of unread mails from // inbox folder
			// of mailbox and does basic // authentication with provided
			// username and password

			response = Unirest
					.get("https://outlook.office365.com/api/v1.0/me/folders/inbox/messages")
					.basicAuth(user, password).asJson();

			System.out.println("response : " + response.getBody());

			jsonObject = response.getBody();

			if (response.getBody() == null) {

				returnString = "NULL";

			} else {

				returnString = jsonObject.toString();

			}

		} catch (UnirestException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		return returnString;

	}
}
