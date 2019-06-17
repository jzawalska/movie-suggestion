# Personalized Movie Suggestion

A simple Java, Spring Boot application for retriving and storing information about the movies. 

# Table of Contents
- [Getting Started](#Getting%20Started)
- [Prerequisites](#Prerequisites)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
```
Java 1.8
MongoDB 3.0.15
```

### Installing
1. The application uses MongoDB
Open  terminal window & run and keep running a mongo server/daemon
```
$  mongod
```
2. Run the Application.java class [src/main/java/com/moviessuggestion/Application.java]
3. Open a web browser (default host port: 8080)
    ```URL:```http://localhost:8080/#/movie
    </br> Users are enabled to create a database of movies.
    Supported operations:
    - getting a list of all movies
    - adding a movie
    - adding details to existing movie
    - getting details of the selected movie
    - deleting a movie

| Method | Path | Decription | Example |
| ------ | ---- | ---------- | ------- |
| GET    | /movie  | get all movies |
|GET | /movie/{movieId} | get details of a selected movie| 
| POST | /movie/{movieId}| add a movie  | {{"title": "...","description": "..."}}
| PUT    | /movie/{movieId}  | update a selected movie |

## Running the tests

The application contains some unit tests

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## License

This project is licensed under the MIT License.
