package org.minlia.apps.sample.rebecca.http;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by will on 9/10/17.
 */
public class SerializerTest {


  public void test(){
    try {

      Unirest.post("http://httpbin.org/post")
          .queryString("name", "Mark")
          .field("last", "Polo")
          .asJson();

    } catch (UnirestException e) {
      e.printStackTrace();
    }
  }
}
