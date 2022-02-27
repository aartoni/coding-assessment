# To-do list

To-do list created for the Deloitte Ireland coding assessment. The app is built using Java 8 as per specification.

### Design choices

* I used only immutable objects as per Joshua Bloch suggestion in its book "Effective Java":
  >Classes should be immutable unless there's a very good reason to make them mutable
* I used in-memory authentication to avoid wasting time;
* I used the MVC architectural pattern because it seemed the most appropriate;

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
