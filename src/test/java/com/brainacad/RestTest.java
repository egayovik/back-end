package com.brainacad;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class RestTest {

    private static final String URL = "https://reqres.in/";

    @Test//GET метод
    public void checkGetResponseStatusCode() throws IOException {
        String endpoint = "/api/users";

        //TODO: Избавится он хедеров в тесте добавив методы с хедерами по умолчанию в класс HttpClientHelper
        //Создаём переменую headers типа Map
        // Map<String, String> headers=new HashMap<>();
        //Добавляем в headers наш заголовок
        // headers.put("User-Agent", "My-Test-User-Agent");

        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.get(URL + endpoint, "page=2");

        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 200, statusCode);
    }

    @Test//GET метод
    public void checkGetResponseBodyNotNull() throws IOException {
        String endpoint = "/api/users";

        //TODO: Избавится он хедеров в тесте добавив методы с хедерами по умолчанию в класс HttpClientHelper
        //Создаём переменую headers типа Map
        //Map<String, String> headers=new HashMap<>();
        //Добавляем в headers наш заголовок
        //headers.put("User-Agent", "My-Test-User-Agent");

        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.get(URL + endpoint, "page=2");

        //Конвертируем входящий поток тела ответа в строку
        String body = HttpClientHelper.getBodyFromResponse(response);
        //Получаем чисельное значение страницы
        int page = JsonUtils.intFromJSONByPath(body, "page");
        Assert.assertEquals("page should be 2", 2, page);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test//POST метод
    public void checkPostResponseStatusCodeAndData() throws IOException {
        String endpoint = "/api/users";

        //TODO: Избавится он хедеров в тесте добавив методы с хедерами по умолчанию в класс HttpClientHelper
        //Создаём переменую headers типа Map
//        Map<String, String> headers = new HashMap<>();
        //Добавляем в headers наш заголовок
//        headers.put("User-Agent", "My-Test-User-Agent");

        //создаём тело запроса
        String requestBody = "{\"name\": \"morpheus\",\"job\": \"leader\"}";

        //Выполняем REST POST запрос с нашими параметрами
        // и сохраняем результат в переменную response.


        HttpResponse response = HttpClientHelper.post(URL + endpoint, requestBody);
        String bodyFromResponse = HttpClientHelper.getBodyFromResponse(response);
        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 201", 201, statusCode);
        //проверяем имя и доолжность с ответа
        String name = JsonUtils.stringFromJSONByPath(bodyFromResponse, "name");
        String job = JsonUtils.stringFromJSONByPath(bodyFromResponse, "job");
        Assert.assertEquals("morpheus", name);
        Assert.assertEquals("leader", job);
    }

    @Test//PUT метод
    public void checkPutResponseStatusCodeAndData() throws IOException {
        String endpoint = "/api/users/2";

        //создаём тело запроса
        String requestBody = "{\"name\": \"morpheus\",\"job\": \"zion resident\"}";

        //Выполняем REST PUT запрос с нашими параметрами
        // и сохраняем результат в переменную response.


        HttpResponse response = HttpClientHelper.put(URL + endpoint, requestBody);
        String bodyFromResponse = HttpClientHelper.getBodyFromResponse(response);
        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 200, statusCode);
        //проверяем имя и доолжность с ответа
        String name = JsonUtils.stringFromJSONByPath(bodyFromResponse, "name");
        String job = JsonUtils.stringFromJSONByPath(bodyFromResponse, "job");
        Assert.assertEquals("morpheus", name);
        Assert.assertEquals("zion resident", job);
    }

    @Test//PATCH метод
    public void checkPatchResponseStatusCodeAndData() throws IOException {
        String endpoint = "/api/users/2";

        //создаём тело запроса
        String requestBody = "{\"name\": \"morpheus\",\"job\": \"zion resident\"}";

        //Выполняем REST PATCH запрос с нашими параметрами
        // и сохраняем результат в переменную response.


        HttpResponse response = HttpClientHelper.patch(URL + endpoint, requestBody);
        String bodyFromResponse = HttpClientHelper.getBodyFromResponse(response);
        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 200, statusCode);
        //проверяем имя и доолжность с ответа
        String name = JsonUtils.stringFromJSONByPath(bodyFromResponse, "name");
        String job = JsonUtils.stringFromJSONByPath(bodyFromResponse, "job");
        Assert.assertEquals("morpheus", name);
        Assert.assertEquals("zion resident", job);
    }

    @Test//GET метод
    public void checkDeleteResponseStatusCode() throws IOException {
        String endpoint = "/api/users/2";


        HttpResponse response = HttpClientHelper.delete(URL + endpoint);

        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 204, statusCode);
    }

    @Test//GET метод
    public void checkGetResponseBodyArray() throws IOException {
        String endpoint = "/api/users";

        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.get(URL + endpoint, "page=2");

        //Конвертируем входящий поток тела ответа в строку
        String body = HttpClientHelper.getBodyFromResponse(response);
        List data = JsonUtils.listFromJSONByPath(body, "data");
        Assert.assertEquals("data size should be 3", 3, data.size());
    }

    @Test//POST метод
    public void checkPostResponseBodyNotNull() throws IOException {
        String endpoint = "/api/users";

        //TODO: Избавится он хедеров в тесте добавив методы с хедерами по умолчанию в класс HttpClientHelper
        //Создаём переменую headers типа Map
        //Map<String, String> headers=new HashMap<>();
        //Добавляем в headers наш заголовок
        //headers.put("User-Agent", "My-Test-User-Agent");

        //создаём тело запроса
        String requestBody = "{\"name\": \"morpheus\",\"job\": \"leader\"}";

        //Выполняем REST POST запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.post(URL + endpoint, requestBody);

        //Конвертируем входящий поток тела ответа в строку
        String body = HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test//POST метод
    public void checkRegisterError() throws IOException {
        String endpoint = "/api/register";

        //TODO: Избавится он хедеров в тесте добавив методы с хедерами по умолчанию в класс HttpClientHelper
        //Создаём переменую headers типа Map
        //Map<String, String> headers=new HashMap<>();
        //Добавляем в headers наш заголовок
        //headers.put("User-Agent", "My-Test-User-Agent");

        //создаём тело запроса
        String requestBody = "{\"email\": \"sydney@fife\"}";

        //Выполняем REST POST запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.post(URL + endpoint, requestBody);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 400", 400, statusCode);
        //Конвертируем входящий поток тела ответа в строку
        String body = HttpClientHelper.getBodyFromResponse(response);
        String errorMessage = JsonUtils.stringFromJSONByPath(body, "error");
        Assert.assertEquals("Wrong error message", "Missing password", errorMessage);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }


    @Test//GET метод
    public void singleUser() throws IOException {
        String endpoint = "/api/users/2";


        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.get(URL + endpoint, null);

        //Конвертируем входящий поток тела ответа в строку
        String body = HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertEquals("мы проверяем avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg", JsonUtils.stringFromJSONByPath(body, "$.data.avatar"));
    }


    @Test//POST
    public void testPostUnsuccessfulLogin() throws IOException {
        String endpoint = "/api/login";

        //тело реквеста
        String requestBody = "{\"email\": \"peter@klaven\"}";

        //посылаем POST-реквест и получаем ответ
        HttpResponse response = HttpClientHelper.post(URL + endpoint, requestBody);

        //проверяем status code.Он должен быть ошибкой
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals("Статус код должен быть 400", 400, statusCode);
        System.out.println("код верный");

        //проверяем текст сообщения об ошибке

        //превращаем ответ в строку
        String bodyFromResponse = HttpClientHelper.getBodyFromResponse(response);
        //читаем текст сообщения из строки по полю 'error'
        String errorMessage = JsonUtils.stringFromJSONByPath(bodyFromResponse, "error");
        Assert.assertEquals("Сообщение должно быть 'Missing password'", "Missing password", errorMessage);
        System.out.println("сообщение об ошибке верное");

    }

    //TODO: напишите по тесткейсу на каждый вариант запроса на сайте https://reqres.in
    //TODO: в тескейсах проверьте Result Code и несколько параметров из JSON ответа (если он есть)

}
