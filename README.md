# Мамакин Антон
### Тестовое задание на Java EE
<br>

## Содержание
+ [Описание проекта](#id_1)
+ [Подготовка к запуска проект](#id_2)
+ [Запуск проекта](#id_3)



## Описание проекта <a name="id_1"></a>
* #### Цель проекта - реализовать REST API, который позволяет отслеживать почтовые отправления
* #### Стек технологий
    * ##### Java 8
    * ##### Spring   
    * ##### Hibernate  
    * ##### Postgres  
    * ##### Docker   
* #### Функционал проекта
    * ##### Регистрация почтового отправления
    * ##### Его прибытие в промежуточное почтовое отделение
    * ##### Его убытие из почтового отделения
    * ##### Его получение адресатом
    * ##### просмотр статуса и полной истории движения почтового отправления
* #### API проекта - откройте https://editor.swagger.io/ и вставьте код [отсюда](https://github.com/AntonScript/test-job/blob/develop/src/main/java/com/example/testjob/api/api.yaml)  
* #### Пример работы с функционалом проекта    
    * #### Регистрация почтового отправления
    ```json
        post
        "url": "localhost:8089/mailing" 
        body {
          "type": 1,
          "index": 2310,
          "endAddress": "MediaSoft",
          "recipientName": "Mamakin Anton",
          "indexPostOffice": 1234
          }
    ```

    * ##### Его убытие из почтового отделения
    ```json
        post
        "url": "localhost:8089/departure-mailing" 
        body {
          "trackingNumber": 271150694,
          "index": 1234
        }
    ```
    
    * ##### Его прибытие в промежуточное почтовое отделение 
    ```json
        post
        "url": "localhost:8089/receiving-mailing" 
        body {
           "trackingNumber": 271150694,
            "index": 1000
          }
    ```
    * ##### Его получение адресатом
    ```json
        patch
        "url": "localhost:8089/end-mailing?trackingNumber=271150694&index=1000"
    ```
    * ##### просмотр статуса и полной истории движения почтового отправления
     ```json
        get
        "url": "localhost:8089/mailing?trackingNumber=271150694"
    ```


# Подготовка к запуска проекта <a name="id_2"></a>
* #### Необходима UNIX система , например linux Ubuntu
* #### Docker compose 3.2+ и Docker 17.04.0+

# Запуск проекта <a name="id_3"></a>
* #### Склонируйте репозиторий , например через shh
```shell
  git clone git@github.com:AntonScript/test-job.git
```
* #### Перейдите в папку проекту и запустите его через docker-compose,но перед этим убедитесь что у вас свободны 8089 и 5439 порты
```shell
   docker-compose up
```
* #### Готово, возможна ошибка при первом запуске может упасть контейнер с самим приложением, в этом случае нужно остановаить контейнер с бд и повторить команду 
