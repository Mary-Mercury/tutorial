# Tutorial TODO app
## Что это за приложение?
Это классическое TODO приложение, которое позволяет хранить таски добавляемые пользователем. В приложении реализовано:
1. Паттерн MVVM
2. Локальная база данных Room
3. Инъектция зависимостей Hilt
4. CRUD операции
***
## Как запустить сборку приложения?
Для запуска сборки приложения вам желательно иметь приложение Docker Desktop, далее описанные действия будут происходить именно в нем. 
***
### Clone
откройте Docker Desktop, откройте Termital и укажите команду:
```
git clone https://github.com/Mary-Mercury/tutorial
```
поменяйте директорию на tutorial:
```
cd tutorial
```
***
### docker build
создайте образ контейнера при помощи следующей команды:
```
docker build -t tutorial-app .
```
дождитесь окончания создания образа, когда в строке появится сообщение:
```
Building (19/19) FINISHED
```
***
### сборка APK файла
после создания образа можно приступить к сборке APK файла. Укажите следующую команду:
```
docker run --rm -v ${PWD}/app/build:/app/app/build tutorial-app
```
дождитесь, когда в строке появится сообщение:
```
BUILD SUCCESSFUL
```
***
### Где лежит собранный APK файл?
Собранный вами APK файл находится по следующему пути:
```
tutorial\app\build\outputs\apk\debug
```
***
### Характеристики приложения
* Приложение предназначено для операционной системы Android
* Минимальная версия ОС Android - 10
* Вес APK файла - ~60мб.
***
### Скриншоты приложения
<img alt="Screenshot_20260525_185752" src="https://github.com/user-attachments/assets/b4bec11f-d2c6-47f6-837b-532096f03f09" width="20%" height="auto" />

<img alt="image" src="https://github.com/user-attachments/assets/8668460c-f7d8-40b8-8ff8-7d636ea6b8b1" width="20%" height="auto" />

<img width="20%" height="auto" alt="image" src="https://github.com/user-attachments/assets/f5d056eb-8c0c-4959-98ce-39ed34ba2068" />

