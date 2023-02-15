Данное приложение представляет из себя аналог блога или 
форума.

Доступные функции:

- просмотр цитат(как всех так и отдельных);
- получение случайной цитаты;
- создание цитат;
- редактирование цитат;
- удаление цитат;
- голосование по цитатам(лайк или дизлайк);
- просмотр 10 лучших и худших цитат(по результатам 
голосования).

Инструкция по запуску в контейнере docker:

- в корне проекта есть файл Dockerfile(образ доступен по ссылке https://hub.docker.com/layers/maxfedosenko/blog/latest/images/sha256-2b4a52e7259a99aaacdfe9022a2a7c2ee4af62d6681d44dd1db162c31ab1ffe4?context=repo) по сборке образа;
- находясь в директории blog в консоли выполнить команду(для примера) "docker build -t blog .";
- после сборки локального образа выполнить в консоли команду
docker run -p 8080:8888 --name blog {указать id образа};
- запуститься приложение.

Запуск через docker-compose.yml:
- находясь в директории blog в консоли выполнить команду
docker-compose up;
- программа по инструкции, указанной в файле docker-compose.yml
запустит приложение в контейнере docker.

Endpoints:

Для цитат:
- GET http://localhost:8080/quote (просмотр всех цитат);
- GET http://localhost:8080/quote/getbyid с параметром id (просмотр одной цитаты по id);
- GET http://localhost:8080/quote/randomquote (просмотр случайной цитаты);
- POST http://localhost:8080/quote/create с параметром description(создание новой цитаты);
- POST http://localhost:8080/quote/update с параметром description и id (обновление информации о цитате);
- POST http://localhost:8080/quote/like с параметром id(поставить лайк цитате);
- POST http://localhost:8080/quote/dislike с параметром id(поставить дизлайк цитате);
- GET http://localhost:8080/quote/top10 (просмотр 10 лучших цитат);
- GET http://localhost:8080/quote/flop10 (просмотр 10 худших цитат);
- DELETE http://localhost:8080/quote с параметром id (удаляет цитату по id).

Для пользователей:
- GET http://localhost:8080/user (просмотр всех пользователей);
- GET http://localhost:8080/user/getbyid с параметром id (просмотр информации об одном пользователе);
- GET http://localhost:8080/user/getbyname с параметром userName (поиск по имени);
- POST http://localhost:8080/user/create с параметрами userName, email, password (создание нового пользователя);
- POST http://localhost:8080/user/update с параметрами newName и id (редактирование имени пользователя);
- DELETE http://localhost:8080/user с параметром id (удаляет пользователя по id).

Используемые технологии:
- java 17;
- Spring(boot, Data JPA, validation);
- Lombok;
- H2 database;
- maven.
