[![Build Status](https://travis-ci.org/smorozov30/job4j_url_shortcut.svg?branch=master)](https://travis-ci.org/smorozov30/job4j_url_shortcut)
[![codecov](https://codecov.io/gh/smorozov30/job4j_url_shortcut/branch/master/graph/badge.svg?token=EO2UDSSST4)](https://codecov.io/gh/smorozov30/job4j_url_shortcut)

# job4j_url_shortcut

Сервис позволяет обеспечить безопасность пользователей на сайте заменяя обычные ссылки на преобразованные.
Сервис работает через REST API. 

#### Методы API:

- Регистрация сайта в сервисе. ***POST: /registration***
- Конвертировать ссылку в код. ***POST: /convert***
- Получить ссылку по коду. ***GET: /redirect/{code}***
- Получитб статистику по ссылкам. ***GET: /statistic***