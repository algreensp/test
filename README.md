# Building the project
Exexute mvn clean package under the project root directory

# Running the app
Execute the following command:
java -jar {arg0} {arg1} {arg2}


arg0 = path to log file
arg1 = source host
arg2 = target host

# Example of usage
java -jar target/demo-0.0.1-SNAPSHOT.jar /Users/jorgeherrera/test.log quark quark

# Assumptions and additional notes

- The following application assumes that the log file is built according to the provided specs.
- Timer has been set to 2 seconds instead of 1 hour for testing purpose.
- Error handling not considered in this excercise due to time constraints

