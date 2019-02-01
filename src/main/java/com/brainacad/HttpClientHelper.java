package com.brainacad;

import io.qameta.allure.Allure;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HttpClientHelper {


    public static HttpResponse get(String endpointUrl, String parameters) throws IOException {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("User-Agent", "My-Test-User-Agent");
        HttpResponse response = HttpClientHelper.get(endpointUrl, parameters, headers);

        return response;
    }

    //REST GET запрос
    public static HttpResponse get(String endpointUrl, String parameters, Map<String, String> headers) throws IOException {
        //Создаём экземпляр HTTP клиента
        HttpClient client = HttpClientBuilder.create().build();
        //Создаём HTTP GET запрос из URL и параметров
        HttpGet request = new HttpGet(endpointUrl + "?" + parameters);

        //добавляем в запрос необходимые хедеры
        for (String headerKey : headers.keySet()) {
            request.addHeader(headerKey, headers.get(headerKey));
        }

        //выполняем запрос в HTTP клиенте и получаем ответ
        HttpResponse response = client.execute(request);

        //возвращаем response
        return response;
    }


    public static HttpResponse post(String endpointUrl, String body) throws IOException {

        //TODO: написать метод для POST запроса с хедерами по умолчанию
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("User-Agent", "My-Test-User-Agent");
        //Добавляем header для типа передаваемых данных
        headers.put("Content-Type", "application/json");


        HttpResponse response = HttpClientHelper.post(endpointUrl, body, headers);
        return response;
    }

    public static HttpResponse post(String endpointUrl, String body, Map<String, String> headers) throws IOException {
        //Создаём экземпляр HTTP клиента
        HttpClient client = HttpClientBuilder.create().build();
        //Создаём HTTP POST запрос из URL и параметров
        HttpPost post = new HttpPost(endpointUrl);

        //добавляем в запрос необходимые хедеры
        for (String headerKey : headers.keySet()) {
            post.addHeader(headerKey, headers.get(headerKey));
        }

        //добавляем к запросу тело запроса
        post.setEntity(new StringEntity(body));

        //выполняем запрос в HTTP клиенте и получаем ответ
        HttpResponse response = client.execute(post);

        //возвращаем response
        return response;
    }


    public static String getBodyFromResponse(HttpResponse response) throws IOException {
        //создаём ридер буффера и передаём в него входящий поток респонса
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line;

        //получаем в цикле построчно строки из входящего потока и собираем в одну строку
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }


    public static HttpResponse put(String endpointUrl, String body) throws IOException {

        //TODO: написать метод для PUT запроса с хедерами по умолчанию
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("User-Agent", "My-Test-User-Agent");
        //Добавляем header для типа передаваемых данных
        headers.put("Content-Type", "application/json");

        HttpResponse response = HttpClientHelper.put(endpointUrl, body, headers);
        return response;
    }

    public static HttpResponse put(String endpointUrl, String body, Map<String, String> headers) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPut put = new HttpPut(endpointUrl);
        //добавляем в запрос необходимые хедеры
        for (String headerKey : headers.keySet()) {
            put.addHeader(headerKey, headers.get(headerKey));
        }

        //добавляем к запросу тело запроса
        put.setEntity(new StringEntity(body));

        //выполняем запрос в HTTP клиенте и получаем ответ
        HttpResponse response = client.execute(put);

        //возвращаем response
        return response;
    }

    public static HttpResponse delete(String endpointUrl) throws IOException {

        //TODO: написать метод для DELETE запроса с хедерами по умолчанию
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("User-Agent", "My-Test-User-Agent");

        HttpResponse response = HttpClientHelper.delete(endpointUrl, headers);
        return response;
    }

    public static HttpResponse delete(String endpointUrl, Map<String, String> headers) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpDelete delete = new HttpDelete(endpointUrl);
        //добавляем в запрос необходимые хедеры
        for (String headerKey : headers.keySet()) {
            delete.addHeader(headerKey, headers.get(headerKey));
        }

        //выполняем запрос в HTTP клиенте и получаем ответ
        HttpResponse response = client.execute(delete);

        //возвращаем response
        return response;
    }

    public static HttpResponse patch(String endpointUrl, String body) throws IOException {

        //TODO: написать метод для PATCH запроса с хедерами по умолчанию
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("User-Agent", "My-Test-User-Agent");
        //Добавляем header для типа передаваемых данных
        headers.put("Content-Type", "application/json");

        HttpResponse response = HttpClientHelper.patch(endpointUrl, body, headers);
        return response;
    }

    public static HttpResponse patch(String endpointUrl, String body, Map<String, String> headers) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPatch patch = new HttpPatch(endpointUrl);
        //добавляем в запрос необходимые хедеры
        for (String headerKey : headers.keySet()) {
            patch.addHeader(headerKey, headers.get(headerKey));
        }

        //добавляем к запросу тело запроса
        patch.setEntity(new StringEntity(body));

        //выполняем запрос в HTTP клиенте и получаем ответ
        HttpResponse response = client.execute(patch);

        //возвращаем response
        return response;
    }
    //TODO: допишите методы для запросов PUT, PATCH и DELETE


    //REST GET запрос
   // public static HttpResponse get(String endpointUrl, String parameters, Map<String, String> headers) throws IOException {
     //   Allure.addAttachment("Get parameters","Endpoint URL: "+endpointUrl+" Parameters: "+parameters);
        //Создаём экземпляр HTTP клиента
//        //Создаём HTTP GET запрос из URL и параметров
        //HttpGet request = new HttpGet(endpointUrl+"?"+parameters);

        //добавляем в запрос необходимые хедеры
       // for(String headerKey:headers.keySet()) {
         //   request.addHeader(headerKey, headers.get(headerKey));
        }

        //выполняем запрос в HTTP клиенте и получаем ответ
        //HttpResponse response = client.execute(request);

        //Allure.addAttachment("GET Response status code", "Status code:"+response.getStatusLine().getStatusCode());
       // Allure.addAttachment("GET Response body", getBodyFromResponse(response));
       // //возвращаем response
       // return response;
   //
