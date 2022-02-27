# To-do list

To-do list created for the Deloitte Ireland coding assessment. The app is built using Java 8 as per specification.

### Design choices

* I tried to use as many immutable objects as possible as per Joshua Bloch suggestion in its book "Effective Java":
  >Classes should be immutable unless there's a very good reason to make them mutable
* I used the MVC architectural pattern because it seemed the most appropriate;
* I used Thymeleaf as I'm already familiar with its syntax;
* I used Mockito in combination with JUnit 5 to mock the database, I chose not to implement integration tests to avoid wasting time. The project should have enough test coverage anyway.
* I used in-memory authentication to avoid wasting time;
* I have avoided using lombok as I find it hides some code smells;

### Build war

To build a `.war` file just run:

```bash
./gradlew war
```

The produced file can be found in `build/libs`.

### Testing

To test the app just run:

```bash
./gradlew test
```

### Using the app

Once the application is started, simply go to any endpoint to be redirected to `/login`. Two users have been set up to authenticate: "first-user" and "second-user" both with password "password".
