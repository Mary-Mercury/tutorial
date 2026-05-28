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

<img width="20%" height="auto" alt="image" src="https://github.com/user-attachments/assets/5d5b0cec-7d5b-4859-98f8-80bad57517b4" />

<img width="20%" height="auto" alt="image" src="https://github.com/user-attachments/assets/0c89b609-d2d7-4263-948d-bd367ab329f5" />

<img width="20%" height="auto" alt="image" src="https://github.com/user-attachments/assets/5df3d025-99dc-4e8e-9cf6-74ba13847aa1" />

<img width="20%" height="auto" alt="image" src="https://github.com/user-attachments/assets/deeaaeca-793f-4862-a00b-27e9960626c0" />

<img width="20%" height="auto" alt="image" src="https://github.com/user-attachments/assets/50bd27d5-cf4f-4594-9f53-561d9b704dcd" />

